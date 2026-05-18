package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LogoutTest extends BaseTest {

    @Test(
            testName = "Проверка выхода из системы",
            description = "Проверка, что logout выполнен",
            groups = "regression"
    )
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
