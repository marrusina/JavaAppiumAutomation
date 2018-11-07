package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import java.awt.*;
import java.util.List;

public class SearchPageObject extends MainPageObject{
    private static final String
        SEARCH_INIT_ELEMENT = "//*[contains(@text,'Search Wikipedia')]",
        SEARCH_INPUT = "//*[contains(@text,'Search…')]",
        SEARCH_CANCEL_BUTTON = "org.wikipedia:id/search_close_btn",
        SEARCH_RESULT_BY_SUBSTRING_TPL = "//android.widget.LinearLayout[@text='{SUBSTRING}']",
            SEARCH_RESULT_BY_TWO_TPL = "//*[@text='{SUBSTRING}']/following-sibling::android.widget.TextView[@text='{DESCRIPTION}']",

    SEARCH_RESULT_BY_DESCRIPTION_TPL = "//*[@resource-id='org.wikipedia:id/page_list_item_description'][@text='{DESCRIPTION}']",

        SEARCH_RESULT_ELEMENT = "//*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']",
<<<<<<< HEAD
        SEARCH_EMPTY_RESULT_ELEMENT = "//*[@text='No results found']",
        SEARCH_RESULT_IN_LIST_AFTER_DELETION = "//*[@text='C++']",
        SEARCH_RESULT_ELEMENT_TWO = "org.wikipedia:id/view_page_title_text";


=======
        SEARCH_EMPTY_RESULT_ELEMENT = "//*[@text='No results found']";
>>>>>>> 956ca0ec2c9a868dac4d2bf5668f5e7ec7df2130
    public SearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }
    //teplates methods
    private static String getResultSearchElement(String substring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }

    private static String getResultSearchElementByTwoElements(String substring, String description)
    {
       return SEARCH_RESULT_BY_TWO_TPL.replace("{SUBSTRING}",substring ).replace("{DESCRIPTION}",description);

    }

       private static String getResultSearchElementDescription(String description)
    {
        return SEARCH_RESULT_BY_DESCRIPTION_TPL.replace("{DESCRIPTION}", description);
    }

    //templates methods

    public void initSearchInput()
        {
        this.waitForElementAndClick(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find and click search element", 5);
        this.waitForElementPresent(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find search input after clicking search element");
    }

    public void waitForCancelButtomToAppear()
    {
        this.waitForElementPresent(By.id(SEARCH_CANCEL_BUTTON), "Cannot find search cancel button", 5);
    }

<<<<<<< HEAD
//    public void waitForCancelButtomToDisappear()
//    {
//        this.waitForElementNotPresent(By.id(SEARCH_CANCEL_BUTTON), "Search cancel button is still present", 5);
//    }
=======
    public void waitForCancelButtomToDisappear()
    {
        this.waitForElementNotPresent(By.id(SEARCH_CANCEL_BUTTON), "Search cancel button is still present", 5);
    }
>>>>>>> 956ca0ec2c9a868dac4d2bf5668f5e7ec7df2130

    public void clickCancelSearch()
    {
        this.waitForElementAndClick(By.id(SEARCH_CANCEL_BUTTON), "Cannot find and click search cansel button", 5);
    }

    public void typeSearchLine(String search_line)
    {
        this.waitForElementAndSendKeys(By.xpath(SEARCH_INPUT), search_line, "Cannot find any type into search input", 5);
    }

<<<<<<< HEAD
//    public void waitForSearchResult(String substring)
//    {
//        String search_result_xpath = getResultSearchElement(substring);
//        this.waitForElementPresent(By.xpath(search_result_xpath), "Cannot find search result" + substring);
//    }
=======
    public void waitForSearchResult(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(By.xpath(search_result_xpath), "Cannot find search result" + substring);
    }
>>>>>>> 956ca0ec2c9a868dac4d2bf5668f5e7ec7df2130

    public void waitForElementByTitleAndDescription(String substring, String description)
    {
        String search_result_by_two = getResultSearchElementByTwoElements(substring, description);
        this.waitForElementPresent(By.xpath(search_result_by_two),"Cannot find by two elements" + substring + description,15);
    }

    public void waitForSearchResultDescription(String description)
    {
        String search_result_xpath = getResultSearchElementDescription(description);
        this.waitForElementPresent(By.xpath(search_result_xpath), "Cannot find search result" + description);
    }

    public void clickByArticleWithSubstring(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
<<<<<<< HEAD
        this.waitForElementAndClick(By.xpath(search_result_xpath), "Cannot find search result with substring" + substring, 15);
=======
        this.waitForElementAndClick(By.xpath(search_result_xpath), "Cannot find search result with substring" + substring, 5);
>>>>>>> 956ca0ec2c9a868dac4d2bf5668f5e7ec7df2130
    }

    public int getAmountOfFoundArticles()
    {
        this.waitForElementPresent(
                By.xpath(SEARCH_RESULT_ELEMENT),
                "Cannot find anything by request",
                5
        );

        return this.getAmountOfElements(By.xpath(SEARCH_RESULT_ELEMENT));

        }

<<<<<<< HEAD
    public int getAmountOfFoundArticlesAfterDeletion()
    {
        this.waitForElementPresent(
                By.xpath(SEARCH_RESULT_IN_LIST_AFTER_DELETION),
                "Cannot find anything by request",
                5
        );

        return this.getAmountOfElements(By.xpath(SEARCH_RESULT_IN_LIST_AFTER_DELETION));

    }

//    public void waitForEmptyResultsLabel()
//    {
//        this.waitForElementPresent(By.xpath(SEARCH_EMPTY_RESULT_ELEMENT), "Cannot find empty result element", 15);
//
//    }

    public void assertthereIsResultOfSearch()
    {
        this.assertElementPresent(By.id(SEARCH_RESULT_ELEMENT_TWO), "We supposed not to find any result");
    }

    public void waitForSearchLineTodisappear()
    {
        this.waitForElementNotPresent(By.id(SEARCH_INPUT), "Cannot find search", 5);
=======
    public void waitForEmptyResultsLabel()
    {
        this.waitForElementPresent(By.xpath(SEARCH_EMPTY_RESULT_ELEMENT), "Cannot find empty result element", 15);

    }

    public void assertthereIsNoResultOfSearch()
    {
        this.assertElementNotPresent(By.xpath(SEARCH_RESULT_ELEMENT), "We supposed not to find any result");
    }

    public void assertthereIsResultOfSearch()
    {
        this.assertElementPresent(By.xpath(SEARCH_RESULT_ELEMENT), "We supposed not to find any result");
>>>>>>> 956ca0ec2c9a868dac4d2bf5668f5e7ec7df2130
    }

}


