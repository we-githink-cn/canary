package cn.githink.upms;

import cn.githink.wagger.annotations.EnableDpSwagger;
import io.swagger.annotations.Api;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDpSwagger
@SpringCloudApplication
public class DpUpmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DpUpmsApplication.class, args);
    }

}
