package com.tyc.service.kafkademo.common;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author tyc
 * @version 1.0
 * @description 类描述
 * @date 2021-04-26 14:30:50
 */
//@Component
@Slf4j
public class Consumer {
//    @KafkaListener(topics = {"test_topic"})
//    public void onMessage(ConsumerRecord<?,?> record){
//        log.info("简单消费："+record.topic()+"-"+record.partition()+"-"+record.value());
//        DataLog.info("基本数据",record.value().toString());
//    }
}
