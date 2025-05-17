package com.sep.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-reports.html",
                "rerun:target/rerun.txt",
        },
        features = "src/test/resources/features",
        glue = "com/sep/step_definition",
        dryRun = false,
        tags = "@sep19",
        publish = true
)
public class CukesRunner {

}