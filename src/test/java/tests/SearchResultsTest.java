package tests;

//import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchResultsTest extends BaseTests {
    //constants
    private static final String NEGATIVE_SEARCH_KEYWORD = "!";
    private static final String EXPECTED_QUERY_NEGATIVE = "no-results-page";
    private static final String SEARCH_TITLE_NEGATIVE = "ASOS | Designer Clothes | Womens Clothing | Womens Fashion";

    private static final String SEARCH_KEYWORD = "Nike";

    private static final String PRODUCT_DESCRIPTION = "Nike Running Juniper Trail trainers in black";

    private static final String EXPECTED_QUERY = "q=nike";
    private static final String SEARCH_TITLE = "Search: "+SEARCH_KEYWORD.toLowerCase();
    private static final int EXPECTED_AMOUNT_OF_PROPUCTS=72;
    private static final String SEARCH_ID = "1677488";
    @Test
    public void invalidSearchKeywordUrlTitleValidation(){
        getHomePage().searchByKeyword(NEGATIVE_SEARCH_KEYWORD);
        getSearchResultsPage().waitForPageLoading(15);
        Assert.assertTrue(getDriver().getCurrentUrl().contains(EXPECTED_QUERY_NEGATIVE));
        Assert.assertEquals(getDriver().getTitle(),SEARCH_TITLE_NEGATIVE);
    }

    @Test
    public void invalidSearchKeywordResultPageLayoutValidation(){
        getHomePage().searchByKeyword(NEGATIVE_SEARCH_KEYWORD);
        getSearchResultsPage().waitForPageLoading(15);
        getSearchResultsPage().waitForElementDisplayed(15, getSearchResultsPage().getNoResultsText());
        Assert.assertTrue(getSearchResultsPage().getNoResultsText().isDisplayed());

        Assert.assertTrue(getSearchResultsPage().getManCathegoryLink().isDisplayed());
        Assert.assertTrue(getSearchResultsPage().getWomanCathegoryLink().isDisplayed());
        Assert.assertTrue(getSearchResultsPage().getFaceBodyLink().isDisplayed());
    }

    @Test
    public void validSearchKeywordUrlValidation(){
        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        getSearchResultsPage().waitForPageLoading(15);
        Assert.assertTrue(getDriver().getCurrentUrl().contains(EXPECTED_QUERY));
        Assert.assertTrue(getDriver().getTitle().contains(SEARCH_TITLE));
    }

    @Test
    public void validSearchPLPLayoutValidation(){
        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        getSearchResultsPage().waitForPageLoading(15);
        Assert.assertEquals(getSearchResultsPage().getSearchResultsQuantity(),EXPECTED_AMOUNT_OF_PROPUCTS);

        for(WebElement listElement : getSearchResultsPage().getSearchResultsList()){
            Assert.assertTrue(listElement.isDisplayed());
        }

        for(WebElement listElement : getSearchResultsPage().getSearchResultsDescriptionList()){
            Assert.assertTrue(listElement.getText().contains(SEARCH_KEYWORD));
        }
    }

    @Test
    public void validSearchPDPLayoutValidation(){
        getHomePage().searchByKeyword(SEARCH_ID);
        getSearchResultsPage().waitForPageLoading(15);

        Assert.assertTrue(getSearchResultsPage().getProductName().isDisplayed());
        Assert.assertEquals(getSearchResultsPage().getProductName().getText(),PRODUCT_DESCRIPTION);

        Assert.assertTrue(getSearchResultsPage().getAddToWishListButton().isDisplayed());
        Assert.assertTrue(getSearchResultsPage().getAddToBagButton().isDisplayed());
        Assert.assertTrue(getSearchResultsPage().getSizeDropdown().isDisplayed());

        Assert.assertTrue(getSearchResultsPage().getProductID().isDisplayed());
        Assert.assertEquals(getSearchResultsPage().getProductID().getText(),SEARCH_ID);


    }
}
