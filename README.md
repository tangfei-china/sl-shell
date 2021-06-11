# sl-shell
圣天诺软锁的Java命令行工具：验证授权、获取授权信息、获取机器指纹信息、更新授权文件等，后续的功能看实际情况在增加,如果你就喜欢用官方的客户端代码去编译，请直接忽视本Shell。



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

3. 需要的动态文件复制到对应的系统目录中，这个根据实际情况的状态码来做调整。

   ![](https://sevenbooks.oss-cn-hangzhou.aliyuncs.com/postimages/20210611094002.png)

4. 启动shell

   ```shell
   java -jar hasp-0.0.1-SNAPSHOT.jar
   ```

   

## 截图

![](https://sevenbooks.oss-cn-hangzhou.aliyuncs.com/postimages/20210608133258.png)



![](https://sevenbooks.oss-cn-hangzhou.aliyuncs.com/postimages/20210608133705.png)



![](https://sevenbooks.oss-cn-hangzhou.aliyuncs.com/postimages/20210608133732.png)



## FAQ

### 状态码

```java
public static final intHASP_STATUS_OK= 0;
public static final intHASP_MEM_RANGE= 1;
public static final intHASP_INV_PROGNUM_OPT= 2;
public static final intHASP_INSUF_MEM= 3;
public static final intHASP_TMOF= 4;
public static final intHASP_ACCESS_DENIED= 5;
public static final intHASP_INCOMPAT_FEATURE= 6;
public static final intHASP_HASP_NOT_FOUND= 7;
public static final intHASP_CONTAINER_NOT_FOUND= 7;
public static final intHASP_TOO_SHORT= 8;
public static final intHASP_INV_HND= 9;
public static final intHASP_INV_FILEID= 10;
public static final intHASP_OLD_DRIVER= 11;
public static final intHASP_NO_TIME= 12;
public static final intHASP_SYS_ERR= 13;
public static final intHASP_NO_DRIVER= 14;
public static final intHASP_INV_FORMAT= 15;
public static final intHASP_REQ_NOT_SUPP= 16;
public static final intHASP_INV_UPDATE_OBJ= 17;
public static final intHASP_KEYID_NOT_FOUND= 18;
public static final intHASP_INV_UPDATE_DATA= 19;
public static final intHASP_INV_UPDATE_NOTSUPP= 20;
public static final intHASP_INV_UPDATE_CNTR= 21;
public static final intHASP_INV_VCODE= 22;
public static final intHASP_ENC_NOT_SUPP= 23;
public static final intHASP_INV_TIME= 24;
public static final intHASP_NO_BATTERY_POWER= 25;
public static final intHASP_NO_ACK_SPACE= 26;
public static final intHASP_TS_DETECTED= 27;
public static final intHASP_FEATURE_TYPE_NOT_IMPL= 28;
public static final intHASP_UNKNOWN_ALG= 29;
public static final intHASP_INV_SIG= 30;
public static final intHASP_FEATURE_NOT_FOUND= 31;
public static final intHASP_NO_LOG= 32;
public static final intHASP_LOCAL_COMM_ERR= 33;
public static final intHASP_UNKNOWN_VCODE= 34;
public static final intHASP_INV_SPEC= 35;
public static final intHASP_INV_SCOPE= 36;
public static final intHASP_TOO_MANY_KEYS= 37;
public static final intHASP_TOO_MANY_USERS= 38;
public static final intHASP_BROKEN_SESSION= 39;
public static final intHASP_REMOTE_COMM_ERR= 40;
public static final intHASP_FEATURE_EXPIRED= 41;
public static final intHASP_OLD_LM= 42;
public static final intHASP_DEVICE_ERR= 43;
public static final intHASP_UPDATE_BLOCKED= 44;
public static final intHASP_TIME_ERR= 45;
public static final intHASP_SCHAN_ERR= 46;
public static final intHASP_STORAGE_CORRUPT= 47;
public static final intHASP_NO_VLIB= 48;
public static final intHASP_INV_VLIB= 49;
public static final intHASP_SCOPE_RESULTS_EMPTY= 50;
public static final intHASP_VM_DETECTED= 51;
public static final intHASP_HARDWARE_MODIFIED= 52;
public static final intHASP_USER_DENIED= 53;
public static final intHASP_UPDATE_TOO_OLD= 54;
public static final intHASP_UPDATE_TOO_NEW= 55;
public static final intHASP_OLD_VLIB= 56;
public static final intHASP_UPLOAD_ERROR= 57;
public static final intHASP_INV_RECIPIENT= 58;
public static final intHASP_INV_DETACH_ACTION= 59;
public static final intHASP_TOO_MANY_PRODUCTS= 60;
public static final intHASP_INV_PRODUCT= 61;
public static final intHASP_UNKNOWN_RECIPIENT= 62;
public static final intHASP_INV_DURATION= 63;
public static final intHASP_CLONE_DETECTED= 64;
public static final intHASP_UPDATE_ALREADY_ADDED= 65;
public static final intHASP_HASP_INACTIVE= 66;
public static final intHASP_NO_DETACHABLE_FEATURE= 67;
public static final intHASP_NO_DEATCHABLE_FEATURE= 67;
public static final intHASP_TOO_MANY_HOSTS= 68;
public static final intHASP_REHOST_NOT_ALLOWED= 69;
public static final intHASP_LICENSE_REHOSTED= 70;
public static final intHASP_REHOST_ALREADY_APPLIED= 71;
public static final intHASP_CANNOT_READ_FILE= 72;
public static final intHASP_EXTENSION_NOT_ALLOWED= 73;
public static final intHASP_DETACH_DISABLED= 74;
public static final intHASP_REHOST_DISABLED= 75;
public static final intHASP_DETACHED_LICENSE_FOUND= 76;
public static final intHASP_RECIPIENT_OLD_LM= 77;
public static final intHASP_SECURE_STORE_ID_MISMATCH= 78;
public static final intHASP_DUPLICATE_HOSTNAME= 79;
public static final intHASP_MISSING_LM= 80;
public static final intHASP_FEATURE_INSUFFICIENT_EXECUTION_COUNT= 81;
public static final intHASP_INCOMPATIBLE_PLATFORM= 82;
public static final intHASP_HASP_DISABLED= 83;
public static final intHASP_SHARING_VIOLATION= 84;
public static final intHASP_NO_API_DYLIB= 400;
public static final intHASP_INV_API_DYLIB= 401;
public static final intHASP_INV_PARAM= 501;
public static final intHASP_NO_EXTBLOCK= 600;
public static final intHASP_INV_PORT_TYPE= 650;
public static final intHASP_INV_PORT= 651;
public static final intHASP_NOT_IMPL= 698;
public static final intHASP_INT_ERR= 699;
public static final intHASP_FIRST_HELPER= 2001;
public static final intHASP_FIRST_HASP_ACT= 3001;
```

### 软锁的位置

```sh
#Winodws
这个路径下是已经安装的SL_AdminMode.
C:\Program Files (x86)\Common Files\SafeNet Sentinel\Sentinel LDK\installed\

#linux
/var/hasplm/installed/xxxxxx
```

