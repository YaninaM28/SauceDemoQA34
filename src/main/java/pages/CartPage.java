package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    private final By INVENTORYITEMNAME = By.className("inventory_item_name");
    private final By INVENTORYITEMPRICE = By.className("inventory_item_price");
    private final By CHECKOUTBUTTON = By.id("checkout");
    private final By REMOVEBUTTON = By.id("remove-sauce-labs-backpack");
    private final By TITLE_CART = By.cssSelector("[data-test = title]");

    public CartPage(WebDriver driver) {
        super(driver);
    }
    @Step("Название товара")
    public String getProductName() {
        return driver.findElement(INVENTORYITEMNAME).getText();
    }

    @Step("Цена товара")
    public String getProductPrice() {
        return driver.findElement(INVENTORYITEMPRICE).getText();
    }

    @Step("Открытие страницы для добавления данных пользователя для заказа")
    public CheckoutPage clickCheckout() {
        driver.findElement(CHECKOUTBUTTON).click();
        return new CheckoutPage(driver);
    }

    @Step("Удалить товар из корзины")
    public CartPage clickRemoveButton() {
        driver.findElement(REMOVEBUTTON).click();
        return this;
    }

    @Step("Товар удален из корзины")
    public boolean isProductDisplayedInCart() {
        return driver.findElements(INVENTORYITEMNAME).size() > 0;
    }

    public String getCartTitle() {
        return driver.findElement(TITLE_CART).getText();
    }

    @Override
    public CartPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE_CART));
        return this;
    }
}
