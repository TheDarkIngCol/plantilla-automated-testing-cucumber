package co.com.empresa.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/features/web",
        glue = {"co.com.empresa.steps", "co.com.empresa.hooks"},
        tags = "@web",
        plugin = {"pretty",
                "json:target/cucumber.json",
                "html:target/cucumber-html-report"
        },

        monochrome = true
)
public class WebTestRunner extends AbstractTestNGCucumberTests {
}

