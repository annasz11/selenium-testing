import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.*;  

import java.net.URL;
import java.net.MalformedURLException;


public class MainPageTest {
    public WebDriver driver;

    private Map<String, String> staticPages = new HashMap<String, String>() {{
        put("//li/a[@href='/test_cases' and contains(text(), 'Test Cases')]", "TEST CASES");
        put("//li/a[@href='/api_list' and contains(text(), 'API Testing')]", "APIS LIST FOR PRACTICE");
        put("//li/a[@href='/products' and contains(text(), 'Products')]", "CATEGORY");
    }};
    
    @Before
    public void setup()  throws MalformedURLException  {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-extensions");

        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        driver.manage().window().maximize();
    }

    @Test
    public void testTitle() {
        MainPage mainPage = new MainPage(this.driver);
        String pageTitle = driver.getTitle();
        Assert.assertEquals("Automation Exercise", pageTitle);
    }

    @Test
    public void testStaticPage() {
        MainPage mainPage = new MainPage(this.driver);
        mainPage.staticPage();

        Assert.assertTrue(mainPage.getBodyText().contains("TEST CASES"));
    }

    @Test
    public void testCasesStaticPage() {
        MainPage mainPage = new MainPage(this.driver);

        for (Map.Entry<String, String> staticPage:staticPages.entrySet()) {
            mainPage.staticPage(staticPage.getKey());

            Assert.assertTrue(mainPage.getBodyText().contains(staticPage.getValue()));
        }
    }

    @Test
    public void testHower() {
        MainPage mainPage = new MainPage(this.driver);
        By chartBy = By.xpath("//li/a[@href='/view_cart' and contains(text(), 'Cart')]");
        
        Actions actions = new Actions(this.driver);
        actions.moveToElement(mainPage.waitAndReturnElement(chartBy)).build().perform();
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
