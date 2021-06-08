#!/bin/bash

echo '开始编译项目和打包'
mvn clean package -DskipTests

#部署的机器IP
host=172.26.1.22

#sshpass 需要单独安装
echo '开始上传jar到目标服务器上' $host
sshpass -p 123456 scp ./target/hasp-0.0.1-SNAPSHOT.jar root@$host:/root