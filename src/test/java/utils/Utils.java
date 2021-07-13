package utils;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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

    @BeforeAll
    public static void setup() throws IOException {
        PropertyConfigurator.configure(System.getProperty("user.dir") + "/log4j.properties");
        driver = Browser.getDriver(getProperty("browser"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static boolean FileExists(String path) {
        File tmpdir = new File(path);
        return tmpdir.exists();
    }

    public static String getProperty(String key) throws IOException {
        Properties prop = new Properties();
        InputStream input = new FileInputStream(System.getProperty("user.dir") +"\\resources\\"+"Settings.properties");
        prop.load(input);

        return prop.get(key).toString();
    }
    public static void takeSnapShot(WebDriver driver, String fileName) throws Exception{

        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy").format(new Date());
        File DestFile= new File(System.getProperty("user.dir") +"\\images\\" + "\\" + fileName + "\\" + timestamp + ".jpg");
        FileUtils.copyFile(SrcFile, DestFile);
    }

    @AfterAll
    public static void finish() {
        driver.quit();
    }

}
