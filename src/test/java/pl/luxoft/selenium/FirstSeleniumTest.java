package pl.luxoft.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.naming.directory.SearchResult;
import java.util.concurrent.TimeUnit;


public class FirstSeleniumTest extends ParentSeleniumTest {


    private void acceptPrivacyPolicy(){
             final By PRIVACY_MODAL_WINDOW_WRAPPER = By.className("alert");
             final By PRIVACY_MODAL_ACCEPT_BUTTON = By.xpath("/html/body/div[2]/div[1]/div[2]/div[3]/div[2]/button");

             driver
                     .findElement(PRIVACY_MODAL_WINDOW_WRAPPER)
                     .findElement(PRIVACY_MODAL_ACCEPT_BUTTON)
                     .click();
    }


    @Test
    public void searchResultPageTitleContainSeachedText(){
        String searchQuery = "leather bag";
        final By SEARCH_FIELD = By.name("search_query");
        //final By SEARCH_SUGGESTION_LIST_FIRST = By.cssSelector("#");
        final By SEARCH_SUGGESTION_LIST_FIRST = By.xpath("//*[@id=\"global-enhancements-search-suggestions\"]/ul/li[1]");


        driver.get("https://www.etsy.com/");
        acceptPrivacyPolicy();
        WebElement search_field = driver.findElement(SEARCH_FIELD);
        search_field.clear();
        search_field.sendKeys(searchQuery);
        WebElement firstSuggestionItem = new WebDriverWait(driver, 5)
            .until(ExpectedConditions.visibilityOfElementLocated(SEARCH_SUGGESTION_LIST_FIRST));
        firstSuggestionItem.click();
        Assert.assertTrue(driver.getTitle().contains("Leather bag"));

    }

/*
    @Test
    public void searchResultPageTitleContainSeachedPOText() {
        String searchQuery = "leather bag";

        EtsyComMainPO etsyCom = new EtsyComMainPO(driver);
        SearchResultsPO eatsyResults = new SearchResultsPO(driver)''
        etsyCom.acceptPrivacyPolicy().seachFor(searchQuery)
    }

*/
}
