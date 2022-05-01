package pages;

import actiondriver.Action;
import drivers.DriverFactory;
import helper.assertion.AssertionHelper;
import helper.logger.LoggerHelper;
import helper.wait.WaitHelper;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.datarepo;
import utils.globalVars;

import java.awt.*;
import java.io.*;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BasePage extends DriverFactory {
    public static Logger log = LoggerHelper.getLogger(BasePage.class);
    public static WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(globalVars.explicitWait));
    public static AssertionHelper assertionHelper = new AssertionHelper();
    public static WaitHelper waitHelper = new WaitHelper(getDriver());

    public static Action act = new Action();

    public BasePage() throws IOException {
        PageFactory.initElements(getDriver(), this);
    }

    public static WebDriver getDriver() {
        return DriverFactory.getDriver();

    }
    public void navigateToIndexPage(String url) {
        // log.info("navigate To IndexPage....: " +url);
        getDriver().get(url);
    }
    public void goToIndexPage(String Url) {
        // log.info("navigating To Index Page....: " +Url);
        getDriver().get(Url);
    }
    public String getCurrentPageTitle(String arg1) throws InterruptedException {
        // log.info("got current Page Title....: " +arg1);
        return getDriver().getTitle();
    }
    public String getCurrentPageUrl(String Url) throws InterruptedException {
        // log.info("got current Page Url....: " + Url);
        return getDriver().getCurrentUrl();
    }
    public String getPageTitle() {
        // log.info("page title is: " + getDriver().getTitle());
        return getDriver().getTitle();
    }
    public String generateRandomNumber(int length) {
        return RandomStringUtils.randomNumeric(length);

    }
    public String generateRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);

    }
    public void sendKeys(By by, String textToType) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(textToType);
    }
    public void sendKeys(WebElement element, String textToType) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToType);
    }
    public void waitFor(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }
    public void waitFor(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForWebElementAndClick(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }
    public void waitForWebElementAndClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public void waitForAlert_And_ValidateText(String text) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        String alert_Message_Text = getDriver().switchTo().alert().getText();
        Assert.assertEquals(alert_Message_Text, text);
    }

    /**********************************************************************************
     **CLICK METHODS
     **********************************************************************************/
    public void waitAndClickElement(WebElement element) {
        boolean clicked = false;
        int attempts = 0;
        while (!clicked && attempts < 10) {
            try {
                this.wait.until(ExpectedConditions.elementToBeClickable(element)).click();
                // log.info("Successfully clicked on the WebElement: " + "<" + element.toString() + ">");
                clicked = true;
            } catch (Exception e) {
                // log.info("Unable to wait and click on WebElement, Exception: " + e.getMessage());
                Assert.fail("Unable to wait and click on the WebElement, using locator: " + "<" + element.toString() + ">");
            }
            attempts++;
        }
    }

    public void waitAndClickElementsUsingByLocator(By by) throws InterruptedException {
        boolean clicked = false;
        int attempts = 0;
        while (!clicked && attempts < 10) {
            try {
                this.wait.until(ExpectedConditions.elementToBeClickable(by)).click();
                // log.info("Successfully clicked on the element using by locator: " + "<" + by.toString() + ">");
                clicked = true;
            } catch (Exception e) {
                // log.info("Unable to wait and click on the element using the By locator, Exception: " + e.getMessage());
                Assert.fail("Unable to wait and click on the element using the By locator, element: " + "<"+ by.toString() + ">");
            }
            attempts++;
        }
    }

    public void clickOnTextFromDropdownList(WebElement list, String textToSearchFor) throws Exception {
        Wait<WebDriver> tempWait = new WebDriverWait(getDriver(), Duration.ofSeconds(globalVars.getExplicitWait()));
        try {
            tempWait.until(ExpectedConditions.elementToBeClickable(list)).click();
            list.sendKeys(textToSearchFor);
            list.sendKeys(Keys.ENTER);
            // log.info("Successfully sent the following keys: " + textToSearchFor + ", to the following WebElement: " + "<" + list.toString() + ">");
        } catch (Exception e) {
            // log.info("Unable to send the following keys: " + textToSearchFor + ", to the following WebElement: " + "<" + list.toString() + ">");
            Assert.fail("Unable to select the required text from the dropdown menu, Exception: " + e.getMessage());
        }
    }


    public void clickOnElementUsingCustomTimeout(WebElement locator, WebDriver driver, int timeout) {
        try {
            final WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(globalVars.getExplicitWait()));
            customWait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(locator)));
            locator.click();
            // log.info("Successfully clicked on the WebElement, using locator: " + "<" + locator + ">"+ ", using a custom Timeout of: " + timeout);
        } catch (Exception e) {
            // log.info("Unable to click on the WebElement, using locator: " + "<" + locator + ">" + ", using a custom Timeout of: " + timeout);
            Assert.fail("Unable to click on the WebElement, Exception: " + e.getMessage());
        }
    }
    /**********************************************************************************
     **ACTION METHODS
     **********************************************************************************/

    public void actionMoveAndClick(WebElement element) throws Exception {
        Actions ob = new Actions(getDriver());
        try {
            this.wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
            ob.moveToElement(element).click().build().perform();
            // log.info("Successfully Action Moved and Clicked on the WebElement, using locator: " + "<" + element.toString() + ">");
        } catch (StaleElementReferenceException elementUpdated) {
            WebElement elementToClick = element;
            Boolean elementPresent = wait.until(ExpectedConditions.elementToBeClickable(elementToClick)).isEnabled();
            if (elementPresent == true) {
                ob.moveToElement(elementToClick).click().build().perform();
                // log.info("(Stale Exception) - Successfully Action Moved and Clicked on the WebElement, using locator: " + "<" + element.toString() + ">");
            }
        } catch (Exception e) {
            // log.info("Unable to Action Move and Click on the WebElement, using locator: " + "<" + element.toString() + ">");
            Assert.fail("Unable to Action Move and Click on the WebElement, Exception: " + e.getMessage());
        }
    }

    public void actionMoveAndClickByLocator(By element) throws Exception {
        Actions ob = new Actions(getDriver());
        try {
            Boolean elementPresent = wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
            if (elementPresent == true) {
                WebElement elementToClick = getDriver().findElement(element);
                ob.moveToElement(elementToClick).click().build().perform();
                // log.info("Action moved and clicked on the following element, using By locator: " + "<" + element.toString() + ">");
            }
        } catch (StaleElementReferenceException elementUpdated) {
            WebElement elementToClick = getDriver().findElement(element);
            ob.moveToElement(elementToClick).click().build().perform();
            // log.info("(Stale Exception) - Action moved and clicked on the following element, using By locator: "+ "<" + element.toString() + ">");
        } catch (Exception e) {
            // log.info("Unable to Action Move and Click on the WebElement using by locator: " + "<" + element.toString() + ">");
            Assert.fail("Unable to Action Move and Click on the WebElement using by locator, Exception: " + e.getMessage());
        }
    }

    /**********************************************************************************
     **SEND KEYS METHODS /
     **********************************************************************************/
    public void sendKeysToWebElement(WebElement element, String textToSend) throws Exception {
        try {
            this.WaitUntilWebElementIsVisible(element);
            element.clear();
            element.sendKeys(textToSend);
            // log.info("Successfully Sent the following keys: '" + textToSend + "' to element: " + "<"+ element.toString() + ">");
        } catch (Exception e) {
            // log.info("Unable to locate WebElement: " + "<" + element.toString() + "> and send the following keys: " + textToSend);
            Assert.fail("Unable to send keys to WebElement, Exception: " + e.getMessage());
        }
    }
    /**********************************************************************************
     **JS METHODS & JS SCROLL
     **********************************************************************************/
    public void scrollToElementByWebElementLocator(WebElement element) {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(element)).isEnabled();
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", element);
            ((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0, -400)");
            // log.info("Succesfully scrolled to the WebElement, using locator: " + "<" + element.toString() + ">");
        } catch (Exception e) {
            // log.info("Unable to scroll to the WebElement, using locator: " + "<" + element.toString() + ">");
            Assert.fail("Unable to scroll to the WebElement, Exception: " + e.getMessage());
        }
    }

    public void jsPageScroll(int numb1, int numb2) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("scroll(" + numb1 + "," + numb2 + ")");
            // log.info("Succesfully scrolled to the correct position! using locators: " + numb1 + ", " + numb2);
        } catch (Exception e) {
            // log.info("Unable to scroll to element using locators: " + "<" + numb1 + "> " + " <" + numb2 + ">");
            Assert.fail("Unable to manually scroll to WebElement, Exception: " + e.getMessage());
        }
    }

    public void waitAndclickElementUsingJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            js.executeScript("arguments[0].click();", element);
            // log.info("Successfully JS clicked on the following WebElement: " + "<" + element.toString() + ">");
        } catch (StaleElementReferenceException elementUpdated) {
            WebElement staleElement = element;
            Boolean elementPresent = wait.until(ExpectedConditions.elementToBeClickable(staleElement)).isEnabled();
            if (elementPresent == true) {
                js.executeScript("arguments[0].click();", elementPresent);
                // log.info("(Stale Exception) Successfully JS clicked on the following WebElement: " + "<" + element.toString() + ">");
            }
        } catch (NoSuchElementException e) {
            // log.info("Unable to JS click on the following WebElement: " + "<" + element.toString() + ">");
            Assert.fail("Unable to JS click on the WebElement, Exception: " + e.getMessage());
        }
    }

    public void jsClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", element);
    }
    /**********************************************************************************
     **WAIT METHODS
     **********************************************************************************/
    public boolean WaitUntilWebElementIsVisible(WebElement element) {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(element));
            // log.info("WebElement is visible using locator: " + "<" + element.toString() + ">");
            return true;
        } catch (Exception e) {
            // log.info("WebElement is NOT visible, using locator: " + "<" + element.toString() + ">");
            Assert.fail("WebElement is NOT visible, Exception: " + e.getMessage());
            return false;
        }
    }

    public boolean WaitUntilWebElementIsVisibleUsingByLocator(By element) {
        try {
            this.wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            // log.info("Element is visible using By locator: " + "<" + element.toString() + ">");
            return true;
        } catch (Exception e) {
            // log.info("WebElement is NOT visible, using By locator: " + "<" + element.toString() + ">");
            Assert.fail("WebElement is NOT visible, Exception: " + e.getMessage());
            return false;
        }
    }

    public boolean isElementClickable(WebElement element) {
        try {
            this.wait.until(ExpectedConditions.elementToBeClickable(element));
            // log.info("WebElement is clickable using locator: " + "<" + element.toString() + ">");
            return true;
        } catch (Exception e) {
            // log.info("WebElement is NOT clickable using locator: " + "<" + element.toString() + ">");
            return false;
        }
    }

    public boolean waitUntilPreLoadElementDissapears(By element) {
        return this.wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    /**********************************************************************************
     **PAGE METHODS
     **********************************************************************************/
    public BasePage loadUrl(String url) throws Exception {
        getDriver().get(url);
        return new BasePage();
    }

    public String getCurrentURL() {
        try {
            String url = getDriver().getCurrentUrl();
            // log.info("Found(Got) the following URL: " + url);
            return url;
        } catch (Exception e) {
            // log.info("Unable to locate (Get) the current URL, Exception: " + e.getMessage());
            return e.getMessage();
        }
    }

    public String waitForSpecificPage(String urlToWaitFor) {
        try {
            String url = getDriver().getCurrentUrl();
            this.wait.until(ExpectedConditions.urlMatches(urlToWaitFor));
            // log.info("The current URL was: " + url + ", " + "navigated and waited for the following URL: "+ urlToWaitFor);
            return urlToWaitFor;
        } catch (Exception e) {
            // log.info("Exception! waiting for the URL: " + urlToWaitFor + ",  Exception: " + e.getMessage());
            return e.getMessage();
        }
    }

    /**********************************************************************************/
    /**********************************************************************************/


    /**********************************************************************************
     **ALERT & POPUPS METHODS
     **********************************************************************************/

    public boolean checkPopupIsVisible() {
        try {
            @SuppressWarnings("unused")
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            // log.info("A popup has been found!");
            return true;
        } catch (Exception e) {
            System.err.println("Error came while waiting for the alert popup to appear. " + e.getMessage());
        }
        return false;
    }

    public boolean isAlertPresent() {
        try {
            getDriver().switchTo().alert();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void closeAlertPopupBox() throws AWTException, InterruptedException {
        try {
            Alert alert = this.wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
        } catch (UnhandledAlertException f) {
            Alert alert = getDriver().switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            // log.info("Unable to close the popup");
            Assert.fail("Unable to close the popup, Exception: " + e.getMessage());
        }
    }

    /***EXTENT REPORT****************************************************************/
    public static String returnDateStamp(String fileExtension) {
        Date d = new Date();
        String date = d.toString().replace(":", "_").replace(" ", "_") + fileExtension;
        return date;
    }

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;

        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;

            while((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }

        } finally {
            is.close();
            os.close();
        }
    }

    public static void copyLatestExtentReport() throws IOException {
        Date d = new Date();
        String date = d.toString().replace(":", "_").replace(" ", "_");
        File source = new File(System.getProperty("user.dir") + "\\output\\report.html");
        File dest = new File(System.getProperty("user.dir") + "\\output\\" + date.toString() + ".html");
        copyFileUsingStream(source, dest);
    }



//=====================================================================//
// AssertionHelper
//=====================================================================//

    public static void verifyText(String s1, String s2){
        // log.info("veryfing test: "+ s1 + " with "+ s2);
        Assert.assertEquals(s1, s1);
    }

    public static void markPass(){
        // log.info("making script PASS..");
        Assert.assertTrue(true);
    }

    public static void markPass(String message){
        // log.info("making script PASS.."+ message);
        Assert.assertTrue(true, message);
    }

    public static void markFail(){
        // log.info("making script FAIL..");
        Assert.assertTrue(false);
    }

    public static void markFail(String message){
        // log.info("making script FAIL.."+message);
        Assert.assertTrue(false, message);
    }

    public static void verifyTrue(boolean status){
        Assert.assertTrue(status);
    }

    public static void verifyFalse(boolean status){
        Assert.assertFalse(status);
    }

    public static void verifyNull(String s1){
        // log.info("verify object is null..");
        Assert.assertNull(s1);
    }

    public static void verifyNotNull(String s1){
        // log.info("verify object is not null..");
        Assert.assertNotNull(s1);
    }

    public static void fail(){
        Assert.assertTrue(false);
    }

    public static void pass(){
        Assert.assertTrue(true);
    }

    public static void updateTestStatus(boolean status){
        if(status){
            pass();
        }
        else{
            fail();
        }
    }


//=====================================================================//
// VerificationHelper
//=====================================================================//

    public boolean isDisplayed(WebElement element){
        try{
            element.isDisplayed();
            // log.info("element is Displayed.."+element.getText());
            return true;
        }
        catch(Exception e){
            log.error("element is not Displayed..", e.getCause());
            return false;
        }
    }

    public boolean isEnabled(WebElement element){
        try{
            element.isEnabled();
            // log.info("element is Enabled.."+element.getText());
            return true;
        }
        catch(Exception e){
            log.error("element is not Enabled..", e.getCause());
            return false;
        }
    }


    public boolean isNotDisplayed(WebElement element){
        try{
            element.isDisplayed();
            // log.info("element is present.."+element.getText());
            return false;
        }
        catch(Exception e){
            log.error("element is not present..");
            return true;
        }
    }

    public String readValueFromElement(WebElement element){
        if(null == element){
            // log.info("WebElement is null..");
            return null;
        }
        boolean status = isDisplayed(element);
        if(status){
            // log.info("element text is .."+element.getText());
            return element.getText();
        }
        else{
            return null;
        }
    }
    public String getText(WebElement element){
        if(null == element){
            // log.info("WebElement is null..");
            return null;
        }
        boolean status = isDisplayed(element);
        if(status){
            // log.info("element text is .."+element.getText());
            return element.getText();
        }
        else{
            return null;
        }
    }

    public String getTitle(){
        // log.info("page title is: "+getDriver().getTitle());
        return getDriver().getTitle();
    }

//=====================================================================//

    public void setImplicitWait(long timeout, TimeUnit unit) {
        // log.info("Implicit Wait has been set to: " + timeout);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(datarepo.SIXTY_SECONDS));
    }

    /**
     * This will help us to get WebDriverWait object
     *
     * @param timeOutInSeconds
     * @param pollingEveryInMiliSec
     * @return
     */
    private WebDriverWait getWait(int timeOutInSeconds, int pollingEveryInMiliSec) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(datarepo.SIXTY_SECONDS));
        wait.pollingEvery(Duration.ofMillis(pollingEveryInMiliSec));
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(ElementNotVisibleException.class);
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(NoSuchFrameException.class);
        return wait;
    }

    /**
     * This method will make sure element is visible
     *
     * @param element
     * @param timeOutInSeconds
     * @param pollingEveryInMiliSec
     */
    public void WaitForElementVisibleWithPollingTime(WebElement element, int timeOutInSeconds,
                                                     int pollingEveryInMiliSec) {
        // log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
        WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
        wait.until(ExpectedConditions.visibilityOf(element));
        // log.info("element is visible now");
    }

    /**
     * This method will make sure elementToBeClickable
     *
     * @param element
     * @param timeOutInSeconds
     */
    public void WaitForElementClickable(WebElement element, int timeOutInSeconds) {
        // log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(datarepo.SIXTY_SECONDS));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        // log.info("element is clickable now");
    }

    /**
     * This method will make sure invisibilityOf element
     *
     * @param element
     * @param timeOutInSeconds
     * @return
     */
    public boolean waitForElementNotPresent(WebElement element, long timeOutInSeconds) {
        // log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(datarepo.SIXTY_SECONDS));
        boolean status = wait.until(ExpectedConditions.invisibilityOf(element));
        // log.info("element is invisibile now");
        return status;
    }

    /**
     * This method will wait for frameToBeAvailableAndSwitchToIt
     *
     * @param element
     * @param timeOutInSeconds
     */
    public void waitForframeToBeAvailableAndSwitchToIt(WebElement element, long timeOutInSeconds) {
        // log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(datarepo.SIXTY_SECONDS));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
        // log.info("frame is available and switched");
    }

    private Wait<WebDriver> getfluentWait(int timeOutInSeconds, Duration pollingEveryInMiliSec) {
        Wait<WebDriver> fWait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofMillis(250)).ignoring(NoSuchElementException.class);
        return fWait;
    }

    /**
     * @param element
     * @param timeOutInSeconds
     */
    public WebElement waitForElement(WebElement element, int timeOutInSeconds){
        Wait<WebDriver> fwait = getfluentWait(timeOutInSeconds, Duration.ofSeconds(60));
        fwait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public void pageLoadTime(long timeout, TimeUnit unit){
        // log.info("waiting for page to load for : "+ unit+ " seconds");
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(datarepo.SIXTY_SECONDS));
        // log.info("page is loaded");
    }

    public void clickOnLinkByText(String Text) {
        getDriver().findElement(By.linkText(Text)).click();
    }

}