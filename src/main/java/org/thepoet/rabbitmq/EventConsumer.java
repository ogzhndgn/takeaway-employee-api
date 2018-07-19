package org.thepoet.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.thepoet.model.Event;

/**
 * @author the Poet <dogan_oguzhan@hotmail.com>
 * @date 19.07.2018
 */
public class EventConsumer {

    @RabbitListener(queues = "takeaway-employee-event-queue")
    public void receive(Event event) {
        System.out.println("QQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ");
        System.out.println(event.getEmployeeId() + " " + event.getEventType() + " " + event.getEventDateTime());
        System.out.println("QQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ");
    }
}
