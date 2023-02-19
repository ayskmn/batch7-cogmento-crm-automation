package com.cogmento.tests.pages;

import com.cogmento.tests.config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Login extends BasePage{

    public Login(WebDriver driver){
        super(driver);
    }

    //Web elements
    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//div[text()='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[contains(@class,'negative message')]")
    private WebElement errorMessage;


    public void navigateToLoginPage(){
        driver.get(ConfigReader.getProperty("url"));
        Assert.assertTrue(driver.getTitle().equals("Cogmento CRM"));
    }

    public void login(){
        emailInput.sendKeys(ConfigReader.getProperty("email"));
        passwordInput.sendKeys(ConfigReader.getProperty("password"));
        Assert.assertTrue(loginButton.isEnabled(), "Login button is not enabled");
        loginButton.click();
    }

    public void loginNegative(){
        emailInput.sendKeys("invalid@gmail.com");
        passwordInput.sendKeys("invalidpassword!");
        Assert.assertTrue(loginButton.isEnabled(), "Login button is not enabled");
        loginButton.click();
        Assert.assertTrue(errorMessage.isEnabled(), "Error message is not displayed");
    }




}
