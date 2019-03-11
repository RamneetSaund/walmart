package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PropertiesReader;
import utils.Utils;

public class SearchPage {

    @FindBy(id = "global-search")
    private WebElement searchBox;

    private String thumbPicXpath = "//a[@class='product-link' and substring(@href, string-length(@href) - string-length('%s')+1)='%s']";

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void setSearchBox(String text){
        searchBox.clear();
        searchBox.sendKeys(text);
        searchBox.sendKeys(Keys.ENTER);
    }

    public boolean clickThumbPicByItemNumber(String itemNumber){
        By locator = By.xpath(String.format(thumbPicXpath, itemNumber, itemNumber));
        WebElement elem = Utils.waitForElementToBeVisible(locator, new PropertiesReader().getElementTimeout());
        if(elem !=null){
            elem.click();
            return true;
        } else{
            return false;
        }
    }
}
