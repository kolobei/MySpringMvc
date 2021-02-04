/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.service;

import emergon.entity.Product;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author gkolo
 */
@Service
public class ProductService {

    private List<Product> products;

    public List<Product> getProducts() {
        if (products == null) {
            products = new ArrayList();
            products.add(new Product(1336, "CPU Ryzen 5", 201.20));
            products.add(new Product(1337, "Gigabyte 1080RTX", 535.90));
            products.add(new Product(1338, "Samsung EVO 1TB", 171.10));
        }
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

}
