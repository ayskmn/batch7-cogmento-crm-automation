package com.cogmento.tests;

import com.cogmento.tests.pages.Documents;
import com.cogmento.tests.pages.Login;
import com.cogmento.tests.utils.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.HashMap;

public class DocumentsTest extends  BaseTest{
    @Test(dataProvider = "documents")
    public void verifyDocumentsPageFunctionality(HashMap<String,String> data){
        Login login = new Login(driver);
        Documents documents = new Documents(driver);
        login.navigateToLoginPage();
        login.login();
        documents.verifyDocFunctionality(data);

    }

    @DataProvider(name = "documents")
    public Object[][] getContactsData(){
        return new ExcelReader("src/main/resources/testData/CogmentoTestData.xlsx", "documents").getData();
    }
}
