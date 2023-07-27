package PageObject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends Base {
    WebDriver driver;

    public LogInPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "input[placeholder='Username']")
    WebElement userName;

    @FindBy(css = "input[placeholder='Password']")
    WebElement passwordElement;

    @FindBy(css = "button[type='submit']")
    WebElement loginButton;

    @FindBy(xpath = "//div[@role='alert']")
    WebElement invalidCredentials;

    public void logInApplication(String userid, String pass) {
        waitUntilVisible(userName).sendKeys(userid);
        waitUntilVisible(passwordElement).sendKeys(pass);
        loginButton.click();
    }
    public void goTo() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    public void verifyInvalidCredentials() {
        waitUntilVisible(invalidCredentials);
        Assert.assertTrue(invalidCredentials.getText().contains("Invalid credentials"));
    }

}