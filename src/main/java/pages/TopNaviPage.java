package pages;

import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.datarepo;

import java.io.IOException;

public class TopNaviPage extends BasePage {
    public static Logger log = LoggerHelper.getLogger(TopNaviPage.class);
    public TopNaviPage() throws IOException {
        super();
    }

    public final String URL = datarepo.BASE_URL;

    @FindBy(css = ".navbar-header.header-logo")
    public WebElement logoImage;

    @FindBy(xpath = "//a[contains(text(),'Login or register')]")
    public WebElement loginOrRegisterLink;

    @FindBy(xpath = "//*[@id='main_menu_top']/li[1]/a/span")
    public WebElement specialsLink;

    @FindBy(xpath = "//*[@id='main_menu_top']/li[2]/a/span")
    public WebElement accountLink;
    @FindBy(xpath = "//header/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]/span[1]")
    public WebElement accountCheckYourOrderLink;
    @FindBy(xpath = "//header/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/ul[1]/li[2]/ul[1]/li[2]/a[1]/span[1]")
    public WebElement accountLogoutLink;
    @FindBy(xpath = "//header/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/ul[1]/li[3]/a[1]/span[1]")
    public WebElement cartLink;
    @FindBy(xpath = "//header/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/ul[1]/li[4]/a[1]/span[1]")
    public WebElement checkoutLink;

    @FindBy(css = "#filter_keyword")
    public WebElement searchBox;
    @FindBy(css = ".button-in-search")
    public WebElement searchBtn;

    @FindBy(xpath = "//div[contains(text(),'Welcome back')]")
    public WebElement welcomeBackTxt;
    @FindBy(xpath = "//body[1]/div[1]/header[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/a[1]/span[1]")
    public WebElement currencyDropdown;
    @FindBy(xpath = "/html/body/div/header/div[2]/div/div[3]/ul/li")
    public WebElement itemsCartDropdown;
    @FindBy(xpath = "//header/div[1]/div[1]/div[1]/a[1]/img[1]")
    public WebElement accountIconImage;
    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[1]/a[1]")
    public WebElement accountStatusTxt;

    public void navigateToUrl(String string){
        navigateToIndexPage(string);
        log.info("navigate To IndexPage...");
    }

    public String V() {
        log.info("Gotten current Page Url...");
        return getCurrentURL();
    }
    public String currentPageTitle() throws InterruptedException {
        log.info("Gotten current Page title...");
        return getTitle();
    }
    public String loginOrRegisterLink() {
        log.info("Gotten element text..." + loginOrRegisterLink);
        return getText(loginOrRegisterLink);
    }

    public boolean loginOrRegisterBtnEnabled() {
        return act.isEnabled(getDriver(), loginOrRegisterLink);
    }
    public AccountLoginPage clickOnLoginRegisterBtn() throws IOException {
        AccountLoginPage accountLoginPage = new AccountLoginPage();
        waitForWebElementAndClick(loginOrRegisterLink);
        log.info("Waited and clicked on the element: "+ loginOrRegisterLink.getText());
        waitFor(accountLoginPage.createAnAccountTxt);
        log.info("Waited for element on AccountLoginPage");
        return new AccountLoginPage();
    }

    //************************************************//

    public void clickAndSelectProductCategoryAndEnterKeywordOnSearchBox(String keyword) throws Exception {
        waitForWebElementAndClick(searchBox);
        log.info("Waited and clicked on the element: "+ searchBox.getText());
        sendKeysToWebElement(searchBox, keyword);
        log.info("Sent data to element: "+ searchBox.getText());
    }
    public void clickOnSearchBox(){
        waitForWebElementAndClick(searchBox);
        log.info("Waited and clicked on the element: "+ searchBox.getText());
    }
    public void enterItemKeyword(String keyword) throws Exception {
        sendKeysToWebElement(searchBox, keyword);
        log.info("Sent keyword data to element:"  + searchBox.getText());
    }
    public SearchResultPage clickOnSearchBtn() throws IOException {
        waitForWebElementAndClick(searchBtn);
        log.info("Waited and clicked on the element: "+ searchBtn.getText());
        log.info("Returning to new SearchResultPage");
        return new SearchResultPage();
    }








}