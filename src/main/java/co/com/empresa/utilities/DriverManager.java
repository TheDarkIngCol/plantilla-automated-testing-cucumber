package co.com.empresa.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

/**
 * Manages the WebDriver instance for the current thread.
 */
@SuppressWarnings({"checkstyle:RegexpSingleline", "checkstyle:LineLength"})
public final class DriverManager {
    /**
     * driver context.
     */
    private static final ThreadLocal<WebDriver> DRIVER_CONTEXT = new ThreadLocal<>();

    private DriverManager() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Sets the WebDriver for the current thread.
     *
     * @param driver the WebDriver instance
     */
    public static void setDriver(final WebDriver driver) {
        Objects.requireNonNull(driver, "WebDriver instance must not be null.");
        DRIVER_CONTEXT.set(driver);
    }

    /**
     * Retrieves the WebDriver for the current thread.
     *
     * @return the WebDriver instance
     * @throws IllegalStateException if no driver is set for the thread
     */
    public static WebDriver getDriver() {
        WebDriver driver = DRIVER_CONTEXT.get();
        if (driver == null) {
            throw new IllegalStateException("WebDriver not set for this thread.");
        }
        return driver;
    }

    /**
     * Removes the WebDriver from the current thread context.
     */
    public static void removeDriver() {
        DRIVER_CONTEXT.remove();
    }
}
