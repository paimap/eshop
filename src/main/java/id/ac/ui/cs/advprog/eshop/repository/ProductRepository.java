package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;
import java.util.UUID;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public void create(Product product){
        productData.add(product);
        product.setProductId(UUID.randomUUID().toString());
    }

    public Iterator<Product> findAll(){
        return productData.iterator();
    }

    public void edit(Product product){
        try {
            for(Product p : productData){
                if (p.getProductId().equals(product.getProductId())){
                    p.setProductName(product.getProductName());
                    p.setProductQuantity(product.getProductQuantity());
                }
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public Product findById(String id){
        Product product = null;
        try {
            for (Product p : productData) {
                if (p.getProductId().equals(id)) {
                    product = p;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    public void delete(Product product){
        try {
            productData.removeIf(p -> p.getProductId() == product.getProductId());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
//