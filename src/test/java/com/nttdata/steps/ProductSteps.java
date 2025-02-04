package com.nttdata.steps;

import com.nttdata.page.ProductConfirmationModal;
import com.nttdata.page.ProductPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductSteps {

    private WebDriver driver;

    public ProductSteps(WebDriver driver){
        this.driver = driver;
    }

    public void typeCantidadRequerida(int cantidad){

        WebElement cantidadRequeridaInput= driver.findElement(ProductPage.cantidadRequeridaInput);

        cantidadRequeridaInput.sendKeys(Keys.BACK_SPACE, String.valueOf(cantidad), Keys.END, Keys.BACK_SPACE);

        //Guardamos el valor de la cantida para usarlo mas adelante
        // en el calculo de montos
        ProductConfirmationModalSteps.cantidadRequerida = cantidad;

    }

    public void agregarProductoAlCarrito(){
        WebElement agregarAlCarritoButton = driver.findElement(ProductPage.agregarAlCarritoButton);

        agregarAlCarritoButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(ProductConfirmationModal.modalTitle));

    }



}
