import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;

class PageBase {
    protected WebDriver driver;
    protected WebDriverWait wait;

    private By consentBy = By.xpath("//button[contains(@class, 'fc-cta-consent')]");
    
    public PageBase(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        consentToCookies();
    }

    private void consentToCookies() {
        try {
            System.out.println(this.waitAndReturnElement(By.xpath("/root")));
            this.waitAndReturnElement(consentBy).click();
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println("Consent window not present.");
        }
    }
    
    protected WebElement waitAndReturnElement(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator);
    } 
    
    public String getBodyText() {
        WebElement bodyElement = this.waitAndReturnElement(By.tagName("body"));
        return bodyElement.getText();
    }
   
}
