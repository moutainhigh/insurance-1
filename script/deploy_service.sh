git pull
echo ‘………………..打包项目……………………’

mvn clean install -DskipTests=true

echo ‘………………..部署yundian.fssservice项目……………………’
cd /home/luoyiuser/data/www/yundian.fssservice
rm -rf *
jar -xvf /home/luoyiuser/source/insurance/yundian.fssservice/target/yundian.fssservice.war


echo ‘………………重启yundian.fssservice……………………’
ps  -ef |grep yundian.fssservice/ |awk '{print "kill -9 " $2}' |sh
sh  /home/luoyiuser/server/yundian.fssservice/bin/startup.sh
echo '重启yundian.fssservice ok!'
tail -100f /home/luoyiuser/server/yundian.fssservice/logs/catalina.out
