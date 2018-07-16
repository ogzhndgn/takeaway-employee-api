package org.thepoet.util;

import org.thepoet.exception.ServiceException;

/**
 * @author the Poet <dogan_oguzhan@hotmail.com>
 * @date 15.07.2018
 */
public class TakeawayApiError {
    private String takeawayApiErrorMessage;

    public TakeawayApiError(String takeawayApiErrorMessage) {
        this.takeawayApiErrorMessage = takeawayApiErrorMessage;
    }

    public TakeawayApiError(ServiceException serviceException) {
        this.takeawayApiErrorMessage = serviceException.getMessage();
    }

    public String getTakeawayApiErrorMessage() {
        return takeawayApiErrorMessage;
    }
}