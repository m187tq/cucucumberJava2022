package pages;

import helper.action.Action;
import helper.assertion.VerificationHelper;
import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class AccountSuccessPage extends BasePage {
    public static Logger log = LoggerHelper.getLogger(AccountSuccessPage.class);
    Action act = new Action();
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
        return new VerificationHelper(getDriver()).isDisplayed(myAccountText);

    }

    public String getAccountHasBeenCreatedHeadingTxt() {
        return new VerificationHelper(getDriver()).getText(accountHasBeenCreatedHeadingTxt);
    }
    public String congratulationsYourNewAccountHasBeenSuccessfullyCreatedTxt() {
        return new VerificationHelper(getDriver()).getText(congratulationsYourNewAccountHasBeenSuccessfullyCreatedTxt);
    }

    public AccountPage clickOnContinueAccountSuccessBtn() throws IOException, InterruptedException {
        waitForWebElementAndClick(continueAccountSuccessBtn);
        log.info("Clicked and returning new IndexPage...");
        return new AccountPage();
    }


}
