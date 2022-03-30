import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MailchimpChrome {
    @Given("I navigate to the website")
    public void iNavigateToTheWebsite(WebDriver driver) {
        driver.get("https://login.mailchimp.com/signup/");
    }

    @Given("I enter the e-mail address {string}")
    public void iEnterTheEMailAddress(WebDriver driver, String arg0) {
        WebElement mail = driver.findElement(By.id("email"));
        mail.sendKeys(arg0);
    }

    @And("I enter the user name {string}")
    public void iEnterTheUserName(WebDriver driver, String arg0) {
        WebElement name = driver.findElement(By.id("new_username"));
        name.sendKeys(arg0);
    }

    @And("I enter the password {string}")
    public void iEnterThePassword(WebDriver driver, String arg0) {
        WebElement key = driver.findElement(By.id("new_password"));
        key.sendKeys(arg0);
    }

    @When("I press the register button")
    public void iPressTheRegisterButton(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("create-account")));
        WebElement button = driver.findElement(By.id("create-account"));
        button.click();
    }

    @io.cucumber.java.en.Then("^A user is registered$")
    public boolean aUserIsRegistered(WebDriver driver) {
        try {
            WebElement confirmation = driver.findElement(By.linkText("Re-enter your email and try again"));
            if (confirmation != null) {
                return true;
            }
        } catch (NoSuchElementException e) {
            System.out.println("Registration failed.");
        }
        return false;
    }

    public void iCloseTheCookiePopup(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("onetrust-reject-all-handler")));
        WebElement cookies = driver.findElement(By.id("onetrust-reject-all-handler"));
        cookies.click();
    }
}