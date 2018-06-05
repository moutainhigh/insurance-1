git pull
echo ‘………………..打包项目……………………’

cd /home/luoyiuser/source/insurance/yundian.dealerweb

mvn clean install -DskipTests=true

echo ‘………………..部署yundian.dealerweb……………………’
cd /home/luoyiuser/data/www/yundian.dealerweb
rm -rf *
jar -xvf /home/luoyiuser/source/insurance/yundian.dealerweb/target/yundian-dealerweb.war

cp /home/luoyiuser/data/www/conf/aliyunoss.properties /home/luoyiuser/data/www/yundian.dealerweb/WEB-INF/classes/aliyunoss.properties


echo ‘………………重启yundian.dealerweb……………………’

ps  -ef |grep yundian.dealerweb/ |awk '{print "kill -9 " $2}' |sh
sh  /home/luoyiuser/server/yundian.dealerweb/bin/startup.sh
echo 'yundian.dealerweb ok!'
tail -100f /home/luoyiuser/server/yundian.dealerweb/logs/catalina.out