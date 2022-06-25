package com.tyc.service.kafkademo.common;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

public class ConsumerDemo {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"集群地址");
        props.put(ConsumerConfig.GROUP_ID_CONFIG,"消费组名");
        //自动提交, 若要手动提交改为false
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,true);
        //延时一秒提交
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG,"1000");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        KafkaConsumer<Object, Object> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("topic1","topic2"));
        while (true){
            ConsumerRecords<Object, Object> records = consumer.poll(1000);
            for (ConsumerRecord<Object, Object> record : records) {
                System.out.println(record.value().toString()+record.offset()+record.key());
            }
            //同步提交，同步提交，当前线程会阻塞 直到 offset 提交成功
            consumer.commitSync();
            consumer.commitAsync(new OffsetCommitCallback() {
                @Override
                public void onComplete(Map<TopicPartition, OffsetAndMetadata> map, Exception e) {
                    if(null != e){
                        System.out.println("消费失败"+map);
                    }
                }
            });

        }
    }
}
