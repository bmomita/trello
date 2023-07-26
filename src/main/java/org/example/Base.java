package example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Base {
    public WebDriver driver;
    public WebDriverWait wait;

    private final long TIMEOUT=10L;

    private Actions actions;

    private JavascriptExecutor jse;

    public Base(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, TIMEOUT);
        jse=(JavascriptExecutor) driver;
        actions = new Actions(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement waitUntilVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public List<WebElement> waitForAllElementsToBeVisible(List<WebElement> elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        return elements;
    }

    public WebElement waitUntilClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public void interactUsingJavascript(WebElement element) {
        jse.executeScript("arguments[0].click()", element);
    }

    public void waitForAttribute(WebElement element, String attribute, String attributeValue) {
        wait.until(ExpectedConditions.attributeContains(element, attribute, attributeValue));
    }

    public void hover(WebElement element) {
        actions.moveToElement(element).perform();
    }

}
