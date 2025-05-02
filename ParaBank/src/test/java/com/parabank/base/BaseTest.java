package com.parabank.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    protected WebDriver driver;
    protected Properties prop;
    protected WebDriverWait wait;

    public void loadConfig() {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream(
                    System.getProperty("user.dir") + "/Configuration/Config.properties");
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load configuration file.");
        }
    }
    public void launchApp(){
        String browserName = prop.getProperty("browser");
        if (browserName.contains("Chrome")){
            driver = new ChromeDriver();
        }

        else if (browserName.contains("Firefox")) {
            driver = new FirefoxDriver();
        }

        else if (browserName.contains("Internet Explorer")){
            driver = new InternetExplorerDriver();
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void setUp() {
        loadConfig();
        launchApp();
        driver.manage().window().maximize();
        String url = prop.getProperty("url");
        driver.get(url);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
