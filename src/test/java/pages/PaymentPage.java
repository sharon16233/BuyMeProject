package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BasePage {

    @FindBy(css = "[class='total-price']")
    WebElement totalPriceHeadline;


    public boolean isPaymentPageDisplayed() throws Exception {
        return isElementDisplayed(totalPriceHeadline, "Total price headline.");
    }

    public PaymentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
