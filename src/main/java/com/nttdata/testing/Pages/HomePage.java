package com.nttdata.testing.Pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("https://www.demoblaze.com/")
public class HomePage extends PageObject {
    //  LOG IN

    public static final Target BTN_LOGIN = Target.the("Boton abrir el modal de login")
            .located(By.id("login2"));

    public static final Target INP_LOGIN_USERNAME = Target.the("Nombre de usuario")
            .located(By.id("loginusername"));

    public static final Target INP_LOGIN_PASSWORD = Target.the("Contraseña")
            .located(By.id("loginpassword"));
    public static final Target BTN_LOGIN_SUBMIT = Target.the("Boton para iniciar sesion")
            .located(By.xpath("//button[text()='Log in']"));

    // Select product
    public static final Target BTN_SELECT_PRODUCT = Target.the("Boton para seleccionar un producto")
            .located(By.xpath("//a[text()='Samsung galaxy s6']"));
}


