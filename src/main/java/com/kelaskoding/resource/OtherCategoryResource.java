/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kelaskoding.resource;

import com.kelaskoding.dto.CategoryResponse;
import com.kelaskoding.dto.ProductResponse;
import com.kelaskoding.entity.Category;
import com.kelaskoding.entity.Product;
import com.kelaskoding.repo.CategoryRepo;
import com.kelaskoding.repo.ProductRepo;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author jarvis
 */
@Path("/other")
@ApplicationScoped
public class OtherCategoryResource {

    @Inject
    private ProductRepo repoProduct;

    @Inject
    private CategoryRepo repoCategory;

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("/{id}")
    public Response findOneCategoryById(@PathParam("id")Long id) {
        CategoryResponse response = new CategoryResponse();
        
        Category category = repoCategory.findOne(id);
        List<Product> products = repoProduct.findByCategoryId(id);
        
        response.setId(category.getId());
        response.setName(category.getName());
        for(Product p : products){
            ProductResponse pr = new ProductResponse();
            pr.setId(p.getId());
            pr.setName(p.getName());
            pr.setPrice(p.getPrice());
            pr.setDescription(p.getDescription());
            response.getProducts().add(pr);
        }
        
        return Response.ok(response).build();
    }
}
