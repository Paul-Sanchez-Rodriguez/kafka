package com.kafka.consumer.listener;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConsumerListener {

    @KafkaListener(topics = {"new-provider"}, groupId = "my-group-id")
     public void listener(String message){
         System.out.println("Mensaje recibido, el mensaje es: " + message);
     }
}
