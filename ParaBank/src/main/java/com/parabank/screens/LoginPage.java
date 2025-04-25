package com.parabank.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[contains(@name,'username') and contains(@fdprocessedid,'x1pddt')]")
    WebElement usernameInput;

    @FindBy(xpath = "//input[contains(@name,'password') and contains(@fdprocessedid,'fghou')]")
    WebElement passwordInput;

    @FindBy(xpath = "//input[contains(@value,'Log In') and contains(@fdprocessedid,'i6rbkc')]")
    WebElement loginButton;

    public void enterUsername(String username) {
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}
