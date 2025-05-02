package com.parabank.screens;

import com.parabank.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends BasePage {
    WebDriver driver;

    public RegisterPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[contains(@id, 'firstName')]")
    WebElement firstNameInput;

    @FindBy(xpath = "//input[contains(@id, 'lastName')]")
    WebElement lastNameInput;

    @FindBy(xpath = "//input[contains(@id, 'address.street')]")
    WebElement streetInput;

    @FindBy(xpath = "//input[contains(@id, 'address.city')]")
    WebElement cityInput;

    @FindBy(xpath = "//input[contains(@id, 'address.state')]")
    WebElement stateInput;

    @FindBy(xpath = "//input[contains(@id, 'address.zipCode')]")
    WebElement zipcodeInput;

    @FindBy(xpath = "//input[contains(@id, 'phoneNumber')]")
    WebElement phoneInput;

    @FindBy(xpath = "//input[contains(@id, 'ssn')]")
    WebElement ssnInput;

    @FindBy(xpath = "//input[contains(@id, 'username')]")
    WebElement userNameInput;

    @FindBy(xpath = "//input[contains(@id, 'password') and not(contains(@id,'repeat'))]")
    WebElement passwordInput;

    @FindBy(xpath = "//input[contains(@id, 'repeatedPassword')]")
    WebElement confirmPasswordInput;

    @FindBy(xpath = "//input[@value='Register']")
    WebElement registerButton;


    public void enterFirstName(String firstname) {
        wait.until(ExpectedConditions.visibilityOf(firstNameInput));
        firstNameInput.clear();
        firstNameInput.sendKeys(firstname);
    }

    public void enterLastName(String lastname) {
        lastNameInput.clear();
        lastNameInput.sendKeys(lastname);
    }

    public void enterStreet(String street) {
        streetInput.clear();
        streetInput.sendKeys(street);
    }

    public void enterCity(String city) {
        cityInput.clear();
        cityInput.sendKeys(city);
    }

    public void enterState(String state) {
        stateInput.clear();
        stateInput.sendKeys(state);
    }

    public void enterZip(String zipcode) {
        zipcodeInput.clear();
        zipcodeInput.sendKeys(zipcode);
    }

    public void enterPhone(String phone) {
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    public void enterSsn(String ssn) {
        ssnInput.clear();
        ssnInput.sendKeys(ssn);
    }

    public void enterUserName(String username) {
        userNameInput.clear();
        userNameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void enterConfirmPassword(String password) {
        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys(password);
    }

    public void clickRegister() {
        registerButton.click();
    }

    public void register(String firstname,
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
        enterFirstName(firstname);
        enterLastName(lastname);
        enterStreet(street);
        enterCity(city);
        enterState(state);
        enterZip(zipcode);
        enterPhone(phone);
        enterSsn(ssn);
        enterUserName(username);
        enterPassword(password);
        enterConfirmPassword(password);

        clickRegister();

    }
}
