package noxus.draven.consumer;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ConsumApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumApplication.class, args);
    }

    @Autowired
    private RocketMQTemplate rocketMQTemplate;
}
