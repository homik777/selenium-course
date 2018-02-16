package com.testarena.tests;

import java.time.Instant;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testarena.configuration.DefaultProperties;
import com.testarena.pages.AddReleasePage;
import com.testarena.pages.DashboardPage;
import com.testarena.pages.LoginPage;
import com.testarena.pages.ReleasePage;

public class AddReleaseTest extends DefaultTest{
    private String tempReleaseName;
    private AddReleasePage addReleasePage;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLoginForm(DefaultProperties.BASE_ADMIN_EMAIL, DefaultProperties.BASE_ADMIN_PASSWORD).submit();
        
        ReleasePage releasePage = new ReleasePage(driver);
        releasePage.openReleasePage();
        addReleasePage = releasePage.clickAddReleaseButton();
    }
    
    @AfterClass
    public void afterClass() {
        new DashboardPage(driver).logut();
    }

    @BeforeMethod
    public void beforeMethod() {
        tempReleaseName = "Release_" + Instant.now().toEpochMilli();
    }

    @Test
    public void successAddRelease() {
        ReleasePage releasePage = addReleasePage.fillForm(this.tempReleaseName, "desc", null, null).submit();
        
        Assert.assertEquals(releasePage.getAlert().getText(),
                "Wydanie zostało dodane.");
    }
}
