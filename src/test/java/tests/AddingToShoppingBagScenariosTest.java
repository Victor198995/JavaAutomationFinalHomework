package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddingToShoppingBagScenariosTest extends BaseTests {

    private static final String SEARCH_ID1 = "1677488";
    //accesories without size
    private static final String SEARCH_ID2 = "108543650";
    private static final String SEARCH_ID3 = "103662520";

    @Test
    public void addingProductWithoutChoosingSize() {
        getHomePage().searchByKeyword(SEARCH_ID1);
        getSearchResultsPage().waitForPageLoading(15);
        getSearchResultsPage().waitForElementClickable(15, getSearchResultsPage().getAddToBagButton());
        // getSearchResultsPage().getAddToBagButton().click();
        getSearchResultsPage().clickByJavaScript(getSearchResultsPage().getAddToBagButton());
        Assert.assertTrue(getSearchResultsPage().getSizeError().isDisplayed());
        Assert.assertEquals(getSearchResultsPage().getSizeError().getText(), "Please select from the available colour and size options");
    }

    @Test
    public void adding2ProductsToSB() throws InterruptedException {
        getHomePage().searchByKeyword(SEARCH_ID2);
        getSearchResultsPage().waitForPageLoading(15);
        getSearchResultsPage().waitForElementClickable(15, getSearchResultsPage().getAddToBagButton());
        // getSearchResultsPage().getAddToBagButton().click();
        getSearchResultsPage().clickByJavaScript(getSearchResultsPage().getAddToBagButton());

        getSearchResultsPage().waitForElementDisplayed(15, getHomePage().getShoppingBagPopup());
        Assert.assertTrue(getHomePage().getShoppingBagPopup().isDisplayed());

        getSearchResultsPage().waitForElementClickable(15, getHomePage().getClosePopUpCross());
        getSearchResultsPage().clickByJavaScript(getHomePage().getClosePopUpCross());
        //getHomePage().getClosePopUpCross().click();
        getSearchResultsPage().waitForElementNotDisplayed(15,getHomePage().getShoppingBagPopup());
        Assert.assertFalse(getHomePage().getShoppingBagPopup().isDisplayed());

        //adding second product
        getHomePage().searchByKeyword(SEARCH_ID3);
        getSearchResultsPage().waitForPageLoading(15);
        getSearchResultsPage().waitForElementClickable(15, getSearchResultsPage().getAddToBagButton());
        // getSearchResultsPage().getAddToBagButton().click();
        getSearchResultsPage().clickByJavaScript(getSearchResultsPage().getAddToBagButton());

        getWishListPage().waitForElementDisplayed(15, getHomePage().getShoppingBagPopup());
        Assert.assertTrue(getHomePage().getShoppingBagPopup().isDisplayed());
        getWishListPage().waitForElementDisplayed(15, getHomePage().getViewBagButton());
        //openSBPage
        getWishListPage().clickByJavaScript(getHomePage().getViewBagButton());
        getWishListPage().waitForPageLoading(15);

        getShoppingBagPage().waitForElementDisplayed(25, getShoppingBagPage().getMybagText());
        Assert.assertTrue(getShoppingBagPage().getMybagText().isDisplayed());
        Assert.assertEquals(getShoppingBagPage().getMybagText().getText(), "MY BAG");
        Assert.assertTrue(getShoppingBagPage().getCheckoutButton().isDisplayed());
       // Thread.sleep(3000);
        Assert.assertEquals(getShoppingBagPage().getProductsQuantity(), 2);
        //necessary here
        Thread.sleep(3000);
        Assert.assertEquals(getShoppingBagPage().getSubtotalPrice().getText(), getShoppingBagPage().getSummarizedPrice());
    }

    @Test
    public void addingFromWishlistToSB() throws InterruptedException {
        getHomePage().searchByKeyword(SEARCH_ID1);
        getSearchResultsPage().waitForPageLoading(15);
        getSearchResultsPage().waitForElementClickable(15, getSearchResultsPage().getAddToWishListButton());
        getSearchResultsPage().clickByJavaScript(getSearchResultsPage().getAddToWishListButton());

        getHomePage().openWishList();
        getWishListPage().waitForElementDisplayed(15, getWishListPage().getHeaderIfNotEmpty());
        Assert.assertEquals(getWishListPage().getWishlistActualProductsQuantity(), 1);
        Assert.assertEquals(getWishListPage().getWishlistActualProductsQuantity(), getWishListPage().getWishlistDeclaredProductsQuantity());
        Assert.assertEquals(getWishListPage().titleTextbyIndex(1), "Nike Running Juniper Trail trainers in black");

        getWishListPage().waitForElementClickable(15, getWishListPage().getSizeDropdown());
        getWishListPage().selectDropdownOption(getWishListPage().getSizeDropdown(), "200979638");
        getWishListPage().waitForElementClickable(15, getWishListPage().getMoveToBagButton());
        getWishListPage().getMoveToBagButton().click();

        //Shopping bag
        getWishListPage().waitForElementDisplayed(15, getHomePage().getShoppingBagPopup());
        Assert.assertTrue(getHomePage().getShoppingBagPopup().isDisplayed());
        getWishListPage().waitForElementDisplayed(15, getHomePage().getViewBagButton());
        //openSBPage
        getWishListPage().clickByJavaScript(getHomePage().getViewBagButton());
        getWishListPage().waitForPageLoading(15);

        getShoppingBagPage().waitForElementDisplayed(25, getShoppingBagPage().getMybagText());
        Assert.assertTrue(getShoppingBagPage().getMybagText().isDisplayed());
        Assert.assertEquals(getShoppingBagPage().getMybagText().getText(), "MY BAG");
        Assert.assertTrue(getShoppingBagPage().getCheckoutButton().isDisplayed());

        Assert.assertEquals(getShoppingBagPage().getProductsQuantity(), 1);
        //necessary here
        Thread.sleep(3000);
        Assert.assertEquals(getShoppingBagPage().getSubtotalPrice().getText(), getShoppingBagPage().getSummarizedPrice());
    }
}
