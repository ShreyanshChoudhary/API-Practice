package com.web_app.Controller;

import com.web_app.Service.ProductService;
import com.web_app.model.Product;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> getProducts() {
        return service.getProducts();
    }

    @GetMapping("/{prodId}")
    public Product getProductByID(@PathVariable Integer prodId) {
        logger.info("Started fetching pproduct for prodcutId - {}",prodId);
        return service.getProductByID(prodId);
    }

    @PostMapping
    public ResponseEntity<String> addProd(@Valid @RequestBody Product prod) {
        service.addProd(prod);
        return ResponseEntity.ok("Product added successfully");
    }
    @DeleteMapping
    public ResponseEntity<String> deleteprod(@Valid @RequestBody Integer prodId){
        service.deleteProd(prodId);
        return  ResponseEntity.ok("Product deleted sucessfully");
    }
    @PutMapping
    public ResponseEntity<String> updateprod(@Valid @RequestBody Product prod,Integer prodId){
        service.updateProd(prod,prodId);
        return ResponseEntity.ok("Product updated Sucessfully");
    }
}
