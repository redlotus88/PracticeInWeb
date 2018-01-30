package cn.stsniper.eureka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by dragon on 2018/1/30.
 *
 * PiW eureka server.
 */

@EnableEurekaServer
@SpringBootApplication
public class PiWEurekaServerApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(PiWEurekaServerApplication.class)
                .web(true).run(args);
    }
}
