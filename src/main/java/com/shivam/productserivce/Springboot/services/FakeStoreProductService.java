package com.shivam.productserivce.Springboot.services;

import com.shivam.productserivce.Springboot.DTOs.FakeStoreProductDto;
import com.shivam.productserivce.Springboot.exceptions.ProductNotExistsException;
import com.shivam.productserivce.Springboot.models.Category;
import com.shivam.productserivce.Springboot.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

   private RestTemplate restTemplate;
    @Autowired

    public FakeStoreProductService(RestTemplate restTemplate)
    {
        this.restTemplate=restTemplate;
    }

   private Product ConvertFakeStoreProducttoProduct(FakeStoreProductDto fakeStoreProduct)
   {
       Product product = new Product();
       product.setTitle(fakeStoreProduct.getTitle());
       product.setId(fakeStoreProduct.getId());
       product.setPrice(fakeStoreProduct.getPrice());
       product.setDescription(fakeStoreProduct.getDescription());
       product.setImageurl(fakeStoreProduct.getImage());
       product.setCategory(new Category());
       product.getCategory().setName(fakeStoreProduct.getCategory());

       return product;
   }

    @Override
    public Product getSingleProduct(Long id) throws ProductNotExistsException {
        FakeStoreProductDto productDto= restTemplate.getForObject(
                "https://fakestoreapi.com/products/"+id,
                FakeStoreProductDto.class
        );

       if(productDto==null)
       {
           throw new ProductNotExistsException("Product with id "+ id +" not exists");
       }
     return ConvertFakeStoreProducttoProduct(productDto);
    }

    @Override
    public List<Product> getAllProducts() {

        FakeStoreProductDto [] allproductDto= restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreProductDto[].class
        );

        ArrayList<Product> answer= new ArrayList<>();
        for(FakeStoreProductDto dto:allproductDto)
        {
            answer.add(ConvertFakeStoreProducttoProduct(dto));
        }

        return answer;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setImage(product.getDescription());
        fakeStoreProductDto.setImage(product.getImageurl());

        RequestCallback requestCallback = restTemplate.httpEntityCallback(fakeStoreProductDto, FakeStoreProductDto.class);
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor =
                new HttpMessageConverterExtractor<>(FakeStoreProductDto.class, restTemplate.getMessageConverters());
        FakeStoreProductDto response = restTemplate.execute("https://fakestoreapi.com/products/" + id, HttpMethod.PUT, requestCallback, responseExtractor);

        return ConvertFakeStoreProducttoProduct(response);

         }

}
