import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Testcases {
    @Test
    public void testMailchimpChrome() {
        System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        MailchimpChrome object = new MailchimpChrome();

        object.iNavigateToTheWebsite(driver);

        object.iCloseTheCookiePopup(driver);

        //Need to remember to change email and username after each test.
        object.iEnterTheEMailAddress(driver, "memail@gmail.com");

        object.iEnterTheUserName(driver, "Name2");

        object.iEnterThePassword(driver, "Pa5#word");

        object.iPressTheRegisterButton(driver);

        boolean actual = object.aUserIsRegistered(driver);

        assertEquals(true, actual);

        driver.quit();
    }
    @Test
    public void testMailchimpLongUsernameChrome() {
        System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        MailchimpChrome object = new MailchimpChrome();

        object.iNavigateToTheWebsite(driver);

        object.iCloseTheCookiePopup(driver);

        object.iEnterTheEMailAddress(driver, "moimail@gmail.com");

        object.iEnterTheUserName(driver, "Name000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");

        object.iEnterThePassword(driver, "Pa5#word");

        object.iPressTheRegisterButton(driver);

        boolean actual = object.aUserIsRegistered(driver);

        assertEquals(false, actual);

        driver.quit();
    }
    @Test
    public void testMailchimpUsernameTakenChrome() {
        System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        MailchimpChrome object = new MailchimpChrome();

        object.iNavigateToTheWebsite(driver);

        object.iCloseTheCookiePopup(driver);

        object.iEnterTheEMailAddress(driver, "momail@gmail.com");

        object.iEnterTheUserName(driver, "Name");

        object.iEnterThePassword(driver, "Pa5#word");

        object.iPressTheRegisterButton(driver);

        boolean actual = object.aUserIsRegistered(driver);

        assertEquals(false, actual);

        driver.quit();
    }
    @Test
    public void testMailchimpNoEmailChrome() {
        System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        MailchimpChrome object = new MailchimpChrome();

        object.iNavigateToTheWebsite(driver);

        object.iCloseTheCookiePopup(driver);

        object.iEnterTheEMailAddress(driver, "");

        object.iEnterTheUserName(driver, "NameX");

        object.iEnterThePassword(driver, "Pa5#word");

        object.iPressTheRegisterButton(driver);

        boolean actual = object.aUserIsRegistered(driver);

        assertEquals(false, actual);

        driver.quit();
    }
}