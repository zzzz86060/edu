package com.zz.base;

import java.io.*;

/**
 * Created by jyf on 2017/6/2.
 */
public class test {
    public static void main(String[] args) {
        String ftpHost = "ftp://47.111.158.87:21";
        String ftpUserName = "root";
        String ftpPassword = "MwBp6ZPKY6nAdene";
        int ftpPort = 21;
        String ftpPath = "opt/DockerFile";
        String localPath = "D:\\SteamLibrary\\java_\\demo2\\target\\demo2-0.0.1-SNAPSHOT.jar";
        String fileName = "demo2-0.0.1-SNAPSHOT.jar";

        //上传一个文件
        try {
            FileInputStream in = new FileInputStream(new File(localPath));
            boolean test = FtpUtil.uploadFile(ftpHost, ftpUserName, ftpPassword, ftpPort, ftpPath, fileName, in);
            System.out.println(test);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(e);
        }

    }
}