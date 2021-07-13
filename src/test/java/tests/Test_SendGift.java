package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import pages.*;
import utils.Utils;

import java.io.IOException;

public class Test_SendGift extends Utils {

    public static HomePage homePage;
    public static LoginPage loginPage;
    public static ChooseGiftPage chooseGiftPage;
    public static InsertGIftSumPage insertGIftSumPage;
    public static ReceiverInfoPage receiverInfoPage;
    private static final Logger logger = LogManager.getLogger(Test_SendGift.class);

    @BeforeEach
    public void initPage() throws IOException {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        chooseGiftPage = new ChooseGiftPage(driver);
        insertGIftSumPage = new InsertGIftSumPage(driver);
        receiverInfoPage = new ReceiverInfoPage(driver);
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
        Assert.assertTrue(homePage.isLoggedIn());
        logger.info("Login passed successfully.");
        logger.info("logged in as " + Utils.getProperty("validUsername"));

        homePage.clickOnAmountDropList();
        homePage.chooseValueFromDropList();
        logger.info("Amount was chosen.");
        homePage.clickOnAreaDropList();
        homePage.chooseValueFromDropList();
        logger.info("Area was chosen.");
        homePage.clickOnCategoryDropList();
        homePage.chooseValueFromDropList();
        logger.info("Category was chosen.");
        homePage.clickOnGiftSearchButton();

        Assert.assertTrue(chooseGiftPage.isChooseGiftPageDisplayed());
        logger.info("Choose gift page is displayed.");
        chooseGiftPage.clickOnBuyMeToDoorGift();

        Assert.assertTrue(insertGIftSumPage.isInsertGiftSumPageDisplayed());
        logger.info("Insert gift sum page is displayed.");
        insertGIftSumPage.inputGiftSum(Utils.getProperty("giftSum"));
        insertGIftSumPage.clickOnSubmitButton();

        Assert.assertTrue(receiverInfoPage.isReceiverInfoPageDisplayed());
        logger.info("Receiver info page is displayed.");
        receiverInfoPage.clickOnToSomeoneElse();
        receiverInfoPage.inputReceiverName(Utils.getProperty("receiverName"));
        receiverInfoPage.clickOnEventDropList();
        receiverInfoPage.clickOnEndOfTheYearGifts();
        receiverInfoPage.uploadPhoto(System.getProperty("user.dir") + Utils.getProperty("pathToPhoto"));
        receiverInfoPage.clickOnContinueButton();

    }


}
