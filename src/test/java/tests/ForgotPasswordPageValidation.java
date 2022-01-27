package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPasswordPageValidation extends BaseTests {

    private static final String URL = "https://my.asos.com/identity/password/reset";
    private static final String TITLE = "ASOS | Forgotten Password";


    @Test
    public void forgotPasswordUrlTitleValidation(){
        getHomePage().openSignInPage();
        getSignInPage().waitForElementClickable(15,getSignInPage().getForgotPasswordLink());
        getSignInPage().getForgotPasswordLink().click();

        Assert.assertTrue(getDriver().getCurrentUrl().contains(URL));
        Assert.assertEquals(getDriver().getTitle(),TITLE);
    }

    @Test
    public void forgotPasswordLayoutValidation(){
        getHomePage().openSignInPage();
        getSignInPage().waitForElementClickable(15,getSignInPage().getForgotPasswordLink());
        getSignInPage().getForgotPasswordLink().click();
        getForgotPasswordPage().waitForPageLoading(15);

        Assert.assertTrue(getForgotPasswordPage().getTitleText().isDisplayed());
        Assert.assertTrue(getForgotPasswordPage().getEmailInput().isDisplayed());
        Assert.assertTrue(getForgotPasswordPage().getResetButton().isDisplayed());
    }

    @Test
    public void forgotPasswordErrormessageValidation(){
        getHomePage().openSignInPage();
        getSignInPage().waitForElementClickable(15,getSignInPage().getForgotPasswordLink());
        getSignInPage().getForgotPasswordLink().click();
        getForgotPasswordPage().waitForPageLoading(15);
        getForgotPasswordPage().waitForElementClickable(15,getForgotPasswordPage().getResetButton());
        getForgotPasswordPage().getResetButton().click();


        Assert.assertTrue(getForgotPasswordPage().getErrorMessage().isDisplayed());
        Assert.assertEquals(getForgotPasswordPage().getErrorMessage().getText(),"Oops! You need to type your email here");
    }

}
