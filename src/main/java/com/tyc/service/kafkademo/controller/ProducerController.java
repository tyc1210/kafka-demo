package com.tyc.service.kafkademo.controller;

import com.tyc.service.kafkademo.common.DataLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tyc
 * @version 1.0
 * @description 类描述
 * @date 2021-04-26 14:25:26
 */
@RestController
@RequestMapping("/kafka")
@Slf4j
public class ProducerController {
//    @Autowired
//    private KafkaTemplate<String,Object> kafkaTemplate;
    @Value("${server.port}")
    private String port;
    @GetMapping("{message}")
    public void sendMessage(@PathVariable String message){
        System.out.println(port);
        DataLog.info("log",message,"随便添加");
//        throw new RuntimeException("aaaa");
//        kafkaTemplate.send("test_topic",message).addCallback(success ->{
//            String topic = success.getRecordMetadata().topic();
//            System.out.println("消息发送到topic:"+topic+"成功");
//            int partition = success.getRecordMetadata().partition();
//            System.out.println("消息发送到partition:"+partition+"成功");
//            long offset = success.getRecordMetadata().offset();
//            System.out.println("消息写到到offset:"+offset+"成功");
//        },failure->{
//            System.out.println("发送消息失败:" + failure.getMessage());
//        });
    }

}
