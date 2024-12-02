package com.nttdata.testing.stepDefinition;

import com.nttdata.testing.Pages.HomePage;
import com.nttdata.testing.Pages.ProductPage;
import com.nttdata.testing.Tasks.NavigateTo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static net.serenitybdd.core.Serenity.getDriver;
import static org.junit.Assert.assertEquals;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class AgregarProductoStep {


    String mensajeCapturado = "";

    @Given("el {actor} esta logeado con el usuario {string} y contrasenia {string}")
    public void elUsuarioEstaLogeadoConElUsuarioYContrasenia( Actor actor, String username, String password) {


            actor.attemptsTo(NavigateTo.theHomePage());
            theActorInTheSpotlight().attemptsTo(Click.on(HomePage.BTN_LOGIN));
            theActorInTheSpotlight().attemptsTo(Enter.theValue(username).into(HomePage.INP_LOGIN_USERNAME));
            theActorInTheSpotlight().attemptsTo(Enter.theValue(password).into(HomePage.INP_LOGIN_PASSWORD));
            theActorInTheSpotlight().attemptsTo(Click.on(HomePage.BTN_LOGIN_SUBMIT));






    }

    @And("selecciona un producto")
    public void seleccionaUnProducto() {
        try {
            Thread.sleep(3000);
        WebElement datos = getDriver().findElement(By.xpath("//img[@src='imgs/galaxy_s6.jpg']"));
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));wait.until(ExpectedConditions.visibilityOf(datos));
        datos.click();

        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage(), e);
        }
    }

    @When("selecciona el boton agregar producto")
    public void seleccionaElBotonAgregarProducto() {
        try {
            Thread.sleep(3000);
        theActorInTheSpotlight().attemptsTo(Click.on(ProductPage.BTN_ADD_PRODUCT));
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage(), e);
        }
    }

    @Then("se agrega el producto de manera exitosa {string}")
    public void seAgregaElProductoDeManeraExitosa(String mensajeEsperado) {

        try {
            // Crear una instancia de WebDriverWait con un tiempo máximo de espera de 10 segundos
            WebDriverWait wait2 = new WebDriverWait(Serenity.getDriver(), Duration.ofSeconds(10));

            // Esperar a que el alert esté presente
            Alert alert = wait2.until(ExpectedConditions.alertIsPresent());

            // Capturar el texto del alert
            mensajeCapturado = alert.getText();

            // Validar el mensaje capturado contra el mensaje esperado
            assertEquals("El mensaje del alert SI coincide", mensajeEsperado, mensajeCapturado);

            // Aceptar (cerrar) el alert
            alert.accept();
        } catch (Exception e) {
            throw new RuntimeException("Error al manejar el alert: " + e.getMessage(), e);
        }

    }
}
