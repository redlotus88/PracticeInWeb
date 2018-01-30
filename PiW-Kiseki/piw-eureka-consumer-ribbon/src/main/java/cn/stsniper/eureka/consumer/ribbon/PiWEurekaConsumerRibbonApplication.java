package cn.stsniper.eureka.consumer.ribbon;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by dragon on 2018/1/30.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PiWEurekaConsumerRibbonApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    public static void main(String[] args) {
        new SpringApplicationBuilder(PiWEurekaConsumerRibbonApplication.class).web(true).run(args);
    }
}
