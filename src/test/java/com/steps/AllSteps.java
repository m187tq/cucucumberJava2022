package com.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.*;
import utilities.data;

import java.io.IOException;

public class AllSteps extends BasePage {

    public AllSteps() throws IOException {
        super();
    }
    private WebDriver driver = getDriver();
    private TopNaviPage topNaviPage;
    private AccountPage accountPage;
    private AccountLoginPage accountLoginPage;
    private AccountCreatePage accountCreatePage;
    private AccountEditPage accountEditPage;
    private AccountLogoutPage accountLogoutPage;
    private AccountSuccessPage accountSuccessPage;
    private IndexPage indexPage;
    private AddToCartPage addToCartPage;

    private NavigationMenuPage navigationMenuPage;
    private ProductIDPage productIDPage;
    private SearchResultPage searchResultPage;
    private ShippingReturnsPage shippingReturnsPage;
    private InvoiceOrderPage invoiceOrderPage;
    private MiddleMenuNaviPage middleMenuNaviPage;

    private FooterPage footerPage;

    private CheckoutBillingPage checkoutBillingPage;
    private CheckoutCartPage checkoutCartPage;
    private CheckoutConfirmationPage checkoutConfirmationPage;
    private CheckoutCustomerPage checkoutCustomerPage;
    private CheckoutPage checkoutPage;
    private CheckoutShippingModeEditPage checkoutShippingModeEditPage;
    private CheckoutSuccessPage checkoutSuccessPage;
    private PaymentModeEditPage paymentModeEditPage;
    private CartSummary cartSummary;
    private CartPage cartPage;

    public AllSteps(TopNaviPage topNaviPage,
                    AccountLoginPage accountLoginPage,
                    IndexPage indexPage,
                    AccountSuccessPage accountSuccessPage,
                    AccountEditPage accountEditPage,
                    AccountLogoutPage accountLogoutPage,
                    AccountCreatePage accountCreatePage,
                    AccountPage accountPage,
                    AddToCartPage addToCartPage,
                    NavigationMenuPage navigationMenuPage,
                    ProductIDPage productIDPage,
                    SearchResultPage searchResultPage,
                    ShippingReturnsPage shippingReturnsPage,
                    InvoiceOrderPage invoiceOrderPage,
                    MiddleMenuNaviPage middleMenuNaviPage,
                    FooterPage footerPage,
                    CheckoutBillingPage checkoutBillingPage,
                    CheckoutCartPage checkoutCartPage,
                    CheckoutConfirmationPage checkoutConfirmationPage,
                    CheckoutCustomerPage checkoutCustomerPage,
                    CheckoutPage checkoutPage,
                    CheckoutShippingModeEditPage checkoutShippingModeEditPage,
                    PaymentModeEditPage paymentModeEditPage,
                    CartSummary cartSummary,
                    CartPage cartPage)
            throws IOException {
        this.topNaviPage = topNaviPage;
        this.accountLoginPage = accountLoginPage;
        this.indexPage = indexPage;
        this.accountSuccessPage = accountSuccessPage;
        this.accountEditPage = accountEditPage;
        this.accountLogoutPage = accountLogoutPage;
        this.accountCreatePage = accountCreatePage;
        this.accountPage = accountPage;
        this.addToCartPage = addToCartPage;
        this.accountLoginPage = accountLoginPage;
        this.productIDPage = productIDPage;
        this.searchResultPage = searchResultPage;
        this.shippingReturnsPage = shippingReturnsPage;
        this.invoiceOrderPage = invoiceOrderPage;
        this.accountCreatePage = accountCreatePage;
        this.middleMenuNaviPage = middleMenuNaviPage;
        this.checkoutBillingPage = checkoutBillingPage;
        this.checkoutCartPage = checkoutCartPage;
        this.checkoutConfirmationPage = checkoutConfirmationPage;
        this.checkoutCustomerPage = checkoutCustomerPage;
        this.checkoutShippingModeEditPage = checkoutShippingModeEditPage;
        this.checkoutPage = checkoutPage;
        this.paymentModeEditPage = paymentModeEditPage;
        this.cartSummary = cartSummary;
        this.cartPage = cartPage;
    }

    @Given("user is on index page url as {string} and page title as {string}")
    public void userIsOnIndexPageUrlAsAndPageTitleAs(String Url, String arg1) throws InterruptedException {
        goToIndexPage(Url);
        Assert.assertEquals(getCurrentPageTitle(arg1),arg1);
        Assert.assertEquals(getCurrentPageUrl(Url),Url);
    }

    @When("user clicks the LoginOrRegister link")
    public void userClicksTheLoginOrRegisterLink() throws IOException {
        Assert.assertTrue(topNaviPage.loginOrRegisterBtnEnabled());
        topNaviPage.clickOnLoginRegisterBtn();
    }
     @And("user should be on account login page with option to login as {string} or create an Account as {string}")
    public void userShouldBeOnAccountLoginPageWithOptionToLoginAsOrCreateAnAccountAs(String arg0, String arg1) {
        Assert.assertTrue(accountLoginPage.validateNewCustomerTxtIsDisplayed(arg0));
        Assert.assertTrue(accountLoginPage.verifyReturningCustomerTxtIsDisplayed(arg1));

    }

    @When("user enters login Name as {string} and password as {string} and clicks on Login button")
    public void user_enters_login_name_as_and_password_as_and_clicks_on_login_button(String string, String string2) throws Exception {
        accountLoginPage.enterLoginName(string);
        accountLoginPage.enterPassword(string2);
        accountLoginPage.clickOnLoginBtn();
    }
    @Then("user should be presented with the following validation message as {string}")
    public void user_should_be_presented_with_the_following_validation_message_as(String arg1) throws InterruptedException {
        Assert.assertTrue(accountPage.homePageWelcomeMessage(arg1), arg1);
    }
    @Then("user clicks on edit profile button")
    public void user_clicks_on_edit_profile_button() throws IOException {
        accountPage.clickOnEditAccountDetailsLink();
    }
    @Then("user enters {string} {string} and EmailAddress telephone as {string} and fax as {string} in their respective box")
    public void user_enters_and_email_address_telephone_as_and_fax_as_in_their_respective_box(String string, String string2, String string3, String string4) throws Exception {
        Assert.assertTrue(accountEditPage.validateUserOnAccountEditPageIsDisplayed());
        accountEditPage.enterFirstNameBox(string);
        accountEditPage.enterLastNameBox(string2);
        accountEditPage.enterFreshEmailBox();
        accountEditPage.enterTelephoneBox(string3);
        accountEditPage.enterFaxBox(string4);
    }
    @And("user clicks on Continue button to confirms profile successful update message as {string}")
    public void userClicksOnContinueButtonToConfirmsProfileSuccessfulUpdateMessageAs(String arg0) throws InterruptedException, IOException {
        accountEditPage.clickOnContinueEditBtn();
        Assert.assertTrue(accountPage.accountProfileSuccessfulUpdateMessage().contains(arg0));
    }
    @When("user clicks on logoff button and logout Continue Button")
    public void user_clicks_on_logoff_button_and_logout_continue_button() throws IOException, InterruptedException {
        accountPage.clickOnLogoffBtn();
        Assert.assertTrue(accountLogoutPage.validateLogoutContinueBtnIsDisplayed());
        accountLogoutPage.clickOnLogoutContinueButton();
    }
    @Then("user is back to index page as {string}")
    public void user_is_back_to_index_page_as(String arg1) throws InterruptedException {
        Assert.assertEquals(indexPage.getCurrentPageUrl(), arg1);
    }

    // NEGATIVE LOGIN UNIQUE STEPS//

    @And("user enters wrong combination of both login Name as {string} or password as {string}")
    public void userEntersWrongCombinationOfBothLoginNameAsOrPasswordAs(String loginName, String password) throws Exception {
        accountLoginPage.enterLoginName(loginName);
        accountLoginPage.enterPassword(password);
    }
    @And("user clicks on Login_Button")
    public void userClicksOnLogin_Button() throws IOException, InterruptedException {
    accountLoginPage.clickOnLoginButton();

    }
    @Then("User gets error message as {string} and still on Home page title as {string}")
    public void userGetsErrorMessageAsAndStillOnHomePageTitleAs(String loginValidationErrorMessage, String pageTitle) {
        Assert.assertTrue(accountLoginPage.errorIncorrectLoginPasswordProvidedConfirmationMessage(loginValidationErrorMessage).contains(loginValidationErrorMessage));
        Assert.assertTrue(accountLoginPage.currentPageTitle(pageTitle).contains(pageTitle));
    }
// REGISTRATION UNIQUE STEPS//

    @And("^user verifies register account radio button is checked and clicks on Continue button$")
    public void userVerifiesRegisterAccountRadioButtonIsCheckedAndClicksOnContinueButton() throws IOException, InterruptedException {
        Assert.assertTrue(accountLoginPage.verifyRegisterAccountTextCheckBoxIsDisplayed());
        accountLoginPage.clickOnContinueRegisterAccountBtn();
    }
    @And("user is on account create page and verifies page heading as {string} and page Url contains {string}")
    public void userIsOnAccountCreatePageAndVerifiesPageHeadingAsAndPageUrlContains(String arg0, String arg1) throws InterruptedException {
        Assert.assertEquals(accountCreatePage.createAccountText(arg0), arg0);
        Assert.assertTrue(getDriver().getCurrentUrl().contains(arg1));

    }

    @And("user enters email and personal details in {string}")
    public void userEntersEmailAndPersonalDetailsIn(String arg0) {
        Assert.assertTrue(accountCreatePage.verifyYourPersonalDetailsTxtIsDisplayed(arg0));
        accountCreatePage.enterFirstName(data.firstName);
        accountCreatePage.enterLastName(data.lastName);
        accountCreatePage.enterEmailAddress();
        accountCreatePage.enterTelephoneNumber(data.getTelephone());
        accountCreatePage.enterFaxNumber(data.getFaxNumber());
    }

    @And("user enters all the address details as {string}")
    public void userEntersAllTheAddressDetailsAs(String arg0) {
        Assert.assertTrue(accountCreatePage.verifyYourAddressTextIsDisplayed(arg0));
        accountCreatePage.enterCompanyName(data.getCompanyName());
        accountCreatePage.enterAddress1(data.getAddress1());
        accountCreatePage.enterAddress2(data.getAddress2());
        accountCreatePage.enterCity(data.getCity());
        accountCreatePage.enterZipCode(data.getZipCode());
        accountCreatePage.selectRegionState(data.getRegionState());
        accountCreatePage.selectCountry(data.getCountry());
    }
    @And("user enters all the login requested details as {string}")
    public void userEntersAllTheLoginRequestedDetailsAs(String arg0) throws IOException {
        Assert.assertTrue(accountCreatePage.verifyLoginDetailsSectionTextIsDisplayed(arg0));
        accountCreatePage.enterLoginName();
        accountCreatePage.enterPassword(data.getPassword());
        accountCreatePage.enterPasswordConfirm(data.getConfirmPassword());
    }

    @And("^user subscribed to Newsletter and check on Yes$")
    public void userSubscribedToNewsletterAndCheckOnYes() throws IOException {
        Assert.assertTrue(accountCreatePage.verifyNewsletterTextIsDisplayed());
        accountCreatePage.tickOnSubscribeAsYes();
    }
    @And("user ticks on Privacy Policy radio button and create account button")
    public void userTicksOnPrivacyPolicyRadioButtonAndCreateAccountButton() throws IOException, InterruptedException {
        accountCreatePage.tickOnSubscribeAsYes();
        accountCreatePage.checkOnIAgreeToPrivacyPolicyRadioButton();
        accountCreatePage.clickOnContinueButton();
    }
    @Then("user gets success confirmation message as {string}")
    public void userGetsSuccessConfirmationMessageAs(String arg1) {
        Assert.assertTrue(accountSuccessPage.validateAccountHasBeenCreatedHeadingTxtIsDisplayed(arg1));
    }
    @And("^user clicks on Continue Shipping button$")
    public void userClicksOnContinueShippingButton() throws IOException {
        accountSuccessPage.clickOnContinueAccountSuccessBtn();
    }
    @And("user is on home page and presented with welcome message as {string}")
    public void userIsOnHomePageAndPresentedWithWelcomeMessageAs(String arg0) throws InterruptedException {
        Assert.assertTrue(accountPage.homePageWelcomeMessage(arg0),(arg0));

    }
    @And("^user clicks on SignOut button$")
    public void userClicksOnSignOutButton() throws IOException, InterruptedException {
        accountPage.clickOnLogoffBtn();
        accountLogoutPage.clickOnLogoutContinueButton();

    }

    @And("user is back to login page url as {string}")
    public void userIsBackToLoginPageUrlAs(String arg0) {
        Assert.assertEquals(getDriver().getCurrentUrl(), arg0);
    }

}
