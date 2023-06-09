package com.praveenramachandran.shopping.productbrochure.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import com.praveenramachandran.shopping.productbrochure.services.ProductService;
import com.praveenramachandran.shopping.productbrochure.model.Product;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {

    private ProductService productService;

    @Inject
    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GET
    @Timed
    public Response getAllProducts() {
        return Response.status(200)
                .entity(productService.getAllProducts())
                .build();
    }

    @GET
    @Timed
    @Path("{id}")
    public Response getProduct(@PathParam("id") String id) {
        Optional<Product> result = productService.getProduct(id);

        if (result.isPresent()) {
            return Response.status(Response.Status.OK)
                    .entity(result.get())
                    .build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .build();
        }
    }
}
