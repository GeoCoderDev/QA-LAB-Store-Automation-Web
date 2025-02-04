package com.nttdata.steps;

import com.nttdata.page.CategoryPage;
import com.nttdata.page.SubCategoryPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CategorySteps {

    private WebDriver driver;

    public CategorySteps(WebDriver driver){
        this.driver = driver;
    }

    public void clickOnSubcategory(String subcategory){
        List<WebElement> subCategoryButtons = driver.findElements(CategoryPage.subCategoryButtons);

        //Recorremos todos los subcategory buttons
        for (WebElement button : subCategoryButtons) {

            if (button.getDomProperty("title").equalsIgnoreCase(subcategory)) {
                button.click();

                // Esperamos a que aparezca el titulo de la pagina de subcategoria
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                WebElement subCategoryTitle = wait.until(
                        ExpectedConditions.visibilityOfElementLocated(SubCategoryPage.subCategoryTitle)
                );

                // verificamos que el titulo muestre la subcategoria correcta
                Assert.assertEquals("El breadcrumb no muestra la categoria seleccionada",
                        subcategory.toLowerCase(),
                        subCategoryTitle.getText().trim().toLowerCase());
                return;
            }
        }

        // Si no se encuentra la subcategoria, lanzar el error
        throw new AssertionError("No se encontró la subcategoria: " + subcategory);


    }


}
