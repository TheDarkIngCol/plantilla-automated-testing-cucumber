package co.com.empresa.pages.web;

import co.com.empresa.utilities.BasePage;

import static co.com.empresa.utilities.Constants.*;

public class LoginPage extends BasePage {

    public LoginPage() {
        super();
    }

    private String usernameField = "//input[@id='user-name']";
    private String passwordField = "//input[@id='password']";
    private String loginButton = "//input[@id='login-button']";
    private String textFailed = "//div[@class='error-message-container error']";

    public void loginSuccessfull() {
        sendKeys(usernameField, USERNAME);
        sendKeys(passwordField, PASS);
        click(loginButton);
    }

    public void loginFailed() {
        sendKeys(usernameField, USERNAME);
        sendKeys(passwordField, PASS_WRONG);
        click(loginButton);
        String getTextFailed = getText(textFailed);
        System.out.println("El texto encontrado es: " + getTextFailed);
    }
}
