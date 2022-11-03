package org.practice.jpa.ShoppingApplication.service;

import org.practice.jpa.ShoppingApplication.domain.Product;

import java.util.List;

public interface ProductService {

    public Product addProduct(Product user);

    public List<Product> getAllProducts();

    public List<Product> getProductByProductId(int productId);

    public boolean deleteProductByProductId(int productId);


}
