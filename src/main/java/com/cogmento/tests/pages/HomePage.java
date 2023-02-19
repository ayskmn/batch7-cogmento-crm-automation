package com.cogmento.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//div[@class='header item']")
    protected WebElement logo;

    @FindBy(xpath = "//div[@class='header item']/following-sibling::b")
    protected WebElement orgName;

    @FindBy(xpath = "//span[@class='user-display']")
    protected WebElement userName;

    @FindBy(xpath = "//input[@placeholder='Search']")
    protected WebElement searchInput;

    @FindBy(xpath = "(//i[@class='settings icon'])[1]")
    protected WebElement settingsGear;

    protected String settingNavigation = "//div[starts-with(@class,'menu transition')]/a//span[text()='";

    protected void logout(){
        settingsGear.click();
        driver.findElement(By.xpath(settingNavigation + "Log Out']")).click();
    }

    protected void navigateToSettings(){
        settingsGear.click();
        driver.findElement(By.xpath(settingNavigation + "Settings']")).click();
    }

    protected void navigateToProducts(){
        settingsGear.click();
        driver.findElement(By.xpath(settingNavigation + "Products']")).click();
    }

    protected void navigateToImports(){
        settingsGear.click();
        driver.findElement(By.xpath(settingNavigation + "Imports']")).click();
    }

    protected void navigateToTools(){
        settingsGear.click();
        driver.findElement(By.xpath(settingNavigation + "Tools']")).click();
    }


    @FindBy(id = "main-nav")
    protected WebElement leftNavBarMenu;

    protected void navigate(String page){
        actions.moveToElement(leftNavBarMenu).build().perform();
        driver.findElement(By.xpath("//div[@class='menu-item-wrapper']/a[@href='/"+page+"']")).click();
    }

}
