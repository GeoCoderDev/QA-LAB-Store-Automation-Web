package com.nttdata.page;

import org.openqa.selenium.By;

public class ProductConfirmationModal {

    public static By modalTitle = By.cssSelector("#myModalLabel");

    public static  By productPriceLabel = By.cssSelector("#blockcart-modal > div > div > div.modal-body > div > div.col-md-5.divide-right > div > div:nth-child(2) > p");

    public static By impuestosLabel = By.cssSelector("#blockcart-modal > div > div > div.modal-body > div > div.col-md-7 > div > p.product-tax > span");

    public static By totalConImpuestosIncluidosLabel = By.cssSelector("#blockcart-modal > div > div > div.modal-body > div > div.col-md-7 > div > p.product-total > span.value");


    public static By finalizarCompraButton = By.cssSelector("#blockcart-modal > div > div > div.modal-body > div > div.col-md-7 > div > div > a");

}
