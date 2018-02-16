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

public class AddVersionTest extends DefaultTest {
    private String tempVersionName;

    private AddVersionPage addVersionPage;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        // TODO: check if logged in
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLoginForm(DefaultProperties.BASE_ADMIN_EMAIL, DefaultProperties.BASE_ADMIN_PASSWORD).submit();
        
        VersionPage versionPage = new VersionPage(driver);
        versionPage.openVersionPage();
        
        addVersionPage = versionPage.clickAddVersionButton();
    }
    
    @AfterClass
    public void afterClass() {
        new DashboardPage(driver).logut();
    }

    @BeforeMethod
    public void beforeMethod() {
        tempVersionName = "Wersja_" + Instant.now().toEpochMilli();
    }

    @Test
    public void successAddVersionTest() {
        VersionPage versionPage = addVersionPage.fillForm(this.tempVersionName, "description").submit();
        Assert.assertEquals(versionPage.getAlert().getText(), "Wersja została dodana.");
    }
}
