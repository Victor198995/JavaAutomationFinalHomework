package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasePage{

    //constructor
    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[text()='Reset your password']")
    private WebElement titleText;

    @FindBy(xpath = "//input[@id='Email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@id='send']")
    private WebElement resetButton;

    @FindBy(xpath = "//span[@id='Email-error']")
    private WebElement errorMessage;//Oops! You need to type your email here

    //getters

    public WebElement getTitleText() {
        return titleText;
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getResetButton() {
        return resetButton;
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }


    //methods
}
