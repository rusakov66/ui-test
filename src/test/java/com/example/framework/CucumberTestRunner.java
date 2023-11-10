package com.example.framework;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.example.framework.stepdefinitions",
        plugin = {"pretty", "html:target/cucumber-reports"},
        strict = true
)
public class CucumberTestRunner {

    public CucumberTestRunner() {
    }
}
