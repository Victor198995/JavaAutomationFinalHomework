package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SignUpPage;

public class SignInPageValidation extends BaseTests{

    private static final String EMAIL = "ukr@net";
    private static final String PASSWORD = "VK123VK456!";

    private static final String URL = "https://my.asos.com/identity/login?signin";
    private static final String TITLE = "ASOS | Sign in";


    @Test
    public void signInUrlTitleValidation(){
        getHomePage().openSignInPage();
        Assert.assertTrue(getDriver().getCurrentUrl().contains(URL));
        Assert.assertEquals(getDriver().getTitle(),TITLE);
    }

    @Test
    public void signInLayoutValidation(){
        getHomePage().openSignInPage();

        Assert.assertTrue(getSignInPage().getSignUpLink().isDisplayed());
        Assert.assertTrue(getSignInPage().getEmailInput().isDisplayed());
        Assert.assertTrue(getSignInPage().getEmailInput().isDisplayed());
        Assert.assertTrue(getSignInPage().getPasswordInput().isDisplayed());
        Assert.assertTrue(getSignInPage().getSignInButton().isDisplayed());
        Assert.assertTrue(getSignInPage().getForgotPasswordLink().isDisplayed());
    }

    @Test
    public void signInEmailPasswordErrorMessagesValidation(){
        getHomePage().openSignInPage();
        getSignInPage().waitForPageLoading(15);
        getSignInPage().waitForElementClickable(15,getSignInPage().getSignInButton());
        getSignInPage().getSignInButton().click();

        Assert.assertTrue(getSignInPage().getEmailErrorMessage().isDisplayed());
        Assert.assertTrue(getSignInPage().getPasswordErrorMessage().isDisplayed());
    }

    @Test
    public void signInPasswordErrorMessageValidation(){
        getHomePage().openSignInPage();
        getSignInPage().waitForPageLoading(15);
        getSignInPage().waitForElementClickable(15,getSignInPage().getSignInButton());
        getSignInPage().getEmailInput().sendKeys(EMAIL);
        getSignInPage().getSignInButton().click();

        Assert.assertTrue(getSignInPage().getPasswordErrorMessage().isDisplayed());
        Assert.assertFalse(getSignInPage().checkVisibilityofElement(getSignInPage().getEmailErrorMessage()));
        Assert.assertEquals(getSignInPage().getPasswordErrorMessage().getText(),"Hey, we need a password here");
    }

    @Test
    public void signInEmailErrorMessageValidation(){
        getHomePage().openSignInPage();
        getSignInPage().waitForPageLoading(15);
        getSignInPage().waitForElementClickable(15,getSignInPage().getSignInButton());
        getSignInPage().getPasswordInput().sendKeys(PASSWORD);
        getSignInPage().getSignInButton().click();

        Assert.assertTrue(getSignInPage().getEmailErrorMessage().isDisplayed());
        Assert.assertFalse(getSignInPage().checkVisibilityofElement(getSignInPage().getPasswordErrorMessage()));
        Assert.assertEquals(getSignInPage().getEmailErrorMessage().getText(),"Oops! You need to type your email here");
    }
}
