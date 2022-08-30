package pages;

import helper.assertion.VerificationHelper;
import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.globalVars;

import java.io.IOException;
import java.util.List;

public class AccountPage extends BasePage {
    public static Logger log = LoggerHelper.getLogger(AccountPage.class);
    public AccountPage() throws IOException {
            super();
    }
    @FindBy(css = ".maintext")
    public WebElement userProfileMyAccountTxt;

    @FindBy(css = "h1.heading")
    public WebElement myAccountTxt;

    @FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div[2]/div[1]/div/ul/li[1]")
    public WebElement accountDashboardTxt;

    @FindBy(linkText = "Logoff")
    public WebElement logoffBtn;

    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[2]/div[1]")
    public List<WebElement> sideWidgetAccountDashboardLinks;

    @FindBy(css = "body.account-account:nth-child(2) div.container-fixed:nth-child(1) div.container-fluid div.column_right.col-md-3.col-xs-12.mt20 div.sidewidt div.myaccountbox ul.side_account_list li:nth-child(3) a:nth-child(1) > i.fa.fa-edit.fa-fw")
    public WebElement editAccountDetailsLink;

    @FindBy(id = "customer_menu_top")
    public WebElement welcomeBackTxt;

    @FindBy(linkText = "Logoff")
    public WebElement logout;

    @FindBy(css = ".alert.alert-success")
    public WebElement successYourAccountSuccessfullyUpdatedTxt;


    public boolean isAccountDashboardTxtDisplayed() {
        return new VerificationHelper(getDriver()).isDisplayed(accountDashboardTxt);
    }

    public AccountLogoutPage clickOnLogoffBtn() throws IOException {
        waitForWebElementAndClick(logoffBtn);
        return new AccountLogoutPage();
    }

    public boolean isLogoffBtnDisplayed() {
        return new VerificationHelper(getDriver()).isDisplayed(logoffBtn);
    }

    public void verifyAllSideWidgetElementsInAccountPageLinks() {
        List<WebElement> links = sideWidgetAccountDashboardLinks;
        for (int i = 0; i < links.size(); i = i++) {
            String listOfElements = links.get(i).getText();
            System.out.println("Size Of Side Widget List => " + links.size());
            log.info("Size Of Side Widget List => " + links.size());
            break;
        }

    }

    public void ClickOnLogOffLinkInSideWidgetList() {
        List<WebElement> ListSideWidget = getDriver().findElements(By.cssSelector(".side_account_list"));
        for (int i = 0; i < ListSideWidget.size(); i = i++) {
            String listName = ListSideWidget.get(i).getText();
            if (listName.contains("Logoff")) {
                getDriver().findElements(By.linkText("Logoff")).get(i).click();
                break;
            }

        }

    }

    public boolean validateUserAccountTextIsDisplayed() throws InterruptedException {
        fluentWait(getDriver(), myAccountTxt, globalVars.getDefaultExplicitTimeout());
        return new VerificationHelper(getDriver()).isDisplayed(myAccountTxt);
    }
    public String userProfileInfoMessage() {
        fluentWait(getDriver(), userProfileMyAccountTxt, globalVars.getDefaultExplicitTimeout());
        return new VerificationHelper(getDriver()).getText(userProfileMyAccountTxt);
    }
    public boolean homePageWelcomeMessage() throws InterruptedException {
        fluentWait(getDriver(), welcomeBackTxt, globalVars.getDefaultExplicitTimeout());
        return new VerificationHelper(getDriver()).isDisplayed(welcomeBackTxt);
    }

    public String accountDashboardMessage() {
        return new VerificationHelper(getDriver()).getText(accountDashboardTxt);
    }

    public void clickOnLogoutBtn() {
        fluentWait(getDriver(), userProfileMyAccountTxt, globalVars.getDefaultExplicitTimeout());
        waitAndClickElement(logout);
        log.info("Waited and clicked on the element...");
    }
    public AccountEditPage clickOnEditAccountDetailsLink() throws IOException, InterruptedException {
        fluentWait(getDriver(), editAccountDetailsLink, globalVars.getDefaultExplicitTimeout());
        waitAndClickElement(editAccountDetailsLink);
        return new AccountEditPage();

    }
    public String accountProfileSuccessfulUpdateMessage() {
        fluentWait(getDriver(), successYourAccountSuccessfullyUpdatedTxt, globalVars.getDefaultExplicitTimeout());
        return new VerificationHelper(getDriver()).getText(successYourAccountSuccessfullyUpdatedTxt);

    }

}