package pages;

import helper.action.Action;
import helper.assertion.VerificationHelper;
import helper.logger.LoggerHelper;
import helper.wait.WaitHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.datarepo;
import utils.globalVars;

import java.io.IOException;
import java.util.List;

public class AccountCreatePage extends BasePage {
    public static Logger log = LoggerHelper.getLogger(AccountCreatePage.class);
    Action act = new Action();
    AccountSuccessPage asPage = new AccountSuccessPage();
    String loginName = "covid19" + generateRandomString(5);
    String email = System.currentTimeMillis() + "Apr";

    public AccountCreatePage() throws IOException {
        super();
    }

    // URL, LOGO, TEXTS//
    public final String URL = "https://automationteststore.com/index.php?rt=account/create";
    @FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div[1]/div/h1/span[1]/text()")
    public WebElement yourAccountHasBeenCreatedTxt;
    @FindBy(xpath = "//a[contains(text(),'Register')]")
    public WebElement registerLinkText;
    @FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div/div/h1")
    public WebElement createAccountTxt;
    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/p[1]")
    public WebElement ifYouAlreadyHaveAnAccountWithUs;
    @FindBy(xpath = "//h4[contains(text(),'Your Personal Details')]")
    public WebElement yourPersonalDetailsTxt;
    @FindBy(xpath = "//input[@id='AccountFrm_firstname']")
    public WebElement firstNameTextBox;

    //**************Your Personal Details**************//
    @FindBy(xpath = "//input[@id='AccountFrm_lastname']")
    public WebElement lastNameTextBox;
    @FindBy(xpath = "//input[@id='AccountFrm_email']")
    public WebElement emailTextBox;
    @FindBy(xpath = "//input[@id='AccountFrm_telephone']")
    public WebElement telephoneTextBox;
    @FindBy(xpath = "//input[@id='AccountFrm_fax']")
    public WebElement faxTextBox;
    @FindBy(xpath = "//h4[contains(text(),'Your Address')]")
    public WebElement yourAddressText;
    @FindBy(css = "#AccountFrm_company")
    public WebElement companyTextBox;

    //**************Your Address*****************//
    @FindBy(css = "#AccountFrm_address_1")
    public WebElement address1TextBox;
    @FindBy(xpath = "//input[@id='AccountFrm_address_2']")
    public WebElement address2TextBox;
    @FindBy(css = "#AccountFrm_city")
    public WebElement cityTextBox;
    @FindBy(css = "select#AccountFrm_zone_id")
    public WebElement regionOrStateDropdownBtn;
    @FindBy(xpath = "//*[@id=\"AccountFrm_zone_id\"]/option[52]")
    public WebElement regionOrStateName;
    @FindBy(xpath = "//input[@id='AccountFrm_postcode']")
    public WebElement zipCodeTextBox;
    @FindBy(xpath = "//select[@id='AccountFrm_country_id']")
    public WebElement countryDropdownBtn;
    @FindBy(xpath = "//h4[contains(text(),'Login Details')]")
    public WebElement loginDetailsSectionText;
    @FindBy(css = "#AccountFrm_loginname")
    public WebElement loginNameTextBox;

    //**************Login Details**************//
    @FindBy(css = "#AccountFrm_password")
    public WebElement passwordTextBox;
    @FindBy(css = "#AccountFrm_confirm")
    public WebElement passwordConfirmTextBox;
    @FindBy(xpath = "//h4[contains(text(),'Newsletter')]")
    public WebElement newsletterText;
    @FindBy(css = "#AccountFrm_newsletter1")
    public WebElement subscribeYesRadioButton;

    //**************Newsletter**********************//
    @FindBy(css = "#AccountFrm_newsletter0")
    public WebElement subscribeNORadioButton;
    @FindBy(css = "#AccountFrm_agree")
    public WebElement agreeToPrivacyPolicyButton;
    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[5]/div[1]/label[1]")
    public WebElement agreeToPrivacyPolicyText;
    // Summit button //
    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[5]/div[1]/div[1]/button[1]")
    public WebElement continueBtn;


    //**********ERRORS ********************//
    @FindBy(css = "#AccountFrm_firstname")
    public WebElement firstNameErrorTxt;
    @FindBy(css = "#AccountFrm_lastname")
    public WebElement lastNameErrorTxt;
    @FindBy(css = "#AccountFrm_email")
    public WebElement emailErrorTxt;
    @FindBy(css = "#AccountFrm_address_1")
    public WebElement address1ErrorTxt;
    @FindBy(css = "#AccountFrm_city")
    public WebElement cityErrorTxt;
    @FindBy(css = "#AccountFrm_zone_id")
    public WebElement regionStateErrorTxt;
    @FindBy(css = "#AccountFrm_postcode")
    public WebElement zipCodeErrorTxt;
    @FindBy(css = "#AccountFrm_password")
    public WebElement passwordErrorTxt;
    @FindBy(xpath = "//b[contains(text(),'Privacy Policy')]")
    public WebElement privacyPolicyErrorTxt;
    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]")
    public WebElement youMustAgreeToThePrivacyPolicyErrorTxt;
    @FindBy(xpath = "//span[contains(text(),'')]")
    public List<WebElement> allHighlightedWarningRedMessageErrorTxt;
    @FindBy(xpath = "//span[contains(text(),'First Name must be between 1 and 32 characters!')]")
    public WebElement firstNameRedMessages;
    @FindBy(xpath = "//span[contains(text(),'Last Name must be between 1 and 32 characters!')]")
    public WebElement lastNameRedMessages;

    //**********RED WARNING MESSAGES**********//
    @FindBy(xpath = "//span[contains(text(),'Email Address does not appear to be valid!')]")
    public WebElement emailRedMessages;
    @FindBy(xpath = "//span[contains(text(),'Address 1 must be between 3 and 128 characters!')]")
    public WebElement address1RedMessages;
    @FindBy(xpath = "//span[contains(text(),'City must be between 3 and 128 characters!')]")
    public WebElement cityRedMessages;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/fieldset[1]/div[6]/span[1]")
    public WebElement zipCodeRedMessages;
    @FindBy(xpath = "//span[contains(text(),'Please select a region / state!')]")
    public WebElement stateProvinceRedMessages;
    @FindBy(xpath = "//span[contains(text(),'Login name must be alphanumeric only and between 5')]")
    public WebElement loginNameRedMessages;
    @FindBy(xpath = "//span[contains(text(),'Password must be between 4 and 20 characters!')]")
    public WebElement passwordRedMessages;
    @FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div/div/div[1]")
    public WebElement agreeToPrivacyPolicyRedMessages;


    public String createAccountText(String arg0) {
        fluentWait(getDriver(), createAccountTxt, globalVars.getDefaultExplicitTimeout());
        return new VerificationHelper(getDriver()).getText(createAccountTxt);
    }

    public String getIfYouAlreadyHaveAnAccountWithUsTxt() {
        return new VerificationHelper(getDriver()).getText(ifYouAlreadyHaveAnAccountWithUs);
    }

    public String getYourPersonalDetailsTxt(String arg1) {
        return new VerificationHelper(getDriver()).getText(yourPersonalDetailsTxt);
    }

    public void enterFirstName(String firstname) throws Exception {
        sendKeysToWebElement(firstNameTextBox, firstname);

    }

    public void enterLastName(String lastName) throws Exception {
        sendKeysToWebElement(lastNameTextBox, lastName);

    }

    public void enterFreshEmailAddress() throws Exception {
        sendKeysToWebElement(emailTextBox, email);
    }

    public void enterTelephoneNumber(String telephoneNumber) throws Exception {
        sendKeysToWebElement(telephoneTextBox, telephoneNumber);
    }

    public void enterFaxNumber(String faxNumber) throws Exception {
        sendKeysToWebElement(faxTextBox, faxNumber);
    }

    public void enterYourPersonalDetailsSection(String firstName, String lastName, String telephone, String fax) throws Exception {
        enterFirstName(firstName);
        log.info("Entered text :" + firstName);
        enterLastName(lastName);
        log.info("Entered text :" + lastName);
        enterFreshEmailAddress();
        log.info("Entered text => entered Fresh EmailAddress...");
        enterTelephoneNumber(telephone);
        log.info("Entered text :" + telephone);
        enterFaxNumber(fax);
        log.info("Entered text :" + fax);

    }

    public String getYourAddressTxt() {
        return new VerificationHelper(getDriver()).getText(yourAddressText);
    }

    public void enterCompanyName(String companyName) throws Exception {
        sendKeysToWebElement(companyTextBox, companyName);
    }

    public void enterAddress1(String address1) throws Exception {
        sendKeysToWebElement(address1TextBox, address1);
    }

    public void enterAddress2(String address2) throws Exception {
        sendKeysToWebElement(address2TextBox, address2);
    }

    public void enterCity(String yourCity) throws Exception {
        sendKeysToWebElement(cityTextBox, yourCity);
    }

    public void selectRegionOrState(String arg0) {
        log.info("selecting region/ state....");
        WebElement regionOrStateName = getDriver().findElement(By.xpath("//option[contains(text(),'"+arg0+"')]"));
        regionOrStateName.click();
    }

    public void enterZipCode(String ZipCode) throws Exception {
        sendKeysToWebElement(zipCodeTextBox, ZipCode);
    }

    public void selectCountry(String countryName) {
        selectByVisibleText(countryName, countryDropdownBtn);
    }

    public String getLoginDetailsSectionTxt(String arg0) throws IOException {
        return new VerificationHelper(getDriver()).getText(loginDetailsSectionText);
    }
    public boolean validateLoginDetailsSectionTxtIsDisplayed(String arg0) throws IOException {
        log.info("getting Your Address Txt...");
        return new VerificationHelper(getDriver()).isDisplayed(loginDetailsSectionText);
    }

    public void enterLoginName() throws Exception {
        sendKeysToWebElement(loginNameTextBox, ("Covid" + generateRandomNumber(5)));
        log.info("Entered generated Random loginName.... ");
    }

    public void enterPassword(String arg0) throws Exception {
        sendKeysToWebElement(passwordTextBox, arg0);
    }
    public void enterPasswordConfirm(String arg0) throws Exception {
        sendKeysToWebElement(passwordConfirmTextBox, arg0);
    }

    public String getNewsletterTxt() throws IOException {
        log.info("Gotten element Newsletter text...");
        return getText(newsletterText);
    }

    public void tickOnSubscribeAsYes() {
        waitForWebElementAndClick(subscribeYesRadioButton);
        log.info("Waited and clicked on the element: " + subscribeYesRadioButton.getText());
    }

    public boolean validateSubscribeYesTicked() {
        return isSelected(getDriver(), subscribeYesRadioButton);
    }

    public void clickOnSubscribeAsNo() {
        waitForWebElementAndClick(subscribeNORadioButton);
    }

    public void checkOnIAgreeToPrivacyPolicyRadioButton() {
        waitForWebElementAndClick(agreeToPrivacyPolicyButton);
    }

    public void clickOnIAgreeToPrivacyPolicyRadioButton() {
        waitForWebElementAndClick(agreeToPrivacyPolicyButton);

    }

    public AccountSuccessPage clickOnContinueButton() throws IOException, InterruptedException {
        act.explicitWait(getDriver(),continueBtn, datarepo.getFifteenSeconds());
        waitForWebElementAndClick(continueBtn);
        return new AccountSuccessPage();
    }

    //******************SETTERS for Error*****************************//

    public String getFirstNameRedErrorTxt() throws Exception {
        return new VerificationHelper(getDriver()).getText(this.firstNameErrorTxt);
    }

    public String getLastNameRedErrorTxt() throws Exception {
        return new VerificationHelper(getDriver()).getText(lastNameErrorTxt);
    }

    public String getEmailRedErrorTxt() throws Exception {
        return new VerificationHelper(getDriver()).getText(emailErrorTxt);
    }

    public String getAddress1RedErrorTxt() throws Exception {
        return new VerificationHelper(getDriver()).getText(address1ErrorTxt);
    }

    public String getCityRedErrorTxt() throws Exception {
        return new VerificationHelper(getDriver()).getText(cityErrorTxt);
    }

    public String getRegionStateRedErrorTxt() throws Exception {
        return new VerificationHelper(getDriver()).getText(regionStateErrorTxt);       
    }

    public String getZipCodeRedErrorTxt() throws Exception {
        return new VerificationHelper(getDriver()).getText(zipCodeErrorTxt);
    }

    public String getPasswordRedErrorTxt() throws Exception {
        return new VerificationHelper(getDriver()).getText(passwordErrorTxt);
    }
    public String getPrivacyPolicyTxtRedErrorTxt() throws Exception {
        return new VerificationHelper(getDriver()).getText(privacyPolicyErrorTxt);
    }

    public String getErrorYouMustAgreeToThePrivacyPolicyRedErrorTxt() throws Exception {
        return new VerificationHelper(getDriver()).getText(youMustAgreeToThePrivacyPolicyErrorTxt);
    }

//===========================================================================================================//

    public boolean verifyFirstNameRedMessageIsDisplayed() {
        return new VerificationHelper(getDriver()).isDisplayed(firstNameRedMessages);
    }
    public boolean verifyLastNameRedMessagesIsDisplayed() {
        return new VerificationHelper(getDriver()).isDisplayed(lastNameRedMessages);

    }
    public boolean verifyEmailRedMessagesIsDisplayed() {
        return new VerificationHelper(getDriver()).isDisplayed(emailRedMessages);
    }
    public boolean verifyAddress1RedMessagesIsDisplayed() {
        return new VerificationHelper(getDriver()).isDisplayed(address1RedMessages);
    }
    public boolean verifyCityRedMessagesIsDisplayed() {
        return new VerificationHelper(getDriver()).isDisplayed(cityRedMessages);
    }
    public boolean verifyZipCodeRedMessagesIsDisplayed() {
        return new VerificationHelper(getDriver()).isDisplayed(zipCodeRedMessages);
    }
    public boolean verifyStateProvinceRedMessagesIsDisplayed() {
        return new VerificationHelper(getDriver()).isDisplayed(stateProvinceRedMessages);
    }
    public boolean verifyLoginNameRedMessagesIsDisplayed() {
        return new VerificationHelper(getDriver()).isDisplayed(loginNameRedMessages);

    }
    public boolean verifyPasswordRedMessagesIsDisplayed() {
        return new VerificationHelper(getDriver()).isDisplayed(passwordRedMessages);
    }
    public boolean verifyAgreeToPrivacyPolicyRedMessagesIsDisplayed() {
        return new VerificationHelper(getDriver()).isDisplayed(agreeToPrivacyPolicyRedMessages);
    }

}


