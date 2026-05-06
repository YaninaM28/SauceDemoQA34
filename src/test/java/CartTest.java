import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CartTest extends BaseTest {

    @Test
    public void checkCart() {
        SoftAssert softAssert = new SoftAssert();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.className("submit-button")).click();
        //add product
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a")).click();
        String cartName = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
        softAssert.assertEquals(cartName, "Sauce Labs Backpack");
        String cartPrice = driver.findElement(By.xpath("//div[@class='inventory_item_price']")).getText();
        softAssert.assertEquals(cartPrice, "29.99");
    }
}
