# sl-shell
圣天诺软锁的Java命令行工具：验证授权、获取授权信息、获取机器指纹信息、更新授权文件等



## 快速开始

1. 执行jars文件安装

   ```shell
   ci/install_jars.sh
   ```

2. 执行编译的脚本

   ```shell
   #!/bin/bash
   
   echo '开始编译项目和打包'
   mvn clean package -DskipTests
   
   #部署的机器IP
   host=172.26.1.22
   
   #sshpass 需要单独安装
   echo '开始上传jar到目标服务器上' $host
   sshpass -p 123456 scp ./target/hasp-0.0.1-SNAPSHOT.jar root@$host:/root
   ```

3. 拷贝2个动态文件到/usr/lib64(linux的环境)

   ![image-20210608133536345](/Users/tangfei/Library/Application Support/typora-user-images/image-20210608133536345.png)

4. 启动shell

   ```shell
   java -jar hasp-0.0.1-SNAPSHOT.jar
   ```

   

## 截图

![](https://sevenbooks.oss-cn-hangzhou.aliyuncs.com/postimages/20210608133258.png)



![](https://sevenbooks.oss-cn-hangzhou.aliyuncs.com/postimages/20210608133705.png)



![](https://sevenbooks.oss-cn-hangzhou.aliyuncs.com/postimages/20210608133732.png)







