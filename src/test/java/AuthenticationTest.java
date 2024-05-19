import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.net.MalformedURLException;


public class AuthenticationTest {
    public WebDriver driver;

    private String email = "anna.szaraz11@gmail.com";
    private String password = "SqatHomework2024";
    
    @Before
    public void setup()  throws MalformedURLException  {
        ChromeOptions options = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        driver.manage().window().maximize();
    }

    @Test
    public void testLogin() {
        MainPage mainPage = new MainPage(this.driver);
        mainPage.login(email, password);
        Assert.assertTrue(mainPage.getHeaderText().contains("Logout"));
    }
   
    @Test
    public void testLogout() {
        MainPage mainPage = new MainPage(this.driver);
        mainPage.login(email, password);

        mainPage.logout();
        Assert.assertTrue(mainPage.getHeaderText().contains("Signup / Login"));
    }
    
    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
