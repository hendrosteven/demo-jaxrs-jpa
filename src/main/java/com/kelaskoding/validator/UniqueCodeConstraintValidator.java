/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kelaskoding.validator;

import com.kelaskoding.entity.Product;
import com.kelaskoding.repo.ProductRepo;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author jarvis
 */
@ApplicationScoped
public class UniqueCodeConstraintValidator implements ConstraintValidator<UniqueCode, String> {

    @Inject
    private ProductRepo repo;

    @Override
    public void initialize(UniqueCode constraintAnnotation) {
    }

    @Override
    public boolean isValid(String code, ConstraintValidatorContext context) {
        Long count = -1L;
        try {
            count = repo.findByCode(code);
            System.out.println("COUNT: "+ count);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return count < 1L; 
    }

}
