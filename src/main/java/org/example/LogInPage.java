package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage extends example.Base {


    WebDriver driver;
    private static final By USERNAME = By.cssSelector("input[name='username']");
    private static final By PASSWORD = By.cssSelector("input[name='password']");
    private static final By SUBMIT = By.xpath("//button[@type='submit']");
    public LogInPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void LogIn() {
        waitUntilVisible(driver.findElement(USERNAME)).sendKeys("Admin");
        waitUntilVisible(driver.findElement(PASSWORD)).sendKeys("Admin123");
    driver.findElement(SUBMIT).click();
    }
}