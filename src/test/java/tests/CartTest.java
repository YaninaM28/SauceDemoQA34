package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CartTest extends BaseTest {

    @Test(
            testName = "Проверка корзины",
            description = "Проверка товара, который был добавлен в корзину",
            groups = "smoke"
    )
    @Owner("Savich Yanina")
    @Epic("Sauce Demo 1")
    @Feature("Cart")
    @Story("Add to cart")
    @Description("Проверка корзины после добавления товара")
    @Severity(SeverityLevel.CRITICAL)
    @Flaky
    @Link(name = "Аналитика", url = "https://www.saucedemo.com/")
    @TmsLink("SD-T02")
    @Issue("BUG-02")
    public void checkCart() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        String expectedProduct = "Sauce Labs Backpack";
        String expectedPrice = "$29.99";
        //add product
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        String actualProduct = cartPage.getProductName();
        String actualPrice = cartPage.getProductPrice();
        softAssert.assertEquals(
                actualProduct,
                expectedProduct,
                "Название товара не совпадает");
        softAssert.assertEquals(
                actualPrice,
                expectedPrice,
                "Цена товара не совпадает");
        softAssert.assertAll();
    }
}
