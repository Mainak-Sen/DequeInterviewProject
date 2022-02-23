package com.deque.interview.tests;

import com.deque.axe.AXE;
import com.deque.interview.components.DequeMainPage;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.ConfigLoader;
import utils.DataLoader;

public class DequeUniversityTest extends BaseTest {

    private DequeMainPage dequeMainPage;


    @BeforeTest
    public void setUpPagesAndOpenDequeHomePage() {
        dequeMainPage = new DequeMainPage(getDriver());
        dequeMainPage.goTo(ConfigLoader.getInstance().getUrl());

    }

    @Test
    public void testIfNavigationBarIsDisplayed() {
        Assert.assertTrue(this.dequeMainPage.isNavigationBarDisplayed());
    }

    @Test
    public void testNumberOfRadioButtonsUnderLetTheAdventureBegin() {
        Assert.assertEquals(this.dequeMainPage.getAdventureRadioButtons().size(), DataLoader.getInstance().getexpectedRadioButtonCountUnderLetTheAdventureBegin());
    }

    @Test
    public void testIfClickingOnAddTravellerAddsAnotherSelectToThePage() {

        this.dequeMainPage.clickAddTravellerButton();

        Assert.assertTrue(this.dequeMainPage.isSecondTravellerDisplayed());
    }

    @Test
    public void testIfVideoTextChangesIfNextButtonIsClicked() {

        String firstText = this.dequeMainPage.getVideoText();
        Assert.assertEquals(firstText, DataLoader.getInstance().getFirstVideoText());

        this.dequeMainPage.clickVideoNext();
        Assert.assertEquals(this.dequeMainPage.getVideoText(), DataLoader.getInstance().getUpdatedVideoText());
    }

    @Test
    public void testAccessibilityDequeUniversity() {

        JSONObject jsonResponse = new AXE.Builder(getDriver(), scriptUrl).analyze();
        JSONArray violations = jsonResponse.getJSONArray("violations");

        if (violations.length() == 0) {
            LOGGER.info("No accessibility violations found!!! ");
        } else {
            LOGGER.error(violations.length() + " accessibility violations found!!! ");
            AXE.writeResults("testAccessibilityDequeUniversity", jsonResponse);
            Assert.assertTrue(false, AXE.report(violations));
        }
    }


}
