package com.example.framework;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    public static WebDriver getDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver119.exe");
            ChromeDriver driver = new ChromeDriver();
            driver.manage().window().setSize(new Dimension(1920, 1080));
            return driver;
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
            FirefoxDriver driver = new FirefoxDriver();
            driver.manage().window().setSize(new Dimension(1920, 1080));
            return driver;
        }
        throw new IllegalArgumentException("Browser \"" + browser + "\" not supported.");
    }
}
