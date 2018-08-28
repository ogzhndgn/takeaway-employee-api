package org.thepoet.rabbitmq;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thepoet.model.Event;

import java.util.Date;
import java.util.UUID;

/**
 * @author the Poet <dogan_oguzhan@hotmail.com>
 * @date 19.07.2018
 */
@Component
public class EventPublisher {
    private final RabbitTemplate rabbitTemplate;
    private final TopicExchange topicExchange;

    @Autowired
    public EventPublisher(RabbitTemplate rabbitTemplate, TopicExchange topicExchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.topicExchange = topicExchange;
    }

    public void sendMessage(String eventType, String employeeId) {
        Event event = new Event();
        event.setEventId(UUID.randomUUID().toString());
        event.setEmployeeId(employeeId);
        event.setEventType(eventType);
        event.setPublishedTime(new Date());
        rabbitTemplate.convertAndSend(topicExchange.getName(), employeeId, event);
    }
}
