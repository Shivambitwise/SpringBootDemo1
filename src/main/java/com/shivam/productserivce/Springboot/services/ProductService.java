package com.shivam.productserivce.Springboot.services;

import com.shivam.productserivce.Springboot.exceptions.ProductNotExistsException;
import com.shivam.productserivce.Springboot.models.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(Long id) throws ProductNotExistsException;

    List<Product> getAllProducts();

    Product replaceProduct(Long id, Product product);
}
