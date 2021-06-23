/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kelaskoding.exception;

import com.kelaskoding.dto.ErrorMessageResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author jarvis
 */
@Provider
public class MyExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(prepareMessage(exception))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    private ErrorMessageResponse prepareMessage(ConstraintViolationException exception) {
        ErrorMessageResponse errors = new ErrorMessageResponse();
        for (ConstraintViolation<?> cv : exception.getConstraintViolations()) {
            errors.getErrors().put(cv.getPropertyPath()+"", cv.getMessage());
        }
        errors.setStatus(true);
        return errors;
    }

}
