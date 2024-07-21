package com.web_app.Service;

import com.web_app.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {
    Logger logger = LoggerFactory.getLogger(ProductService.class);
    private final List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(101, "Iphone", 50000),
            new Product(102, "Google", 40000),
            new Product(103, "Micromax", 10000)
    ));

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductByID(int prodId) {

        Product  product =  products.stream()
                .filter(p -> p.getProdId() == prodId)
                .findFirst()
                .orElse(new Product(prodId, "not found", 0));
        if(product.getProdName().contains("not found")){
            logger.info("Product is not available for productId - {}",prodId);
            return product;
        }

        logger.info("Product fetched successfully for productId - {}",prodId);
        return product;
    }

    public void addProd(Product prod) {
        products.add(prod);
    }

    public void deleteProd(Product prod) {
        products.remove(prod);
    }

    public void updateProd(Product prod) {
        int index = 0;

        for (int i = 0; i < products.size(); i++) {

            if (products.get(i).getProdId() == prod.getProdId()) {
                index = i;
            }
            products.set(index, prod);
        }
    }
}