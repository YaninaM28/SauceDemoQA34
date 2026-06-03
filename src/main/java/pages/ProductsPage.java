package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Log4j2
public class ProductsPage extends BasePage {

    private final By TITLE = By.cssSelector("[data-test = title]");
    private final By CART = By.cssSelector("[data-test = shopping-cart-link]");
    private final By MENU_BUTTON = By.id("react-burger-menu-btn");
    private final By LOGOUT = By.cssSelector("[data-test = logout-sidebar-link]");

    private final String ADD_TO_CART_PATTERN =
            "//*[text()='%s']//ancestor::div[@class='inventory_item']//button[text()='Add to cart']";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage open() {
        driver.get(BASE_URL + "/inventory.html");
        return this;
    }

    @Override
    public ProductsPage isPageOpened() {
        log.info("Opening Products page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
        return this;
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    @Step("Добавление в корзину товара с именем: '{product}'")
    public ProductsPage addToCart(String product) {
        log.info("Adding product '{}' to cart", product);
        driver.findElement(By.xpath(String.format(ADD_TO_CART_PATTERN, product))).click();
        return this;
    }

    @Step("Нажатие на кнопку корзина")
    public CartPage clickCart() {
        driver.findElement(CART).click();
        return new CartPage(driver);
    }

    @Step("Выход из системы")
    public LoginPage logout() {
        log.info("Logging out");
        driver.findElement(MENU_BUTTON).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(LOGOUT));
        driver.findElement(LOGOUT).click();
        return new LoginPage(driver);
    }
}
