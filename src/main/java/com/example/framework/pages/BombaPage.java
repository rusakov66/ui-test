package com.example.framework.pages;

import com.example.framework.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class BombaPage implements WebPages {

    public BombaPage(TestContext context) {
        this.context = context;
        this.driver = context.getDriver();
        PageFactory.initElements(driver, this);
    }


    private WebDriver driver;

    private TestContext context;

    @FindBy(className = "title-3")
    public WebElement searchResults;

//    @FindBy(className = "item-product")
//    public List<WebElement> searchedResults;
    @FindBy(className = "search_word")
    public WebElement searchWord;

    public void searching(String forSearch) {
        searchWord.sendKeys(forSearch + "\n");
    }

    public boolean isOnSearchingPage(String forSearch, TestContext context) {
        this.driver = context.getDriver();

        if (driver.getTitle().contains("Magazin online de electrocasnice - BOMBA: televizoare, frigidere")) {
            return true;
        }
        return false;
    }

    public boolean isElementIsDisplayed(TestContext context) {
        this.driver = context.getDriver();
        List <WebElement> searchedResults = driver.findElements(By.className("item-product-in"));
//        List<String> elementList = new ArrayList<>();
//  class="js-content product__item  "
//        for (String elemen : elementList) {
//
//            elemen = searchedResults.getText();
//            elemen = searchedResults.


//        }
        System.out.println("2");
        return searchedResults.size() > 0;
    }

}
