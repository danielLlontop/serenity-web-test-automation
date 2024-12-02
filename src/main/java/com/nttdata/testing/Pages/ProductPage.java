package com.nttdata.testing.Pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;



public class ProductPage  extends PageObject {
    // ADD PRODUCT
    public static final Target BTN_ADD_PRODUCT = Target.the("Boton para agregar un producto al carrito")
            .located(By.xpath("//a[text()='Add to cart']"));


}
