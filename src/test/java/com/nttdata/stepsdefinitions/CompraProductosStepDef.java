package com.nttdata.stepsdefinitions;

import com.nttdata.steps.*;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class CompraProductosStepDef {

    private WebDriver driver;


    private HomeSteps homeSteps(WebDriver driver){
        return new HomeSteps(driver);
    }

    private LoginSteps loginSteps(WebDriver driver){
        return new LoginSteps(driver);
    }

    private CategorySteps categorySteps(WebDriver driver){
        return new CategorySteps(driver);
    }

    private SubCategorySteps subCategorySteps(WebDriver driver){
        return new SubCategorySteps(driver);
    }

    private ProductSteps productSteps(WebDriver driver){
        return new ProductSteps(driver);
    }

    private ProductConfirmationModalSteps productConfirmationModalSteps(WebDriver driver){
        return new ProductConfirmationModalSteps(driver);
    }

    private CarritoSteps carritoSteps(WebDriver driver){
        return new CarritoSteps(driver);
    }


    @Dado("estoy en la página de la tienda")
    public void estoyEnLaPaginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store");
        screenShot();
    }

    @Y("me logueo con mi correo {string} y clave {string}")
    public void meLogueoConMiUsuarioOCorreoYClave(String email, String password) {

        try {
            homeSteps(driver).goToLoginPage();
            screenShot();
            loginSteps(driver).typeEmail(email);
            loginSteps(driver).typePassword(password);
            screenShot();
            loginSteps(driver).clickOnSubmitLoginButton();
            screenShot();
        }catch (AssertionError error){
            //Tomamos captura en caso de error de login tambien
            screenShot();
            //Luego lanzamos el error capturrado
            throw error;
        }
    }

    @Cuando("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String categoria, String subcategoria) {

        try{
            homeSteps(driver).clickOnCategory(categoria);
            screenShot();
            categorySteps(driver).clickOnSubcategory(subcategoria);
            screenShot();


        }catch (AssertionError error){
            //Tomamos captura en caso de no encontrar la categoria o subcategoria brindadas
            screenShot();

            //Luego lanzamos el error capturrado
            throw error;

        }


    }

    @Y("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int cantProducto) {

        try{

            subCategorySteps(driver).clickOnPrimerProducto();
            screenShot();
            productSteps(driver).typeCantidadRequerida(cantProducto);
            screenShot();
            productSteps(driver).agregarProductoAlCarrito();
            screenShot();

        }catch (AssertionError error){
            throw error;
        }

    }

    @Entonces("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmacionDelProductoAgregado() {

        productConfirmationModalSteps(driver).validarConfirmacionProductoAgregado();
    }

    @Y("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        productConfirmationModalSteps(driver).validarMontoTotal();
    }

    @Cuando("finalizo la compra")
    public void finalizoLaCompra() {
        productConfirmationModalSteps(driver).clickOnFinalizarCompra();
        screenShot();
    }

    @Entonces("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        carritoSteps(driver).validarTituloCarrito();

    }

    @Y("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        carritoSteps(driver).validarCalculoDeMontos();
    }
}
