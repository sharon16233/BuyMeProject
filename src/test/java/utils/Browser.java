package utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class Browser {

    public static WebDriver driver = null;
    private static final Logger logger = LogManager.getLogger(Browser.class);


    public static WebDriver getDriver(String browser) throws IOException {

        if (browser.equals("chrome")) {
            System.setProperty(Utils.getProperty("WEB_DRIVER"), Utils.getProperty("CHROME_DRIVER_LOCATION"));
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            //options.addArguments("--headless");
            driver = new ChromeDriver(options);
        }
        else {
            logger.error("Couldn't initialize web driver, only Chrome is an available browser");
        }
        return driver;
    }

}
