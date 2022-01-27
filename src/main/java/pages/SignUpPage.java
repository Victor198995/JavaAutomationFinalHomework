package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage{

    //constructor
    public SignUpPage(WebDriver driver) {
        super(driver);
    }
    //elements

    @FindBy(xpath = "//div[@class='title qa-title with-link qa-sign-in']")
    private WebElement signInLink;

    @FindBy(xpath = "//div[@id='register-form']/h2")
    private WebElement headerText;//Or sign up with email

    @FindBy(xpath = "//input[@id='Email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@id='FirstName']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='LastName']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='LastName']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='register']")
    private WebElement submitButton;

    //errormessages
    @FindBy(xpath = "//span[@id='Email-error']")
    private WebElement emailErrormessage;//Oops! You need to type your email here

    @FindBy(xpath = "//span[@id='FirstName-error']")
    private WebElement firstnameErrormessage;//We need your first name – it’s nicer that way

    @FindBy(xpath = "//span[@id='LastName-error']")
    private WebElement lastnameErrormessage;//Last name, too, please!

    @FindBy(xpath = "//span[@id='Password-error']")
    private WebElement passwordErrormessage;//Hey, we need a password here

    @FindBy(xpath = "//span[@id='BirthYear-error']")
    private WebElement fulldateErrormessage;//Enter your full date of birth

    //getters

    public WebElement getSignInLink() {
        return signInLink;
    }

    public WebElement getHeaderText() {
        return headerText;
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getFirstNameInput() {
        return firstNameInput;
    }

    public WebElement getLastNameInput() {
        return lastNameInput;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getEmailErrormessage() {
        return emailErrormessage;
    }

    public WebElement getFirstnameErrormessage() {
        return firstnameErrormessage;
    }

    public WebElement getLastnameErrormessage() {
        return lastnameErrormessage;
    }

    public WebElement getPasswordErrormessage() {
        return passwordErrormessage;
    }

    public WebElement getFulldateErrormessage() {
        return fulldateErrormessage;
    }


    //methods

}
