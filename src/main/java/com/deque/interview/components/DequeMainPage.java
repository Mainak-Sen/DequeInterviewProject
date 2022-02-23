package com.deque.interview.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class DequeMainPage {

    private WebDriver driver;

    @FindBy(id = "main-nav")
    private WebElement mainNavigationBar;

    @FindBy(xpath = "//input[@name='widget-type']")
    private List<WebElement> adventureRadioButtons;

    @FindBy(css = "a.add-traveler")
    private WebElement addTravellerButton;

    @FindBy(id = "traveler0")
    private WebElement firstTraveller;

    @FindBy(id = "traveler1")
    private WebElement SecondTraveller;

    @FindBy(id = "video-text")
    private WebElement videoText;

    @FindBy(css = ".vid-next")
    private WebElement videoNextButton;

    public DequeMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void goTo(String url) {
        this.driver.get(url);
    }

    public boolean isNavigationBarDisplayed() {
        return this.mainNavigationBar.isDisplayed();
    }

    public List<WebElement> getAdventureRadioButtons() {
        return adventureRadioButtons;
    }

    public void clickAddTravellerButton() {
        this.addTravellerButton.click();
    }

    public boolean isSecondTravellerDisplayed() {
        return this.SecondTraveller.isDisplayed();
    }

    public String getVideoText() {
        return this.videoText.getText();
    }

    public void clickVideoNext() {
        this.videoNextButton.click();
    }


}
