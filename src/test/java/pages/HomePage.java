package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class HomePage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'כניסה')]")
    WebElement entranceButton;

    @FindBy(css = "[class='ember-view dropdown solid']")
    WebElement myAccountDropList;

    @FindBy(xpath = "//header[@class='m-page-header']//select[1]")
    WebElement amountDropList;

    @FindBy(xpath = "//header[@class='m-page-header']//select[2]")
    WebElement areaDropList;

    @FindBy(xpath = "//header[@class='m-page-header']//select[3]")
    WebElement categoryDropList;

    @FindBy(id = "ember1663")
    WebElement searchButton;

    public void clickOnEntranceButton() throws Exception {
        clickOnElement(entranceButton, "entrance button");
    }

    public boolean isLoggedIn() throws Exception {
        return isElementDisplayed(myAccountDropList, "My account drop list");
    }

    public void chooseAmountFromDropList(String value) throws Exception {
        selectFromDropList(amountDropList, "Amount drop list", value);
    }

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
