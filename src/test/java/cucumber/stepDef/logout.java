package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class logout {
    WebDriver driver;
    WebDriverWait wait;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user login with username {string}")
    public void userLoginWithUsername(String username) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        driver.get(baseUrl);

        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        String errorMessage = driver.findElement(By.className("app_logo")).getText();
        Assert.assertEquals("Swag Labs", errorMessage);
    }

    @And("user click logout button")
    public void userClickLogoutButton() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("logout_sidebar_link"))));
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    @Then("user in login page")
    public void userInLoginPage() {
        String loginPageAssert = driver.findElement(By.className("login_logo")).getText();
        Assert.assertEquals("Swag Labs", loginPageAssert);

        driver.quit();
    }
}
