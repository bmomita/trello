package PageObject;

import Inputs.UrlConstants;
import Interfaces.LogInPageSelectors;
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

    @FindBy(css = LogInPageSelectors.USERNAME)
    WebElement userName;

    @FindBy(css = LogInPageSelectors.PASSWORD)
    WebElement passwordElement;

    @FindBy(css = LogInPageSelectors.LOGINSUBMIT)
    WebElement loginButton;

    @FindBy(xpath = LogInPageSelectors.INVALIDCREDENTIALS)
    WebElement invalidCredentials;

    public void logInApplication(String userid, String pass) {
        waitUntilVisible(userName).sendKeys(userid);
        waitUntilVisible(passwordElement).sendKeys(pass);
        loginButton.click();
    }
    public void goTo() {
        driver.get(UrlConstants.BASE_URL.getUrl());
    }

    public void verifyInvalidCredentials() {
        waitUntilVisible(invalidCredentials);
        Assert.assertTrue(invalidCredentials.getText().contains("Invalid credentials"));
    }

}