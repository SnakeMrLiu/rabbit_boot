package com.rabbit.boot.rabbit_boot.rabbit_listence;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class OnListener {
    @RabbitListener(queues = "queue.boot")
    public void OnMessage(@Payload String message, @Header(name = "key") String values) {
        System.out.println(message);
        System.out.println(values);
    }
}
