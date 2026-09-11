    package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckoutPage;
import pages.LandingPage;
import pages.LoginPage;
import pages.ProductPage;
import pages.SearchPage;

public class AmazonEndToEndTest {
        WebDriver driver;

        @BeforeClass
        public void setUp() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.amazon.in");

        }

        @Test //testng 

        public void amazonPurchaseFlow() throws InterruptedException {

            // Landing Page
            LandingPage landing = new LandingPage(driver);
            landing.clickSignIn();

            // Login Page
            LoginPage login = new LoginPage(driver);
            login.enterEmail("9842619691");
            login.clickContinue();
            login.enterPassword("hariprajaa@13");
            login.clickSignIn();
        
        SearchPage search = new SearchPage(driver);
        search.searchProduct("watches");
        search.applyBrandFilter();
        search.verifyFilteredResults();
        search.clickFirstProduct();

        // Product Page
        ProductPage product = new ProductPage(driver);
        product.switchToProductWindow();
        product.clickAddToCart();
        //product.clickNoCoverage();

        // Cart Page
        CartPage cart = new CartPage(driver);
        //cart.increaseQuantity();
        cart.clickProceedToBuy();

        // Checkout Page
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.selectUPI();
        checkout.clickUsePaymentMethod();
        //checkout.clickPayWithUPI();

        }

        @AfterClass //testng 
        public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

        }
}

