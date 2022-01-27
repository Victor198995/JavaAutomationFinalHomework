package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpPageValidation extends BaseTests {


    private static final String URL = "https://my.asos.com/identity/register";
    private static final String TITLE = "ASOS | Join ASOS";


    @Test
    public void signInUrlTitleValidation(){
        getHomePage().openSignUpPage();
        Assert.assertTrue(getDriver().getCurrentUrl().contains(URL));
        Assert.assertEquals(getDriver().getTitle(),TITLE);
    }

    @Test
    public void signUpLayoutValidation(){
        getHomePage().openSignUpPage();
        getSignUpPage().waitForPageLoading(15);

        Assert.assertTrue(getSignUpPage().getSignInLink().isDisplayed());
        Assert.assertTrue(getSignUpPage().getHeaderText().isDisplayed());
        Assert.assertEquals(getSignUpPage().getHeaderText().getText(),"OR SIGN UP WITH EMAIL");
        Assert.assertTrue(getSignUpPage().getEmailInput().isDisplayed());
        Assert.assertTrue(getSignUpPage().getFirstNameInput().isDisplayed());
        Assert.assertTrue(getSignUpPage().getLastNameInput().isDisplayed());
        Assert.assertTrue(getSignUpPage().getPasswordInput().isDisplayed());
        Assert.assertTrue(getSignUpPage().getSubmitButton().isDisplayed());
    }

    @Test
    public void signUpErrorMessagesValidation(){
        getHomePage().openSignUpPage();
        getSignUpPage().waitForPageLoading(15);
        getSignUpPage().waitForElementClickable(15,getSignUpPage().getSubmitButton());
        getSignUpPage().getSubmitButton().click();

        Assert.assertTrue(getSignUpPage().getEmailErrormessage().isDisplayed());
        Assert.assertEquals(getSignUpPage().getEmailErrormessage().getText(),"Oops! You need to type your email here");

        Assert.assertTrue(getSignUpPage().getFirstnameErrormessage().isDisplayed());
        Assert.assertEquals(getSignUpPage().getFirstnameErrormessage().getText(),"We need your first name – it’s nicer that way");

        Assert.assertTrue(getSignUpPage().getLastnameErrormessage().isDisplayed());
        Assert.assertEquals(getSignUpPage().getLastnameErrormessage().getText(),"Last name, too, please!");

        Assert.assertTrue(getSignUpPage().getPasswordErrormessage().isDisplayed());
        Assert.assertEquals(getSignUpPage().getPasswordErrormessage().getText(),"Hey, we need a password here");

        Assert.assertTrue(getSignUpPage().getFulldateErrormessage().isDisplayed());
        Assert.assertEquals(getSignUpPage().getFulldateErrormessage().getText(),"Enter your full date of birth");
    }

}
