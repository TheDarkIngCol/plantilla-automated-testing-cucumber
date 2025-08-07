package co.com.empresa.hooks;

import co.com.empresa.utilities.BasePage;
import co.com.empresa.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;

public class Hooks extends BasePage {

    @Before
    public void setUp(Scenario scenario) {
        if (scenario.getSourceTagNames().contains("@mobile")) {
            Driver.inicioAppiumDriver();
        } else {
            Driver.inicioWebDriverLocal();
        }
    }

    @Given("que estoy en la página de login")
    public void estoyEnLaPaginaDeLogin() {

    }

    @After
    public void tearDown() {
        Driver.cerrarWebDriver();
    }
}