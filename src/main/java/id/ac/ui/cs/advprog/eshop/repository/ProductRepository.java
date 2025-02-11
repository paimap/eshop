package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@Repository
public class ProductRepository {
    private int idCounter = 0;
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product){
        productData.add(product);
        product.setProductId(idCounter);
        idCounter++;
        return product;
    }

    public Iterator<Product> findAll(){
        return productData.iterator();
    }

    public Product edit(Product product){
        for(Product p : productData){
            if (p.getProductId() == product.getProductId()){
                p.setProductName(product.getProductName());
                p.setProductQuantity(product.getProductQuantity());
                return product;
            }
        }
        return null;
    }

    public Product findById(int id){
        for(Product p : productData){
            if (p.getProductId() == id){
                return p;
            }
        }
        return null;
    }

}
//