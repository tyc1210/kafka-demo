package com.tyc.service.kafkademo.common;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class ProducerDemo {
    public static void main(String[] args) {
        Properties props = new Properties();
        //kafka 集群， broker list
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"kafka地址");
        props.put(ProducerConfig.ACKS_CONFIG,"all");
        //重试次数
        props.put(ProducerConfig.RETRIES_CONFIG,1);
        //批次大小
        props.put(ProducerConfig.BATCH_SIZE_CONFIG,16384);
        //等待时间
        props.put(ProducerConfig.LINGER_MS_CONFIG,1);
        //缓存池大小
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG,33554432);
        //key value 序列化
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        Producer<String,String> producer = new KafkaProducer<>(props);
        for (int i = 0; i < 100; i++) {
            producer.send(new ProducerRecord<String, String>("topic",Integer.toString(i)),(metadata,exception)->{
                if(null == exception){
                    System.out.println("发送成功");
                }else {exception.printStackTrace();}
            });
        }
        producer.close();
    }
}
