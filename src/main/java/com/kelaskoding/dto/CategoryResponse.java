/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kelaskoding.dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jarvis
 */

public class CategoryResponse {
    private Long id;
    private String name;
    private List<ProductResponse> products = new ArrayList<>();

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
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
     * @return the products
     */
    public List<ProductResponse> getProducts() {
        return products;
    }

    /**
     * @param products the products to set
     */
    public void setProducts(List<ProductResponse> products) {
        this.products = products;
    }
    
    
}
