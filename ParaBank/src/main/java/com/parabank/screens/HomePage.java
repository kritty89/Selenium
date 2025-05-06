package com.parabank.screens;

import com.parabank.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='leftPanel']//p[contains(@class,'smallText')]")
    WebElement welcomeUser;

    public String getUserName()
    {
        wait.until(ExpectedConditions.visibilityOf(welcomeUser));
        return welcomeUser.getText();
    }
}
