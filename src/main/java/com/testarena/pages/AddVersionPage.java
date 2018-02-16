package com.testarena.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddVersionPage extends LayoutFrame{

    
    @FindBy(id="name")
    WebElement nameFileld;
    
    @FindBy(id="description")
    WebElement descriptionField;
    
    @FindBy(id="save")
    WebElement saveButton;
    
    public AddVersionPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    
    public AddVersionPage fillForm(String name, String descripiton) {
        fillField(this.nameFileld, name);
        fillField(this.descriptionField, descripiton);
        return this;
    }
    
    public VersionPage submit() {
        clickElement(saveButton);
        return new VersionPage(driver);
    }
    
    
}
