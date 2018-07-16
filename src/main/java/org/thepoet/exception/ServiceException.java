package org.thepoet.exception;

import org.thepoet.enums.ErrorCode;

/**
 * @author the Poet <dogan_oguzhan@hotmail.com>
 * @date 15.07.2018
 */
public class ServiceException extends Exception {
    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(ErrorCode errorCode) {
        super(errorCode.name());
    }
}