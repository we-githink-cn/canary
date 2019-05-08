package cn.githink.cms;

import cn.githink.wagger.annotations.EnableDpSwagger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@EnableDpSwagger
@SpringCloudApplication
public class DpCmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DpCmsApplication.class, args);
    }

}
