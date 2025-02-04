package com.nttdata.steps;

import com.nttdata.page.HomeStorePage;
import com.nttdata.page.LoginPage;
import com.nttdata.page.CategoryPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomeSteps {

    private WebDriver driver;

    public HomeSteps(WebDriver driver){
        this.driver = driver;
    }

    public void goToLoginPage(){
        // Clic en el botón de iniciar sesión
        WebElement iniciarSesionButton = driver.findElement(HomeStorePage.iniciarSesionLinkButton);
        iniciarSesionButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.submitLoginButton));

    }


    public void clickOnCategory(String category){
        List<WebElement> categoryButtons = driver.findElements(HomeStorePage.categoryButtons);

        //Recorremos todos los category buttons
        for (WebElement button : categoryButtons) {

            if (button.getText().equalsIgnoreCase(category)) {
                button.click();

                // Esperamos a que aparezca el titulo de la pagina de categoria
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                WebElement categoryTitle = wait.until(
                        ExpectedConditions.visibilityOfElementLocated(CategoryPage.categoryTitle)
                );

                // verificamos que el titulo muestre la categoría correcta
                Assert.assertEquals("El breadcrumb no muestra la categoría seleccionada",
                        category.toLowerCase(),
                        categoryTitle.getText().trim().toLowerCase());
                return;
            }
        }

        // Si no se encuentra la categoría, lanzar el error
        throw new AssertionError("No se encontró la categoría: " + category);
    }

}
