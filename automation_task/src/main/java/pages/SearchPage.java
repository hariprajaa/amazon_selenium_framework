package pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

    WebDriver driver;
    WebDriverWait wait;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Search Text Box
    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBox;

    // Search Button
    @FindBy(id = "nav-search-submit-button")
    WebElement searchButton;

    // Brand Filter (Replace with actual locator)
    @FindBy(xpath = "//span[contains(normalize-space(), 'Casio')]/ancestor::a[1]")
    WebElement brandFilter;

    // Price Filter (Replace with actual locator)
    // @FindBy(xpath = "Price Filter XPath")
    // WebElement priceFilter;

    // First Product from Search Results
    @FindBy(xpath = "//img[contains(@alt,'Casio')]")
    WebElement firstProduct;

    // Search Product
    public void searchProduct(String product) {
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.clear();
        searchBox.sendKeys(product);
        searchBox.sendKeys(Keys.ENTER);
    }

    // OR Search using Search Button
    public void searchUsingButton(String product) {
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.clear();
        searchBox.sendKeys(product);

        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
    }

    // Apply Brand Filter
    public void applyBrandFilter() {
        wait.until(ExpectedConditions.elementToBeClickable(brandFilter));
        brandFilter.click();
    }

    // Apply Price Filter
    // public void applyPriceFilter() {
    //     wait.until(ExpectedConditions.elementToBeClickable(priceFilter));
    //     priceFilter.click();
    // }

    // Verify Product List Updated
    public boolean verifyFilteredResults() {
        wait.until(ExpectedConditions.visibilityOf(firstProduct));
        return firstProduct.isDisplayed();
    }

    // Click First Product
    public void clickFirstProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(firstProduct));
        firstProduct.click();
    }

}
