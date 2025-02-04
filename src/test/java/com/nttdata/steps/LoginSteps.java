





package com.nttdata.steps;

import com.nttdata.page.HomeStorePage;
import com.nttdata.page.LoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps {

    private WebDriver driver;

    public LoginSteps(WebDriver driver){
        this.driver = driver;
    }

    public void typeEmail(String email){
        WebElement emailInput = driver.findElement(LoginPage.emailInput);
        emailInput.sendKeys(email);
    }

    public void typePassword(String password){
        WebElement passwordInput = driver.findElement(LoginPage.passwordInput);
        passwordInput.sendKeys(password);
    }

    public void clickOnSubmitLoginButton(){
        WebElement submitLoginButton = driver.findElement(LoginPage.submitLoginButton);
        submitLoginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Intento encontrar el botón de logout por 10 segundos máximo
            wait.until(ExpectedConditions.visibilityOfElementLocated(HomeStorePage.logoutButton));

        } catch (Exception e) {
            // Si no lo encuentro después de 10 segundos paso aca
            try {
                // Intento encontrar el mensaje de error por otros 10 segundos
                WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.loginErrorMessageLbl));
                // Si encuentro el mensaje de error lanzo un error de Login Fallido + el texto del error de la pagina
                throw new AssertionError("Login fallido: " + errorMessage.getText());
            } catch (Exception ex) {
                // Si no encuentra ni el mensaje de error lanzaria un error genérico
                throw new AssertionError("No se pudo validar el estado del login");
            }
        }



    }




}
