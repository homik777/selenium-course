package com.testarena.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class DefaultPage {

    protected WebDriver driver;

    public DefaultPage(WebDriver driver) {
        this.driver = driver;
    }

    protected void fillField(WebElement field, String text) {
        field.clear();
        field.sendKeys(text);
    }

    protected void clickElement(WebElement element) {
        element.click();
    }

    protected WebElement waitForElement(WebElement element, int i) {
        WebDriverWait wait = new WebDriverWait(driver, i);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void selectCheckBox(WebElement checkBox, boolean enabled) {
        if (enabled && !checkBox.isSelected() || !enabled && checkBox.isSelected()) {
            checkBox.click();
        }
    }

}
