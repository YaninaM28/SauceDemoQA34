package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutInfoTest extends BaseTest {

    @Test(
            testName = "Проверка checkout с позитивными данными",
            description = "Проверка checkout с позитивным Именем, Фамилией и кодом",
            priority = 1,
            groups = "smoke"
    )
    @Owner("Savich Yanina")
    @Epic("Sauce Demo 1")
    @Feature("Checkout Info")
    @Story("Checkout with positive data")
    @Description("Проверка checkout с позитивным Именем, Фамилией и кодом")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "Аналитика", url = "https://www.saucedemo.com/")
    @TmsLink("SD-T03")
    public void checkPositiveCheckout() {
        // сразу логин
        loginPage.open()
                .isPageOpened()
                .login("standard_user", "secret_sauce")
                .isPageOpened()
                .addToCart("Sauce Labs Backpack")
                .clickCart()
                .isPageOpened()
                .clickCheckout()
                .isPageOpened()
                .enterDataForCheckout("test", "test", "12345");

        assertEquals(checkoutPage.getPageTitle(),
                "Checkout: Overview",
                "NO OVERVIEW!");
    }

    @Test(
            testName = "Проверка checkout с негативными данными",
            description = "Проверка checkout с пустым Именем",
            groups = "regression"
    )
    @Owner("Savich Yanina")
    @Epic("Sauce Demo 1")
    @Feature("Checkout Info")
    @Story("Checkout with empty first name")
    @Description("Проверка checkout с пустым Именем")
    @Severity(SeverityLevel.MINOR)
    @Link(name = "Аналитика", url = "https://www.saucedemo.com/")
    @TmsLink("SD-T04")
    public void checkCheckoutWithEmptyFirstName() {
        // сразу логин
        loginPage.open()
                .isPageOpened()
                .login("standard_user", "secret_sauce")
                .addToCart("Sauce Labs Backpack")
                .clickCart()
                .isPageOpened()
                .clickCheckout()
                .isPageOpened()
                .enterNegativeDataForCheckout("", "test", "12345");

        assertEquals(checkoutPage.getErrorMessageCheckout(),
                "Error: First Name is required",
                "Errroooorrr -> empty first name");
    }

    @Owner("Savich Yanina")
    @Epic("Sauce Demo 1")
    @Feature("Checkout Info")
    @Story("Checkout with empty last name")
    @Description("Проверка checkout с пустой фамилией")
    @Severity(SeverityLevel.MINOR)
    @Link(name = "Аналитика", url = "https://www.saucedemo.com/")
    @TmsLink("SD-T05")
    @Test(
            testName = "Проверка checkout с негативными данными",
            description = "Проверка checkout с пустым полем Фамилии",
            groups = "regression"
    )
    public void checkCheckoutWithEmptyLastName() {
        loginPage.open()
                .isPageOpened()
                .login("standard_user", "secret_sauce")
                .isPageOpened()
                .addToCart("Sauce Labs Backpack")
                .clickCart()
                .isPageOpened()
                .clickCheckout()
                .isPageOpened()
                .enterNegativeDataForCheckout("test", "", "12345");

        assertEquals(checkoutPage.getErrorMessageCheckout(),
                "Error: Last Name is required",
                "Errroooorrr -> empty last name");
    }

    @Test(
            testName = "Проверка checkout с негативными данными",
            description = "Проверка checkout с пустым полем Код",
            groups = "regression"
    )
    @Owner("Savich Yanina")
    @Epic("Sauce Demo 1")
    @Feature("Checkout Info")
    @Story("Checkout with empty code")
    @Description("Проверка checkout с пустым полем код")
    @Severity(SeverityLevel.MINOR)
    @Link(name = "Аналитика", url = "https://www.saucedemo.com/")
    @TmsLink("SD-T06")
    public void checkCheckoutWithEmptyPostalCode() {
        loginPage.open()
                .isPageOpened()
                .login("standard_user", "secret_sauce")
                .isPageOpened()
                .addToCart("Sauce Labs Backpack")
                .clickCart()
                .clickCheckout()
                .isPageOpened()
                .enterNegativeDataForCheckout("test", "test", "");

        assertEquals(checkoutPage.getErrorMessageCheckout(),
                "Error: Postal Code is required",
                "Errroooorrr -> empty code");
    }
}
