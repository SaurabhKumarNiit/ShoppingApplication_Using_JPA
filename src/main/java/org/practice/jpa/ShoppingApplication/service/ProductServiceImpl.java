package org.practice.jpa.ShoppingApplication.service;

import org.practice.jpa.ShoppingApplication.domain.Product;
import org.practice.jpa.ShoppingApplication.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    @Override
    public Product addProduct(Product user) {
        return productRepository.save(user);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductByProductId(int productId) {
        return productRepository.findByProductId(productId);
    }

    @Override
    public boolean deleteProductByProductId(int productId) {
        productRepository.deleteById(productId);
        return true;
    }
}
