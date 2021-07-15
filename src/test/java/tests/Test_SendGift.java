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

public class Test_SendGift extends Utils {

    public static HomePage homePage;
    public static LoginPage loginPage;
    public static ChooseGiftPage chooseGiftPage;
    public static InsertGIftSumPage insertGIftSumPage;
    public static ReceiverInfoPage receiverInfoPage;
    public static SendingMethodPage sendingMethodPage;
    public static PaymentPage paymentPage;
    private static final Logger logger = LogManager.getLogger(Test_SendGift.class);

    @BeforeEach
    public void initPage() throws IOException {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        chooseGiftPage = new ChooseGiftPage(driver);
        insertGIftSumPage = new InsertGIftSumPage(driver);
        receiverInfoPage = new ReceiverInfoPage(driver);
        sendingMethodPage = new SendingMethodPage(driver);
        paymentPage = new PaymentPage(driver);
        driver.get(Utils.getProperty("baseUrl"));
    }

    /**
     * Given: User has entered into the home page of BuyMe.
     * When: User is searching for a gift to send.
     * Then: User sends the gift to a friend/family member.
     */

    @Test
    public void sendGift() throws Exception {
        //Reports Initiation
        testReporter = extent.startTest("Send gift");
        logger.info("Begin test 'Send a Gift' ...");

        //Login page actions
        homePage.clickOnEntranceButton();
        loginPage.isLoginPageDisplayed();
        logger.info("Login page is displayed.");
        testReporter.log(LogStatus.PASS, "Login page is displayed");
        loginPage.inputEmail(Utils.getProperty("validUsername"));
        loginPage.inputPassword(Utils.getProperty("validPassword"));
        loginPage.clickOnSubmitButton();
        Assert.assertTrue(homePage.isLoggedIn());
        logger.info("Login passed successfully.");
        logger.info("logged in as " + Utils.getProperty("validUsername"));
        testReporter.log(LogStatus.PASS, "Login passed successfully.");
        testReporter.log(LogStatus.PASS, "logged in as " + Utils.getProperty("validUsername"));

        //Home page - Search for gift.
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

        //Insert sum for the gift.
        Assert.assertTrue(insertGIftSumPage.isInsertGiftSumPageDisplayed());
        logger.info("Insert gift sum page is displayed.");
        testReporter.log(LogStatus.PASS, "Insert gift sum page is displayed.");
        insertGIftSumPage.inputGiftSum(Utils.getProperty("giftSum"));
        insertGIftSumPage.clickOnSubmitButton();

        //Insert gift's receiver data.
        Assert.assertTrue(receiverInfoPage.isReceiverInfoPageDisplayed());
        logger.info("Receiver info page is displayed.");
        testReporter.log(LogStatus.PASS, "Receiver info page is displayed.");
        receiverInfoPage.clickOnToSomeoneElse();
        receiverInfoPage.inputReceiverName(Utils.getProperty("receiverName"));
        receiverInfoPage.clickOnEventDropList();
        receiverInfoPage.clickOnEndOfTheYearGifts();
        receiverInfoPage.uploadPhoto(System.getProperty("user.dir") + Utils.getProperty("pathToPhoto"));
        receiverInfoPage.clickOnContinueButton();

        //Insert receiver's Name, mail.
        Assert.assertTrue(sendingMethodPage.isSendingMethodPageDisplayed());
        logger.info("Sending method page is displayed.");
        testReporter.log(LogStatus.PASS, "Sending method page is displayed.");
        sendingMethodPage.clickOnEmailButton();
        sendingMethodPage.inputGiftReceiverEmail(Utils.getProperty("validUsername"));
        sendingMethodPage.clickOnContinueToPaymentPageButton();

        //End of the test - check if the payment page is displayed.
        Assert.assertTrue(paymentPage.isPaymentPageDisplayed());
        Utils.takeSnapShot(driver, "SendGiftTestPassed");
        logger.info("Send Gift test passed successfully!");
        logger.info("Payment page is displayed.");
        testReporter.log(LogStatus.PASS, "Payment page is displayed.");
        testReporter.log(LogStatus.PASS, "Send Gift test passed successfully!");
        testReporter.log(LogStatus.INFO, "Check Screenshot below:"+testReporter.addScreenCapture(dest));
    }

}
