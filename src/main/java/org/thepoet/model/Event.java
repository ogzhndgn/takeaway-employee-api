package org.thepoet.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author the Poet <dogan_oguzhan@hotmail.com>
 * @date 19.07.2018
 */
public class Event implements Serializable {
    private String employeeId;
    private String eventType;
    private Date eventDateTime;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Date getEventDateTime() {
        return eventDateTime;
    }

    public void setEventDateTime(Date eventDateTime) {
        this.eventDateTime = eventDateTime;
    }
}