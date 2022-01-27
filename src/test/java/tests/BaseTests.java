package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTests {

   // private static WebDriver driver;

//    @BeforeClass
//    public static void profileSetup() {
//        chromedriver().setup();
//    }
//
//    @Before
//    public void testsSetup() {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://www.asos.com/");
//    }
//
//    @After
//    public void tearDownTest() {
//        driver.quit();
//    }
//
//    @AfterClass
//    public static void tearDownSuite() {
//        driver.quit();
//    }

    private WebDriver driver;

    @BeforeTest
    public void profileSetup() {
        chromedriver().setup();
    }

    @BeforeMethod
    public void testsSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.asos.com/");
        getHomePage().waitForPageLoading(15);
    }

    @AfterMethod
    public void tearDownTest() {
        driver.quit();
    }

    @AfterTest
    public void tearDownSuite() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    //pages creation

    public HomePage getHomePage(){return new HomePage(getDriver());}

    public SearchResultsPage getSearchResultsPage(){return new SearchResultsPage(getDriver());}

    public SignInPage getSignInPage(){return new SignInPage(getDriver());}

    public SignUpPage getSignUpPage(){return new SignUpPage(getDriver());}

    public ForgotPasswordPage getForgotPasswordPage(){return new ForgotPasswordPage(getDriver());}

    public ShoppingBagPage getShoppingBagPage(){return new ShoppingBagPage(getDriver());}

    public WishListPage getWishListPage(){return new WishListPage(getDriver());}






}
