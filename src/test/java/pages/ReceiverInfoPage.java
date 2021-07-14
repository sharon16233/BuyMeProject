package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sun.security.krb5.internal.PAData;

import java.awt.print.Pageable;

public class ReceiverInfoPage extends BasePage{

    @FindBy(css = "[gtm='למישהו אחר']")
    WebElement toSomeoneElseButton;

    @FindBy(css = "[data-parsley-required-message='מי הזוכה המאושר? יש להשלים את שם המקבל/ת']")
    WebElement receiverNameField;

    @FindBy(css = "[class='selected-name']")
    WebElement eventDropList;

    @FindBy(xpath = "//span[contains(text(),'מתנות סוף שנה')]")
    WebElement endOfTheYearGiftsButton;

    @FindBy(css = "[class='bm-h1']")
    WebElement receiverInfoPageHeadline;

    @FindBy(css = "[name='logo']")
    WebElement uploadButton;

    @FindBy(css = "[type='submit']")
    WebElement continueButton;

    @FindBy(css = "[class='parsley-required']")
    WebElement nameErrorMessage;

    @FindBy(css = "[class='parsley-success']")
    WebElement blessingMessage;


    public void clickOnToSomeoneElse() throws Exception {
        clickOnElement(toSomeoneElseButton, "To someone else button");
    }

    public void inputReceiverName(String name) throws Exception {
        inputText(receiverNameField, name, "Receiver name field");
    }

    public void clickOnEventDropList() throws Exception {
        clickOnElement(eventDropList, "Event drop list");
    }

    public void clickOnEndOfTheYearGifts() throws Exception {
        clickOnElement(endOfTheYearGiftsButton, "End of the year gifts button");
    }

    public boolean isReceiverInfoPageDisplayed() throws Exception {
        return isElementDisplayed(receiverInfoPageHeadline, "Reciever page headline");
    }

    public void uploadPhoto(String pathToFile) throws Exception {
        uploadFile(uploadButton, pathToFile, "Upload photo button");
    }

    public void clickOnContinueButton() throws Exception {
        clickOnElement(continueButton, "Continue button");
    }

    public boolean isNameErrorMessageDisplayed() throws Exception {
        return isElementDisplayed(nameErrorMessage, "Name error message");
    }

    public boolean isBlessingMessageDisplayed() throws Exception {
        return isElementDisplayed(blessingMessage, "Blessing message");
    }


    public ReceiverInfoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
