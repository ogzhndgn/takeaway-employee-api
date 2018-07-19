package org.thepoet.config;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.thepoet.rabbitmq.EventPublisher;

/**
 * @author the Poet <dogan_oguzhan@hotmail.com>
 * @date 19.07.2018
 */
@Profile("publisher")
@Configuration
@EnableScheduling
public class TakeawayEventPublisherConfiguration {

    @Bean
    public TopicExchange sendTopicExchange() {
        return new TopicExchange("takeaway-event-exchange");
    }

    public EventPublisher eventPublisher(RabbitTemplate rabbitTemplate, TopicExchange topicExchange) {
        return new EventPublisher(rabbitTemplate, sendTopicExchange());
    }
}
