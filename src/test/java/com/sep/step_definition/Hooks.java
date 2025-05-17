package com.sep.step_definition;

import com.sep.utilities.ConfigurationReader;
import com.sep.utilities.DriverUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.reset;

public class Hooks {


    /**
     * This method is a setup hook that runs before each scenario.
     * It checks if the scenario tag starts with "@api" and if so, it sets the base URI for API requests.
     * Otherwise, it initializes the web driver, maximizes the window, and sets implicit and page load timeouts.
     *
     * @param scenario The scenario object that contains information about the current scenario.
     */
    @Before
    public void setup(Scenario scenario) {
        if (scenario.getSourceTagNames().stream().anyMatch(p -> p.equalsIgnoreCase("@api"))) {
            baseURI = ConfigurationReader.getConfigProperty("baseUrl");
            return;
        }
        DriverUtils.getDriver();
        DriverUtils.getDriver().manage().window().maximize();
        DriverUtils.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }


    /**
     * This method is a teardown hook that runs after each scenario.
     * It checks if the scenario tag starts with "@api" and if so, it resets the API client.
     * Otherwise, it takes a screenshot if the scenario failed and then closes the web driver.
     *
     * @param scenario The scenario object that contains information about the current scenario.
     */
    @After
    public void teardown(Scenario scenario) {
        if (scenario.getSourceTagNames().stream().anyMatch(p -> p.equalsIgnoreCase("@api"))) {
            reset();
            return;
        }
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) DriverUtils.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        DriverUtils.closeDriver();
    }

}
