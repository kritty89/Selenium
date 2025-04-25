package com.parabank.testcases;

import com.parabank.base.BaseTest;
import com.parabank.screens.LoginPage;
import com.parabank.utilities.ExcelUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
    }

    @DataProvider(name = "loginData")
    public Object[][] getData() {
        String excelPath = System.getProperty("user.dir") + "/TestData/LoginData.xlsx";
        return ExcelUtils.getExcelData(excelPath, "Sheet1");
    }
}
