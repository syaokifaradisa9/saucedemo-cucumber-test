package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class cart {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user login to dashboard with {string}")
    public void userLoginToDashboardWith(String username) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        String errorMessage = driver.findElement(By.className("app_logo")).getText();
        Assert.assertEquals("Swag Labs", errorMessage);
    }

    @And("click add to cart button for item {string}")
    public void clickAddToCartButtonForItem(String itemId) {
        driver.findElement(By.id(itemId)).click();
    }

    @Then("User see cart icon with number {int}")
    public void userSeeCartIconWithNumber(int number) {
        int cartCount = Integer.parseInt(driver.findElement(By.className("shopping_cart_link")).getText());
        Assert.assertEquals(number, cartCount);
        driver.quit();
    }

    @And("click all add to cart item in dashboard page")
    public void clickAllAddToCartItemInDashboardPage() {
        for (var element: driver.findElements(By.className("btn_inventory"))) {
            element.click();
        }
    }

    @And("click all remove item in cart page")
    public void clickAllRemoveItemInCartPage() {
        for (var element: driver.findElements(By.className("cart_button"))) {
            element.click();
        }
    }

    @And("click all remove item in dashboard page")
    public void clickAllRemoveItemInDashboardPage() {
        for (var element: driver.findElements(By.className("btn_inventory"))) {
            element.click();
        }
    }

    @And("user click cart icon")
    public void userClickCartIcon() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    @And("User see no items in cart item")
    public void userSeeNoItemsInCartItem() {
        int itemCount = driver.findElements(By.className("cart_item")).size();
        Assert.assertEquals(0, itemCount);
        driver.quit();
    }
}
