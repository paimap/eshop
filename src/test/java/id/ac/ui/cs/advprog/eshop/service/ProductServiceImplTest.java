package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product();
        product.setProductId("test-id");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
    }

    @Test
    void testCreate() {
        productService.create(product);
        verify(productRepository, times(1)).create(product);
    }

    @Test
    void testFindAll() {
        List<Product> mockProducts = new ArrayList<>();
        mockProducts.add(product);

        Iterator<Product> iterator = mockProducts.iterator();
        when(productRepository.findAll()).thenReturn(iterator);

        List<Product> result = productService.findAll();
        assertEquals(1, result.size());
        assertEquals(product.getProductId(), result.get(0).getProductId());
    }

    @Test
    void testEdit() {
        productService.edit(product);
        verify(productRepository, times(1)).edit(product);
    }

    @Test
    void testFindById() {
        when(productRepository.findById("test-id")).thenReturn(product);

        Product foundProduct = productService.findById("test-id");
        assertNotNull(foundProduct);
        assertEquals("test-id", foundProduct.getProductId());
    }

    @Test
    void testFindByIdNotFound() {
        when(productRepository.findById("non-existent-id")).thenReturn(null);

        Product foundProduct = productService.findById("non-existent-id");
        assertNull(foundProduct);
    }

    @Test
    void testDelete() {
        productService.delete(product);
        verify(productRepository, times(1)).delete(product);
    }
}
