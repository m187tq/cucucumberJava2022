package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.globalVars;

import java.io.IOException;

public class AccountLogoutPage extends BasePage {
    public AccountLogoutPage() throws IOException {
        super();
    }

    @FindBy(xpath = "//p[contains(text(),'You have been logged off your account. It is now s')]")
    public WebElement saveToLogoutTxt;

    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/section[1]/a[1]")
    public WebElement logoutAccountContinueBtn;

    @FindBy(css = ".heading1")
    public WebElement accountLogoutTxt;

    public boolean validateSuccessfulLogOffProcess() throws InterruptedException {
        return act.isDisplayed(getDriver(), saveToLogoutTxt);
    }

    public boolean validateAccountLogoutTxtIsDisplayed() {
        return act.isDisplayed(getDriver(), accountLogoutTxt);
    }

    public String getCurrentUrl() throws InterruptedException {
        return getDriver().getCurrentUrl();
    }
    public IndexPage clickOnLogoutContinueButton() throws IOException {
        IndexPage indexPage = new IndexPage();
        act.explicitWait(getDriver(), logoutAccountContinueBtn, globalVars.getDefaultExplicitTimeout());
        waitAndClickElement(logoutAccountContinueBtn);
        act.fluentWait(getDriver(), indexPage.logoImage, globalVars.getDefaultExplicitTimeout());
        return new IndexPage();

    }
    public boolean validateLogoutContinueBtnIsDisplayed() {
        act.explicitWait(getDriver(), logoutAccountContinueBtn, globalVars.getDefaultExplicitTimeout());
        return act.isDisplayed(getDriver(), logoutAccountContinueBtn);
    }


}
