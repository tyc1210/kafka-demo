package com.tyc.service.kafkademo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kafka初始化配置
 * @version 1.0
 * @description 类描述
 * @date 2021-04-26 14:11:59
 */
//@Configuration
public class KafkaInitialConfiguration {

    /**
     * 创建一个名为testtopic的Topic并设置分区数为8，分区副本数为2
     * @return
     */
//    @Bean
//    public NewTopic initTopic(){
//        return new NewTopic("test_topic",8,(short) 2);
//    }

    /**
     * 如果要修改分区数，只需修改配置值重启项目即可
     * 修改分区数并不会导致数据的丢失，但是分区数只能增大不能减小
     * @return
     */
//    @Bean
//    public NewTopic updateTopic() {
//        return new NewTopic("test_topic",10, (short) 2 );
//    }
}
