package PageObject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends Base {

    WebDriver driver;

    public AccountPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
    WebElement accountName;

    public void checkName() {
    waitUntilVisible(accountName);
    Assert.assertTrue(accountName.isDisplayed());
    }
}
