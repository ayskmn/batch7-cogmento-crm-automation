package com.cogmento.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;

public class Deals extends HomePage{
    public Deals(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//td//following-sibling::td[@class='right aligned collapsing options-buttons-container']/a//following-sibling::a/button/i")
    private WebElement editBtn;
    @FindBy(xpath = "//div[@name='company']/input")
    private WebElement company;
    @FindBy(xpath="//label[text()='Contacts']//following-sibling::div/input")
    private WebElement contact;
    @FindBy(xpath = "//label[text() = 'Products']//following-sibling::div/input")
    private WebElement product;
    @FindBy(xpath = "//label[text()='Assigned To']//following-sibling::div/i")
    private WebElement assignTo;
    @FindBy(xpath = "//label[text()='Close Date']/following-sibling::div/div/input")
    private WebElement closeDateBtn;

    @FindBy(xpath = "//div[@class='react-datepicker__week']/div[text()='15']")
    private WebElement closeDate;
    @FindBy(xpath = "//button[@aria-label='Next Month']")
    private WebElement nextMonthBtn;
    @FindBy(xpath = "//label[text()='Description']//following-sibling::textarea")
    private WebElement descriptionInput;
    @FindBy(xpath = "//label[text()='Probability']//following-sibling::div/input")
    private WebElement probabilityInput;
    @FindBy(xpath = "//label[text()='Amount']//following-sibling::div/input")
    private WebElement amountInput;
    @FindBy(xpath = "//label[text()='Commission']//following-sibling::div/input")
    private WebElement commissionInput;
    @FindBy(xpath = "//label[text()='Stage']/following-sibling::div/i")
    private WebElement stageLink;
    @FindBy(xpath = "//label[text()='Status']//following-sibling::div/i")
    private WebElement statusLink;
    @FindBy(xpath = "//label[text()='Next Steps']/following-sibling::textarea")
    private WebElement nextStep;
    @FindBy(xpath = "//label[text()='Type']/following-sibling::div/i")
    private WebElement typeLink;
    @FindBy(xpath = "//label[text()='Source']/following-sibling::div/i")
    private WebElement sourceLink;
    @FindBy(xpath = "//label[text()='Closed']/following-sibling::div/input")
    private WebElement closeBtn;
    @FindBy(xpath = "//button[text()='Save']")
    private WebElement saveBtn;

    public void editDealsDetails(HashMap<String, String> data){
        navigate("deals");
        editDealsOption(data);
    }
    private void editDealsOption(HashMap<String, String> data){
        editBtn.click();
        company.sendKeys(data.get("Company"));
        assignTo.click();
        driver.findElement(By.xpath("//label[text()='Assigned To']//following-sibling::div/i//following-sibling::div/div/span[text()='"+data.get("Assigned To")+"']")).click();
        product.sendKeys(data.get("Products"));
        contact.sendKeys(data.get("Contact"));
        closeDateBtn.click();
        nextMonthBtn.click();
        driver.findElement(By.xpath("//div[@class='react-datepicker__week']/div[text()='"+ (int) Double.parseDouble(data.get("Close Date")) +"']")).click();
        descriptionInput.sendKeys(data.get("Description"));
        probabilityInput.sendKeys(String.valueOf((int)Double.parseDouble(data.get("Probability"))));
        amountInput.sendKeys(data.get("Amount"));
        commissionInput.sendKeys(data.get("Commission"));
        stageLink.click();
        stageLink.findElement(By.xpath("//following-sibling::div/div/span[text()='"+data.get("Stage")+"']")).click();
        if(data.get("Closed").equalsIgnoreCase("yes")) closeBtn.click();
        statusLink.click();
        statusLink.findElement(By.xpath("//following-sibling::div/div/span[text()='"+data.get("Status")+"']")).click();
        nextStep.sendKeys(data.get("Next Steps"));
        typeLink.click();
        typeLink.findElement(By.xpath("//following-sibling::div/div/span[text()='"+data.get("Type")+"']")).click();
        sourceLink.click();
        sourceLink.findElement(By.xpath("//following-sibling::div/div/span[text()='"+data.get("Source")+"']")).click();
        saveBtn.click();
    }

}
