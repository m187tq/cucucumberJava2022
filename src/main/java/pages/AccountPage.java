package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.globalVars;

import java.io.IOException;
import java.util.List;

public class AccountPage extends BasePage {
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
        waitFor(accountDashboardTxt);
        return act.isDisplayed(getDriver(),accountDashboardTxt);
    }

    public AccountLogoutPage clickOnLogoffBtn() throws IOException {
        waitFor(logoffBtn);
        waitForWebElementAndClick(logoffBtn);
        return new AccountLogoutPage();
    }

    public boolean isLogoffBtnDisplayed() {
        return act.isDisplayed(getDriver(), logoffBtn);
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
        waitFor(myAccountTxt);
        Thread.sleep(2000);
        return act.isDisplayed(getDriver(), myAccountTxt);
    }

    public String userProfileInfoMessage() {
        waitFor(userProfileMyAccountTxt);
        return userProfileMyAccountTxt.getText();
    }
    public boolean homePageWelcomeMessage(String arg1) throws InterruptedException {
        //act.fluentWait(getDriver(), welcomeBackTxt, globalVars.getDefaultExplicitTimeout());
        Thread.sleep(5000);
        return act.isDisplayed(getDriver(), welcomeBackTxt);
    }

    public boolean accountDashboardMessage() {
        return act.getText(getDriver(), accountDashboardTxt);
    }

    public void clickOnLogoutBtn() {
        waitFor(logout);
        act.click(getDriver(), logout);
    }

    public AccountEditPage clickOnEditAccountDetailsLink() throws IOException {
        waitFor(editAccountDetailsLink);
        act.click(getDriver(), editAccountDetailsLink);
        return new AccountEditPage();

    }

    public String accountProfileSuccessfulUpdateMessage() {
        act.explicitWait(getDriver(), successYourAccountSuccessfullyUpdatedTxt, globalVars.getExplicitWait());
        //waitFor(successYourAccountSuccessfullyUpdatedTxt);
        return successYourAccountSuccessfullyUpdatedTxt.getText();

    }

}