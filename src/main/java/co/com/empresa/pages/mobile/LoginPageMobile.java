package co.com.empresa.pages.mobile;

import co.com.empresa.utilities.BasePage;

import static co.com.empresa.utilities.Constants.PASS;
import static co.com.empresa.utilities.Constants.USERNAME;

public class LoginPageMobile extends BasePage {

    public LoginPageMobile() {
        super();
    }

    private String usernameField = "//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/nameET\"]";
    private String passwordField = "//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/passwordET\"]";
    private String loginButton = "//android.widget.Button[@content-desc=\"Tap to login with given credentials\"]";
    private String textFailed = "com.saucelabs.mydemoapp.android:id/passwordErrorTV']";

    public void loginSuccessfullMobile() {
        sendKeys(usernameField, USERNAME);
        sendKeys(passwordField, PASS);
        click(loginButton);
    }

}
