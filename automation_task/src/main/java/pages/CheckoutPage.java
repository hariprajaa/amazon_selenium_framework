package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Scan and Pay with UPI
    @FindBy(xpath = "//span[contains(text(),'Scan and Pay with')]/ancestor::div[contains(@class,'a-fixed-left-grid')]//input[@type='radio']")
    WebElement upiOption;

    // Use this payment method Button
    @FindBy(css = "input[data-testid='bottom-continue-button']")
    WebElement usePaymentMethodButton;

    // Pay with UPI Button
    @FindBy(xpath = "//input[@value='Pay with UPI']")
    WebElement continueWithUPI;

//    @FindBy(xpath = "//a[span[normalize-space()='No Thanks']]")
//    WebElement noThanksButton;

    // Select UPI
    public void selectUPI() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOf(upiOption));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", upiOption);

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", upiOption);
                Thread.sleep(15000);
    
        }

    // Click "Use this payment method"
    public void clickUsePaymentMethod() throws InterruptedException {

        WebElement button = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("input[data-testid='bottom-continue-button']")));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", button);

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", button);
                Thread.sleep(5000);
    }

    // Click "Pay with UPI"
    public void clickupipayment() {

        wait.until(ExpectedConditions.visibilityOf(continueWithUPI));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", continueWithUPI);

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", continueWithUPI);
    }

    
public void dismissPopup() {

    wait.until(ExpectedConditions.alertIsPresent());

    Alert alert = driver.switchTo().alert();
    alert.dismiss();
}

// public void clickPayWithUPI() {
//     // TODO Auto-generated method stub
//     throw new UnsupportedOperationException("Unimplemented method 'clickPayWithUPI'");
// }
}
