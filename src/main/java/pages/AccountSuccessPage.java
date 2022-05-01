package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.globalVars;

import java.io.IOException;

public class AccountSuccessPage extends BasePage {
    public AccountSuccessPage() throws IOException {
        super();
    }


    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/h2[1]/span[1]")
    public WebElement myAccountText;

    @FindBy(css = ".btn.btn-default.mr10")
    public WebElement continueAccountSuccessBtn;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[1]/div/h1")
    public WebElement accountHasBeenCreatedHeadingTxt;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[1]/div/div/section/p[2]")
    WebElement congratulationsYourNewAccountHasBeenSuccessfullyCreatedTxt;

    public boolean validateMyAccountTxtIsDisplayed() {
        waitFor(myAccountText);
        return act.isDisplayed(getDriver(), myAccountText);
    }

    public String getAccountHasBeenCreatedHeadingTxt() {
        waitHelper.waitForElement(accountHasBeenCreatedHeadingTxt,globalVars.getExplicitWait());
        return accountHasBeenCreatedHeadingTxt.getText();
    }
    public WebElement congratulationsYourNewAccountHasBeenSuccessfullyCreatedTxt() {
        act.fluentWait(getDriver(), accountHasBeenCreatedHeadingTxt, globalVars.getExplicitWait());
        return congratulationsYourNewAccountHasBeenSuccessfullyCreatedTxt;
    }

    public AccountPage clickOnContinueAccountSuccessBtn() throws IOException, InterruptedException {
        waitForWebElementAndClick(continueAccountSuccessBtn);
        return new AccountPage();
    }


}
