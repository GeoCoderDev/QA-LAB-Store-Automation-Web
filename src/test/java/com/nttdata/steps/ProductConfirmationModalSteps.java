package com.nttdata.steps;

import com.nttdata.page.CarritoPage;
import com.nttdata.page.ProductConfirmationModal;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductConfirmationModalSteps {

    public static int cantidadRequerida;

    private final String Mensaje_Confirmacion = "Producto añadido correctamente a su carrito de compra";

    private WebDriver driver;

    public ProductConfirmationModalSteps(WebDriver driver){
        this.driver = driver;
    }

    public void validarConfirmacionProductoAgregado(){
        WebElement modalTitle = driver.findElement(ProductConfirmationModal.modalTitle);

        Assert.assertEquals(Mensaje_Confirmacion, modalTitle.getText().substring(1));

    }

    public void validarMontoTotal(){
        WebElement precioProductoLabel = driver.findElement(ProductConfirmationModal.productPriceLabel);
        WebElement impuestosLabel = driver.findElement(ProductConfirmationModal.impuestosLabel);
        WebElement totalConImpuestosIncluidosLabel = driver.findElement(ProductConfirmationModal.totalConImpuestosIncluidosLabel);

        //Obtenemos los numeros y las comas de los textos de los label
        //y luego reemplamos las comas por puntos para convertir a double

        double precioProducto = Double.parseDouble(
                precioProductoLabel.getText().replaceAll("[^0-9,]", "")
                        .replace(",", ".")
        );

        double impuestos = Double.parseDouble(impuestosLabel.getText().replaceAll("[^0-9,]","").replace(",", ".")
        );

        double totalConImpuestoEsperado =  (ProductConfirmationModalSteps.cantidadRequerida * precioProducto) + impuestos;

        double totalConImpuestosObtenidoWeb = Double.parseDouble(totalConImpuestosIncluidosLabel.getText().replaceAll("[^0-9,]", "").replace(",","."));

        System.out.println("Total con impuesto esperado: " + totalConImpuestoEsperado);
        System.out.println("Total con impuesto obtenido web: " + totalConImpuestosObtenidoWeb);
        Assert.assertEquals(totalConImpuestoEsperado,totalConImpuestosObtenidoWeb,0.1);

    }

    public void clickOnFinalizarCompra(){
        WebElement finalizarCompraButton = driver.findElement(ProductConfirmationModal.finalizarCompraButton);

        finalizarCompraButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(CarritoPage.carritoTitle));



    }
}
