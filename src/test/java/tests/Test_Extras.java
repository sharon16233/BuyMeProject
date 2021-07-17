package tests;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.*;
import utils.Utils;
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
    public void initPage() throws IOException, InterruptedException {
        homePage = new HomePage(driver);
        comeetPage = new ComeetPage(driver);
        loginPage = new LoginPage(driver);
        chooseGiftPage = new ChooseGiftPage(driver);
        insertGIftSumPage = new InsertGIftSumPage(driver);
        receiverInfoPage = new ReceiverInfoPage(driver);
        driver.get(Utils.getProperty("baseUrl"));
        Thread.sleep(500);
    }

    /**
     * Given: User has entered into the home page of BuyMe.
     * When: User goes to Comeet website.
     * Then: At least one job exists.
     */

    @Test
    public void careersAmountTest() throws Exception {
        //Reports Initiation
        testReporter = extent.startTest("Careers amount");
        logger.info("Careers amount test has begun!");

        homePage.clickOnCareersButton();
        homePage.switchToComeetPageTab();
        Assert.assertTrue(comeetPage.isComeetPageDisplayed());
        logger.info("Comeet page is displayed.");
        testReporter.log(LogStatus.PASS, "Comeet page is displayed.");
        Assert.assertTrue(comeetPage.numOfCareers() >= MIN_NUM_OF_CAREERS);
        logger.info("Comeet has at least one open career opportunity.");
        testReporter.log(LogStatus.PASS, "Comeet has at least one open career opportunity.");
        Utils.takeSnapShot(driver, "CareersAmountTestPassed");
        logger.info("Careers amount test passed successfully!");
        testReporter.log(LogStatus.PASS, "Careers amount test passed successfully!");
        testReporter.log(LogStatus.INFO, "Check Screenshot below:" + testReporter.addScreenCapture(dest));

    }

    /**
     * Given: User has entered into the home page of BuyMe.
     * When: User tries to login with no input.
     * Then: Error message appears.
     */

    @Test
    public void noValuesLoginTest() throws Exception {
        //Reports Initiation
        testReporter = extent.startTest("No values login");
        logger.info("No values login test has begun!");

        homePage.clickOnEntranceButton();
        Assert.assertTrue(loginPage.isLoginPageDisplayed());
        logger.info("Login page is displayed.");
        testReporter.log(LogStatus.PASS, "Login page is displayed.");
        loginPage.inputEmail(Utils.getProperty("validUsername"));
        loginPage.clickOnSubmitButton();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
        logger.info("Error message is displayed!");
        testReporter.log(LogStatus.PASS, "Error message is displayed!");
        Utils.takeSnapShot(driver, "NoValuesLoginTestPassed");
        testReporter.log(LogStatus.INFO, "Check Screenshot below:" + testReporter.addScreenCapture(dest));
        logger.info("No values login test passed successfully!");
    }

    /**
     * Given: User has entered into the home page of BuyMe.
     * When: User scrolls down.
     * Then: The page is scrolled down and a screenshot is taken.
     */

    @Test
    public void scrollDownSnapShotTest() throws Exception {
        //Reports Initiation
        testReporter = extent.startTest("Scroll down snapshot");
        logger.info("Scroll down snapshot test has begun!");

        Assert.assertTrue(homePage.scrollPageDown());
        logger.info("Page scrolled down.");
        testReporter.log(LogStatus.PASS, "Page scrolled down.");

        Utils.takeSnapShot(driver, "ScrollDownSnapShotTestPassed");
        testReporter.log(LogStatus.INFO, "Check Screenshot below:" + testReporter.addScreenCapture(dest));
        logger.info("Scroll down snapshot test passed successfully!");
    }

    /**
     * Given: User has entered into the home page of BuyMe.
     * When: User goes to gift receiver info's page.
     * Then: Error message and blessing appear.
     */

    @Test
    public void receiverInfoMessagesTest() throws Exception {
        //Reports Initiation
        testReporter = extent.startTest("Receiver info messages");
        logger.info("Receiver info messages test has begun!");

        //Search for a gift.
        homePage.clickOnAmountDropList();
        homePage.chooseValueFromDropList();
        logger.info("Amount was chosen.");
        testReporter.log(LogStatus.PASS, "Amount was chosen.");
        homePage.clickOnAreaDropList();
        homePage.chooseValueFromDropList();
        logger.info("Area was chosen.");
        testReporter.log(LogStatus.PASS, "Area was chosen.");
        homePage.clickOnCategoryDropList();
        homePage.chooseValueFromDropList();
        logger.info("Category was chosen.");
        testReporter.log(LogStatus.PASS, "Category was chosen.");
        homePage.clickOnGiftSearchButton();

        //Choose a gift from the list.
        Assert.assertTrue(chooseGiftPage.isChooseGiftPageDisplayed());
        logger.info("Choose gift page is displayed.");
        testReporter.log(LogStatus.PASS, "Choose gift page is displayed.");
        chooseGiftPage.clickOnBuyMeToDoorGift();

        //Insert gift's sum.
        Assert.assertTrue(insertGIftSumPage.isInsertGiftSumPageDisplayed());
        logger.info("Insert gift sum page is displayed.");
        testReporter.log(LogStatus.PASS, "Insert gift sum page is displayed.");
        insertGIftSumPage.inputGiftSum(Utils.getProperty("giftSum"));
        insertGIftSumPage.clickOnSubmitButton();

        //Receiver info's page.
        Assert.assertTrue(receiverInfoPage.isReceiverInfoPageDisplayed());
        logger.info("Receiver info page is displayed.");
        testReporter.log(LogStatus.PASS, "Receiver info page is displayed.");
        receiverInfoPage.clickOnEventDropList();
        receiverInfoPage.clickOnEndOfTheYearGifts();
        receiverInfoPage.clickOnContinueButton();
        Assert.assertTrue(receiverInfoPage.isNameErrorMessageDisplayed());
        logger.info("Name error message is displayed!");
        testReporter.log(LogStatus.PASS, "Name error message is displayed!");
        Assert.assertTrue(receiverInfoPage.isBlessingMessageDisplayed());
        logger.info("Blessing is displayed!");
        testReporter.log(LogStatus.PASS, "Blessing is displayed!");
        Utils.takeSnapShot(driver, "ReceiverInfoMessagesTestSuccess");
        testReporter.log(LogStatus.INFO, "Check Screenshot below:" + testReporter.addScreenCapture(dest));
        logger.info("Receiver info messages test passed successfully!");
    }


}
