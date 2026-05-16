package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test(
            testName = "Проверка логина с позитивными данными",
            description = "Проверка логина с позитивным логином и паролем",
            priority = 1,
            groups = "smoke",
            retryAnalyzer = Retry.class
    )
    public void checkLoginWithPositiveCred() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(),
                "Products",
                "SO BAAAD");
    }

    @Test(
            testName = "Проверка логина с негативными данными",
            description = "Проверка логина с пустым именем",
            invocationCount = 3,
            groups = "regression"
    )
    public void checkLoginWithEmptyUserName() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "SO BAAAD");
    }

    @Test(
            testName = "Проверка логина с негативными данными",
            description = "Проверка логина с пустым паролем",
            groups = "regression"
    )
    public void checkLoginWithEmptyPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "SO BAAAD");
    }

    @Test(
            testName = "Проверка логина с негативными данными",
            description = "Проверка логина с невалидными логином и паролем",
            groups = "regression",
            enabled = false
    )
    public void checkLoginWithNegativeCred() {
        loginPage.open();
        loginPage.login("test", "test");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "SO BAAAD");
    }

    @DataProvider(name = "Параметризированный тест для негативного логина", indices = {0, 2})
    public Object[][] loginData() {
        return new Object[][] {
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"test", "test", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(dataProvider = "Параметризированный тест для негативного логина")
    public void checkLoginWithNegativeCred1(String user, String password, String errorMessage) {
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(loginPage.getErrorMessage(),
                errorMessage,
                "SO BAAAD");
    }
}