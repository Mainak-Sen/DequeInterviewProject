package com.deque.interview.tests;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected static final URL scriptUrl = BaseTest.class.getResource("/axe.min.js");
    protected static final Logger LOGGER = LogManager.getLogger(BaseTest.class);

    //setup
    @BeforeSuite
    public void setupDriver() {
        //System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver());
        LOGGER.info("Successfully initialized driver session");
    }

    //teardown
    @AfterSuite
    public void quitDriver() {
        //not a good practice to use sleep,using this for demo purpose
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        getDriver().quit();
        LOGGER.info("Successfully quit driver session");
    }

    public static WebDriver getDriver() {
        return driver.get();
    }
}
