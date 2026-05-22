package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RemoveFromCartTest extends BaseTest {

    @Test(
            testName = "Проверка удаления товара из корзины",
            description = "Товар из корзины удаляется",
            groups = "regression"
    )
    @Epic("Sauce Demo 1")
    @Feature("Cart")
    @Story("Removing product from cart")
    @Description("Проверка удаления товара из корзины")
    @Severity(SeverityLevel.NORMAL)
    @Link(name = "Аналитика", url = "https://www.saucedemo.com/")
    @TmsLink("SD-T01")
    public void checkRemoveProductFromCart() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        //add product
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        softAssert.assertTrue(
                cartPage.isProductDisplayedInCart(),
                "Нет продукта в корзине!"
        );
        cartPage.clickRemoveButton();
        softAssert.assertFalse(
                cartPage.isProductDisplayedInCart(),
                "Продукт не был удален"
        );
        softAssert.assertAll();
    }
}
