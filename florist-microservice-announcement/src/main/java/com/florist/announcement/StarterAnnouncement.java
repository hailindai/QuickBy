package com.florist.announcement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 公告展示模块
 *
 */
@SpringBootApplication
@MapperScan("com.florist.announcement.mapper")
@EnableEurekaClient
public class StarterAnnouncement 
{
    public static void main( String[] args )
    {
        SpringApplication.run(StarterAnnouncement.class, args);
    }
}
