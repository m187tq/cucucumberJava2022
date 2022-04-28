package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.globalVars;

import java.io.IOException;
import java.time.Duration;

public class AccountLoginPage extends BasePage {
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

    public String getCreateAnAccountTxt() {
        return createAnAccountTxt.getText();
    }


    // Forget Password Variable declaration //

    @FindBy(xpath = "//*[@id='email_create']")
    public WebElement registrationEmailAddress;

    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/fieldset[1]/button[1]")
    public WebElement registerAccountContinueBtn;


    public void enterLoginName(String LoginName) {
        act.type(loginNameTxtField,LoginName);
    }
    public void enterPassword(String Password) {
        //sendKeys(passwordTxtField, Password);
        act.type(passwordTxtField, Password);
    }
    public AccountPage clickOnLoginBtn() throws IOException, InterruptedException {
        act.click(getDriver(), loginBtn);
        Thread.sleep(2000);
        return new AccountPage();
    }

    public void clickOnLoginButton() throws InterruptedException, IOException {
        act.click(getDriver(), loginBtn);
        Thread.sleep(2000);
    }

    public boolean isLoginBtnEnabled() {
        return act.isEnabled(getDriver(), loginBtn);
    }

    public void goToLoginPageEnterLoginNameAndPasswordThenClickOnLoginBtn(String loginName, String password) throws Exception {
        enterLoginName(loginName);
        enterPassword(password);
        clickOnLoginBtn();
    }

    public void clickForgetYourLogin() {
        waitForWebElementAndClick(forgotYourLoginLink);
    }

    public void clickForgetYourPassword() {
       waitForWebElementAndClick(forgotYourPasswordLink);
    }

    public boolean verifyForgotYourPasswordTxtLink() {
        return act.isDisplayed(getDriver(), forgotYourPasswordLink);
    }

    public boolean verifyingForgotYourLogin() {
        return act.isDisplayed(getDriver(),forgotYourLoginLink);
    }

    public String errorIncorrectLoginPasswordProvidedConfirmationMessage(String loginValidationErrorMessage) {
        return errorIncorrectLoginOrPasswordProvidedTxt.getText();
    }

    public boolean validateErrorIncorrectLoginPasswordProvidedConfirmationMessage() {
        waitFor(errorIncorrectLoginOrPasswordProvidedTxt);
        return act.isDisplayed(getDriver(), errorIncorrectLoginOrPasswordProvidedTxt);
    }
    public String currentPageTitle(String pageTitle) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(globalVars.DEFAULT_EXPLICIT_TIMEOUT));
        this.wait.until(ExpectedConditions.visibilityOf(errorIncorrectLoginOrPasswordProvidedTxt));
        return getDriver().getTitle();
    }


  public boolean verifyReturningCustomerTxtIsDisplayed(String arg1) {
      return  act.isDisplayed(getDriver(), returningCustomerTxt);
  }

    public boolean verifyRegisterAccountTextCheckBoxIsDisplayed() {
        return act.isDisplayed(getDriver(), registerAccountCheckBoxTxt);
    }

    public boolean validateNewCustomerTxtIsDisplayed(String arg0) {
        return act.isDisplayed(getDriver(),newCustomerTxt);
    }

    public AccountCreatePage clickOnContinueRegisterAccountBtn() throws IOException, InterruptedException {
        act.click(getDriver(), continueRegisterAccountBtn);
        AccountCreatePage acp = new AccountCreatePage();
        act.fluentWait(getDriver(), acp.createAccountTxt, globalVars.getDefaultExplicitTimeout());
        return new AccountCreatePage();
    }


}
