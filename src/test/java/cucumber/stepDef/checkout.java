package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class checkout {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("add several item using username {string}")
    public void addSeveralItemUsingUsername(String username) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        String errorMessage = driver.findElement(By.className("app_logo")).getText();
        Assert.assertEquals("Swag Labs", errorMessage);

        for (var element: driver.findElements(By.className("btn_inventory"))) {
            element.click();
        }

        driver.findElement(By.className("shopping_cart_link")).click();
    }

    @And("user click checkout button")
    public void userClickLogoutButton() {
        driver.findElement(By.id("checkout")).click();
    }

    @And("user fill the first name field")
    public void userFillTheFirstNameField() {
        driver.findElement(By.id("first-name")).sendKeys("Muhammad");
    }

    @And("user fill the last name field")
    public void userFillTheLastNameField() {
        driver.findElement(By.id("last-name")).sendKeys("Syaoki Faradisa");
    }

    @And("user fill the postal code field")
    public void userFillThePostalCodeField() {
        driver.findElement(By.id("postal-code")).sendKeys("12345");
    }

    @And("user fill the postal code field With Not Number")
    public void userFillThePostalCodeFieldWithNotNumber() {
        driver.findElement(By.id("postal-code")).sendKeys("asdfgh");
    }

    @And("user fill the postal code field With Not Six Digit")
    public void userFillThePostalCodeFieldWithNotSixDigit() {
        driver.findElement(By.id("postal-code")).sendKeys("123");
    }

    @And("user click continue checkout button")
    public void userClickContinueCheckoutButton() {
        driver.findElement(By.id("continue")).click();
    }

    @And("user click finish checkout button")
    public void userClickFinishCheckoutButton() {
        driver.findElement(By.id("finish")).click();
    }

    @Then("user in checkout complete page")
    public void userInCheckoutCompletePage() {
        String assertText = driver.findElement(By.className("title")).getText();
        Assert.assertEquals("Checkout: Complete!", assertText);
        driver.quit();
    }

    @Then("user see checkout error message {string}")
    public void userSeeCheckoutErrorMessage(String expectedErrorMessage) {
        String errorMessage = driver.findElement(By.className("error-message-container")).getText();
        Assert.assertEquals(expectedErrorMessage, errorMessage);
        driver.quit();
    }
}
