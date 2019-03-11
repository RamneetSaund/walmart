package stepDefinitions;
import cucumber.api.java.en.*;
import org.openqa.selenium.WebElement;
import pageObjects.ItemPage;
import utils.PropertiesReader;
import utils.Utils;

import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class itemPageStepDef extends TestBase {

    ItemPage itemPage;

    @Given("^item page for (.*) opens successfully$")
    public void validateItemPageOpens(String itemNumber) throws Throwable {
        assertThat("Item page URL should end with item number " + itemNumber, getCurrentUrl(), endsWith(itemNumber) );
    }

    @Given("^item page has title (.*)$")
    public void itemPageHasTitle(String title) throws Throwable {
        itemPage = new ItemPage(getDriver());
        WebElement elem = Utils.waitAndGetElementAfterVisible(itemPage.getTitle());
        assertThat("Item page title should be present", elem, is(notNullValue()));
        assertThat("Item page should have correct title: " + title, elem.getText(), is(title));
    }

    @Given("^item page has price (.*)$")
    public void itemPageHasPrice(String price) throws Throwable {
        itemPage = new ItemPage(getDriver());
        assertThat("Item page should have correct price: " + price, itemPage.getPrice().getText(), is(price) );
    }

    @Given("^item page (doesnot have|has) buttons available for (online|in-store) purchase$")
    public void itemPageHasCorrectBtnsAvailable(String availability, String purchase) throws Throwable {
        itemPage = new ItemPage(getDriver());
        int timeout = new PropertiesReader().getElementTimeout();
        boolean expAvailability = true;
        if(Objects.equals(availability, "doesnot have")){
            expAvailability = false;
            switch(purchase){
                case "online":
                    assertThat("Item page should NOT have Add to cart btn displayed", Utils.waitForElementToBeVisible(itemPage.getAddToCartBtn(), 10), is(expAvailability) );
                    break;
                case "in-store":
                    assertThat("Item page should NOT have Find in-store btn displayed", Utils.waitForElementToBeVisible(itemPage.getFindInStoreBtn(), 10), is(expAvailability) );
                    break;
            }
        } else{
            switch(purchase){
                case "online":
                    assertThat("Item page should have Add to cart btn displayed", Utils.waitForElementToBeVisible(itemPage.getAddToCartBtn(), timeout), is(expAvailability) );
                    assertThat("Item page should have Add to cart btn enabled", Utils.isEnabled(itemPage.getAddToCartBtn()), is(expAvailability) );
                    break;
                case "in-store":
                    assertThat("Item page should have Find in-store btn displayed", Utils.waitForElementToBeVisible(itemPage.getFindInStoreBtn(), timeout), is(expAvailability) );
                    assertThat("Item page should have Find in-store btn enabled", Utils.isEnabled(itemPage.getAddToCartBtn()), is(expAvailability) );
                    break;
            }
        }
    }
}
