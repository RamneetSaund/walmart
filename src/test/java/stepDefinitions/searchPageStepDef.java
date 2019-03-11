package stepDefinitions;
import cucumber.api.java.en.*;
import pageObjects.*;
import utils.PropertiesReader;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class searchPageStepDef extends TestBase{

    private SearchPage searchPage;

    @Given("^customer is on home page$")
    public void customerIsOnHomePage() {
        PropertiesReader propertiesReader = new PropertiesReader();
        String expUrl = propertiesReader.getBaseUrl();
        goToHomePage();
        assertThat("home page URL should be " + expUrl, getCurrentUrl(), is(expUrl) );
    }

    @Given("^customer searches for (.*)$")
    public void searchByItemNumber(String itemNumber) {
        searchPage = new SearchPage(getDriver());
        searchPage.setSearchBox(itemNumber);
    }

    @Given("^clicks on the search item number (.*)$")
    public void clickSearchItemNumber(String num) {
        searchPage = new SearchPage(getDriver());
        assertThat("item number should be found in search results", searchPage.clickThumbPicByItemNumber(num), is(true));
    }
}
