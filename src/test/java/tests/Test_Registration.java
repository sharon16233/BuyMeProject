package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;
import utils.Utils;
import java.io.IOException;

public class Test_Registration extends Utils {

    public static HomePage homePage;
    public static LoginPage loginPage;
    public static RegistrationPage registrationPage;
    private static final Logger logger = LogManager.getLogger(Test_Registration.class);

    @BeforeEach
    public void initPage() throws IOException {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        driver.get(Utils.getProperty("baseUrl"));
    }

    /*

    Given: Entrance to registration page.
    When:


     */
    @Test
    public void registerToBuyMe() throws Exception {
        logger.info("Begin test 'register to BuyMe' ...");

        homePage.clickOnEntranceButton();
        Assert.assertTrue(loginPage.isLoginPageDisplayed());
        logger.info("Login page is displayed.");
        loginPage.clickOnRegistrationButton();
        Assert.assertTrue(registrationPage.isRegistrationPageDisplayed());
        logger.info("Registration page is displayed.");

        registrationPage.inputName(Utils.getProperty("name"));
        registrationPage.inputEmail(Utils.getProperty("email"));
        registrationPage.inputPassword(Utils.getProperty("registrationPassword"));
        registrationPage.inputConfirmPassword(Utils.getProperty("confirmRegistrationPassword"));
        registrationPage.clickOnRegistrationButton();
        Thread.sleep(2000);

        // Which is enough for this test because real registration is not required.
        Assert.assertTrue(registrationPage.isMailAlreadyExistsDisplayed());
        takeSnapShot(driver, "registrationTest_Success");
        logger.info("Test 'Register to BuyMe' passed successfully");

    }

}
