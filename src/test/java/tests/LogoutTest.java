package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LogoutTest extends BaseTest {

    @Test(
            testName = "Проверка выхода из системы",
            description = "Проверка, что logout выполнен",
            groups = "regression"
    )
    @Epic("Sauce Demo 1")
    @Feature("Log out")
    @Story("Log out is come back to Log in page")
    @Description("Проверка выполнения logout")
    @Severity(SeverityLevel.MINOR)
    @Link(name = "Аналитика", url = "https://www.saucedemo.com/")
    @TmsLink("SD-T01")
    public void checkLogout() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.logout();
        assertTrue(
                loginPage.isLoginButtonDisplayed(),
                "ты не на странице Login"
        );
    }
}
