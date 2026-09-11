package pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

    WebDriver driver;
    WebDriverWait wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Add to Cart Button
    @FindBy(id = "add-to-cart-button")
    WebElement addToCartButton;

    @FindBy(xpath="//*[@id=\"attachSiNoCoverage\"]/span/input")
    WebElement noCoverageButton;

    // Switch to Product Window
    public void switchToProductWindow() {

        String parentWindow = driver.getWindowHandle();

        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows) {

            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        // Wait until Add to Cart button is visible
        wait.until(ExpectedConditions.visibilityOf(addToCartButton));
    }

    // Click Add to Cart
    public void clickAddToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();
    }

        public void clickNoCoverage() {
            wait.until(ExpectedConditions.elementToBeClickable(noCoverageButton));
            noCoverageButton.click();
        }
    
    
}