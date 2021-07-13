package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsertGIftSumPage extends BasePage {

    @FindBy(css = "[placeholder='הכנס סכום']")
    WebElement giftSumField;

    @FindBy(css = "[gtm='בחירה']")
    WebElement submitButton;



    public void inputGiftSum(String sum) throws Exception {
        inputText(giftSumField, sum, "Gift sum field");
    }

    public void clickOnSubmitButton() throws Exception {
        clickOnElement(submitButton, "Submit button");
    }

    public boolean isInsertGiftSumPageDisplayed() throws Exception {
        return isElementDisplayed(giftSumField, "Gift sum field");
    }



    public InsertGIftSumPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
