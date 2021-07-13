package pages;

import io.reactivex.rxjava3.internal.operators.observable.BlockingObservableLatest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
            logger.info(elementName + " was clicked successfully.");
        } catch (Exception e) {
            Utils.takeSnapShot(driver, "clickOnElement Error");
            logger.error("Could not click on " + elementName + ".");
        }

    }

    public void inputText(WebElement element, String text, String elementName) throws Exception {

        try {
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.clear();
            element.sendKeys(text);
            logger.info("Text was successfully written into " + elementName + ".");
        } catch (Exception e) {
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
            logger.info(elementName + " was successfully hovered.");
        } catch (Exception e) {
            Utils.takeSnapShot(driver, "hoverOnElementError");
            logger.error("Could not hover on " + elementName + ".");
        }
    }

    public boolean isElementDisplayed(WebElement element, String elementName) throws Exception {
        try {
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (Exception e) {
            Utils.takeSnapShot(driver, "ElementNotDisplayedError");
            logger.error("Error finding whether the element " + "'" + elementName + "'" + " is displayed.");
            return false;
        }
    }

    public void selectFromDropList(WebElement dropListElement, String dropListName, String value) throws Exception {
        try {
            js.executeScript("arguments[0].scrollIntoView(true);", dropListElement);
            wait.until(ExpectedConditions.visibilityOf(dropListElement));
            Select select = new Select(dropListElement);
            select.selectByValue(value);
            logger.info("element was selected successfully from " + dropListName);
        } catch (Exception e) {
            Utils.takeSnapShot(driver, "SelectFromDropListError");
            logger.error("Could not select from " + dropListName + ".");
        }
    }

    public void uploadFile(WebElement element, String pathToFile, String elementName) throws Exception {
        try {
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            element.sendKeys(pathToFile);
            logger.info("File was successfully uploaded");
        } catch (Exception e) {
            Utils.takeSnapShot(driver, "UploadFileError");
            logger.error("Could not upload file to " + elementName + ".");
        }
    }
}
