import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;


class ProductsPage extends PageBase {

    private By searchFieldBy = By.xpath("//input[@type='text' and @name='search' and @id='search_product' and @placeholder='Search Product']");
    private By submitSearchBy = By.xpath("//button[@type='button' and @id='submit_search' and @class='btn btn-default btn-lg']//i[contains(@class, 'fa fa-search')]");  
       
    private By womenSectionToggleBy = By.xpath("//div[@class='panel panel-default']//div[@class='panel-heading']//h4[@class='panel-title']//a[@data-toggle='collapse' and @data-parent='#accordian' and @href='#Women']");
    private By dressProductBy = By.xpath("//li/a[@href='/category_products/1' and contains(text(), 'Dress')]");


    public ProductsPage(WebDriver driver) {
        super(driver);
    }    
        
    public ProductsPage search(String searchQuery) {
        this.waitAndReturnElement(searchFieldBy).sendKeys(searchQuery);
        this.waitAndReturnElement(submitSearchBy).click();
        return this;
    }

    public ProductsPage getDresses() {
        this.waitAndReturnElement(womenSectionToggleBy).click();
        this.waitAndReturnElement(dressProductBy).click();
        return this;
    }


}
