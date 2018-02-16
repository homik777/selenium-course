package com.testarena.configuration;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DefaultDriverConfiguration {
    public WebDriver getDriver() {
        System.setProperty(DefaultProperties.CHROME_DRIVER_PROPERTY,
                DefaultProperties.CHROME_DRIVER_PATH);
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
    
    public WebDriver getRemoteDriver() {
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL("http://134.86.5.141:4444/wd/hub"), DesiredCapabilities.chrome());
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        
        return driver;
    }
}
