package com.example.eurekasever;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * ***************************
 * 类说明
 * ***************************
 *
 * @author: qgx
 * @date: 2019-04-03 23:34
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaSeverApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaSeverApplication.class, args);
    }

}
