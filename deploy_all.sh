git pull
echo ‘………………..打包项目……………………’

mvn clean install -DskipTests=true

echo ‘………………..部署yundian.fssservice项目……………………’
cd /home/luoyiuser/data/www/yundian.fssservice
rm -rf *
jar -xvf /home/luoyiuser/source/insurance/yundian.fssservice/target/yundian.fssservice.war

echo ‘………………..部署yundian.fssservice项目……………………’
cd /home/luoyiuser/data/www/yundian.dealerweb
rm -rf *
jar -xvf /home/luoyiuser/source/insurance/yundian.dealerweb/target/yundian.dealerweb.war


echo ‘………………..部署yundian.manage……………………’
cd /home/luoyiuser/data/www/yundian.manage
rm -rf *
jar -xvf /home/luoyiuser/source/insurance/yundian.manage/target/yundian.manage.war




echo ‘………………重启yundian.fssservice……………………’
ps  -ef |grep yundian.fssservice/ |awk '{print "kill -9 " $2}' |sh
sh  /home/luoyiuser/server/yundian.fssservice/bin/startup.sh
echo '重启yundian.fssservice ok!'

echo ‘………………重启yundian.dealerweb……………………’

ps  -ef |grep yundian.dealerweb/ |awk '{print "kill -9 " $2}' |sh
sh  /home/luoyiuser/server/yundian.dealerweb/bin/startup.sh
echo 'yundian.dealerweb ok!'

echo ‘………………重启yundian.manage……………………’

ps  -ef |grep yundian.manage/ |awk '{print "kill -9 " $2}' |sh
sh  /home/luoyiuser/server/yundian.manage/bin/startup.sh
echo 'yundian.manage ok!'