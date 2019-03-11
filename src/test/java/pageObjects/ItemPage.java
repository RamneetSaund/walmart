package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemPage {

    @FindAll({
            @FindBy(xpath = "//div[@id='product-desc']//h1"),
            @FindBy(xpath = "//div[contains(@class,'e1yn5b3f0')]//h1[contains(@class,'e1yn5b3f6')]")
    })
    private WebElement title;

    @FindAll({
            @FindBy(xpath = "//div[@id='product-purchase-cartridge']//div[@class='add-cart-container']//button[contains(@class,'add-to-cart-btn')]"),
            @FindBy(xpath = "//button[text()='Add to cart']")
    })
    private WebElement addToCartBtn;

    @FindAll({
            @FindBy(xpath = "//button[text()='Find in-store']"),
            @FindBy(id = "pf-tab-store-avail")
    })
    private WebElement findInStoreBtn;

    @FindAll({
            @FindBy(xpath = "//div[@id='product-purchase-cartridge']//div[@class='price-current']/div[1]"),
            @FindBy(xpath = "//div[contains(@class,'e1yn5b3f0')]//span[contains(@class,'esdkp3p0')]")
    })
    private WebElement price;

    public ItemPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getAddToCartBtn(){
        return addToCartBtn;
    }

    public WebElement getFindInStoreBtn(){
        return findInStoreBtn;
    }

    public WebElement getPrice(){
        return price;
    }

    public WebElement getTitle(){
        return title;
    }
}
