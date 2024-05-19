import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
 

import java.net.URL;
import java.net.MalformedURLException;


public class ProductsPageTest {
    public WebDriver driver;
    
    @Before
    public void setup()  throws MalformedURLException  {
        ChromeOptions options = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        driver.manage().window().maximize();
    }

    @Test
    public void testSearch() {
        String[] searchQueries={"jeans"};  
        for(String searchQuery : searchQueries) {  
            MainPage mainPage = new MainPage(this.driver);
            ProductsPage productsPage = mainPage.search(searchQuery);
            String bodyText = productsPage.getBodyText();
            Assert.assertTrue(bodyText.contains("SEARCHED PRODUCTS"));
        }  
    }

    @Test
    public void testGetDresses() {
        MainPage mainPage = new MainPage(this.driver);

        ProductsPage productsPage = mainPage.getDresses();
        Assert.assertTrue(productsPage.getBodyText().contains("WOMEN - DRESS PRODUCTS"));

    }
    
    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
