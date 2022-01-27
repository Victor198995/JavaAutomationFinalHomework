package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {

    //constructor
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    //elements
    @FindBy(xpath = "//h2[contains(text(),'NOTHING MATCHES YOUR SEARCH')]")
    private WebElement noResultsText;

    @FindBy(xpath = "//a[@data-analytics-id='row-women-mulink']")
    private WebElement womanCathegoryLink;

    @FindBy(xpath = "//a[@data-analytics-id='row-men-mulink']")
    private WebElement manCathegoryLink;

    @FindBy(xpath = "//a[@data-analytics-id='row-faceandbody-mulink']")
    private WebElement faceBodyLink;

    //nike shoes products
    @FindBy(xpath = "//article[@data-auto-id='productTile']")
    private List<WebElement> searchResultsSection;

    @FindBy(xpath = "//div[@data-auto-id='productTileDescription']//h2")
    private List<WebElement> searchResultsDescription;


    //2016381
    @FindBy(xpath = "//div[@id='aside-content']//h1")
    private WebElement productName;


    @FindBy(xpath = "//button[@id='product-add-button']")
    private WebElement addToBagButton;

    @FindBy(xpath = "(//button[@aria-label='Save for later'])[1]")
    private WebElement addToWishListButton;

    @FindBy(xpath = "//div[@class='product-code']/p")
    private WebElement productID;

    @FindBy(xpath = "//span[@data-id='current-price']")
    private WebElement prricePDP;


    @FindBy(xpath = "//span[@id='selectSizeError']")
    private WebElement sizeError;
    //Please select from the available colour and size options

    @FindBy(xpath = "//select[@data-id='sizeSelect']")
    private WebElement sizeDropdown;

       //getters
    public WebElement getNoResultsText(){return noResultsText;}

    public WebElement getWomanCathegoryLink(){return womanCathegoryLink;}

    public WebElement getManCathegoryLink(){return manCathegoryLink;}

    public WebElement getFaceBodyLink(){return faceBodyLink;}

    public WebElement getProductName() {
        return productName;
    }

    public WebElement getAddToBagButton() {
        return addToBagButton;
    }

    public WebElement getAddToWishListButton() {
        return addToWishListButton;
    }

    public WebElement getProductID() {
        return productID;
    }

    public WebElement getSizeError() {
        return sizeError;
    }

    public WebElement getSizeDropdown() {
        return sizeDropdown;
    }

    public int getSearchResultsQuantity(){return searchResultsSection.size();}

    public List<WebElement> getSearchResultsList(){return searchResultsSection;}
    public List<WebElement> getSearchResultsDescriptionList(){return searchResultsDescription;}


   // public WebElement getTitleText() {   return titleText;    }

    //methods

}
