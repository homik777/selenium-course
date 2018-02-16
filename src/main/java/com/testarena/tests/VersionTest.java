package com.testarena.tests;

import java.time.Instant;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testarena.configuration.DefaultProperties;
import com.testarena.pages.AddVersionPage;
import com.testarena.pages.DashboardPage;
import com.testarena.pages.LoginPage;
import com.testarena.pages.VersionPage;

public class VersionTest extends DefaultTest {

    private String tempVersionName;

    private VersionPage versionPage;

    @Override
    @BeforeClass
    public void beforeClass() {
        // TODO: check if logged in
        super.beforeClass();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLoginForm(DefaultProperties.BASE_ADMIN_EMAIL, DefaultProperties.BASE_ADMIN_PASSWORD).submit();
    }
    
    @AfterClass
    public void afterClass() {
        new DashboardPage(driver).logut();
    }

    @BeforeMethod
    public void beforeMethod() {
        tempVersionName = "Wersja_" + Instant.now().toEpochMilli();
        versionPage = new VersionPage(driver);
        versionPage.openVersionPage();
    }

    @Test
    public void searchTest() {
        AddVersionPage addVersionPage = versionPage.clickAddVersionButton();

        versionPage = addVersionPage.fillForm(this.tempVersionName, "description").submit();

        versionPage.fillSearchForm(tempVersionName).clickSearchButton();

        Assert.assertEquals(versionPage.getFirstColumnAt(1).getText(), tempVersionName);
    }
}
