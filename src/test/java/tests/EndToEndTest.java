package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import utils.Retry;

import static org.testng.Assert.assertEquals;

public class EndToEndTest extends BaseTest {

    @Test(
            testName = "Проверка полного пользовательского теста",
            description = "Проверка логирования + добавления товара + оформления заказа",
            groups = "smoke",
            retryAnalyzer = Retry.class
    )
    @Owner("Savich Yanina")
    @Epic("Sauce Demo 1")
    @Feature("End to end test")
    @Story("Full positive steps for ordering")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "Аналитика", url = "https://www.saucedemo.com/")
    public void checkEndToEndTest() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        cartPage.clickCheckout();
        checkoutPage.enterDataForCheckout("test", "test", "12345");
        checkoutOverviewPage.clickFinishButton();
        assertEquals(
                checkoutCompletePage.getPageTitle(),
                "Checkout: Complete!",
                "Заказ не завершен!!!!"
        );
    }
}
