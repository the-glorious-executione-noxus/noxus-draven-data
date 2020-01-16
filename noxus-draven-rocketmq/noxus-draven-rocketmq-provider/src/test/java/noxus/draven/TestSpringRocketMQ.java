package noxus.draven;

import noxus.draven.provider.ProviderApplication;
import noxus.draven.provider.controller.ProviderTest;
import noxus.draven.provider.controller.TransactionProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProviderApplication.class)
public class TestSpringRocketMQ {
    @Autowired
    private ProviderTest providerTest;

    @Autowired
    private TransactionProducer transactionProduce;

    @Test
    public void testSendMsg() {
        this.providerTest.sendMsg("my-topic", "第一个Spring消息");
    }

    @Test
    public void testSendMsg2() {
        this.transactionProduce.sendMsg("my-topic", "事务Spring消息");
    }

}
