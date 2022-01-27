package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WishListPage;

public class WishlistPageLayoutValidation extends BaseTests {

    private static final String URL = "https://www.asos.com/saved-lists";
    private static final String TITLE = "Saved Items | ASOS";
    private static final String SEARCH_ID1 = "1677488";
    private static final String SEARCH_ID2 = "1957420";

    @Test
    public void wishListUrlTitleValidation(){
        getHomePage().openWishList();
        Assert.assertTrue(getDriver().getCurrentUrl().contains(URL));
        Assert.assertEquals(getDriver().getTitle(),TITLE);
    }

    @Test
    public void emptyWishListLayoutValidation(){
        getHomePage().openWishList();
        getWishListPage().waitForElementDisplayed(15,getWishListPage().getNoSavedItemsText());
        Assert.assertTrue(getWishListPage().getNoSavedItemsText().isDisplayed());
        Assert.assertEquals(getWishListPage().getNoSavedItemsText().getText(),"You have no Saved Items");
        Assert.assertTrue(getWishListPage().getSignInButton().isDisplayed());
    }

    @Test
    public void addedProductWishListLayoutValidation(){
        getHomePage().searchByKeyword(SEARCH_ID1);
        getSearchResultsPage().waitForPageLoading(15);
        getSearchResultsPage().waitForElementClickable(15,getSearchResultsPage().getAddToWishListButton());
        getSearchResultsPage().clickByJavaScript(getSearchResultsPage().getAddToWishListButton());

        getHomePage().openWishList();
        getWishListPage().waitForElementDisplayed(15,getWishListPage().getHeaderIfNotEmpty());
        Assert.assertTrue(getWishListPage().getHeaderIfNotEmpty().isDisplayed());
        Assert.assertFalse(getWishListPage().checkVisibilityofElement(getWishListPage().getNoSavedItemsText()));
        Assert.assertEquals(getWishListPage().getHeaderIfNotEmpty().getText(),"Saved Items");
        Assert.assertTrue(getWishListPage().getSortDropdown().isDisplayed());
        Assert.assertEquals(getWishListPage().getWishlistActualProductsQuantity(),1);
        Assert.assertEquals(getWishListPage().getWishlistActualProductsQuantity(),getWishListPage().getWishlistDeclaredProductsQuantity());
        Assert.assertEquals(getWishListPage().titleTextbyIndex(1),"Nike Running Juniper Trail trainers in black");

        //deleting
        getWishListPage().waitForElementClickable(15,getWishListPage().getDeleteButton());
        getWishListPage().getDeleteButton().click();
        getWishListPage().waitForElementDisplayed(15,getWishListPage().getNoSavedItemsText());
        Assert.assertTrue(getWishListPage().getNoSavedItemsText().isDisplayed());

    }


    @Test
    public void addedProductsWishListLayoutValidation(){
        getHomePage().searchByKeyword(SEARCH_ID1);
        getSearchResultsPage().waitForPageLoading(15);
        getSearchResultsPage().waitForElementClickable(15,getSearchResultsPage().getAddToWishListButton());
        getSearchResultsPage().clickByJavaScript(getSearchResultsPage().getAddToWishListButton());

        getHomePage().searchByKeyword(SEARCH_ID2);
        getSearchResultsPage().waitForPageLoading(15);
        getSearchResultsPage().waitForElementClickable(15,getSearchResultsPage().getAddToWishListButton());
        getSearchResultsPage().clickByJavaScript(getSearchResultsPage().getAddToWishListButton());

        getHomePage().openWishList();
        getWishListPage().waitForElementDisplayed(15,getWishListPage().getHeaderIfNotEmpty());
        Assert.assertTrue(getWishListPage().getHeaderIfNotEmpty().isDisplayed());
        Assert.assertFalse(getWishListPage().checkVisibilityofElement(getWishListPage().getNoSavedItemsText()));
        Assert.assertEquals(getWishListPage().getHeaderIfNotEmpty().getText(),"Saved Items");
        Assert.assertTrue(getWishListPage().getSortDropdown().isDisplayed());
        Assert.assertEquals(getWishListPage().getWishlistActualProductsQuantity(),2);
        Assert.assertEquals(getWishListPage().getWishlistActualProductsQuantity(),getWishListPage().getWishlistDeclaredProductsQuantity());
        Assert.assertEquals(getWishListPage().titleTextbyIndex(1),"Nike Air Max 2021 trainers in blue/grey");
        Assert.assertEquals(getWishListPage().titleTextbyIndex(2),"Nike Running Juniper Trail trainers in black");

        //deleting first
        getWishListPage().waitForElementClickable(15,getWishListPage().getDeleteButton());
        getWishListPage().getDeleteButton().click();

        getWishListPage().waitForElementTextToBe(15,getWishListPage().getQuantityText(),"1 item");
        Assert.assertEquals(getWishListPage().getWishlistActualProductsQuantity(),1);
        Assert.assertEquals(getWishListPage().getWishlistActualProductsQuantity(),getWishListPage().getWishlistDeclaredProductsQuantity());

        //deleting second
        getWishListPage().waitForElementClickable(15,getWishListPage().getDeleteButton());
        getWishListPage().getDeleteButton().click();
        getWishListPage().waitForElementDisplayed(15,getWishListPage().getNoSavedItemsText());
        Assert.assertTrue(getWishListPage().getNoSavedItemsText().isDisplayed());
    }

    @Test
    public void movingFromWishlistToShoppingBagValidation(){
        getHomePage().searchByKeyword(SEARCH_ID1);
        getSearchResultsPage().waitForPageLoading(15);
        getSearchResultsPage().waitForElementClickable(15,getSearchResultsPage().getAddToWishListButton());
        getSearchResultsPage().clickByJavaScript(getSearchResultsPage().getAddToWishListButton());

        getHomePage().openWishList();
        getWishListPage().waitForElementDisplayed(15,getWishListPage().getHeaderIfNotEmpty());
        Assert.assertEquals(getWishListPage().getWishlistActualProductsQuantity(),1);
        Assert.assertEquals(getWishListPage().getWishlistActualProductsQuantity(),getWishListPage().getWishlistDeclaredProductsQuantity());
        Assert.assertEquals(getWishListPage().titleTextbyIndex(1),"Nike Running Juniper Trail trainers in black");

        getWishListPage().waitForElementClickable(15,getWishListPage().getSizeDropdown());
        getWishListPage().selectDropdownOption(getWishListPage().getSizeDropdown(),"200979638");
        getWishListPage().waitForElementClickable(15,getWishListPage().getMoveToBagButton());
        getWishListPage().getMoveToBagButton().click();

        getWishListPage().waitForElementDisplayed(15,getWishListPage().getNoSavedItemsText());
        Assert.assertTrue(getWishListPage().getNoSavedItemsText().isDisplayed());
        Assert.assertEquals(getWishListPage().getNoSavedItemsText().getText(),"You have no Saved Items");
        Assert.assertTrue(getWishListPage().getSignInButton().isDisplayed());
    }


}
