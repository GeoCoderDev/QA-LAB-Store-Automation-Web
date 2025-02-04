package com.nttdata.steps;

import com.nttdata.page.ProductPage;
import com.nttdata.page.SubCategoryPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SubCategorySteps {

    private WebDriver driver;

    public SubCategorySteps(WebDriver driver){
        this.driver = driver;
    }

    public void clickOnPrimerProducto(){

        List<WebElement> productButtons = driver.findElements(SubCategoryPage.productButtons);

        Assert.assertFalse("No se encontraron productos en la página",
                productButtons.isEmpty());

        WebElement primerProductoButton = productButtons.get(0);

        primerProductoButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPage.cantidadRequeridaInput));


    }

}
