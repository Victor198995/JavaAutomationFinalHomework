package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingBagPage extends BasePage{

    //constructor
    public ShoppingBagPage(WebDriver driver) {
        super(driver);
    }

    //elements
    @FindBy(xpath = "//h2[@class='empty-bag-title']")
    private WebElement emptyBagText;

    @FindBy(xpath = "//p[@class='button-holder']")
    private WebElement signInButton;



    @FindBy(xpath = "//div[@class='bag-contents-holder-panel bag-title-holder']/h1")
    private WebElement mybagText;//MY BAG

    @FindBy(xpath = "//li[@class='bag-item-holder']")
    private List<WebElement> productContainer;//list


    @FindBy(xpath = "//button[@class='bag-item-remove']")
    private WebElement deleteProductCross;

    @FindBy(xpath = "(//p[@class='bag-total-button-holder']/a)[2]")
    private WebElement checkoutButton;



    @FindBy(xpath = "//span[contains(@class,'bag-item-price bag-item-price')]")
    private List<WebElement> priceValue;//list

    @FindBy(xpath = "//span[@class='bag-subtotal-price']")
    private WebElement subtotalPrice;//£204.40

    @FindBy(xpath = "(//span[@class='bag-total-price bag-total-price--subtotal'])[2]")
    private WebElement totalPrice;//£204.40

    @FindBy(xpath = "")
    private WebElement womanLink;

    //getters

    public WebElement getEmptyBagText() {
        return emptyBagText;
    }

    public WebElement getSignInButton() {
        return signInButton;
    }

    public WebElement getMybagText() {
        return mybagText;
    }

    public WebElement getDeleteProductCross() {
        return deleteProductCross;
    }

    public WebElement getCheckoutButton() {
        return checkoutButton;
    }

    public WebElement getSubtotalPrice() {
        return subtotalPrice;
    }

    //methods
    public int getProductsQuantity(){
        return productContainer.size();
    }

    public String getSummarizedPrice(){
        double value=0;
        for(int i=0;i<priceValue.size();i++){
           value=value+Double.parseDouble(priceValue.get(i).getText().substring(1));
        }
        return "£"+String.format("%.2f", value);
    }

}
