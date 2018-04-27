#!/bin/bash
source etc.sh
cd `dirname $0`
BIN_DIR=`pwd`
cd ..
DEPLOY_DIR=`pwd`
CONF_DIR=$DEPLOY_DIR/conf

export BANK_WEB_HOME=$DEPLOY_DIR

PIDS=`ps -f | grep java | grep "$CONF_DIR" |awk '{print $2}'`
if [ -n "$PIDS" ]; then
    echo "ERROR: The $DEPLOY_DIR already started!"
    echo "PID: $PIDS"
    exit 1
fi

LOGS_DIR=$DEPLOY_DIR/var/log

if [ ! -d $LOGS_DIR ]; then
    mkdir $LOGS_DIR
fi
STDOUT_FILE=$LOGS_DIR/cls-web.log

LIB_DIR=$DEPLOY_DIR/lib
LIB_JARS=`ls $LIB_DIR|grep .jar|awk '{print "'$LIB_DIR'/"$0}'|tr "\n" ":"`

JAVA_OPTS=" -Djava.awt.headless=true -Djava.net.preferIPv4Stack=true "
GC_OPTS=" -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:$DEPLOY_DIR/logs/gc.log "
JAVA_DEBUG_OPTS=""
if [ "debug" = "$1" ]; then
    JAVA_DEBUG_OPTS=" -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=7799,server=y,suspend=n "
fi
#JAVA_JMX_OPTS=""
#if [ "$1" = "jmx" ]; then
    JAVA_JMX_OPTS=" -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.port=9022 "
#fi
JAVA_MEM_OPTS=""
BITS=`java -version 2>&1 | grep -i 64-bit`
if [ -n "$BITS" ]; then
    JAVA_MEM_OPTS=" -server -Xmx2g -Xms2g -Xmn256m -Xss256k -XX:+DisableExplicitGC -XX:+UseConcMarkSweepGC -XX:+CMSParallelRemarkEnabled -XX:+UseCMSCompactAtFullCollection -XX:LargePageSizeInBytes=128m -XX:+UseFastAccessorMethods -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=70 "
else
    JAVA_MEM_OPTS=" -server -Xms1g -Xmx1g -XX:SurvivorRatio=2 -XX:+UseParallelGC "
fi
#DUMP_ON_OUT_OF_MEM=""
#if [ "$1" = "oome" ]; then
    DUMP_ON_OUT_OF_MEM=" -XX:-UseGCOverheadLimit -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=$DEPLOY_DIR/logs -XX:ErrorFile=$DEPLOY_DIR/logs/hs_error_%p.log "
#fi

PROPS=" -Dapplication.name=CLS-WEB -Djava.util.logging.config.file=$DEPLOY_DIR/tomcat/conf/logging.properties -Djava.util.logging.manager=org.apache.juli.ClassLoaderLogManager -Djava.endorsed.dirs=$YUNDIAN_PLATFORM_HOME/tomcat7/endorsed "
CLASS_PATH=" -classpath $DEPLOY_DIR/conf/:$DEPLOY_DIR/conf/dubbo/consumer:$DEPLOY_DIR/conf/dubbo/provider:$DEPLOY_DIR/conf/spring:$YUNDIAN_PLATFORM_HOME/tomcat7/bin/bootstrap.jar:$YUNDIAN_PLATFORM_HOME/tomcat7/bin/tomcat-juli.jar -Dcatalina.base=$DEPLOY_DIR/tomcat -Dcatalina.home=$YUNDIAN_PLATFORM_HOME/tomcat7 -Djava.io.tmpdir=$DEPLOY_DIR/tomcat/temp "

CMD=" $JAVA_MEM_OPTS $JAVA_DEBUG_OPTS $JAVA_JMX_OPTS $JAVA_OPTS $DUMP_ON_OUT_OF_MEM $PROPS $CLASS_PATH org.apache.catalina.startup.Bootstrap start "
echo java $JAVA_MEM_OPTS $GC_OPTS $JAVA_DEBUG_OPTS $JAVA_JMX_OPTS $JAVA_OPTS $DUMP_ON_OUT_OF_MEM $PROPS $CLASS_PATH org.apache.catalina.startup.Bootstrap start
echo -e "Starting the $DEPLOY_DIR ...\c"
nohup java $JAVA_MEM_OPTS $GC_OPTS $JAVA_DEBUG_OPTS $JAVA_JMX_OPTS $JAVA_OPTS $DUMP_ON_OUT_OF_MEM $PROPS $CLASS_PATH org.apache.catalina.startup.Bootstrap start >> $STDOUT_FILE 2>&1 &

COUNT=0
while [ $COUNT -lt 1 ]; do    
    echo -e ".\c"
    sleep 1 
    COUNT=`ps -f | grep java | grep "$DEPLOY_DIR" | awk '{print $2}' | wc -l`
    if [ $COUNT -gt 0 ]; then
        break
    fi
done

echo "OK!"
PIDS=`ps -f | grep java | grep "$DEPLOY_DIR" | awk '{print $2}'`
echo "PID: $PIDS"
echo "STDOUT: $STDOUT_FILE"
