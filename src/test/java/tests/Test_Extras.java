package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.*;
import utils.Utils;

import javax.rmi.CORBA.Util;
import java.io.IOException;

public class Test_Extras extends Utils {

    public static HomePage homePage;
    public static ComeetPage comeetPage;
    public static LoginPage loginPage;
    public static ChooseGiftPage chooseGiftPage;
    public static InsertGIftSumPage insertGIftSumPage;
    public static ReceiverInfoPage receiverInfoPage;
    private static final Logger logger = LogManager.getLogger(Test_Extras.class);
    private static final int MIN_NUM_OF_CAREERS = 1;


    @BeforeEach
    public void initPage() throws IOException {
        homePage = new HomePage(driver);
        comeetPage = new ComeetPage(driver);
        loginPage = new LoginPage(driver);
        chooseGiftPage = new ChooseGiftPage(driver);
        insertGIftSumPage = new InsertGIftSumPage(driver);
        receiverInfoPage = new ReceiverInfoPage(driver);
        driver.get(Utils.getProperty("baseUrl"));
    }

    @Test
    public void careersAmountTest() throws Exception {
        logger.info("Careers amount test has begun!");
        homePage.clickOnCareersButton();
        homePage.switchToComeetPageTab();
        Assert.assertTrue(comeetPage.isComeetPageDisplayed());
        logger.info("Comeet page is displayed.");
        Assert.assertTrue(comeetPage.numOfCareers() >= MIN_NUM_OF_CAREERS);
        logger.info("Comeet has at least one open career opportunity");
        Utils.takeSnapShot(driver, "CareersAmountTestPassed");
        logger.info("Careers amount test passed successfully!");
    }

    @Test
    public void noValuesLoginTest() throws Exception {
        logger.info("No values login test has begun!");
        homePage.clickOnEntranceButton();
        Assert.assertTrue(loginPage.isLoginPageDisplayed());
        logger.info("Login page is displayed");
        loginPage.inputEmail(Utils.getProperty("validUsername"));
        loginPage.clickOnSubmitButton();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
        logger.info("Error message is displayed!");
        Utils.takeSnapShot(driver, "NoValuesLoginTestPassed");
        logger.info("No values login test passed successfully!");
    }

    @Test
    public void scrollDownSnapShotTest() throws Exception {
        logger.info("Scroll down snapshot test has begun!");
        Assert.assertTrue(homePage.scrollPageDown());
        logger.info("Page scrolled down.");
        Utils.takeSnapShot(driver, "ScrollDownSnapShotTestPassed");
        logger.info("Scroll down snapshot test passed successfully!");
    }

    @Test
    public void receiverInfoMessagesTest() throws Exception {
        logger.info("Receiver info messages test has begun!");
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
        receiverInfoPage.clickOnEventDropList();
        receiverInfoPage.clickOnEndOfTheYearGifts();
        receiverInfoPage.clickOnContinueButton();
        Assert.assertTrue(receiverInfoPage.isNameErrorMessageDisplayed());
        logger.info("Name error message is displayed!");
        Assert.assertTrue(receiverInfoPage.isBlessingMessageDisplayed());
        logger.info("Blessing message is displayed!");
        Utils.takeSnapShot(driver, "ReceiverInfoMessagesTestSuccess");
        logger.info("Receiver info messages test passed successfully!");
    }



}
