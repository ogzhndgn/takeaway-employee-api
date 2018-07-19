package org.thepoet.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thepoet.rabbitmq.EventConsumer;

/**
 * @author the Poet <dogan_oguzhan@hotmail.com>
 * @date 19.07.2018
 */
@Configuration
public class TakeawayEventConsumerConfiguration {
    @Bean
    public TopicExchange sendTopicExchange() {
        return new TopicExchange("takeaway-event-exchange");
    }

    @Bean
    public Queue queue() {
        return new Queue("takeaway-employee-event-queue");
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue).to(topicExchange).with("*");
    }

    @Bean
    public EventConsumer eventConsumer() {
        return new EventConsumer();
    }
}