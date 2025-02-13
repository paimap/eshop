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

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
class NumberOfItemsFunctionalTest {
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
    void numberOfItemsIs1_isCorrect(ChromeDriver driver) {
        driver.get(baseUrl);
        WebElement createButton = driver.findElement(By.id("create-button"));

        createButton.click();

        WebElement productNameField = driver.findElement(By.id("nameInput"));
        WebElement productQuantityField = driver.findElement(By.id("quantityInput"));
        productNameField.clear();
        productQuantityField.clear();

        productNameField.sendKeys("Test");
        productQuantityField.sendKeys("10");

        WebElement submitButton = driver.findElement(By.id("submit-button"));
        submitButton.click();

        List<WebElement> productRows = driver.findElements(By.xpath("//tbody/tr"));

        assertEquals(1, productRows.size());
    }

    @Test
    void numberOfItemsIs3_isCorrect(ChromeDriver driver) {
        for (int i = 0; i < 3; i++) {
            driver.get(baseUrl);
            WebElement createButton = driver.findElement(By.id("create-button"));

            createButton.click();

            WebElement productNameField = driver.findElement(By.id("nameInput"));
            WebElement productQuantityField = driver.findElement(By.id("quantityInput"));
            productNameField.clear();
            productQuantityField.clear();

            productNameField.sendKeys("Test");
            productQuantityField.sendKeys("10");

            WebElement submitButton = driver.findElement(By.id("submit-button"));
            submitButton.click();
        }


        List<WebElement> productRows = driver.findElements(By.xpath("//tbody/tr"));

        assertEquals(3, productRows.size());
    }
}