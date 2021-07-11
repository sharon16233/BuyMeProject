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

    public void clickOnEntranceButton() throws Exception {
        clickOnElement(entranceButton, "entrance button");
    }

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
