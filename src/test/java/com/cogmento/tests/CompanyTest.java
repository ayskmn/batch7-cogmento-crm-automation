package com.cogmento.tests;

import com.cogmento.tests.pages.Companies;
import com.cogmento.tests.pages.Login;
import com.cogmento.tests.utils.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

public class CompanyTest extends BaseTest{
    @Test(dataProvider = "companies")
    public void createCompanyPositive(HashMap<String,String> data) {
        Login login = new Login(driver);
        Companies companies = new Companies(driver);
        login.navigateToLoginPage();
        login.login();
        companies.createNewCompany(data);
    }
    @DataProvider(name = "companies")
    public Object[][] getContactsData(){
        return new ExcelReader("src/main/resources/testData/CogmentoTestData.xlsx", "companies").getData();
    }
}
