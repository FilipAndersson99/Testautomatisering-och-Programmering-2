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
        object.iEnterTheEMailAddress(driver, "mememememail@gmail.com");

        object.iEnterTheUserName(driver, "Name5");

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

        String expected = "Enter a value less than 100 characters long";

        String actual = object.iAmToldTheUserNameIsTooLong(driver);

        assertEquals(expected, actual);

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

        String expected = "Another user with this username already exists. Maybe it's your evil twin. Spooky.";

        String actual = object.iAmToldTheUserNameIsTaken(driver);

        assertEquals(expected, actual);

        driver.quit();
    }
    @Test
    public void testMailchimpNoEmailChrome() {
        System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        MailchimpChrome object = new MailchimpChrome();

        object.iNavigateToTheWebsite(driver);

        object.iCloseTheCookiePopup(driver);

        object.iEnterTheUserName(driver, "NameX");

        object.iEnterThePassword(driver, "Pa5#word");

        object.iPressTheRegisterButton(driver);

        String expected = "Please enter a value";

        String actual = object.iAmToldToEnterAnEMailAddress(driver);

        assertEquals(expected, actual);

        driver.quit();
    }
}
