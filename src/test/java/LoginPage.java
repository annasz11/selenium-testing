import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;


class LoginPage extends PageBase {

    // Locators for the login form elements
    private By emailFieldBy = By.xpath("//input[@data-qa='login-email']");
    private By passwordFieldBy = By.xpath("//input[@data-qa='login-password']");
    private By loginButtonBy = By.xpath("//button[@data-qa='login-button']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        this.waitAndReturnElement(emailFieldBy).sendKeys(email);
        this.waitAndReturnElement(passwordFieldBy).sendKeys(password);
        this.waitAndReturnElement(loginButtonBy).click();
    }
}

