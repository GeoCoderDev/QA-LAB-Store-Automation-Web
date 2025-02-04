package com.nttdata.page;

import org.openqa.selenium.By;

public class CarritoPage {

    public static By carritoTitle = By.cssSelector("#main > div > div.cart-grid-body.col-lg-8 > div > div.card-block > h1");

    public static By productPriceLabel = By.cssSelector("#main > div > div.cart-grid-body.col-lg-8 > div > div.cart-overview.js-cart > ul > li > div > div.product-line-grid-body.col-md-4.col-xs-8 > div.product-line-info.product-price.h5.has-discount > div.current-price > span");

    public static By cantidadRequeridaInput = By.cssSelector("#main > div > div.cart-grid-body.col-lg-8 > div > div.cart-overview.js-cart > ul > li > div > div.product-line-grid-right.product-line-actions.col-md-5.col-xs-12 > div > div.col-md-10.col-xs-6 > div > div.col-md-6.col-xs-6.qty > div > input");


    public static By impuestosLabel = By.cssSelector("#main > div > div.cart-grid-right.col-lg-4 > div.card.cart-summary > div.cart-detailed-totals.js-cart-detailed-totals > div.card-block.cart-summary-totals.js-cart-summary-totals > div:nth-child(3) > span.value.sub");

    public static By totalConImpuestosIncluidosLabel = By.cssSelector("#main > div > div.cart-grid-right.col-lg-4 > div.card.cart-summary > div.cart-detailed-totals.js-cart-detailed-totals > div.card-block.cart-summary-totals.js-cart-summary-totals > div.cart-summary-line.cart-total > span.value");



}
