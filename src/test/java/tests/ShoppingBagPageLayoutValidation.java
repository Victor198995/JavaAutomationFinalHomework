package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingBagPageLayoutValidation extends BaseTests {

    private static final String URL = "https://www.asos.com/bag";
    private static final String TITLE = "Shopping Bag | ASOS";

    @Test
    public void shoppingBagUrlTitleValidation(){
        getHomePage().openSB();
        Assert.assertTrue(getDriver().getCurrentUrl().contains(URL));
        Assert.assertEquals(getDriver().getTitle(),TITLE);
    }

    @Test
    public void shoppingBagLayoutEmpty(){
        getHomePage().openSB();
        getShoppingBagPage().waitForElementDisplayed(15,getShoppingBagPage().getEmptyBagText());
        Assert.assertTrue(getShoppingBagPage().getEmptyBagText().isDisplayed());
        Assert.assertEquals(getShoppingBagPage().getEmptyBagText().getText(),"Your bag is empty");
        Assert.assertTrue(getShoppingBagPage().getSignInButton().isDisplayed());
    }

}
