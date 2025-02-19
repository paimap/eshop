package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {
    @InjectMocks
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository = new ProductRepository();
    }

    @Test
    void testCreateAndFind(){
        Product product = new Product();
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        assertNotNull(product.getProductId());

        Iterator<Product> iterator = productRepository.findAll();
        assertTrue(iterator.hasNext());
        Product savedProduct = iterator.next();
        assertNotNull(savedProduct.getProductId());
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }

    @Test
    void testEditProduct(){
        Product product = new Product();
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Product editedProduct = new Product();
        editedProduct.setProductId(product.getProductId());
        editedProduct.setProductName("Sampo Cap Ilham");
        editedProduct.setProductQuantity(200);
        productRepository.edit(editedProduct);

        Product foundProduct = productRepository.findById(product.getProductId());
        assertNotNull(foundProduct);
        assertEquals("Sampo Cap Ilham", foundProduct.getProductName());
        assertEquals(200, foundProduct.getProductQuantity());
    }

    @Test
    void testDeleteProduct(){
        Product product = new Product();
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);
        productRepository.delete(product);

        Iterator<Product> iterator = productRepository.findAll();
        assertFalse(iterator.hasNext());
        assertNull(productRepository.findById(product.getProductId()));
    }

    @Test
    void testFindByIdWhenOnlyOneProductExists(){
        Product product = new Product();
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Product foundProduct = productRepository.findById(product.getProductId());
        assertNotNull(foundProduct);
        assertEquals(product.getProductId(), foundProduct.getProductId());
    }

    @Test
    void testEditProductWhenNotExists(){
        Product nonExistentProduct = new Product();
        nonExistentProduct.setProductId("random-id");
        nonExistentProduct.setProductName("Produk Tidak Ada");
        nonExistentProduct.setProductQuantity(999);

        productRepository.edit(nonExistentProduct);

        assertNull(productRepository.findById("random-id")); // Pastikan produk tidak ditemukan
    }

    @Test
    void testDeleteNonExistentProduct(){
        Product product = new Product();
        product.setProductId("non-existent-id");
        product.setProductName("Tidak Ada");
        product.setProductQuantity(0);

        productRepository.delete(product);

        assertFalse(productRepository.findAll().hasNext()); // Tidak ada produk dalam repository
    }

    @Test
    void testEditOneOfMultipleProducts(){
        Product product1 = new Product();
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Product editedProduct = new Product();
        editedProduct.setProductId(product1.getProductId());
        editedProduct.setProductName("Sampo Cap Baru");
        editedProduct.setProductQuantity(150);
        productRepository.edit(editedProduct);

        Product foundProduct1 = productRepository.findById(product1.getProductId());
        Product foundProduct2 = productRepository.findById(product2.getProductId());

        assertNotNull(foundProduct1);
        assertEquals("Sampo Cap Baru", foundProduct1.getProductName());
        assertEquals(150, foundProduct1.getProductQuantity());

        // Pastikan produk lain tidak berubah
        assertNotNull(foundProduct2);
        assertEquals("Sampo Cap Usep", foundProduct2.getProductName());
        assertEquals(50, foundProduct2.getProductQuantity());
    }

    @Test
    void testFindByIdWhenMultipleProductsExist(){
        Product product1 = new Product();
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Product foundProduct = productRepository.findById(product2.getProductId());
        assertNotNull(foundProduct);
        assertEquals(product2.getProductId(), foundProduct.getProductId());
        assertEquals("Sampo Cap Usep", foundProduct.getProductName());
    }

    @Test
    void testDeleteWhenMultipleProductsExist(){
        Product product1 = new Product();
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        productRepository.delete(product1);

        assertNull(productRepository.findById(product1.getProductId()));
        assertNotNull(productRepository.findById(product2.getProductId()));
    }



}
