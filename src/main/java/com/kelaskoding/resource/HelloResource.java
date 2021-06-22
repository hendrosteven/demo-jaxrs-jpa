/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kelaskoding.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author jarvis
 */

@Path("/hello")
public class HelloResource {
    
    @GET
    public String sayHello(){
        return "Hello World!";
    }
}
