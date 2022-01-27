package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

   WebDriver driver;

    //constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //waits:
    //implicit wait
    public void implicitWait(long time){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }

    //explicit waits
    public void waitForPageLoading(long timeToWait){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeToWait));
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void waitForElementDisplayed(long timeToWait, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeToWait));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementClickable(long timeToWait, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeToWait));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementNotDisplayed(long timeToWait, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeToWait));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitForUrlToBe(long timeToWait, String url){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeToWait));
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public void waitForTitleToBe(long timeToWait, String title){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeToWait));
        wait.until(ExpectedConditions.titleIs(title));
    }

    public void waitForElementTextToBe(long timeToWait, WebElement element,String text){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeToWait));
        wait.until(ExpectedConditions.textToBePresentInElement(element,text));
    }

    public void clickByJavaScript(WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();", element);
    }

    public void selectDropdownOption(WebElement dropdownElement,String option){
        Select select = new Select(dropdownElement);
        select.selectByValue(option);
    }

    public void waitForElementNotVisible(long timeToWait, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeToWait));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public boolean checkVisibilityofElement(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
