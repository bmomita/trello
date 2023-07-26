package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRMTest extends example.Base {
    public OrangeHRMTest(WebDriver driver) {
        super(driver);
    }

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement usernameInput = driver.findElement(By.cssSelector("input[name='username']"));

        WebElement passwordInput = driver.findElement(By.className("oxd-input oxd-input--active"));

        WebElement loginButton = driver.findElement(By.cssSelector("#submit"));


        loginButton.click();
    }
}