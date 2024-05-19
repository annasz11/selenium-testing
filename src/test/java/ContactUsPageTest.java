import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.Alert;

import java.net.URL;
import java.net.MalformedURLException;


public class ContactUsPageTest {
    public WebDriver driver;
    protected WebDriverWait wait;


    private String email = "anna.szaraz11@gmail.com";
    private String password = "SqatHomework2024";
    
    @Before
    public void setup()  throws MalformedURLException  {
        ChromeOptions options = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        driver.manage().window().maximize();
    }

    @Test
    public void testContactUs() {
        MainPage mainPage = new MainPage(this.driver);
        mainPage.login(email, password);

        String name = "bbnmkf";
        String email = "anna.szaraz11@gmail.com";
        String subject = "Order not arrived";
        String message = "My order JXH638BBDU236 has not arrived yet.";

        ContactUsPage contactUsPage = mainPage.contactUs(name, email, subject, message);
        driver.switchTo().alert().accept();

        String bodyText = contactUsPage.getBodyText();
        Assert.assertTrue(bodyText.contains("Success! Your details have been submitted successfully."));
    }
    
    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
