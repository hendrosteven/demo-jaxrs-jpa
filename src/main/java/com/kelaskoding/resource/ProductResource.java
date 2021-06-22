/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kelaskoding.resource;

import com.kelaskoding.entity.Category;
import com.kelaskoding.entity.Product;
import com.kelaskoding.repo.ProductRepo;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author jarvis
 */
@Path("/products")
@ApplicationScoped
public class ProductResource {

    @Inject
    private ProductRepo repo;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createOne(Product product) {
        repo.create(product);
        return Response.ok(product).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> findAll() {
        return repo.findAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/category/{id}")
    public List<Product> findByCategoryId(@PathParam("id") Long categoryId) {
        return repo.findByCategoryId(categoryId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response findOne(@PathParam("id") Long id) {
        Product product = repo.findOne(id);
        if (product == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(product).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public void removeOne(@PathParam("id") Long id) {
        repo.removeOne(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateOne(Product product) {
        repo.update(product);
        return Response.ok(product).build();
    }

}
