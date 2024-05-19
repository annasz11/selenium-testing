import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;


class ContactUsPage extends PageBase {

    private By nameFieldBy = By.xpath("//input[@type='text' and @name='name']");
    private By emailFieldBy = By.xpath("//input[@type='email' and @name='email']");
    private By subjectFieldBy = By.xpath("//input[@type='text' and @name='subject']");
    private By messageFieldBy = By.xpath("//textarea[@name='message']");
    private By submitButtonBy = By.xpath("//input[@type='submit' and @data-qa='submit-button' and @name='submit']");

    public ContactUsPage(WebDriver driver) {    
        super(driver);
    }

    public ContactUsPage fillForm(String name, String email, String subject, String message) {
        this.waitAndReturnElement(nameFieldBy).sendKeys(name);
        this.waitAndReturnElement(emailFieldBy).sendKeys(email);
        this.waitAndReturnElement(subjectFieldBy).sendKeys(subject);
        this.waitAndReturnElement(messageFieldBy).sendKeys(message);
        this.waitAndReturnElement(submitButtonBy).click();
        return this;
    }
}
