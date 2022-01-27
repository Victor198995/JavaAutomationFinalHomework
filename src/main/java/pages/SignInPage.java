package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{

    //constructor
    public SignInPage(WebDriver driver) {
        super(driver);
    }

    //elements
    @FindBy(xpath = "//div[@class='title qa-title with-link']")
    private WebElement signUpLink;

    @FindBy(xpath = "//input[@id='EmailAddress']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@id='Password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='signin']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@data-st-tagname='id-signIn-forgotPassword-click']")
    private WebElement forgotPasswordLink;

    @FindBy(xpath = "//span[@id='EmailAddress-error']")
    private WebElement emailErrorMessage;//Oops! You need to type your email here

    @FindBy(xpath = "//span[@id='Password-error']")
    private WebElement passwordErrorMessage;//Hey, we need a password here

    //getters

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public WebElement getSignInButton() {
        return signInButton;
    }

    public WebElement getForgotPasswordLink() {
        return forgotPasswordLink;
    }

    public WebElement getEmailErrorMessage() {
        return emailErrorMessage;
    }

    public WebElement getPasswordErrorMessage() {
        return passwordErrorMessage;
    }

    public WebElement getSignUpLink() {
        return signUpLink;
    }

    //methods


}
