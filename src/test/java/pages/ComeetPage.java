package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ComeetPage extends BasePage {

    @FindBy(id = "companyLogo")
    WebElement buyMeLogo;

    @FindBy(css = "[class='positionLink']")
    List<WebElement> careers;


    public boolean isComeetPageDisplayed() throws Exception {
        return isElementDisplayed(buyMeLogo, "Buy me logo");
    }

    public int numOfCareers() {
        return careers.size();
    }

    public ComeetPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
