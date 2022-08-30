package pages;

import drivers.DriverFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import utilities.datarepo;
import utils.globalVars;

import java.io.*;
import java.time.Duration;

public class BasePage extends DriverFactory {
    WebDriverWait wait;


    public BasePage() throws IOException {
        this.wait = new WebDriverWait(getDriver(), Duration.ofSeconds(datarepo.getFifteenSeconds()));
        PageFactory.initElements(getDriver(), this);
    }

    public static WebDriver getDriver() {
        return DriverFactory.getDriver();

    }

    public void navigateToIndexPage(String url) {
        System.out.println("navigate To IndexPage....: " + url);
        getDriver().get(url);
    }

    public void goToIndexPage(String Url) {
        System.out.println("navigating To Index Page....: " + Url);
        getDriver().get(Url);
    }

    public String getPageTitle() {
        System.out.println("page title is: " + getDriver().getTitle());
        return getDriver().getTitle();
    }

    public String generateRandomNumber(int length) {
        return RandomStringUtils.randomNumeric(length);

    }

    public String generateRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);

    }

    public void sendKeys(By by, String textToType) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(datarepo.getFifteenSeconds()));
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(textToType);
    }

    public void sendKeys(WebElement element, String textToType) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(datarepo.getFifteenSeconds()));
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToType);
    }

    public void waitFor(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(datarepo.getFifteenSeconds()));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public void waitFor(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(datarepo.getFifteenSeconds()));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForWebElementAndClick(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(datarepo.getFifteenSeconds()));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    public void waitForWebElementAndClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(datarepo.getFifteenSeconds()));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void waitForAlert_And_ValidateText(String text) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(datarepo.getFifteenSeconds()));
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
                System.out.println("Successfully clicked on the WebElement: " + "<" + element.toString() + ">");
                clicked = true;
            } catch (Exception e) {
                System.out.println("Unable to wait and click on WebElement, Exception: " + e.getMessage());
                Assert.fail("Unable to wait and click on the WebElement, using locator: " + "<" + element.toString() + ">");
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
            System.out.println("Successfully sent the following keys: " + textToSearchFor + ", to the following WebElement: " + "<" + list.toString() + ">");
        } catch (Exception e) {
            System.out.println("Unable to send the following keys: " + textToSearchFor + ", to the following WebElement: " + "<" + list.toString() + ">");
            Assert.fail("Unable to select the required text from the dropdown menu, Exception: " + e.getMessage());
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
        } catch (Exception e) {
            Assert.fail("Unable to send keys to WebElement, Exception: " + e.getMessage());
        }
    }

    public void waitAndClickElementUsingJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            js.executeScript("arguments[0].click();", element);
        } catch (StaleElementReferenceException elementUpdated) {
            WebElement staleElement = element;
            Boolean elementPresent = wait.until(ExpectedConditions.elementToBeClickable(staleElement)).isEnabled();
            if (elementPresent == true) {
                js.executeScript("arguments[0].click();", elementPresent);
            }
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to JS click on the WebElement, Exception: " + e.getMessage());
        }
    }


    public boolean WaitUntilWebElementIsVisible(WebElement element) {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            Assert.fail("WebElement is NOT visible, Exception: " + e.getMessage());
            return false;
        }
    }


    public String getCurrentURL() {
        try {
            String url = getDriver().getCurrentUrl();
            return url;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;

        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;

            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }

        } finally {
            is.close();
            os.close();
        }
    }

    public boolean isDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getText(WebElement element) {
        if (null == element) {
            return null;
        }
        boolean status = isDisplayed(element);
        if (status) {
            return element.getText();
        } else {
            return null;
        }
    }

    public String getTitle() {
        return getDriver().getTitle();
    }

    //=====================================================================//
    private WebDriverWait getWait(int timeOutInSeconds, int pollingEveryInMiliSec) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(datarepo.SIXTY_SECONDS));
        wait.pollingEvery(Duration.ofMillis(pollingEveryInMiliSec));
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(ElementNotVisibleException.class);
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(NoSuchFrameException.class);
        return wait;
    }

    private Wait<WebDriver> getfluentWait(int timeOutInSeconds, Duration pollingEveryInMiliSec) {
        Wait<WebDriver> fWait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofMillis(250)).ignoring(NoSuchElementException.class);
        return fWait;
    }

    public static boolean selectByVisibleText(String visibletext, WebElement ele) {
        boolean flag = false;
        try {
            Select s = new Select(ele);
            fluentWait(getDriver(), ele, 15);
            s.selectByVisibleText(visibletext);
            flag = true;
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (flag) {
                System.out.println("Option selected by VisibleText: " + "<" + visibletext + ">");
            } else {
                System.out.println("Option not selected by VisibleText");
            }
        }
    }

    public static void fluentWait(WebDriver driver, WebElement element, int timeOut) {
        Wait<WebDriver> wait = null;
        try {
            wait = new FluentWait<WebDriver>((WebDriver) driver)
                    .withTimeout(Duration.ofSeconds(20))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(Exception.class);
            wait.until(ExpectedConditions.visibilityOf(element));
            element.click();
        } catch (Exception e) {
        }
    }

    public static void sleep(long msec, String info) {
        if (info != null) {
            System.out.println("Waiting " + (msec * .001) + " seconds :: " + info);
        }
        try {
            Thread.sleep(msec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void click(WebDriver driver, WebElement ele) {
        Actions act = new Actions(driver);
        System.out.println("clicking on the element....: " + ele.getText());
        act.moveToElement(ele).click().build().perform();
    }

    public static boolean findElement(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            ele.isDisplayed();

            flag = true;
        } catch (Exception e) {

            flag = false;
        } finally {
            if (flag) {
                System.out.println("Successfully Found element as :" + ele.getText());
            } else {
                System.out.println("Unable to locate element at");
            }
        }
        return flag;
    }

    public static boolean isDisplayed(WebDriver driver, WebElement ele) {
        boolean flag = false;
        flag = findElement(driver, ele);
        if (flag) {
            flag = ele.isDisplayed();
            if (flag) {
                System.out.println("The element is Displayed as:  " + "<" + ele.getText() + ">");
            } else {
                System.out.println("The element is not Displayed");
            }
        } else {
            System.out.println("Not displayed: " + ele.getText());
        }
        return flag;
    }

    public static boolean isSelected(WebDriver driver, WebElement ele) {

        boolean flag = false;
        flag = findElement(driver, ele);
        if (flag) {
            flag = ele.isSelected();
            if (flag) {
                System.out.println("The element is Selected:  " + "<" + ele + ">");
            } else {
                System.out.println("The element is not Selected");
            }
        } else {
            System.out.println("Not selected ");
        }
        return flag;
    }


}