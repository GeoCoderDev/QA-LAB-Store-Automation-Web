package com.nttdata.steps;

import com.nttdata.page.CarritoPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CarritoSteps {

    private final String TITULO_CARRITO = "CARRITO";

    private WebDriver driver;

    public CarritoSteps(WebDriver driver){
        this.driver = driver;
    }

    public void validarTituloCarrito(){

        WebElement carritoTitle = driver.findElement(CarritoPage.carritoTitle);

        Assert.assertEquals(TITULO_CARRITO, carritoTitle.getText());

    }

    public void validarCalculoDeMontos (){
        WebElement precioProductoLabel = driver.findElement(CarritoPage.productPriceLabel);
        WebElement cantidadRequeridaInput = driver.findElement(CarritoPage.cantidadRequeridaInput);
        WebElement impuestosLabel = driver.findElement(CarritoPage.impuestosLabel);
        WebElement totalConImpuestosIncluidosLabel = driver.findElement(CarritoPage.totalConImpuestosIncluidosLabel);

        double precioProducto = Double.parseDouble(precioProductoLabel.getText().replaceAll("[^0-9,]","").replace(",","."));

        int cantidadRequerida = Integer.parseInt(cantidadRequeridaInput.getAttribute("value"));

        double impuestos = Double.parseDouble(impuestosLabel.getText().replaceAll("[^0-9,]","").replace(",","."));

        double totalConImpuestosEsperado = (precioProducto * cantidadRequerida) + impuestos;

        double totalConImpuestosObtenidoWeb = Double.parseDouble(totalConImpuestosIncluidosLabel.getText().replaceAll("[^0-9,]","").replace(",","."));

        System.out.println("Total con impuesto esperado: " + totalConImpuestosEsperado);
        System.out.println("Total con impuesto obtenido web: " + totalConImpuestosObtenidoWeb);

        Assert.assertEquals(totalConImpuestosEsperado,totalConImpuestosObtenidoWeb, 0.01);


    }



}
