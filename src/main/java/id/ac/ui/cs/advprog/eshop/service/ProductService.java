package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.List;

public interface ProductService {
    public void create(Product product);
    List<Product> findAll();
    public void edit(Product product);
    public Product findById(String id);
    public void delete(Product product);
}