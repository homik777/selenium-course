package com.testarena.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends DefaultPage {

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "login")
    WebElement loginButton;

    @FindBy(id = "remember")
    WebElement rememberCheckBox;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public LoginPage rememberLogin(boolean remember) {
        if (remember && !rememberCheckBox.isSelected() || !remember && rememberCheckBox.isSelected()) {
            rememberCheckBox.click();
        }
        return this;
    }

    public LoginPage fillLoginForm(String email, String password) {
        fillField(emailField, email);
        fillField(passwordField, password);
        return this;
    }

    public void submit() {
        clickElement(loginButton);
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

}
