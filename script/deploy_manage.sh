set -m
git pull
echo ‘………………..打包项目……………………’
cd /home/luoyiuser/source/insurance/yundian.manage
mvn clean install -DskipTests=true

echo ‘………………..部署yundian.manage……………………’
cd /home/luoyiuser/data/www/yundian.manage
rm -rf *
jar -xvf /home/luoyiuser/source/insurance/yundian.manage/target/yundian-manage.war

echo ‘………………重启yundian.manage……………………’

ps  -ef |grep yundian.manage/ |awk '{print "kill -9 " $2}' |sh
sh  /home/luoyiuser/server/yundian.manage/bin/startup.sh
echo 'yundian.manage ok!'
tail -100f /home/luoyiuser/server/yundian.manage/logs/catalina.out