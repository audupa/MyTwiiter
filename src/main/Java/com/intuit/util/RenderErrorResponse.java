package com.intuit.util;

import com.intuit.classes.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: AUDUPA
 * Date: 9/6/13
 * Time: 8:40 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class RenderErrorResponse {


    @Autowired
    ErrorResponse errorResponse;

    //to render the error Response
    public ErrorResponse renderError(int errorCode , String errorMessage,HttpServletResponse response){
        errorResponse.setErrorMessage(errorMessage);
        errorResponse.setErrorCode(errorCode);
        response.setStatus(errorCode);
        return errorResponse;

    }

}
