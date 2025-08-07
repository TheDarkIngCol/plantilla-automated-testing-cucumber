package co.com.empresa.utilities;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.HashMap;
import java.net.URL;
import static co.com.empresa.utilities.Constants.URL;
import static co.com.empresa.utilities.Constants.BROWSERSTACK_URL;

public class Driver extends BasePage {

    public static void inicioWebDriver(Method method) {
        driver = Driver.createRemoteDriver(method.getName());
        driver.manage().window().maximize();
        driver.get(URL);
        waitDriver = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public static void inicioWebDriverLocal() {
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        options.addArguments("start-maximized", "--disable-notifications", "--incognito", "--disable-popup-blocking");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(URL);
        waitDriver = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public static RemoteWebDriver createRemoteDriver(final String sessionName) {
        if (sessionName == null || sessionName.trim().isEmpty()) {
            throw new IllegalArgumentException("Session name must not be null or empty.");
        }

        MutableCapabilities capabilities = new MutableCapabilities();
        HashMap<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("sessionName", sessionName);
        capabilities.setCapability("bstack:options", bstackOptions);

        try {
            RemoteWebDriver driver = new RemoteWebDriver(new URI(BROWSERSTACK_URL).toURL(), capabilities);
            DriverManager.setDriver(driver);
            return driver;
        } catch (URISyntaxException e) {
            String msg = "La URL de BrowserStack tiene un formato incorrecto (URI): " + BROWSERSTACK_URL;
            throw new IllegalArgumentException(msg, e);
        } catch (MalformedURLException e) {
            String msg = "La URL de BrowserStack tiene un formato inválido (URL): " + BROWSERSTACK_URL;
            throw new IllegalArgumentException(msg, e);
        }

    }

    public static void inicioAppiumDriver() {
        try {
            UiAutomator2Options options = new UiAutomator2Options()
                    .setPlatformName("Android")
                    .setPlatformVersion("11.0")
                    .setDeviceName("Huawei")
                    .setUdid("L4SDU17927002305")
                    .setAutomationName("UiAutomator2")
                    .setApp(System.getProperty("user.dir") + "/src/test/java/resources/apps/mda-2.2.0-25.apk")
                    .setNoReset(false)
                    .setFullReset(true)
                    .autoGrantPermissions();

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
            waitDriver = new WebDriverWait(driver, Duration.ofSeconds(30));
            System.out.println("Driver iniciado correctamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void cerrarWebDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}