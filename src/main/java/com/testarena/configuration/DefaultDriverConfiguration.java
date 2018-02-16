package com.testarena.configuration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DefaultDriverConfiguration {
    public WebDriver getDriver() {
        System.setProperty(DefaultProperties.CHROME_DRIVER_PROPERTY,
                DefaultProperties.CHROME_DRIVER_PATH);
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}
