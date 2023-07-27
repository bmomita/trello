package stepDefinition;

import PageObject.AccountPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import PageObject.LogInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class stepDefinition {

    private WebDriver driver;
    private LogInPage logInPage;

    private AccountPage accountPage;

    @Before
            public void Before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        logInPage = PageFactory.initElements(driver, LogInPage.class);
        accountPage = PageFactory.initElements(driver, AccountPage.class);
    }

    @After
    public void after() {
        driver.quit();
    }

    @Given("I access the homepage")
    public void navigateToLoginPage() {
        logInPage.goTo();
    }

    @When("I enter the Username {} and the Password {} and I press the Login button to log into my account")
    public void enteringCredentials(String username, String password) {
        logInPage.logInApplication(username,password);
    }

    @Then("I verify that I am logged into my account by checking that the username is displayed in the navigation bar in the right corner of the application by using XPath selector")
    public void verifyLogIn() {
        accountPage.checkName();
    }

    @Then("I verify that I am that an appropriate message is displayed for invalid credentials")
    public void verifyInvalidCredentials() {
        logInPage.verifyInvalidCredentials();
    }

}
