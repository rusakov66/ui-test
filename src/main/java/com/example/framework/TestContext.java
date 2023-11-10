package com.example.framework;

import org.openqa.selenium.WebDriver;

public class TestContext {
    private WebDriver driver;

    public void initializeDriver(String browser) {
        if (driver == null) {
            driver = DriverManager.getDriver(browser);
        } else {
            // Логирование или другие действия в случае, если драйвер уже инициализирован
        }
    }

    public TestContext() {
        // Здесь вы можете определить, какой браузер использовать
//        String browser = System.getProperty("browser", "chrome");
//        this.driver = DriverManager.getDriver(browser);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
