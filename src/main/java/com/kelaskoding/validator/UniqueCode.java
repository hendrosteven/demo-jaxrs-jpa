/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kelaskoding.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author jarvis
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RUNTIME)
@Constraint(validatedBy = UniqueCodeConstraintValidator.class)
public @interface UniqueCode {
    String message() default "Code is already in used";
    
    Class<?>[] group() default {};
    
    Class<? extends Payload>[] payload() default {};
}
