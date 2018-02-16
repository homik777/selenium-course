package com.testarena.pages;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddReleasePage extends LayoutFrame {

    @FindBy(id="name")
    WebElement nameFileld;
    
    @FindBy(id="description")
    WebElement descriptionField;
    
    @FindBy(id="startDate")
    WebElement startDateField;
    
    @FindBy(id="endDate")
    WebElement endDateField;
    
    @FindBy(xpath="//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[5]/a")
    WebElement datePicker;
    
    @FindBy(id="save")
    WebElement saveButton;
    
    public AddReleasePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    
    public AddReleasePage fillForm(String name, String description, Date startDate, Date endDate) {
        fillField(this.nameFileld, name);
        fillField(this.descriptionField, description);
        pickDate(this.startDateField,startDate);
        pickDate(this.endDateField,endDate);
        return this;
    }

    private void pickDate(WebElement dateField, Date startDate) {
        clickElement(dateField);
        waitForElement(datePicker, 1).click();
    }
    
    public ReleasePage submit() {
        this.saveButton.click();
        return new ReleasePage(driver);
    }

}
