package com.zz.base;
 
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
 
import java.io.IOException;
 
@Configuration
public class AutoRunWeb {
 
    // 这里是注入你yml配置的端口号
    @Value("${server.port}")
    private String appPort;
    /**
     * 监听事件（当项目启动后），启动浏览器
     */
    @EventListener({ApplicationReadyEvent.class})
    void applicationReadyEvent() {
        System.out.println("应用已经准备就绪 ... 启动浏览器");
        // 需要启动的url（appPort是端口号， "/main"是接口）
        String url = "http://localhost:" + appPort + "/main";
        Runtime runtime = Runtime.getRuntime();
        try {
            // rundll32 url.dll,FileProtocolHandler是Windows系统下用来打开默认浏览器并访问指定URL的命令
            runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
}