package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RemoveFromCartTest extends BaseTest {

    @Test
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
