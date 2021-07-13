package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChooseGiftPage extends BasePage {

    @FindBy(xpath = "(//li[@class='ember-view bm-product-card-link mx-4 lr-6 sm-12'])[1]")
    WebElement buyMeToDoorGift;

    @FindBy(css = "[class='title-xxl bottom-md top-none']")
    WebElement giftPageTitle;


    public void clickOnBuyMeToDoorGift() throws Exception {
        clickOnElement(buyMeToDoorGift, "Buy me to door");
    }

    public boolean isChooseGiftPageDisplayed() throws Exception {
        return isElementDisplayed(giftPageTitle, "Gift page title");
    }

    public ChooseGiftPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
