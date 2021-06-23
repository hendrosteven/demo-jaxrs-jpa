/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kelaskoding.dto;

import com.kelaskoding.entity.Category;
import com.kelaskoding.validator.UniqueCode;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author jarvis
 */
public class ProductRequest {
    
    @NotNull(message = "Code is required")
    @Pattern(regexp = "PR[0-9]+", message = "Code must be start with \'PR\' and follow by digits") //PR003 
    @Size(min = 3, max = 5, message = "Code length must be in 3 to 5 character")
    @UniqueCode
    private String code;
    
    @NotNull(message = "Name is required")
    private String name;
    
    private String description;
        
    private double price;
    
    private Category category;

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
    
    
}
