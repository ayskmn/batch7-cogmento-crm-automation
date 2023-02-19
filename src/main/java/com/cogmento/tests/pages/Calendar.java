package com.cogmento.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.HashMap;

public class Calendar extends HomePage{

    public Calendar(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[text()='Create']")
    private WebElement createBtn;
    @FindBy(xpath = "//input[@name='title']")
    private WebElement titleInput;
    @FindBy(xpath = "//button[@class='ui button']/i")
    private WebElement cancelBtn;
    @FindBy(xpath = "//label[text()='Category']//following-sibling::div[@name='category']/i")
    private WebElement categoryLink;
    @FindBy(xpath = "//label[text()='Description']//following-sibling::textarea")
    private WebElement descriptionInput;
    @FindBy(xpath = "//label[text()='Location']//following-sibling::textarea")
    private WebElement meetingLocation;
    @FindBy(xpath = "//label[text()='Start Date']//following-sibling::div[@class='react-datepicker-wrapper']/div/input")
    private WebElement calendarDropDown;
    @FindBy(xpath = "//button[@aria-label='Next Month']")
    private WebElement nextMonthBtn;
    @FindBy(xpath = "//div[@class='react-datepicker__month']/div/div[text()='11']")
    private WebElement meetingDay;

//    @FindBy(xpath = "//label[text()='End Date']//following-sibling::div/div/input[contains(@value,'11')]")
//    private WebElement endDate;

    @FindBy(xpath = "//label[text()='End Date']/following-sibling::div/div/div/div/div//following-sibling::div[@class='react-datepicker__month-container']/div//following-sibling::div[@class='react-datepicker__week'][5]/div[@class='react-datepicker__day react-datepicker__day--030 react-datepicker__day--selected react-datepicker__day--today']")
    private WebElement endDate;

    @FindBy(xpath = "//label[text()='All Day']//following-sibling::div[@class='ui toggle checkbox']")
    private WebElement allDayBtn;

//    @FindBy(xpath = "//div[contains(@class,'ui toggle checkbox')]//label[contains(text(),'All Day')]")
//    private WebElement allDayBtn;
    @FindBy(xpath = "//div[@name='deal']/input")
    private WebElement dealInput;
    @FindBy(xpath = "//div[@name='task']/input")
    private WebElement taskInput;
    @FindBy(xpath = "//div[@name='case']/input")
    private WebElement caseInput;
    @FindBy(xpath = "//label[text()='Alert Before']//following-sibling::div/i")
    private WebElement alertBeforeBtn;

    @FindBy(xpath = "//label[text()='Alert Via']//following-sibling::div/i")
    private WebElement alertVia;
    @FindBy(xpath = "//label[text()='Reminder Time']//following-sibling::div/input")
    private WebElement reminderTime;
    @FindBy(xpath = "//label[text()='Company']//following-sibling::div/input")
    private WebElement companyName;
    @FindBy(xpath = "//button[text()='Save']")
    private WebElement saveBtn;

    public void createEventInCalendar(HashMap<String,String> data) {

        navigate("calendar");
        fillCalendarInfo(data);
    }

    private void fillCalendarInfo(HashMap<String, String> data){


        createBtn.click();
        cancelBtn.click();
        createBtn.click();
        titleInput.sendKeys(data.get("Title"));
        calendarDropDown.click();

        nextMonthBtn.click();
        WebElement start_meeting_date = driver.findElement(By.xpath("//div[@class='react-datepicker__month']/div/div[text()='" + data.get("start meeting date") + "']"));
        start_meeting_date.click();
        driver.findElement(By.xpath("//div[@class='react-datepicker__time-box']/ul/li[text()='"+data.get("time")+"']")).click();

        categoryLink.click();
        categoryLink.findElement(By.xpath("//following-sibling::div[@class='visible menu transition']/div/span[text()='"+data.get("Category")+"']")).click();
        descriptionInput.sendKeys(data.get("Description"));
        meetingLocation.sendKeys(data.get("Location"));
        if(data.get("All Day").equalsIgnoreCase("yes")) allDayBtn.click();
        dealInput.sendKeys(data.get("Deal"));
        taskInput.sendKeys(data.get("Task"));
        caseInput.sendKeys(String.valueOf((long)Double.parseDouble(data.get("Case"))));
        alertBeforeBtn.click();
        alertBeforeBtn.findElement(By.xpath("//following-sibling::div/div/span[text()='"+data.get("before time")+"']")).click();
        alertVia.click();
        alertVia.findElement(By.xpath("//following-sibling::div/div/span[text()='"+data.get("alert Via")+"']")).click();
        reminderTime.sendKeys(data.get("reminder time"));
        companyName.sendKeys(data.get("company"));
        saveBtn.click();

    }


}
