package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sun.awt.windows.WBufferStrategy;

public class LoginPage extends BasePage {


    @FindBy(css = "[data-ember-action='1397']")
    WebElement registrationButton;

    @FindBy(id = "ember1408")
    WebElement emailField;

    @FindBy(id = "ember1411")
    WebElement passwordField;

    @FindBy(id = "ember1428")
    WebElement submitButton;

    @FindBy(css = "[class='bm-h1']")
    WebElement loginPageHeadline;


    public void clickOnRegistrationButton() throws Exception {
        clickOnElement(registrationButton, "registration Button");
    }

    public void inputEmail(String email) throws Exception {
        inputText(emailField, email, "email field");

    }

    public void inputPassword(String password) throws Exception {
        inputText(passwordField, password, "password");
    }

    public void clickOnSubmitButton() throws Exception {
        clickOnElement(submitButton, "submit login button");
    }

    public boolean isLoginPageDisplayed() throws Exception {
        return isElementDisplayed(loginPageHeadline, "login page Headline");
    }

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


}
