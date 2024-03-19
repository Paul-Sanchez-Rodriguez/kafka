package com.kafka.provider.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic generateTopic(){

        Map<String, String> configurations = new HashMap<>();

        //delete(borra el mensaje) y compact (Mantiene el mas actual)
        configurations.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE);
        //esto hace que se retenga el mensaje en milisegundos - por defecto viene en -1 (osea nunca se borraran los mensajes)
        configurations.put(TopicConfig.RETENTION_MS_CONFIG,"86400000");
        //el tamaño del segmento del topic, se coloca en bytes - por defecto viene 1GB
        configurations.put(TopicConfig.SEGMENT_BYTES_CONFIG,"1073741824");
        //el peso o tamaño maximo de cada mensaje - por defecto viene en 1GB
        configurations.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG,"1000012");

        NewTopic newTopic = TopicBuilder.name("new-provider")
                .partitions(2)
                .replicas(2)
                .configs(configurations)
                .build();

        return newTopic;
    }
}
