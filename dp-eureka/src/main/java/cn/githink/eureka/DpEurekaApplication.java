package cn.githink.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class DpEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DpEurekaApplication.class, args);
    }

}
