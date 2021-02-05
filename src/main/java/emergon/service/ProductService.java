/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.service;

import emergon.entity.Product;
import emergon.repository.ProductRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author gkolo
 */
@Transactional
@Service
public class ProductService {
    
    @Autowired 
    ProductRepo productRepo;

    private List<Product> products;

    public List<Product> getProducts() {
        List<Product> products = productRepo.findAll();
//        if (products == null) {
//            products = new ArrayList();
//            products.add(new Product(1336, "CPU Ryzen 5", 201.20));
//            products.add(new Product(1337, "Gigabyte 1080RTX", 535.90));
//            products.add(new Product(1338, "Samsung EVO 1TB", 171.10));
//        }
        return products;
    }

    public void addProduct(Product product) {
        productRepo.save(product);
    }
    
    public void deleteProduct(int id){
        productRepo.delete(Product.class, id);
    }
    
    public Product getProductById(int pcode){
        return productRepo.find(pcode);
    }
    
    public Product updateProduct(Product product){
        Product productToUpdate = getProductById(product.getPcode());
        productToUpdate.setPdescr(product.getPdescr());
        productToUpdate.setPprice(product.getPprice());
        return productToUpdate;
    }

}
