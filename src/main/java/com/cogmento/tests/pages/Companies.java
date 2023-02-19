package com.cogmento.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.HashMap;

public class Companies extends HomePage{
    public Companies(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@class='ui linkedin button']//i[@class='save icon']")
    protected WebElement saveBtn;

    @FindBy(xpath = "//button[@class='ui button']//i[@class='cancel icon']")
    protected WebElement cancelBtn;

    @FindBy(xpath = "//div[@class='ui right corner labeled input']//input[@name='name']")
    protected WebElement companyNameInput;

    @FindBy(xpath = "//div[@class='four wide field']//button[@class='ui small fluid positive toggle button']/i[@class='unlock icon']")
    protected WebElement accessBtm;

    @FindBy(xpath = "//div[@class='twelve wide field']//div[@role='listbox']")
    protected WebElement accessDropDownMenu;
    @FindBy(xpath = "(//input[@name='url'])[1]")
    protected WebElement websiteInput;
    @FindBy(xpath = "//input[@placeholder='Street Address']")
    protected WebElement streetAddressInput;
    @FindBy(xpath = "//input[@placeholder='City']")
    protected WebElement cityInput;
    @FindBy(xpath = "//input[@name='state']")
    protected WebElement stateInput;
    @FindBy(xpath = "//div[@class='ui input']//input[@name='zip']")
    protected WebElement zipCodeInput;
    @FindBy(xpath = "//div[@name='country']/div//following-sibling::i[@class='dropdown icon']")
    protected WebElement countryDropDownBtn;
    @FindBy(xpath = "//input[@placeholder='Number']")
    protected WebElement phoneNumberInput;
    @FindBy(xpath = "//input[@placeholder='Home, Work, Mobile...']")
    protected WebElement honeNumberType;
    @FindBy(xpath = "//input[@placeholder='Email address']")
    protected WebElement emailInput;
    @FindBy(xpath = "//input[@placeholder='Personal email, Business, Alt...']")
    protected WebElement emailType;
    @FindBy(xpath = "//div/label[text()='Tags']//following-sibling::label[@for='tags']/div/input")
    protected WebElement tagInput;
    @FindBy(xpath = "//div[@class='field']//textarea[@name='description']")
    protected WebElement descriptionInput;
    @FindBy(xpath = "//div[@name='channel_type']/i[@class='dropdown icon']")
    protected WebElement socialChannelsDropDowMenu;
    @FindBy(xpath = "//label[text()='Social Channels']//following-sibling::div/div[@class='three fields']/div//following-sibling::div[@class='ui field']/div/input")
    private WebElement socialChannelHandle;
    @FindBy(xpath = "//div[@class='ui input']//input[@name='industry']")
    protected WebElement industryInput;

    @FindBy(xpath = "(//div[@class='ui input']//input[@name='num_employees'])[1]")
    protected WebElement numOfEmployesInput;

    @FindBy (xpath = "//div[@class='ui field']//input[@name='symbol']")
    protected WebElement stockSymbolInput;

    @FindBy(xpath = "//div[@class='ui input']//input[@name='annual_revenue']")
    protected WebElement annualRevInput;

    @FindBy(xpath="//div[@class='ui selection upward dropdown']")
    protected WebElement priorityInput;

    @FindBy(xpath ="(//div[@name='status'])[1]")
    protected WebElement statusInput;

    @FindBy(xpath = "(//div[@class='ui field']//div[@name='source'])[1]")
    protected WebElement sourceInput;

    @FindBy(xpath="//div[@id='main-content']/div/div[1]/div[2]/div/a/button")
    protected WebElement createCompanyBtn;

    @FindBy(xpath = "//div/label[text()='Status']//following-sibling::div[@name='status']/div//following-sibling::i[@class='dropdown icon']")
    private WebElement statusLink;
    @FindBy(xpath = "//label[text()='Priority']//following-sibling::div[@name='priority']/i")
    private WebElement priorityDropDown;
    @FindBy(xpath = "//div[@name='source']/i")
    private WebElement sourceLink;
    @FindBy(xpath = "//div[@name='category']/i")
    private WebElement categoryLink;

    @FindBy(xpath = "//label[text()='VAT Number']//following-sibling::div/input")
    private WebElement vatInput;
    @FindBy(xpath = "//input[@name='image']")
    private WebElement imageInput;


    public void createNewCompany(HashMap<String,String> data) {
        navigate("companies");
        fillCreateNewCompanyForm(data);
    }

    private void fillCreateNewCompanyForm(HashMap<String,String> data){

        Assert.assertTrue(createCompanyBtn.isDisplayed(), "Create button is not displayed");
        Assert.assertTrue(createCompanyBtn.isEnabled(), "Create button is not enabled");
        createCompanyBtn.click();
        companyNameInput.sendKeys(data.get("Name"));
        websiteInput.sendKeys(data.get("Website"));
        streetAddressInput.sendKeys(data.get("Street Address"));
        cityInput.sendKeys(data.get("City"));
        stateInput.sendKeys(data.get("State"));
        String zip = String.valueOf((long)(Double.parseDouble(data.get("Postal Code"))));
        zipCodeInput.sendKeys(zip);
        countryDropDownBtn.click();
        countryDropDownBtn.findElement(By.xpath("//following-sibling::div[@class='visible menu transition']/div/i//following-sibling::span[text()='"+data.get("Country")+"']")).click();
        phoneNumberInput.sendKeys(String.valueOf((long)(Double.parseDouble(data.get("Phone Number")))));
        honeNumberType.sendKeys(data.get("Phone Number Type"));
        emailInput.sendKeys(data.get("Email"));
        emailType.sendKeys(data.get("Email Type"));
        tagInput.sendKeys(data.get("Tag"));
        descriptionInput.sendKeys(data.get("Description"));
        socialChannelsDropDowMenu.click();
        socialChannelsDropDowMenu.findElement(By.xpath("//following-sibling::div/div/span[text()='Twitter']")).click();
        socialChannelHandle.sendKeys(data.get("Channels Handle"));
        industryInput.sendKeys(data.get("Industry"));
        numOfEmployesInput.sendKeys(String.valueOf((int)Double.parseDouble(data.get("Num of Employes"))));
        stockSymbolInput.sendKeys(data.get("Stock Symbol"));
        annualRevInput.sendKeys(data.get("Annual Revenue"));
        priorityInput.sendKeys(data.get("Priority"));
        statusInput.sendKeys(data.get("Status"));
        sourceInput.sendKeys(data.get("Source"));
        statusLink.click();
        statusLink.findElement(By.xpath("//following-sibling::div[@class='visible menu transition']/div/span[text()='"+data.get("Status")+"']")).click();
        priorityDropDown.click();
        priorityDropDown.findElement(By.xpath("//following-sibling::div[@class='visible menu transition']/div/span[text()='"+data.get("Priority")+"']")).click();
        sourceLink.click();
        sourceLink.findElement(By.xpath("//following-sibling::div[@class='visible menu transition']/div/span[text()='"+data.get("Source")+"']")).click();
        categoryLink.click();
        categoryLink.findElement(By.xpath("//following-sibling::div[@class='visible menu transition']/div/span[text()='"+data.get("Category")+"']")).click();
        vatInput.sendKeys(String.valueOf((long)Double.parseDouble(data.get("VAT"))));
        imageInput.sendKeys(data.get("imagePath"));
        saveBtn.click();
    }
}
