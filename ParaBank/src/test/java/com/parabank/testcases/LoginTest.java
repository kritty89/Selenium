package com.parabank.testcases;

import com.parabank.base.BaseTest;
import com.parabank.screens.HomePage;
import com.parabank.screens.LoginPage;
import com.parabank.screens.RegisterPage;
import com.parabank.utilities.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "registerData")
    public void testRegister(String firstname,
                             String lastname,
                             String street,
                             String city,
                             String state,
                             String zipcode,
                             String phone,
                             String ssn,
                             String username,
                             String password)
    {
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        loginPage.clickRegister();
        registerPage.register(firstname, lastname, street, city, state, zipcode, phone, ssn, username, password);
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password, String firstname) {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login(username, password);
        String actualName = homePage.getUserName();
        System.out.println(actualName);
        Assert.assertTrue(actualName.toLowerCase().contains(firstname.toLowerCase()), "Username mismatch");
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        String excelPath = System.getProperty("user.dir") + "/TestData/LoginData.xlsx";
        return ExcelUtils.getExcelData(excelPath, "Login");
    }

    @DataProvider(name = "registerData")
    public Object[][] getRegisterData() {
        String excelPath = System.getProperty("user.dir") + "/TestData/LoginData.xlsx";
        return ExcelUtils.getExcelData(excelPath, "Register");
    }

}
