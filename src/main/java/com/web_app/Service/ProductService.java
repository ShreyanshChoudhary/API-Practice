package com.web_app.Service;

import com.web_app.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(101, "Iphone", 50000),
            new Product(102, "Google", 40000),
            new Product(103, "Micromax", 10000)
    ));

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductByID(int prodId) {
        return products.stream()
                .filter(p -> p.getProdId() == prodId)
                .findFirst()
                .orElse(new Product(100, "not found", 0));
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