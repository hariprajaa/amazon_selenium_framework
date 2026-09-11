package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Email / Mobile Number Textbox
    @FindBy(xpath="//input[@name='email']")
    WebElement numbertextbox;

    // Continue Button
    @FindBy(xpath = "//input[@type='submit']")
    WebElement continueButton;

    // Password Textbox
    @FindBy(xpath="//input[@name='password']")
    WebElement passwordTextBox;

    // Sign In Button
    @FindBy(xpath="//*[@id='signInSubmit']")
    WebElement signInButton;

    // Enter Email or Mobile Number
    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(numbertextbox));
        numbertextbox.sendKeys(email);
    }

    // Click Continue
    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        continueButton.click();
    }

    // Enter Password
    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordTextBox));
        passwordTextBox.sendKeys(password);
    }

    // Click Sign In
    public void clickSignIn() {
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
    }
}
