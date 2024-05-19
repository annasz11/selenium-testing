import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;


public class MainPage extends PageBase {

    private By headerBy = By.xpath("//header[@id='header']");
	private By bodyBy = By.tagName("body");

    private By loginBy = By.xpath("//a[contains(text(), 'Signup / Login')]");
    private By logoutBy = By.xpath("//a[contains(text(), 'Logout')]");
    private By contactUsBy = By.xpath("//a[contains(text(), 'Contact us')]");

    private By productsBy = By.xpath("//li/a[@href='/products' and contains(text(), 'Products')]");
    
    public MainPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://automationexercise.com/");
    }    
    
    public String getHeaderText() {
        return this.waitAndReturnElement(headerBy).getText();
    }

    public String getBodyText() {
        return this.waitAndReturnElement(bodyBy).getText();
    }


    public void login(String email, String password) {
        if (this.getHeaderText().contains("Signup / Login")) {
            this.waitAndReturnElement(loginBy).click();

            LoginPage loginPage = new LoginPage(this.driver);
            loginPage.login(email, password);
        } else {
            System.out.println("Already logged in.");
        }
    }

    public void logout() {
        if (this.getHeaderText().contains("Logout")) {
            this.waitAndReturnElement(logoutBy).click();
        } else {
            System.out.println("Already logged out.");
        }
    }

    public ContactUsPage contactUs(String name, String email, String subject, String message) {
        this.waitAndReturnElement(contactUsBy).click();

        ContactUsPage contactUsPage = new ContactUsPage(this.driver);
        contactUsPage = contactUsPage.fillForm(name, email, subject, message);
        return contactUsPage;
    }

    public void staticPage() {
        if (this.getHeaderText().contains("Test Cases")) {
            staticPage("//li/a[@href='/test_cases' and contains(text(), 'Test Cases')]");
        } else {
            System.out.println("No such page.");
        }
    }

    public void staticPage(String xpath) {
        this.waitAndReturnElement(By.xpath(xpath)).click();
    }

    
    public ProductsPage search(String searchQuery) {
        this.waitAndReturnElement(productsBy).click();
    
        ProductsPage productsPage = new ProductsPage(this.driver);
        return productsPage.search(searchQuery);
    }

    public ProductsPage getDresses() {
        this.waitAndReturnElement(productsBy).click();
    
        ProductsPage productsPage = new ProductsPage(this.driver);
        return productsPage.getDresses();
    }
}
