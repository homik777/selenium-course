package com.testarena.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReleasePage extends LayoutFrame {

    @FindBy(xpath = "//*[@id=\"content\"]/article/nav/ul/li/a")
    WebElement addReleaseButton;

    @FindBy(id = "search")
    WebElement searchField;

    @FindBy(id = "j_searchButton")
    WebElement searchButton;

    String baseXpathOfNameOfElemntInList = "//*[@id=\"content\"]/article/table/tbody/tr[%s]/td[1]/a";

    public ReleasePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public AddReleasePage clickAddReleaseButton() {
        this.addReleaseButton.click();
        return new AddReleasePage(driver);
    }

}
