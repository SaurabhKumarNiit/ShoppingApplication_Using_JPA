package org.practice.jpa.ShoppingApplication.controller;

import org.practice.jpa.ShoppingApplication.domain.Product;
import org.practice.jpa.ShoppingApplication.service.ProductService;
import org.practice.jpa.ShoppingApplication.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productdetails/app/")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService=productService;
    }

    @PostMapping("/product")
    public ResponseEntity<?> insertProduct(@RequestBody Product product){

        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
    }

    @GetMapping("/products")
    public ResponseEntity<?> getProductDetails(){
        return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.FOUND);
    }

    @DeleteMapping("/product/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable int productId){
        return new ResponseEntity<>(productService.deleteProductByProductId(productId),HttpStatus.OK);
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<?> fetchByProductId(@PathVariable int productId){
        return new ResponseEntity<>(productService.getProductByProductId(productId),HttpStatus.FOUND);
    }
}
