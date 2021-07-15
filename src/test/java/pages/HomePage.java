package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class HomePage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'כניסה')]")
    WebElement entranceButton;

    @FindBy(xpath = "//span[contains(text(),'סכום')]")
    WebElement myAccountDropList;

    @FindBy(xpath = "(//a[@class='chosen-single'])[1]")
    WebElement amountDropList;

    @FindBy(xpath = "(//a[@class='chosen-single'])[2]")
    WebElement areaDropList;

    @FindBy(xpath = "(//a[@class='chosen-single'])[3]")
    WebElement categoryDropList;

    @FindBy(css = "[class='ui-btn search ember-view']")
    WebElement searchButton;

    @FindBy(linkText = "careers")
    WebElement careersButton;

    public void clickOnEntranceButton() throws Exception {
        clickOnElement(entranceButton, "Entrance button");
    }

    public boolean isLoggedIn() throws Exception {
        return isElementDisplayed(myAccountDropList, "My account drop list");
    }

    public void clickOnAmountDropList() throws Exception {
        Thread.sleep(1000);
        clickOnElement(amountDropList, "Amount droplist");
    }

    public void clickOnAreaDropList() throws Exception {
        clickOnElement(areaDropList, "Area droplist");
    }

    public void clickOnCategoryDropList() throws Exception {
        clickOnElement(categoryDropList, "Category droplist");
    }

    public void clickOnGiftSearchButton() throws Exception {
        clickOnElement(searchButton, "Gift search button");
    }

    public void clickOnCareersButton() throws Exception {
        clickOnElement(careersButton, "Careers button");
    }

    public void chooseValueFromDropList() {
        pressOnKeyboard(Keys.DOWN);
        pressOnKeyboard(Keys.DOWN);
        pressOnKeyboard(Keys.ENTER);
    }

    public void switchToComeetPageTab() {
        switchToNewTab();
    }

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
