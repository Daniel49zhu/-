package rocketmqtest.producer;

import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import rocketmqdemo.Application;
import rocketmqdemo.producer.Demo01Producer;

import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class Demo01ProducerTest {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    private Demo01Producer producer;


    @Test
    public void testSyncSend() throws InterruptedException {
        int id = (int) (System.currentTimeMillis() / 1000);
        SendResult result = producer.syncSend(id);
        logger.info("[testSyncSend][发送编号：[{}] 发送结果：[{}]]", id, result);
        new CountDownLatch(1).await();
    }

    @Test
    public void testAsyncSend() throws InterruptedException {
        int id = (int) (System.currentTimeMillis() / 1000);

        producer.asyncSend(id, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                logger.info("[testASyncSend][发送编号：[{}] 发送成功，结果为：[{}]]", id, sendResult);
            }

            @Override
            public void onException(Throwable throwable) {

            }
        });

        new CountDownLatch(1).await();
    }

    @Test
    public void testOneWaySend() throws InterruptedException {
        int id = (int) (System.currentTimeMillis() / 1000);
        producer.onewaySend(id);
        logger.info("[testOnewaySend][发送编号：[{}] 发送完成]", id);

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }
}
