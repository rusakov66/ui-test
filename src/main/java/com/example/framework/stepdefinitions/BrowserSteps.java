package com.example.framework.stepdefinitions;

import com.example.framework.TestContext;
import com.example.framework.pages.BombaPage;
import com.example.framework.pages.MaximumPage;
import com.example.framework.pages.WebPages;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.assertj.core.api.Assertions;

public class BrowserSteps {


    private final TestContext context;
    private WebDriver driver;

    private WebPages currentPage;

    private BombaPage bombaPage;
    private MaximumPage maximumPage;
    public BrowserSteps(TestContext context) {
        this.context = context;
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("User choose browser {string}")
    public void userLoadBrowser(String browser) {
        context.initializeDriver(browser);
        this.driver = context.getDriver();
    }

    @When("^User choose site (.*)$")
    public void userChooseSite(String site) {
        switch (site.toLowerCase()) {
            case "bomba":
                currentPage = new BombaPage(context);
                break;
            case "maximum":
                currentPage = new MaximumPage(context);
                break;
            default:
                throw new IllegalArgumentException("Unknown site: " + site);
        }
    }

    @When("User load page {string}")
    public void userNavigateURL(String url) {
        driver.get(url);
    }

    @When("^I type in the search box word '(.*)'$")
    public void navigateToSite(String forSearchString) {
        driver = context.getDriver();
        bombaPage = new BombaPage(context);
        bombaPage.searching(forSearchString);
    }

    @Then("^I am on the searching page (.*)$")
    public void isSearchPage(String searchingWord) {
//        String searchingWord = Serenity.sessionVariableCalled("searchingKey");
        Assertions.assertThat(currentPage.isOnSearchingPage(searchingWord, context)).isEqualTo(true);
    }

    @Then("Page is loaded")
    public void pageIsLoaded() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assert driver.getTitle() != null;
    }
    @When("^User is looking '(.*)' on site '(.*)'$")
    public void userIsLooking (String query, String site) {
        switch (site.toLowerCase()) {
            case "bomba":
                currentPage = new BombaPage(context);
                break;
            case "maximum":
                currentPage = new MaximumPage(context);
                break;
            default:
                throw new IllegalArgumentException("Неизвестный сайт: " + site);
        }
        currentPage.searching(query);
    }
}
