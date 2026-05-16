package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By INVENTORYITEMNAME = By.className("inventory_item_name");
    private final By INVENTORYITEMPRICE = By.className("inventory_item_price");
    private final By CHECKOUTBUTTON = By.id("checkout");
    private final By REMOVEBUTTON = By.id("remove-sauce-labs-backpack");
    private final By TITLE_CART = By.cssSelector("[data-test = title]");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return driver.findElement(INVENTORYITEMNAME).getText();
    }

    public String getProductPrice() {
        return driver.findElement(INVENTORYITEMPRICE).getText();
    }

    public void clickCheckout() {
        driver.findElement(CHECKOUTBUTTON).click();
    }

    public void clickRemoveButton() {
        driver.findElement(REMOVEBUTTON).click();
    }

    public boolean isProductDisplayedInCart() {
        return driver.findElements(INVENTORYITEMNAME).size() > 0;
    }

    public String getCartTitle() {
        return driver.findElement(TITLE_CART).getText();
    }
}
