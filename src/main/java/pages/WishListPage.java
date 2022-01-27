package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WishListPage extends BasePage{

    //constructor
    public WishListPage(WebDriver driver) {
        super(driver);
    }

    //elements
    @FindBy(xpath = "//h2[contains(@class,'noItemsTitle')]")
    private WebElement noSavedItemsText;

    @FindBy(xpath = "//button[text()='Sign in']")
    private WebElement signInButton;



    @FindBy(xpath = "//select[@id='sortBy']")
    private WebElement sortDropdown;

    @FindBy(xpath = "//div[contains(@class,'itemCount')]") //first symbol needs to be taken
    private WebElement quantityText;

    @FindBy(xpath = "//h1[contains(@class,'header')]")//Saved Items
    private WebElement headerIfNotEmpty;

    @FindBy(xpath = "//div[contains(@class,'productImageWrapper')]")
    private List<WebElement> productImageList;

    @FindBy(xpath = "//div[contains(@class,'title')]//p")
    private WebElement productTitleText;

    @FindBy(xpath = "//button[@aria-label='Delete']")
    private WebElement deleteButton;

    @FindBy(xpath = "//select[@aria-label='Size']")
    private WebElement sizeDropdown;

    @FindBy(xpath = "//button[text()='Move to bag']")
    private WebElement moveToBagButton;

    //getters

    public WebElement getNoSavedItemsText() {
        return noSavedItemsText;
    }

    public WebElement getSignInButton() {
        return signInButton;
    }

    public WebElement getSortDropdown() {
        return sortDropdown;
    }

    public WebElement getHeaderIfNotEmpty() {
        return headerIfNotEmpty;
    }

    public WebElement getDeleteButton() {
        return deleteButton;
    }

    public WebElement getMoveToBagButton() {
        return moveToBagButton;
    }

    public WebElement getQuantityText() {
        return quantityText;
    }

    public WebElement getSizeDropdown() {
        return sizeDropdown;
    }

    //methods
    public List<WebElement> getWishlistProducts(){return productImageList;}

    public int getWishlistActualProductsQuantity(){return productImageList.size();}

    public int getWishlistDeclaredProductsQuantity(){return Character.getNumericValue(quantityText.getText().charAt(0));}

    public String titleTextbyIndex(int number){
        String xpath = "(//div[contains(@class,'title')]//p)["+number+"]";
        return driver.findElement(By.xpath(xpath)).getText();}
}
