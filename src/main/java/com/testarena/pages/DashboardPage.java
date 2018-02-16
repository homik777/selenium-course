package com.testarena.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends LayoutFrame{

    public DashboardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

}
