package com.rabbit.boot.rabbit_boot.controller;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

@RestController
public class SendController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping(value = "sendMessage/{message}")
    public String sendMessage(@PathVariable String message){
        MessageProperties properties = MessagePropertiesBuilder.newInstance().setContentType("utf-8")
                .setHeader("key", "value")
                .setContentEncoding("utf-8")
                .build();
        Message msg = MessageBuilder.withBody(message.getBytes(StandardCharsets.UTF_8)).andProperties(properties)
                .setContentEncoding("utf-8")
                .build();
        amqpTemplate.send("ex.direct.boot","key.boot",msg);
        return "ko";
    }

}
