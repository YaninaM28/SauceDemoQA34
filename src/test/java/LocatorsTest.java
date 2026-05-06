import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LocatorsTest extends BaseTest{

    @Test
    public void checkLocators() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.className("submit-button")).click();

        driver.findElement(By.id("shopping_cart_container"));
        driver.findElement(By.name("add-to-cart-sauce-labs-bike-light"));
        driver.findElement(By.className("bm-burger-button"));
        driver.findElement(By.tagName("button"));
        driver.findElement(By.linkText("Twitter"));
        driver.findElement(By.partialLinkText("Linked"));

        driver.findElement(By.xpath("//div[@data-test='inventory-item-name']"));
        driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        driver.findElement(By.xpath("//div[contains(text(),'Sauce')]"));
        driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']//ancestor::div"));
        driver.findElement(By.xpath("//div[@class='inventory_item']//descendant::div[@data-test='inventory-item-name']"));
        driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']//following::div"));
        driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']//parent::div"));
        driver.findElement(By.xpath("//div[@data-test='inventory-item-name']//preceding::div[1]"));
        driver.findElement(By.xpath("//div[@data-test='inventory-item-name' and contains(text(),'Backpack')]"));

        driver.findElement(By.cssSelector(".btn"));
        driver.findElement(By.cssSelector(".btn.btn_primary"));
        driver.findElement(By.cssSelector("#item_4_title_link"));
        driver.findElement(By.cssSelector("button"));
        driver.findElement(By.cssSelector("button.btn_primary"));
        driver.findElement(By.cssSelector("[data-test='inventory-item-name']"));
        driver.findElement(By.cssSelector("[class~='btn_small']"));
        driver.findElement(By.cssSelector("[data-test|='inventory-list']"));
        driver.findElement(By.cssSelector("[data-test^='inventory-sidebar']"));
        driver.findElement(By.cssSelector("[src$='.jpg']"));
        driver.findElement(By.cssSelector("[data-test*='price']"));
    }

}
