package com.rabbit.boot.rabbit_boot.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue queue(){
        return new Queue("queue.boot",true,false,false,null);
    }

    // 选择器
    @Bean
    public Exchange exchange(){
        return new DirectExchange("ex.direct.boot",false,false);
    }
    // 绑定
    @Bean
    public Binding binding(){
        return new Binding("queue.boot", Binding.DestinationType.QUEUE,"ex.direct.boot","key.boot",null);

    }
    //

}
