package noxus.draven.provider.controller;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Controller;

@Controller
@RocketMQMessageListener(topic = "my-topic",
        consumerGroup = "haoke-consumer",
        selectorExpression = "*")
public class ConsumerTest implements RocketMQListener<String> {
    @Override
    public void onMessage(String msg) {
        System.out.println("接收到消息 -> " + msg);
    }
}
