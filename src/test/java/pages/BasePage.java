package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utils;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;
    private static final Logger logger = LogManager.getLogger(BasePage.class);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.js = (JavascriptExecutor) driver;
    }

    public void clickOnElement(WebElement element, String elementName) throws Exception {
        try {
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        } catch (Exception e) {
            Utils.takeSnapShot(driver, "clickOnElement Error");
            logger.error("Could not click on" + elementName + ".");
        }

    }

    public void inputText(WebElement element, String text, String elementName) throws Exception {

        try {
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.clear();
            element.sendKeys(text);
        }catch (Exception e) {
            Utils.takeSnapShot(driver, "inputTextError");
            logger.error("Could not input text into" + elementName + ".");
        }

    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void pressOnKeyboard(Keys key) {
        Actions action = new Actions(driver);
        action.sendKeys(key).build().perform();
    }

    public void hoverOnElement(WebElement element, String elementName) throws Exception {
        try {
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            Actions action = new Actions(driver);
            action.moveToElement(element).build().perform();
        }catch (Exception e) {
            Utils.takeSnapShot(driver, "hoverOnElementError");
            logger.error("Could not hover on " + elementName + ".");
        }
    }

    public boolean isElementDisplayed(WebElement element, String elementName) throws Exception {
        try {
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return element.isDisplayed();
        }catch (Exception e) {
            Utils.takeSnapShot(driver, "ElementNotDisplayedError");
            logger.error("Error finding whether the element " + "'" + elementName + "'" + " is displayed.");
            return false;
        }
    }
}
