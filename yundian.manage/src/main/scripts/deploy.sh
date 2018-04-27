#!/usr/bin/env bash
CURRENT_DIR=`pwd`
source=$CURRENT_DIR/source
service=$CURRENT_DIR/service
release_version=0.0.1-SNAPSHOT
app_name=yundian.bankweb
source $CURRENT_DIR/profile.sh

release_dir=$app_name-$release_version-release
web_context='approval'

if [ -z $service ]; then
echo 'Service dir is null';
exit;
fi;

echo 'Starting Checking Out And Package trunk';
echo '===========================================================================================';

SVN_URL="https://10.10.13.41/DEV/trunk";
LOCAL_SVN_DIR=$source"/trunk"
mkdir -p $LOCAL_SVN_DIR
cd $LOCAL_SVN_DIR

if [ $1x == 'init'x ]; then
        echo "checking out source code from url $SVN_URL";
        rm -rf *
        svn co $SVN_URL .
else
        svn update
fi
mvn clean install -Dmaven.test.skip=true -P $profile

rm -rf $service/web/$web_context/
rm -rf $service/conf
cp -rf $source/trunk/target/$release_dir/conf $service/
cp -rf $source/trunk/target/$release_dir/sbin $service/

cp -rf $source/trunk/src/main/webapp/ $service/web/
rm -rf $service/lib/*.jar
cp -rf $source/trunk/target/$release_dir/lib/*.jar $service/lib

cd $service/sbin
chmod 777 *
./restart.sh

echo '==================================================';
echo 'Service Started Successfully!';
echo '==================================================';
touch $service/logs/web.log
tail -f $service/logs/web.log -n 2000



