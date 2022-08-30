package pages;

import helper.action.Action;
import helper.assertion.VerificationHelper;
import helper.logger.LoggerHelper;
import helper.wait.WaitHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.datarepo;

import java.io.IOException;

public class AccountLoginPage extends BasePage {
    public static Logger log = LoggerHelper.getLogger(AccountLoginPage.class);
    Action act = new Action();
    WaitHelper waitHelper;
    public AccountLoginPage() throws IOException {
    super();
    }

    @FindBy(id = "loginFrm_loginname")
    public WebElement loginNameTxtField;
    @FindBy(css = "#loginFrm_password")
    public WebElement passwordTxtField;
    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/fieldset[1]/button[1]")
    public WebElement loginBtn;

    // successful Login Variables declaration //
    @FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div/div/div[1]")
    public WebElement loginWithBlanksCredentialsTxt;

    @FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div/div/div[1]/text()")
    public WebElement loginWithBadPasswordTxt;
    @FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div/div/div[1]")
    public WebElement errorIncorrectLoginOrPasswordProvidedTxt;

    // Registration Variables declaration //

    @FindBy(xpath = "//div[contains(text(),'By creating an account you will be able to shop fa')]")
    public WebElement createAnAccountTxt;
    @FindBy(xpath = "//h2[contains(text(),'Returning Customer')]")
    public WebElement returningCustomerTxt;
    @FindBy(xpath = "//a[contains(text(),'Forgot your passwordErrorTxt?')]")
    public WebElement forgotYourPasswordLink;

    // Unsuccessful Login attempts Variables declaration //
    @FindBy(xpath = "//a[contains(text(),'Forgot your Login?')]")
    public WebElement forgotYourLoginLink;

    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/fieldset[1]/div[1]/label[1]")
    public WebElement registerAccountCheckBoxTxt;

    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/fieldset[1]/button[1]")
    public WebElement continueRegisterAccountBtn;

    @FindBy(xpath = "//h2[contains(text(),'I am a new customer.')]")
    public WebElement newCustomerTxt;
    @FindBy(id = "accountFrm_accountguest")
    public WebElement guestCheckoutRadioBtn;
    public boolean validateGuestCheckoutRadioBtnIsEnabled() {
        return new VerificationHelper(getDriver()).isEnabled(guestCheckoutRadioBtn);
    }

    // Forget Password Variable declaration //

    @FindBy(xpath = "//*[@id='email_create']")
    public WebElement registrationEmailAddress;

    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/fieldset[1]/button[1]")
    public WebElement registerAccountContinueBtn;


    public void enterLoginName(String LoginName) throws Exception {
        log.info("Sent data to the element: " + LoginName);
        sendKeysToWebElement(loginNameTxtField,LoginName);
    }
    public void enterPassword(String Password) throws Exception {
        sendKeysToWebElement(passwordTxtField, Password);
    }
    public AccountPage clickOnLoginBtn() throws IOException, InterruptedException {
        waitAndClickElement(loginBtn);
        return new AccountPage();
    }
    public AccountLoginPage clickOnLoginButton() throws InterruptedException, IOException {
        waitAndClickElement(loginBtn);
        log.info("Waited and clicked on the element...");
        return new AccountLoginPage();
    }
    public boolean validateLoginBtnIsEnabled() {
        return new VerificationHelper(getDriver()).isEnabled(loginBtn);
    }

    public void goToLoginPageEnterLoginNameAndPasswordThenClickOnLoginBtn(String loginName, String password) throws Exception {
        enterLoginName(loginName);
        enterPassword(password);
        clickOnLoginBtn();
        log.info("Successfully logged in....");
    }
    public void clickForgetYourLogin() {
        waitForWebElementAndClick(forgotYourLoginLink);
    }
    public void clickForgetYourPassword() {
       waitForWebElementAndClick(forgotYourPasswordLink);
    }
    public String getForgotYourPasswordTxtLink() {
        return new VerificationHelper(getDriver()).getText(forgotYourPasswordLink);
    }
    public String getForgotYourLogin() {
        return new VerificationHelper(getDriver()).getText(forgotYourLoginLink);
    }
    public String errorIncorrectLoginPasswordProvidedConfirmationMessage(String loginValidationErrorMessage) {
        return new VerificationHelper(getDriver()).getText(errorIncorrectLoginOrPasswordProvidedTxt);

    }
    public String validateErrorIncorrectLoginPasswordProvidedConfirmationMessage() {
        return new VerificationHelper(getDriver()).getText(errorIncorrectLoginOrPasswordProvidedTxt);
    }
    public String currentPageTitle(String pageTitle) {
        return new VerificationHelper(getDriver()).getTitle();
    }
  public boolean verifyReturningCustomerTxtIsDisplayed(String arg1) {
      return new VerificationHelper(getDriver()).isDisplayed(returningCustomerTxt);
  }
    public boolean verifyRegisterAccountTextCheckBoxIsDisplayed() {
        return new VerificationHelper(getDriver()).isDisplayed(registerAccountCheckBoxTxt);
    }
    public boolean validateNewCustomerTxtIsDisplayed(String arg0) {
        return new VerificationHelper(getDriver()).isDisplayed(newCustomerTxt);
    }
    public AccountCreatePage clickOnContinueRegisterAccountBtn() throws IOException, InterruptedException {
        waitAndClickElementUsingJS(continueRegisterAccountBtn);
        log.info("clicked and waited for element on returning to AccountSuccessPage...");
        return new AccountCreatePage();
    }
    public String getCreateAnAccountTxt() {
        return new VerificationHelper(getDriver()).getText(createAnAccountTxt);

    }


}
