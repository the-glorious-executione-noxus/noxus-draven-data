# 架构概念

## provider



### consumer



## nameserver（集群）

查找broker



## broker（集群）

### topic

message queue



3.x摒弃了zk

使用了NameServer



零拷贝

拉取

推送

事务消息



### 顺序消息







# 安装

非docker

```shell
# 注意版本是否一致
https://www.apache.org/dyn/closer.cgi?path=rocketmq/4.3.2/rocketmq-all-4.3.2-bin-release.z


cd /haoke
unzip rocketmq-all-4.3.2-bin-release.zip
cd rocketmq-all-4.3.2-bin-release
#启动nameserver
bin/mqnamesrv
# The Name Server boot success. serializeType=JSON 看到这个表示已经提供成功
#启动broker
bin/mqbroker -n 172.16.185.55:9876 #-n 指定nameserver地址和端口
#启动出错
Java HotSpot(TM) 64-Bit Server VM warning: INFO:
os::commit_memory(0x00000005c0000000, 8589934592, 0) failed; error='Cannot allocate
memory' (errno=12)





# 测试
export NAMESRV_ADDR=127.0.0.1:9876
cd bin
sh tools.sh org.apache.rocketmq.example.quickstart.Producer
#测试结果
SendResult [sendStatus=SEND_OK, msgId=AC110001473C7D4991AD336AEA5703E0,
offsetMsgId=AC11000100002A9F00000000000E8580, messageQueue=MessageQueue
[topic=TopicTest, brokerName=itcast, queueId=3], queueOffset=1323]
SendResult [sendStatus=SEND_OK, msgId=AC110001473C7D4991AD336AEA5903E1,
offsetMsgId=AC11000100002A9F00000000000E8634, messageQueue=MessageQueue
[topic=TopicTest, brokerName=itcast, queueId=0], queueOffset=1323]
SendResult [sendStatus=SEND_OK, msgId=AC110001473C7D4991AD336AEA5F03E2,
offsetMsgId=AC11000100002A9F00000000000E86E8, messageQueue=MessageQueue
[topic=TopicTest, brokerName=itcast, queueId=1], queueOffset=1323]
SendResult [sendStatus=SEND_OK, msgId=AC110001473C7D4991AD336AEA6103E3,
offsetMsgId=AC11000100002A9F00000000000E879C, messageQueue=MessageQueue
[topic=TopicTest, brokerName=itcast, queueId=2], queueOffset=1323]
#可以正常发送消息



sh tools.sh org.apache.rocketmq.example.quickstart.Consumer
#测试结果
ConsumeMessageThread_7 Receive New Messages: [MessageExt [queueId=2, storeSize=180,
queueOffset=1322, sysFlag=0, bornTimestamp=1544456244818,
bornHost=/172.16.55.185:33702, storeTimestamp=1544456244819,
storeHost=/172.17.0.1:10911, msgId=AC11000100002A9F00000000000E84CC,
commitLogOffset=951500, bodyCRC=684865321, reconsumeTimes=0,
preparedTransactionOffset=0, toString()=Message{topic='TopicTest', flag=0,
properties={MIN_OFFSET=0, MAX_OFFSET=1325, CONSUME_START_TIME=1544456445397,
UNIQ_KEY=AC110001473C7D4991AD336AEA5203DF, WAIT=true, TAGS=TagA}, body=[72, 101, 108,
108, 111, 32, 82, 111, 99, 107, 101, 116, 77, 81, 32, 57, 57, 49],
transactionId='null'}]]
ConsumeMessageThread_6 Receive New Messages: [MessageExt [queueId=2, storeSize=180,
queueOffset=1323, sysFlag=0, bornTimestamp=1544456244833,
bornHost=/172.16.55.185:33702, storeTimestamp=1544456244835,
storeHost=/172.17.0.1:10911, msgId=AC11000100002A9F00000000000E879C,
commitLogOffset=952220, bodyCRC=801108784, reconsumeTimes=0,
preparedTransactionOffset=0, toString()=Message{topic='TopicTest', flag=0,
properties={MIN_OFFSET=0, MAX_OFFSET=1325, CONSUME_START_TIME=1544456445397,
UNIQ_KEY=AC110001473C7D4991AD336AEA6103E3, WAIT=true, TAGS=TagA}, body=[72, 101, 108,
108, 111, 32, 82, 111, 99, 107, 101, 116, 77, 81, 32, 57, 57, 53],
transactionId='null'}]]
#从结果中，可以看出，接收消息正常



```

## docker

#拉取镜像

```shell
docker pull foxiswho/rocketmq:server-4.5.2
docker pull foxiswho/rocketmq:broker-4.5.2

vi /haoke/rmq/rmqbroker/conf/broker.conf
brokerIP1=116.196.77.250
namesrvAddr=116.196.77.250:9876
brokerName=broker_haoke_im


```

```shell
#创建nameserver容器
docker create -p 9876:9876 --name rmqserver \
-e "JAVA_OPT_EXT=-server -Xms128m -Xmx128m -Xmn128m" \
-e "JAVA_OPTS=-Duser.home=/opt" \
-v /haoke/rmq/rmqserver/logs:/opt/logs \
-v /haoke/rmq/rmqserver/store:/opt/store \
foxiswho/rocketmq:server-4.5.2


# 创建broker容器
docker create -p 10911:10911 -p 10909:10909 --name rmqbroker \
-e "JAVA_OPTS=-Duser.home=/opt" \
-e "JAVA_OPT_EXT=-server -Xms128m -Xmx128m -Xmn128m" \
-v /haoke/rmq/rmqbroker/conf/broker.conf:/etc/rocketmq/broker.conf \
-v /haoke/rmq/rmqbroker/logs:/opt/logs \
-v /haoke/rmq/rmqbroker/store:/opt/store \
foxiswho/rocketmq:broker-4.5.2


# styletang/rocketmq-console-ng
docker run -e "JAVA_OPTS=-Drocketmq.namesrv.addr=116.196.77.250:9876 - Dcom.rocketmq.sendMessageWithVIPChannel=false" \ -p 8082:8080 \
-t styletang/rocketmq-console-ng



```







# FQA

```shell
启动错误，是因为内存不够，导致启动失败，原因：RocketMQ的配置默认是生产环境的配置，设置的jvm的内大小值比较大，对于学习而言没有必要设置这么大，测试环境的内存往往都不是很大，所以需要调整默


调整默认的内存大小参数
cd bin/
vim runserver.sh
JAVA_OPT="${JAVA_OPT} -server -Xms128m -Xmx128m -Xmn128m -XX:MetaspaceSize=128m -
XX:MaxMetaspaceSize=128m"
cd bin/
vim runbroker.sh
JAVA_OPT="${JAVA_OPT} -server -Xms128m -Xmx128m -Xmn128m"
#从新启动测试
bin/mqbroker -n 172.16.55.185:9876
The broker[itcast, 172.17.0.1:10911] boot success. serializeType=JSON and name
server is 172.16.185.55:9876
```







```
org.springframework.messaging.MessagingException: sendDefaultImpl call timeout; nested exception is org.apache.rocketmq.remoting.exception.RemotingTooMuchRequestException: sendDefaultImpl call timeout

```

