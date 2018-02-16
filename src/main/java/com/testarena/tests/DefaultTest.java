package com.testarena.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.testarena.configuration.DefaultDriverConfiguration;
import com.testarena.configuration.DefaultProperties;

public abstract class DefaultTest {
    protected static WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        driver = new DefaultDriverConfiguration().getDriver();
    }
    
    @BeforeClass
    public void beforeClass() {
        driver.get(DefaultProperties.BASE_URL);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
