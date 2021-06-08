package com.tangf.hasp;

import Aladdin.Hasp;
import Aladdin.HaspStatus;
import cn.hutool.core.io.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

/**
 * @author tangfei(tangfeizz @ outlook.com)
 * @date 2021/6/7 15:21
 */
@Slf4j
@ShellComponent
public class AppShell {

    /**
     * 默认值
     */
    long feature = Hasp.HASP_DEFAULT_FID;

    Hasp hasp = new Hasp(feature);

    @Value("${hasp.vendorCode}")
    private String vendorCode;

    /**
     * 授权程序验证是否授权方法
     *
     * @param fid 功能ID
     */
    @ShellMethod("登录验证")
    public void Login(@ShellOption(help = "功能ID") Long fid) {

        hasp = new Hasp(fid);

        hasp.login(vendorCode);

        int status = hasp.getLastError();

        log.info("状态：{}", status);

        if (status == 64) {
            log.warn("功能对应的授权锁已经报废了，请联系管理员");
            return;
        }

        if (HaspStatus.HASP_STATUS_OK != status) {
            log.warn("访问失败");
        } else {
            log.info("成功访问");
        }


    }

    /**
     * 获取锁的信息
     */
    @ShellMethod("获取锁信息")
    public void GetInfo() {

        String scope =
                "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
                        "<haspscope>" +
                        "    <license_manager hostname=\"localhost\" />" +
                        "</haspscope>";

        String format =
                "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
                        "<haspformat root=\"hasp_info\">" +
                        "    <feature>" +
                        "        <attribute name=\"id\" />" +
                        "        <element name=\"license\" />" +
                        "        <hasp>" +
                        "          <attribute name=\"id\" />" +
                        "          <attribute name=\"type\" />" +
                        "        </hasp>" +
                        "    </feature>" +
                        "</haspformat>" +
                        "";

        String info;

        info = hasp.getInfo(scope, format, vendorCode);

        int status = hasp.getLastError();

        log.info("状态：{}", status);
        log.info("返回信息：{}", info);
    }

    /**
     * 获取机器指纹信息
     */
    @ShellMethod("获取指纹信息")
    public void Generate() {

        String scope =
                "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
                        "<haspscope>" +
                        "    <license_manager hostname=\"localhost\" />" +
                        "</haspscope>";

        String format =
                "<haspformat format=\"host_fingerprint\"/>";

        String info;

        info = hasp.getInfo(scope, format, vendorCode);

        int status = hasp.getLastError();

        log.info("状态：{}", status);
        log.info("返回信息：{}", info);
    }

    /**
     * 更新授权文件操作
     *
     * @param path V2C文件的绝对路径地址
     */
    @ShellMethod("更新授权文件")
    public void Update(@ShellOption(help = "V2C文件路径") String path) {

        String result = FileUtil.readString(path, "UTF-8");

        String ack = hasp.update(result);

        int status = hasp.getLastError();

        log.info("状态：{}", status);
        log.info("ACK：{}", ack);

    }
}
