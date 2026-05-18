package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutInfoTest extends BaseTest {

    @Test(
            testName = "Проверка checkout с позитивными данными",
            description = "Проверка checkout с позитивным Именем, Фамилией и кодом",
            priority = 1,
            groups = "smoke"
    )
    public void checkPositiveCheckout() {
        // сразу логин
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        // добавить продукт
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        // переход на checkout page
        cartPage.clickCheckout();
        // заполнить поля в checkout page
        checkoutPage.enterDataForCheckout("test", "test", "12345");

        assertEquals(checkoutPage.getPageTitle(),
                "Checkout: Overview",
                "NO OVERVIEW!");
    }

    @Test(
            testName = "Проверка checkout с негативными данными",
            description = "Проверка checkout с пустым Именем",
            groups = "regression"
    )
    public void checkCheckoutWithEmptyFirstName() {
        // сразу логин
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        // добавить продукт
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        // переход на checkout page
        cartPage.clickCheckout();
        // заполнить поля в checkout page
        checkoutPage.enterDataForCheckout("", "test", "12345");

        assertEquals(checkoutPage.getErrorMessageCheckout(),
                "Error: First Name is required",
                "Errroooorrr -> empty first name");
    }

    @Test(
            testName = "Проверка checkout с негативными данными",
            description = "Проверка checkout с пустым полем Фамилии",
            groups = "regression"
    )
    public void checkCheckoutWithEmptyLastName() {
        // сразу логин
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        // добавить продукт
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        // переход на checkout page
        cartPage.clickCheckout();
        // заполнить поля в checkout page
        checkoutPage.enterDataForCheckout("test", "", "12345");
        assertEquals(checkoutPage.getErrorMessageCheckout(),
                "Error: Last Name is required",
                "Errroooorrr -> empty last name");
    }

    @Test(
            testName = "Проверка checkout с негативными данными",
            description = "Проверка checkout с пустым полем Код",
            groups = "regression"
    )
    public void checkCheckoutWithEmptyPostalCode() {
        // сразу логин
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        // добавить продукт
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        // переход на checkout page
        cartPage.clickCheckout();
        // заполнить поля в checkout page
        checkoutPage.enterDataForCheckout("test", "test", "");
        assertEquals(checkoutPage.getErrorMessageCheckout(),
                "Error: Postal Code is required",
                "Errroooorrr -> empty code");
    }
}
