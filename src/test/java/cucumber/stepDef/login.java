package cucumber.stepDef;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user open website in browser")
    public void userOpenWebsiteInBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        String loginPageAssert = driver.findElement(By.className("login_logo")).getText();
        Assert.assertEquals("Swag Labs", loginPageAssert);
    }

    @When("input username {string}")
    public void inputUsername(String username) {
        driver.findElement(By.id("user-name")).sendKeys(username);
    }

    @And("input password {string}")
    public void inputPassword(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("click login button")
    public void clickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("user in dashboard page")
    public void userInDashboardPage() {
        String errorMessage = driver.findElement(By.className("app_logo")).getText();
        Assert.assertEquals("Swag Labs", errorMessage);
        driver.quit();
    }

    @Then("user see error message {string}")
    public void userSeeErrorMessage(String expectedErrorMessage) {
        String errorMessage = driver.findElement(By.className("error-message-container")).getText();
        Assert.assertEquals(expectedErrorMessage, errorMessage);
        driver.quit();
    }
}
