package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BasePage {

    @FindBy(id = "ember1432")
    WebElement nameField;

    @FindBy(id = "ember1435")
    WebElement emailField;

    @FindBy(id = "ember1438")
    WebElement passwordField;

    @FindBy(id = "ember1441")
    WebElement confirmPasswordField;

    @FindBy(id = "ember1443")
    WebElement registrationButton;

    @FindBy(xpath = "//span[contains(text(),'הרשמה ל-BUYME')]")
    WebElement registrationPageHeadline;

    @FindBy(css = "[class='login-error']")
    WebElement mailAlreadyExistsMessage;


    public void inputName(String name) throws Exception {
        inputText(nameField, name, "name field");
    }

    public void inputEmail(String email) throws Exception{
        inputText(emailField, email, "email field");
    }

    public void inputPassword(String password) throws Exception{
        inputText(passwordField, password, "password field");
    }

    public void inputConfirmPassword(String confirmPassword) throws Exception{
        inputText(confirmPasswordField, confirmPassword, "confirmPassword field");
    }

    public void clickOnRegistrationButton() throws Exception {
        clickOnElement(registrationButton, "registration button");
    }

    public boolean isRegistrationPageDisplayed() throws Exception {
        return isElementDisplayed(registrationPageHeadline, "registrationPage headline");
    }

    public boolean isMailAlreadyExistsDisplayed() throws Exception {
        return isElementDisplayed(mailAlreadyExistsMessage, "mail already exists message");
    }

    public RegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
