package com.saucedemoTest.tests;

import com.saucedemoTest.base.BaseTest;
import com.saucedemoTest.data.TestData;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.ConfigReader;

@Listeners({AllureTestNg.class})
public class NavigationTest extends BaseTest {

    @Test(description = "TC-01 Open Base URL")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Navigation")
    public void testOpenBaseURL() {
        String expectedURL = ConfigReader.get("base.url");
        String expectedTitle = TestData.BASE_URL_TITLE;

        final String actualURL = getDriver().getCurrentUrl();
        final String actualTitle = getDriver().getTitle();

        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
