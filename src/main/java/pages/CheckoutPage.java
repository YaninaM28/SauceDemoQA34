package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {

    private final By INPUTFIRSTNAME = By.id("first-name");
    private final By INPUTLASTNAME = By.id("last-name");
    private final By INPUTPOSTALCODE = By.id("postal-code");
    private final By CONTINUE = By.id("continue");
    private final By ERROR_MESSAGE = By.cssSelector("[data-test = error]");
    private final By PAGE_TITLE = By.cssSelector("[data-test = title]");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Step("Данные пользователя для заказа: '{firstName}' '{lastName}' и код пользователя '{postalCode}'")
    public CheckoutOverviewPage enterDataForCheckout(String firstName, String lastName, String postalCode) {
        driver.findElement(INPUTFIRSTNAME).sendKeys(firstName);
        driver.findElement(INPUTLASTNAME).sendKeys(lastName);
        driver.findElement(INPUTPOSTALCODE).sendKeys(postalCode);
        driver.findElement(CONTINUE).click();
        return new CheckoutOverviewPage(driver);
    }

    @Step("Негативные данные пользователя для заказа")
    public CheckoutPage enterNegativeDataForCheckout(String firstName, String lastName, String postalCode) {
        driver.findElement(INPUTFIRSTNAME).sendKeys(firstName);
        driver.findElement(INPUTLASTNAME).sendKeys(lastName);
        driver.findElement(INPUTPOSTALCODE).sendKeys(postalCode);
        driver.findElement(CONTINUE).click();
        return this;
    }

    public String getErrorMessageCheckout() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    public String getPageTitle() {
        return driver.findElement(PAGE_TITLE).getText();
    }

    @Override
    public CheckoutPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PAGE_TITLE));
        return this;
    }
}
