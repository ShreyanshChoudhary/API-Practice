package com.web_app.Service;

import com.web_app.model.Product;
import com.web_app.repository.ProductRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    Logger logger = LoggerFactory.getLogger(ProductService.class);
   /* private final List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(101, "Iphone", 50000),
            new Product(102, "Google", 40000),
            new Product(103, "Micromax", 10000)
    ));*/

    public List<Product> getProducts() {
        return repo.findAll();
    }
    @Autowired
    ProductRepo repo;

    public Product getProductByID(int prodId) {

      /*  Product  product =  products.stream()
                .filter(p -> p.getProdId() == prodId)
                .findFirst()
                .orElse(new Product(prodId, "not found", 0));
        if(product.getProdName().contains("not found")){
            logger.info("Product is not available for productId - {}",prodId);
            return product;
        }*/

    /*    logger.info("Product fetched successfully for productId - {}",prodId);*/
        return repo.findById(prodId).orElseGet
                (()->
        {
            logger.info("product is not available for productId - {}", prodId);
            return new Product(100, "Product not found", 0);
        });
    }

    public void addProd(Product prod) {
        logger.info("Product added successfully");
        repo.save(prod);
    }

    public void deleteProd(Integer prodId) {
        logger.info("Product deleted successfully");
repo.deleteById(prodId);    }

    public void updateProd(Product prod,Integer prodId) {
        logger.info("Product with prodId{} updated successfully",prodId);
     repo.save(prod);
    }
}