package com.shivam.productserivce.Springboot.controller;

import com.shivam.productserivce.Springboot.exceptions.ProductNotExistsException;
import com.shivam.productserivce.Springboot.models.Product;
import com.shivam.productserivce.Springboot.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

   private ProductService productService;

  @Autowired
   public ProductController(ProductService productService)
   {
       this.productService=productService;
   }

    @GetMapping()
    public ResponseEntity<List<Product>> getAllproducts()
    {

        List<Product> allProducts = productService.getAllProducts();
        ResponseEntity<List<Product>> response= new ResponseEntity<>(allProducts, HttpStatus.NOT_EXTENDED);
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") long id) throws ProductNotExistsException {

           ResponseEntity<Product> response = new ResponseEntity<>(productService.getSingleProduct(id), HttpStatus.OK);
           return response;

    }

    @PostMapping ()
    public ResponseEntity<Product> addProduct(@RequestBody Product product)
    {
        ResponseEntity<Product> response= new ResponseEntity<>(new Product(),HttpStatus.OK);

        return response;
    }


    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") long id,@RequestBody Product product)
    {
        return new Product();
    }

    @PutMapping("/{id}")

    public Product replaceProduct(@PathVariable("id") long id, @RequestBody Product product)
    {
        return productService.replaceProduct(id,product);
    }


  @DeleteMapping("/{id}")
    public void deleteProduct( @PathVariable long id)
  {
      System.out.println("Deleted Successfully");
  }
}
