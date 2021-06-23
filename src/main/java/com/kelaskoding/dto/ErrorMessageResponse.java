/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kelaskoding.dto;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jarvis
 */
public class ErrorMessageResponse {
    
    private boolean status;
    
    private Map<String, String> errors = new HashMap<>();

    /**
     * @return the errors
     */
    public Map<String, String> getErrors() {
        return errors;
    }

    /**
     * @param errors the errors to set
     */
    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
    
    
}
