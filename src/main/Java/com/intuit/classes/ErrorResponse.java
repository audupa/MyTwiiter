package com.intuit.classes;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

/**
 * Created with IntelliJ IDEA.
 * User: AUDUPA
 * Date: 9/6/13
 * Time: 8:42 PM
 * To change this template use File | Settings | File Templates.
 */

@Component
public class ErrorResponse {
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    private String errorMessage;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    private int errorCode;
}
