package noxus.draven.provider.topic;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;

public class TopicDemo {
    private static final String IP = "116.196.77.250:9876";
    private static final String DEFAULT_PRODUCER = "demo";
    private static final String ip = "116.196.77.250:9876";
    private static final String createTopic1 = "broker_haoke_im";
    private static final String createTopic2 = "haoke_im_topic";
    private static final Integer createTopic3 = 8;


    public static void main(String[] args) throws MQClientException {
        DefaultMQProducer demo = new DefaultMQProducer(DEFAULT_PRODUCER);
        demo.setNamesrvAddr(ip);
        demo.start();
        /**
         * key：broker名称
         * newTopic：topic名称
         * queueNum：队列数（分区）
         */
        demo.createTopic(createTopic1, createTopic2, createTopic3);
        System.out.println("创建topic成功");
        demo.shutdown();
    }
}
