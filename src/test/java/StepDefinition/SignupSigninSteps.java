package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.After;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.Random;

public class SignupSigninSteps {
    private WebDriver driver;
    private static String generatedEmail;
    private static String generatedPassword;
    private static String firstName;
    private static String lastName;

    private String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }

    @Given("I launch the browser and navigate to Magento home page")
    public void launch_browser_and_navigate() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @When("I click on Create an Account")
    public void click_create_account() {
        driver.findElement(By.xpath("(//a[normalize-space()='Create an Account'])[1]")).click();
    }

    @When("I enter first name")
    public void enter_first_name() {
        firstName = generateRandomString(6);
        driver.findElement(By.xpath("//input[@title='First Name']")).sendKeys(firstName);
    }

    @When("I enter last name")
    public void enter_last_name() {
        lastName = generateRandomString(6);
        driver.findElement(By.xpath("//input[@title='Last Name']")).sendKeys(lastName);
    }

    @When("I enter email address")
    public void enter_email_address() {
        generatedEmail = firstName + lastName + "@example.com";
        driver.findElement(By.id("email_address")).sendKeys(generatedEmail);
    }

    @When("I enter password and confirm password")
    public void enter_password() {
        generatedPassword = "Test@" + generateRandomString(8);
        driver.findElement(By.id("password")).sendKeys(generatedPassword);
        driver.findElement(By.id("password-confirmation")).sendKeys(generatedPassword);
    }

    @When("I click on Create Account button")
    public void click_create_account_button() {
        driver.findElement(By.xpath("//button[@title='Create an Account']")).click();
    }

    @Then("I should see a success message")
    public void verify_account_creation() {
        assertTrue(driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")) != null);
    }

    @When("I click on Sign In link")
    public void click_sign_in() {
        driver.findElement(By.xpath("(//a[contains(text(),'Sign In')])[1]")).click();
    }

    @When("I enter the generated email and password")
    public void enter_generated_credentials() {
        driver.findElement(By.id("email")).sendKeys(generatedEmail);
        driver.findElement(By.id("pass")).sendKeys(generatedPassword);
    }

    @When("I click on Sign In button")
    public void click_sign_in_button() {
        driver.findElement(By.id("send2")).click();
    }

    @Then("I should be logged in successfully")
    public void verify_login() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement welcomeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='logged-in'])[1]")));
        String welcomeText = welcomeElement.getText();
        String expectedText = "Welcome, " + firstName + " " + lastName + "!";
        assertEquals("The welcome message is incorrect!", expectedText, welcomeText);
        WebElement myAccountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='base'])[1]")));
        String myAccountHeader = myAccountElement.getText();
        assertEquals("Home Page", myAccountHeader);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}