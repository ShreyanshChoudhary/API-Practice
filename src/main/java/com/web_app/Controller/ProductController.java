package com.web_app.Controller;

import com.web_app.Service.ProductService;
import com.web_app.model.Product;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> getProducts() {
        return service.getProducts();
    }

    @GetMapping("/{prodId}")
    public Product getProductByID(@PathVariable int prodId) {
        return service.getProductByID(prodId);
    }

    @PostMapping
    public ResponseEntity<String> addProd(@Valid @RequestBody Product prod) {
        service.addProd(prod);
        return ResponseEntity.ok("Product added successfully");
    }
    @DeleteMapping
    public ResponseEntity<String> deleteprod(@Valid @RequestBody Product prod){
        service.deleteProd(prod);
        return  ResponseEntity.ok("Product deleted sucessfully");
    }
    @PutMapping
    public ResponseEntity<String> updateprod(@Valid @RequestBody Product prod){
        service.updateProd(prod);
        return ResponseEntity.ok("Product updated Sucessfully");
    }
}
