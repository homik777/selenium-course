package com.testarena.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.testarena.configuration.DefaultProperties;
import com.testarena.pages.DashboardPage;
import com.testarena.pages.LoginPage;

public class LoginTest extends DefaultTest {

    private LoginPage loginPage;

    private DashboardPage dashboardPage;

    @BeforeMethod
    public void beforeMethod() {
        this.loginPage = new LoginPage(driver);
        this.dashboardPage = new DashboardPage(driver);
    }

    @Test
    public void successLoginTest() {
        loginPage = new LoginPage(driver);
        loginPage.fillLoginForm(DefaultProperties.BASE_ADMIN_EMAIL, DefaultProperties.BASE_ADMIN_PASSWORD)
                .rememberLogin(true).submit();
        Assert.assertTrue(dashboardPage.isLogutButtonDisplayed());
    }

    @Test
    @Ignore
    public void failLoginTest() {
        loginPage = new LoginPage(driver);
        loginPage.fillLoginForm("", "").rememberLogin(true).submit();
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
    }

    @AfterMethod
    public void afterMethod() {
        if (dashboardPage.isLogutButtonDisplayed()) {
            dashboardPage.logut();
        }
    }

}
