package com.testarena.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class LayoutFrame extends DefaultPage {

    @FindBy(xpath = "//*[@id=\"head-top\"]/div[2]/div[2]/a/span")
    protected WebElement logutButton;

    @FindBy(css = "#wrapper > ul > li:nth-child(5)")
    protected WebElement versionMenuItem;

    @FindBy(xpath = "//*[@id=\"j_info_box\"]/p")
    protected WebElement alert;

    @FindBy(css = "#wrapper > ul > li:nth-child(3)")
    private WebElement releaseMenuItem;

    public LayoutFrame(WebDriver driver) {
        super(driver);
    }

    public WebElement getLogutButton() {
        return logutButton;
    }

    public void logut() {
        clickElement(logutButton);
    }

    public void openVersionPage() {
        clickElement(this.versionMenuItem);
    }
    
    public void openReleasePage() {
        clickElement(this.releaseMenuItem);
    }

    public WebElement getAlert() {
        return waitForElement(alert, 1);
    }

    public boolean isLogutButtonDisplayed() {
        try {
            return logutButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
