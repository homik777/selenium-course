package com.testarena.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionHelper {
    private final WebDriver driver; 
    
    public ActionHelper(final WebDriver driver) {
        this.driver = driver;
    }
    
    public void login( String email, String password) {
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("remember")).click();
        driver.findElement(By.id("login")).click();
    }
    
    public void addRelease(String releaseName) {
        driver.findElement(By.xpath("//*[@id=\"content\"]/article/nav/ul/li/a")).click();
        
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(releaseName);
        
        driver.findElement(By.id("startDate")).click();
        new WebDriverWait(driver, 1).until(ExpectedConditions
                .elementToBeClickable(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[4]/a")));
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[4]/a")).click();

        driver.findElement(By.id("endDate")).click();
        new WebDriverWait(driver, 1).until(ExpectedConditions
                .elementToBeClickable(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[4]/a")));
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[4]/a")).click();
        
        driver.findElement(By.id("description")).clear();
        driver.findElement(By.id("description")).sendKeys("Test description");
        driver.findElement(By.id("save")).click();
    }
    public void addVersion(String versionName) {
        driver.findElement(By.xpath("//*[@id=\"content\"]/article/nav/ul/li/a")).click();
        
        driver.findElement(By.id("name")).clear();
        
        driver.findElement(By.id("name")).sendKeys(versionName);
        driver.findElement(By.id("description")).clear();
        driver.findElement(By.id("description")).sendKeys("Test description");
        driver.findElement(By.id("save")).click();
    }
}
