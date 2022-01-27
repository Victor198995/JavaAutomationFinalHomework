package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    //constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //elements
    @FindBy(xpath = "//input[@id='chrome-search']")
    private WebElement searchInput;

    @FindBy(xpath = "//button[@data-testid='search-button-inline']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@data-testid='asoslogo']")
    private WebElement homePageLink;

    @FindBy(xpath = "//a[@id='women-floor']")
    private WebElement womanLink;

    @FindBy(xpath = "//a[@id='men-floor']")
    private WebElement manLink;

    @FindBy(xpath = "//button[@data-testid='myAccountIcon']")
    private WebElement accountLink;

    @FindBy(xpath = "//div[@id='myaccount-dropdown']")
    private WebElement accountDropdown;

        @FindBy(xpath = "//a[@data-testid='signin-link']")
        private WebElement signInLink;

        @FindBy(xpath = "//a[@data-testid='signup-link']")
        private WebElement signUpLink;

    @FindBy(xpath = "//button[@data-testid='myaccount-close-btn']")
    private WebElement closeWindowCross;

    @FindBy(xpath = "//a[@data-testid='savedItemsIcon']")
    private WebElement wishListLink;

    @FindBy(xpath = "//a[@data-testid='miniBagIcon']")
    private WebElement shoppingBagLink;

    @FindBy(xpath = "//div[@id='minibag-dropdown']")
    private WebElement shoppingBagPopup;

        @FindBy(xpath = "//a[@data-test-id='bag-link']")
        private WebElement viewBagButton;

        @FindBy(xpath = "//a[@data-test-id='checkout-link']")
        private WebElement checkoutButton;

        @FindBy(xpath = "//button[@data-testid='minibag-close-btn']")
        private WebElement closePopUpCross;

        @FindBy(xpath = "//div[@data-test-id='miniBagSubTotal']")
        private WebElement priceValueElement;
       //getters


    public WebElement getShoppingBagPopup() {
        return shoppingBagPopup;
    }

    public WebElement getViewBagButton() {
        return viewBagButton;
    }

    public WebElement getCheckoutButton() {
        return checkoutButton;
    }

    public WebElement getClosePopUpCross() {
        return closePopUpCross;
    }

    //methods
    public void searchByKeyword(String keyword){
        searchInput.sendKeys(keyword);
        searchButton.click();
    }

    public void openSignInPage(){
        accountLink.click();
        waitForElementDisplayed(15,accountDropdown);
        waitForElementClickable(15,signInLink);
        signInLink.click();
    }

    public void openSignUpPage(){
        accountLink.click();
        waitForElementDisplayed(15,accountDropdown);
        waitForElementClickable(15,signUpLink);
        signUpLink.click();
    }

    public void openWishList(){
        wishListLink.click();
        waitForPageLoading(15);
    }

    public void openSB(){
        shoppingBagLink.click();
        waitForPageLoading(15);
    }

}
