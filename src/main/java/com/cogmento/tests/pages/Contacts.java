package com.cogmento.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.HashMap;

public class Contacts extends HomePage{
    public Contacts(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[text()='Create']")
    protected WebElement createContactButton;

    @FindBy(xpath = "//button[text()='Save']")
    protected WebElement saveContactButton;

    @FindBy(name = "first_name")
    protected WebElement firstNameInput;

    @FindBy(name = "middle_name")
    protected WebElement middleNameInput;

    @FindBy(xpath = "//label[text()='Access']/following-sibling::div//button")
    protected WebElement accesBtn;

    @FindBy(xpath = "//div[text()='Select users allowed access']/following-sibling::div/div")
    protected WebElement accessAllowedUsersDropDown;


    @FindBy(xpath = "//input[@placeholder='Email address']")
    protected WebElement emailInput;

    @FindBy(xpath = "//input[@placeholder='Personal email, Business, Alt...']")
    protected WebElement emailTypeInput;

    public void setDescriptionTextArea(WebElement descriptionTextArea) {
    }

    @FindBy(xpath = "//label[text()='Status']/following-sibling::div")
    protected WebElement statusDropDown;

    @FindBy(xpath = "//label[text()='Social Channels']/following-sibling::div/div/div[1]")
    protected WebElement socialChannelDropDown;

    @FindBy(xpath = "//label[text()='Social Channels']/following-sibling::div/div/div[2]//input")
    protected WebElement socialChannelInput;

    @FindBy(xpath = "//label[text()='Social Channels']/following-sibling::div/div/div[3]/button")
    protected WebElement socialChannelAddBtn;

    @FindBy(name = "address")
    protected WebElement streetAddressInput;

    @FindBy(name = "city")
    protected WebElement cityInput;

    @FindBy(name="state")
    protected WebElement stateIput;

    @FindBy(name = "zip")
    protected WebElement zipInput;

    @FindBy(name = "country")
    protected WebElement countryDropDown;

    @FindBy(name = "position")
    protected WebElement positionInput;

    @FindBy(xpath = "//label[text()='Supervisor']/following-sibling::div/input")
    protected WebElement supervisorInput;

    @FindBy(xpath = "//label[text()='Referred By']/following-sibling::div/input")
    protected WebElement referredByInput;

    @FindBy(xpath = "//label[text()='Do not Call']/following-sibling::div")
    protected WebElement doNotCallRadioBtn;

    @FindBy(xpath = "//label[text()='Do not Email']/following-sibling::div")
    protected WebElement doNotEmailRadioBtn;

    @FindBy(name = "identifier")
    protected WebElement identifierInput;

    @FindBy(name = "last_name")
    protected WebElement lastNameInput;

    @FindBy(xpath = "//div[@name='company']/input")
    protected WebElement companyInput;

    @FindBy(xpath = "//label[@for='tags']/div/input")
    protected WebElement tagsInput;

    @FindBy(name = "category")
    protected WebElement categoryDropDown;

    @FindBy(name = "description")
    protected WebElement descriptionTextArea;

    @FindBy(xpath = "//div[@name='timezone']/input")
    protected WebElement timeZoneInput;

    @FindBy(xpath = "//div[@name='hint']/div[1]")
    protected WebElement phoneRegionDropDown;

    @FindBy(xpath = "//input[@placeholder='Number']")
    protected WebElement phoneNumberInput;

    @FindBy(xpath ="//input[@placeholder='Home, Work, Mobile...']" )
    protected WebElement phoneType;

    @FindBy(xpath = "//label[text()='Phone']/following-sibling::div//button")
    protected WebElement addPhoneBtn;

    @FindBy(name = "department")
    protected WebElement departmentInput;

    @FindBy(xpath = "//div[@name='assistant']/input")
    protected WebElement assistantInput;

    @FindBy(xpath = "//label[text()='Source']/following-sibling::div")
    protected WebElement sourceDropDown;


    @FindBy(xpath = "//label[text()='Do not Text']/following-sibling::div")
    protected WebElement doNotTextRadioBtn;

    @FindBy(xpath = "//input[@placeholder='Day' and @name='day']")
    protected WebElement birthDayInput;

    @FindBy(xpath = "//div[@name='month']")
    protected WebElement birthMonthDropDown;

    @FindBy(xpath = "//input[@placeholder='Year' and @name='year']")
    protected WebElement birthYearInput;

    @FindBy(xpath = "//input[@name='image']")
    protected WebElement imagePathInput; //we need to send the path of the picture based on the OS

    @FindBy(xpath = "//button[text()='Save']")
    protected WebElement saveCustomerBtn;

    @FindBy(xpath = "//button[text()='Cancel']")
    protected WebElement cancelSaveBtn;

    public void createContact(HashMap<String,String> data) {
        navigate("contacts");
        Assert.assertTrue(createContactButton.isEnabled(), "Create button is not enabled");
        createContactButton.click();

        firstNameInput.sendKeys(data.get("firstname"));
        lastNameInput.sendKeys(data.get("lastname"));
        middleNameInput.sendKeys(data.get("middlename"));
        companyInput.sendKeys(data.get("company"));
        if (!data.get("access").equals("Public")){
            accesBtn.click();
        }

        tagsInput.sendKeys(data.get("tags"));
        emailInput.sendKeys(data.get("email"));
        emailTypeInput.sendKeys(data.get("typeOfEmail"));

        categoryDropDown.click();
        categoryDropDown.findElement(By.xpath("//div/div/span[text()='"+ data.get("category")+"']")).click();
        statusDropDown.click();
        statusDropDown.findElement(By.xpath("//div/div/span[text()='"+data.get("status")+"']")).click();

        descriptionTextArea.sendKeys(data.get("description"));

        socialChannelDropDown.click();
        socialChannelDropDown.findElement(By.xpath("//div[@role='option']/span[text()='"+data.get("socialChannel")+"']")).click();
        socialChannelInput.sendKeys(data.get("channelLink"));

        streetAddressInput.sendKeys(data.get("street"));
        cityInput.sendKeys(data.get("city"));
        stateIput.sendKeys(data.get("state/county"));
        zipInput.sendKeys(data.get("zip"));

        countryDropDown.click();
        countryDropDown.findElement(By.xpath("//div[@role='option']/span[text()='"+data.get("country")+"']")).click();

        phoneRegionDropDown.click();
        driver.findElement(By.xpath("//div[@name='hint']/div[1]/following-sibling::div/div/span[text()='"+data.get("region")+"']")).click();

        phoneNumberInput.sendKeys(data.get("number"));
        phoneType.sendKeys(data.get("phoneType"));

        positionInput.sendKeys(data.get("position"));
        departmentInput.sendKeys(data.get("department"));

        supervisorInput.sendKeys(data.get("supervisor"));
        assistantInput.sendKeys(data.get("assistant"));

        referredByInput.sendKeys(data.get("referredBy"));
        sourceDropDown.click();
        sourceDropDown.findElement(By.xpath("//div[@role='option']/span[text()='"+data.get("source")+"']")).click();

        if (data.get("call?").equals("yes")){
            doNotCallRadioBtn.click();
        }

        if (data.get("text?").equals("yes")){
            doNotTextRadioBtn.click();
        }

        if (data.get("email?").equals("yes")){
            doNotEmailRadioBtn.click();
        }

        birthDayInput.sendKeys(data.get("birthday"));
        birthMonthDropDown.click();
        birthMonthDropDown.findElement(By.xpath("//div[@role='option']/span[text()='"+data.get("birthmonth")+"']")).click();

        birthYearInput.sendKeys(data.get("birthyear"));

        identifierInput.sendKeys(data.get("identifier"));

        imagePathInput.sendKeys(data.get("imagePath"));

        Assert.assertTrue(saveContactButton.isEnabled(), "Create Customer is not enabled");
        saveContactButton.click();

    }


}
