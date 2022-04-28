package pages;

import actiondriver.Action;
import drivers.DriverFactory;
import helper.assertion.AssertionHelper;
import helper.logger.LoggerHelper;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.globalVars;

import java.io.IOException;
import java.time.Duration;

public class BasePage extends DriverFactory {
    public static Logger log = LoggerHelper.getLogger(BasePage.class);
    public static WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(globalVars.DEFAULT_EXPLICIT_TIMEOUT));
    public static AssertionHelper assertionHelper = new AssertionHelper();
    Action act = new Action();

    public BasePage() throws IOException {
        PageFactory.initElements(getDriver(), this);
    }

    public static WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    public void navigateToIndexPage(String url) {
        log.info("navigate To IndexPage....: " +url);
        getDriver().get(url);
    }
    public void goToIndexPage(String Url) {
        log.info("navigating To Index Page....: " +Url);
        getDriver().get(Url);
    }
    public String getCurrentPageTitle(String arg1) throws InterruptedException {
        log.info("got current Page Title....: " +arg1);
        return getDriver().getTitle();
    }

    public String getCurrentPageUrl(String Url) throws InterruptedException {
        log.info("got current Page Url....: " + Url);
        return getDriver().getCurrentUrl();
    }

    public String getPageTitle() {
        log.info("page title is: " + getDriver().getTitle());
        return getDriver().getTitle();
    }

    public String generateRandomNumber(int length) {
        log.info("generating Random Number....: " +length);
        return RandomStringUtils.randomNumeric(length);
    }

    public String generateRandomString(int length) {
        log.info("generating Random String....: " +length);
        return RandomStringUtils.randomAlphabetic(length);
    }

    public void sendKeys(WebElement element, String textToType) {
        element.clear();
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToType);
        System.out.println("Waited and Entered text :" + textToType);
        log.info("Waited and Entered text :" + textToType);
    }

    public void waitFor(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        log.info("waited for....." +element.getText());
    }

    public void waitForWebElementAndClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        log.info("element clicked....." +element);
    }

    public boolean isDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            log.info("element is Displayed.." + element.getText());
            System.out.println("element is Displayed.." + element.getText());
            return true;
        } catch (Exception e) {
            log.error("element is not Displayed..", e.getCause());
            return false;
        }
    }

    public boolean isEnabled(WebElement element) {
        try {
            element.isEnabled();
            log.info("element is isEnabled.." + element.getText());
            System.out.println("element is isEnabled.." + element.getText());
            return true;
        } catch (Exception e) {
            log.error("element is not isEnabled..", e.getCause());
            return false;
        }
    }

    public boolean isNotDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            log.info("element is present.." + element.getText());
            System.out.println("element is present.." + element.getText());

            return false;
        } catch (Exception e) {
            log.error("element is not present..");
            System.out.println("element is not present..");
            return true;
        }

    }

}