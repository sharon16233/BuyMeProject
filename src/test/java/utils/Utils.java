package utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Utils {

    protected static WebDriver driver;
    protected static ExtentReports extent;
    protected static ExtentTest testReporter;
    protected static String dest;


    @BeforeAll
    public static void setup() throws IOException {
        PropertyConfigurator.configure(System.getProperty("user.dir") + "/log4j.properties");
        extent = new ExtentReports(System.getProperty("user.dir") + "/Report/Report.html");
        driver = Browser.getDriver(getProperty("browser"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static boolean FileExists(String path) {
        File tmpdir = new File(path);
        return tmpdir.exists();
    }

    public static String getProperty(String key) throws IOException {
        Properties prop = new Properties();
        InputStream input = new FileInputStream(System.getProperty("user.dir") + "\\resources\\" + "Settings.properties");
        prop.load(input);

        return prop.get(key).toString();
    }

    public static void takeSnapShot(WebDriver driver, String fileName) throws Exception {

        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy").format(new Date());
        dest = System.getProperty("user.dir") + "\\images\\" + "\\" + fileName + "\\" + timestamp + ".jpg";
        File DestFile = new File(dest);
        FileUtils.copyFile(SrcFile, DestFile);
    }

    public static ExtentTest getTestReporter() {
        return testReporter;
    }

    public static String getDest() {
        return dest;
    }

    @After
    public void endTest() {
        extent.endTest(testReporter);
    }


    @AfterAll
    public static void finish() {
        driver.quit();
        extent.flush();
    }

}
