package main.java.com.viacomcbs.page_objects;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.springframework.beans.factory.annotation.Value;
import main.java.com.viacomcbs.annotation.PageObject;
import org.testng.Assert;

@PageObject
public class Search_PageObject extends BasePage {

    private final Logger LOGGER = Logger.getLogger(Search_PageObject.class.getName());

    @Value("${searchPageURL:}")
    private String searchPageURL;

    @FindBy(css = "#search > div:nth-of-type(1) > div > input")
    private WebElement searchInput;

    @FindBy(how = How.CSS, using = "ul.navigation.header__nav--items li:nth-child(5) > a.icon.search")
    private WebElement searchPage1;

    @FindBy(how = How.CSS, using = "div.search__inputWrap > input:nth-child(1)")
    private WebElement searchTitle;

    String titlePut = "a";

    @FindBy(className = "search__results--empty")
    private WebElement emptySearchResults;

    @FindBy(css = "#search > div:nth-of-type(2) > div")
    private WebElement firstSearchResult;

    @FindAll({@FindBy(css = "#search > div:nth-of-type(2) > div > a")})
    private List<WebElement> results;

    @FindBy(css = "#search > div:nth-of-type(1) > a")
    private WebElement closeIcon;

    String invalidSearchErrorText = "Uh-oh, we couldn't find that!";
    String invalidTerm = "1nvalid";
    String validTerm = "bull";

    public String getSearchPageURL() {
        return searchPageURL;
    }

    public boolean iAmHere() {
        return this.atURL(searchPageURL);
    }

    public void enterInvalidTerm() {

        LOGGER.log(Level.INFO, "Entering invalid term... \n");

        WebElement el = this.returnVerifiedElement(searchInput);
        el.sendKeys(invalidTerm);
    }

    public void observeOnSelectingSearchiconTakesUserToSearchPageIsDisplayed() throws InterruptedException {

        LOGGER.log(Level.INFO, "Selecting search icon... \n");

        waitForPageLoaded();
        driver.manage().window().maximize();
        searchPage1.click();
        waitForPageLoaded();
        assertPageEquals(searchPageURL);

    }


    public void noResultsDisplayed() {
        Assert.assertNotNull(this.returnVerifiedElement(emptySearchResults, 10));
    }

    public void invalidSearchErrorAppears() {

        LOGGER.log(Level.INFO, "Validating invalid search error... \n");

        WebElement el = this.returnVerifiedElement(emptySearchResults);
        Assert.assertTrue(el.getText().contains(invalidSearchErrorText));
    }

    public void enterAValidTerm() {

        LOGGER.log(Level.INFO, "Entering a valid term... \n");

        WebElement el = this.returnVerifiedElement(searchInput);
        el.sendKeys(validTerm);
    }

    public void showAndPostersFromTheSearchResultsAreSelectableAndInHighRes() {

        LOGGER.log(Level.INFO, "Validating posters... \n");

        wait.until(ExpectedConditions.visibilityOf(searchPage1));
        driver.manage().window().maximize();
        searchPage1.click();
        searchTitle.sendKeys(titlePut);
    }

    public void atLeastOneShowCardAppears() {
        Assert.assertNotNull(this.returnVerifiedElement(firstSearchResult, 3));
    }

    public void enterASingleLetterTerm() {

        LOGGER.log(Level.INFO, "Entering a single letter term... \n");

        enterTheSearchTerm("a");
    }

    public void enterANumberTerm() {

        LOGGER.log(Level.INFO, "Entering a single digit term... \n");

        enterTheSearchTerm("6");
    }

    public void enterTheSearchTerm(String str) {

        WebElement el = this.returnVerifiedElement(searchInput);
        el.sendKeys(str);
    }

    public void deleteACharacter() {

        LOGGER.log(Level.INFO, "Deleting a character... \n");

        WebElement el = this.returnVerifiedElement(searchInput);
        el.sendKeys(Keys.BACK_SPACE);
    }

    public void searchTermShouldEqual(String str) {

        LOGGER.log(Level.INFO, "Verifying search term... \n");

        WebElement el = this.returnVerifiedElement(searchInput);
        String text = el.getText().trim();
        Assert.assertTrue(text.contentEquals(str), text + ".!=" + str + ".");
    }

    public boolean searchTermIsInSomeResults(String term, int seconds) {

        LOGGER.log(Level.INFO, "Searching terms... \n");

        term = term.replaceAll(" ", "");
        String temp;

        Wait<String> fluentWait = setupFluentWaitParameters(100000,300, "");

        boolean found = false;
        try {
            found = fluentWait.until(new Function<String, Boolean>() {
                public Boolean apply(String termParam) {
                    String temp = "";
                    boolean returnMe = false;
                    for (int i = 0; i < results.size(); i++) {
                        try {
                            temp = results.get(i).getAttribute("href").split("shows/")[1];
                            temp = termParam.replace('-', '\b');
                            temp = termParam.replace('_', '\b');
                            if (temp.contains(termParam)) {
                                returnMe = true;
                                break;
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            //results has href, but does not have the shows/ format
                        } catch (StaleElementReferenceException e) {
                            //results have updated but Spring hasn't updated results
                        }
                    }
                    return returnMe;
                }
            });
        } catch (TimeoutException e) {
            e.getStackTrace();
        }
        return found;

    }

    public void clearSearchInput() {
        this.driver.navigate().refresh();
    }

    public void appendSearchTerm(String str) {

        LOGGER.log(Level.INFO, "Appending search term... \n");

        WebElement el = this.returnVerifiedElement(searchInput);
        el.sendKeys(str);
    }

    public void clickCloseSearch() {

        LOGGER.log(Level.INFO, "Clicking close search... \n");

        WebElement el = this.returnVerifiedElement(closeIcon);
        el.click();
    }

    public boolean waitWhileResultsStillContain(String term, int seconds) {

        LOGGER.log(Level.INFO, "Verifying search results... \n");


        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(this.driver)
                .withTimeout(Duration.ofMillis(seconds * 1000))
                .pollingEvery(Duration.ofMillis(40));

        boolean termIsNoLongerThere = false;
        try {
            termIsNoLongerThere = fluentWait.until(new Function<WebDriver, Boolean>() {
                public Boolean apply(WebDriver driver) {
                    boolean notFound = false;
                    String temp = "";
                    int i = 0;
                    try {
                        while (i < results.size()) {
                            temp = results.get(i).getAttribute("href").split("shows/")[1];
                            temp = temp.replace('-', '\b');
                            temp = temp.replace('_', '\b');

                            if (temp.contains(term)) {//term is found
                                notFound = false;//start the wait again
                            }
                            if (i == results.size() - 1) {
                                notFound = true;//if we go through the entire list, and haven't found the term yet, then the termIsNoLongerThere
                            }
                            i++;
                        }
                    } catch (StaleElementReferenceException | IndexOutOfBoundsException e) {
                        notFound = false;
                    }
                    return notFound;

                }
            });
        } catch (TimeoutException e) {
            e.getStackTrace();
        }
        return termIsNoLongerThere;
    }

    public boolean resultsShouldNotContain(String term) {
        term = term.replaceAll("\\s", "");
        return waitWhileResultsStillContain(term, 5);
    }

    public void deleteALetterFromTheSearchTerm() {

        LOGGER.log(Level.INFO, "Deleting a character... \n");

        WebElement el = this.returnVerifiedElement(searchInput);
        el.sendKeys(Keys.BACK_SPACE);

        //TODO: Can't grab the input text from the search term so can't compare. Deleting a letter also can't reliably be sensed by checking an updated search result
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickResultWithTerm(String term) {

        LOGGER.log(Level.INFO, "Clicking on a search result... \n");

        term = term.replace(' ', '\b');
        String temp = "";
        for (WebElement result : results) {
            temp = result.getAttribute("href").split("shows/")[1];
            temp = temp.replace('-', '\b');

            if (temp.contains(term)) {
                result.click();
            }
        }
    }


}
