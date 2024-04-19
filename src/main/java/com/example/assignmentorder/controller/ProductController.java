package com.example.assignmentorder.controller;

import com.example.assignmentorder.entity.Product;
import com.example.assignmentorder.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.findAll();
        return ResponseEntity.ok().body(products);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Product>> filterProduct(@RequestBody Product product) {
        List<Product> products = productService.findByProductDetail(product);
        return ResponseEntity.ok().body(products);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Integer id) {
        var productOpt = productService.findById(id);

        if(productOpt.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(productOpt.get());
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.create(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Integer id, @RequestBody Product product) {

        if(productService.findById(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }

        product.setId(id);
        Product updatedProduct = productService.update(product);
        return ResponseEntity.ok().body(updatedProduct);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Integer id) {
        var productOpt = productService.findById(id);

        if(productOpt.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        productService.delete(productOpt.get());

        return ResponseEntity.ok().build();
    }

}
