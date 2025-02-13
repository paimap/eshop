package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
class CreateProductFunctionalTest {
    @LocalServerPort
    private int serverPort;

    @Value("${app.baseUrl:http://localhost:8080/product/list}")
    private String testBaseUrl;

    private String baseUrl;

    @BeforeEach
    void setUpTest() {
        baseUrl = String.format("http://localhost:%d/product/list", serverPort);
    }

    @Test
    void addProductButtonClick_isCorrect(ChromeDriver driver) {
        driver.get(baseUrl);
        WebElement createButton = driver.findElement(By.id("create-button"));

        createButton.click();

        String expectedUrl = String.format("http://localhost:%d/product/create", serverPort);
        assertEquals(expectedUrl, driver.getCurrentUrl());

        WebElement productNameField = driver.findElement(By.id("nameInput"));
        WebElement productQuantityField = driver.findElement(By.id("quantityInput"));
        productNameField.clear();
        productQuantityField.clear();

        productNameField.sendKeys("Test");
        productQuantityField.sendKeys("10");

        WebElement submitButton = driver.findElement(By.id("submit-button"));
        submitButton.click();

        expectedUrl = String.format("http://localhost:%d/product/list", serverPort);
        assertEquals(expectedUrl, driver.getCurrentUrl());

        WebElement productName = driver.findElement(By.id("product-name"));
        WebElement productQuantity = driver.findElement(By.id("product-quantity"));
        assertEquals("Test", productName.getText());
        assertEquals("10", productQuantity.getText());
    }

    @Test
    void pageTitle_isCorrect(ChromeDriver driver) throws Exception {
        driver.get(baseUrl);
        String pageTitle = driver.getTitle();

        assertEquals("Product List", pageTitle);
    }

    @Test
    void welcomeMessage_homePage_isCorrect(ChromeDriver driver) throws Exception {
        driver.get(baseUrl);
        String welcomeMessage = driver.findElement(By.tagName("h2")).getText();

        assertEquals("Product List", welcomeMessage);
    }
}