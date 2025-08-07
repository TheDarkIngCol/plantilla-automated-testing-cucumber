package co.com.empresa.steps.mobile;

import co.com.empresa.pages.mobile.LoginPageMobile;
import co.com.empresa.pages.mobile.MenuPageMobile;
import co.com.empresa.utilities.BasePage;
import io.cucumber.java.en.When;

public class LoginStepsMobile extends BasePage {

    LoginPageMobile loginPageMobile = new LoginPageMobile();
    MenuPageMobile menuPageMobile = new MenuPageMobile();

    @When("ingreso usuario y contraseña correctos en mobile")
    public void ingreso_usuario_y_contraseña() {
        menuPageMobile.menuSuccess();
        loginPageMobile.loginSuccessfullMobile();
    }
}
