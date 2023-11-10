package com.example.framework.pages;

import com.example.framework.TestContext;

public interface WebPages  {
    public void searching(String forSearch);
    public boolean isOnSearchingPage(String forSearch, TestContext context);
    public boolean isElementIsDisplayed(TestContext context);

}