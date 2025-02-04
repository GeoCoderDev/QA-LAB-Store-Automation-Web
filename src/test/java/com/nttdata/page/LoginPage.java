package com.nttdata.page;


import org.openqa.selenium.By;

public class LoginPage {

    public static  By emailInput = By.id("field-email");
    public static  By passwordInput = By.id("field-password");
    public static By submitLoginButton = By.id("submit-login");

    public static By loginErrorMessageLbl  = By.cssSelector("#content > section > div > ul > li");



}
