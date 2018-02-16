package com.testarena.tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.testarena.configuration.DefaultDriverConfiguration;
import com.testarena.configuration.DefaultProperties;

public abstract class DefaultTest {
    protected static WebDriver driver;

    @BeforeTest
    @Parameters("environment")
    public void beforeTest(String environment) {

        switch (environment) {
        case "local":
            driver = new DefaultDriverConfiguration().getRemoteDriver();
            break;
        case "remote":
            driver = new DefaultDriverConfiguration().getRemoteDriver();
            break;
        default:
            break;
        }
    }

    @BeforeClass
    public void beforeClass() {
        driver.get(DefaultProperties.BASE_URL);
    }

    @AfterMethod
    public void screenshotIfFailed(ITestResult result) {
        if (!result.isSuccess()) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenshot, File.createTempFile(result.getName(), ".png"));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
