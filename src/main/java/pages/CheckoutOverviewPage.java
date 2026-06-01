package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutOverviewPage extends BasePage {

    private final By FINISH_BUTTON = By.id("finish");
    private final By CANCEL_BUTTON = By.id("cancel");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    @Step("Кнопка Finish отображается для подтверждения заказа")
    public boolean isFinishButtonDisplayed() {
        return driver.findElement(FINISH_BUTTON).isDisplayed();
    }

    @Step("Нажатие на кнопку Finish для оформления заказа")
    public CheckoutCompletePage clickFinishButton() {
        driver.findElement(FINISH_BUTTON).click();
        return new CheckoutCompletePage(driver);
    }

    @Step("Нажатие Cancel для отмены оформления заказа")
    public ProductsPage clickCancelButton() {
        driver.findElement(CANCEL_BUTTON).click();
        return new ProductsPage(driver);
    }

    @Override
    public CheckoutOverviewPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(FINISH_BUTTON));
        return this;
    }
}
