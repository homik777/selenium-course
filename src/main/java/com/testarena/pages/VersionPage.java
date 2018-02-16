package com.testarena.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VersionPage extends LayoutFrame {

    @FindBy(xpath = "//*[@id=\"content\"]/article/nav/ul/li/a")
    WebElement addVersionButton;

    @FindBy(id = "search")
    WebElement searchField;

    @FindBy(id = "j_searchButton")
    WebElement searchButton;

    String baseXpathOfNameOfElemntInList = "//*[@id=\"content\"]/article/table/tbody/tr[%s]/td[1]/a";

    public VersionPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public AddVersionPage clickAddVersionButton() {
        addVersionButton.click();
        return new AddVersionPage(driver);
    }

    public VersionPage fillSearchForm(String searchPhrase) {
        fillField(searchField, searchPhrase);
        return this;
    }

    public VersionPage clickSearchButton() {
        searchButton.click();
        return new VersionPage(driver);
    }

    public WebElement getFirstColumnAt(int row) {
        return driver.findElement(By.xpath(String.format(this.baseXpathOfNameOfElemntInList, row + "")));
    }

}
