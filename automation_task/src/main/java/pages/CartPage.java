package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // // Quantity Dropdown
    // @FindBy(id = "quantity")
    // WebElement quantityDropdown;

    // Proceed to Buy Button
  @FindBy(xpath = "//input[@name='proceedToRetailCheckout']")
    WebElement proceedToBuyButton;

    // Increase Quantity
    // public void increaseQuantity() {
    //     wait.until(ExpectedConditions.visibilityOf(quantityDropdown));
    //     Select quantity = new Select(quantityDropdown);
    //     quantity.selectByVisibleText("2");
    // }

    // Click Proceed to Buy
    public void clickProceedToBuy() {
        wait.until(ExpectedConditions.elementToBeClickable(proceedToBuyButton));
        proceedToBuyButton.click();
    }

    
}