package com.shoppingCenter.product_service.service;

import com.shoppingCenter.product_service.dto.ProductRequest;
import com.shoppingCenter.product_service.dto.ProductResponse;
import com.shoppingCenter.product_service.entity.Product;
import com.shoppingCenter.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
    }

    public List<ProductResponse> getAllProducts(){
        List<Product> products = productRepository.findAll();

        return products.stream().map(this::mapper).toList();

    }

    private ProductResponse mapper(Product product){
        return ProductResponse.builder()
                .id(Math.toIntExact(product.getId()))
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
