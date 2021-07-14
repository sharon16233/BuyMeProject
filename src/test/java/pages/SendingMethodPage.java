package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendingMethodPage extends BasePage {

    @FindBy(css = "[gtm='method-email']")
    WebElement emailButton;

    @FindBy(id = "email")
    WebElement giftReceiverEmailField;

    @FindBy(css = "[type='submit']")
    WebElement continueToPaymentPageButton;

    public boolean isSendingMethodPageDisplayed() throws Exception {
        return isElementDisplayed(emailButton, "Email Button");
    }

    public void clickOnEmailButton() throws Exception {
        clickOnElement(emailButton, "Email button");
    }

    public void inputGiftReceiverEmail(String email) throws Exception {
        inputText(giftReceiverEmailField, email, "Gift receiver email field");
    }

    public void clickOnContinueToPaymentPageButton() throws Exception {
        clickOnElement(continueToPaymentPageButton, "Continue to payment page button");
    }
    public SendingMethodPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
