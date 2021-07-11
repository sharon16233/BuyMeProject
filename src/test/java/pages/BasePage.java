package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.js = (JavascriptExecutor) driver;
    }

    public void clickOnElement(WebElement element){
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void inputText(WebElement element, String text){
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.clear();
        element.sendKeys(text);
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        }catch (NoAlertPresentException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void pressOnKeyboard(Keys key) {
        Actions action = new Actions(driver);
        action.sendKeys(key).build().perform();
    }

    public void hoverOnElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    public boolean isElementDisplayed(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element.isDisplayed();
    }

}
