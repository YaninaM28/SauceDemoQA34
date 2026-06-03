package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
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
        log.info("Finishing order");
        driver.findElement(FINISH_BUTTON).click();
        return new CheckoutCompletePage(driver);
    }

    @Step("Нажатие Cancel для отмены оформления заказа")
    public ProductsPage clickCancelButton() {
        log.info("Cancelling checkout");
        driver.findElement(CANCEL_BUTTON).click();
        return new ProductsPage(driver);
    }

    @Override
    public CheckoutOverviewPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(FINISH_BUTTON));
        return this;
    }
}
