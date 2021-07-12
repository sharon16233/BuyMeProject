package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;
import utils.Utils;

import java.io.IOException;

public class Test_SendGift extends Utils {

    public static HomePage homePage;
    public static LoginPage loginPage;
    private static final Logger logger = LogManager.getLogger(Test_SendGift.class);

    @BeforeEach
    public void initPage() throws IOException {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        driver.get(Utils.getProperty("baseUrl"));
    }

    @Test
    public void sendGift() throws Exception {
        logger.info("Begin test 'Send a Gift' ...");

        homePage.clickOnEntranceButton();
        loginPage.isLoginPageDisplayed();
        logger.info("Login page is displayed.");
        loginPage.inputEmail(Utils.getProperty("validUsername"));
        loginPage.inputPassword(Utils.getProperty("validPassword"));
        loginPage.clickOnSubmitButton();
        Thread.sleep(2000);
        Assert.assertTrue(homePage.isLoggedIn());
        logger.info("Login passed successfully.");

        homePage.chooseAmountFromDropList("1");


    }


}
