#!/bin/bash

echo '开始编译项目和打包'
mvn clean package -DskipTests

#部署的机器IP
user=admin
host=172.26.10.60
pass=admin

#sshpass 需要单独安装
echo '开始上传jar到目标服务器上' $host
sshpass -p $pass scp -q -o StrictHostKeyChecking=no ./target/hasp-0.0.1-SNAPSHOT.jar $user@$host:/home/admin