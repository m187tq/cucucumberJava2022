package com.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.*;

import java.io.IOException;

public class E2ESteps extends BasePage {

    public E2ESteps() throws IOException {
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

    public E2ESteps (TopNaviPage topNaviPage,
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
/*    @Given("user is on index page url as {string} and page title as {string}")
    public void userIsOnIndexPageUrlAsAndPageTitleAs(String Url, String arg1) throws InterruptedException {
        goToIndexPage(Url);
        Assert.assertEquals(getCurrentPageTitle(arg1),arg1);
        Assert.assertEquals(getCurrentPageUrl(Url),Url);
    }*/

    @When("user clicks on search button")
    public void userClicksOnSearchButton() {
    }

    @And("user enters product name as {string}")
    public void userEntersProductNameAs(String arg0) {

    }

    @And("user should be able to see search result items")
    public void userShouldBeAbleToSeeSearchResultItems() {
    }

    @And("user adds products to the cart")
    public void userAddsProductsToTheCart() {
    }

    @And("user verifies the product item by item image, unit price, quantity and grand total")
    public void userVerifiesTheProductItemByItemImageUnitPriceQuantityAndGrandTotal() {
    }

    @And("user should be able to increase and remove item from cart")
    public void userShouldBeAbleToIncreaseAndRemoveItemFromCart() {
    }

    @And("user clicks on the Check out button")
    public void userClicksOnTheCheckOutButton() {
    }

    @And("user is on checks Customer Shipping Address, Method,Order Summary, Coupon and Total")
    public void userIsOnChecksCustomerShippingAddressMethodOrderSummaryCouponAndTotal() {
    }

    @And("user should be able to edit the cart")
    public void userShouldBeAbleToEditTheCart() {
    }
    @And("user verifies the unit price against total price")
    public void userVerifiesTheUnitPriceAgainstTotalPrice() {
    }
    @And("user clicks on continue button")
    public void userClicksOnContinueButton() {
    }

    @And("user confirms email, Shipping Address, Method, Billing and total")
    public void userConfirmsEmailShippingAddressMethodBillingAndTotal() {
    }

    @And("user should be able to edit the cart, Shipping,Method and Billing Address")
    public void userShouldBeAbleToEditTheCartShippingMethodAndBillingAddress() {
    }

    @And("user is given the option to register or login or as a guest")
    public void userIsGivenTheOptionToRegisterOrLoginOrAsAGuest() {
    }

    @And("user registers and login as a new user")
    public void userRegistersAndLoginAsANewUser() {
    }

    @And("user enters payment details and clicks on place order button")
    public void userEntersPaymentDetailsAndClicksOnPlaceOrderButton() {
    }

    @And("user is presented with a purchase confirmation page.")
    public void userIsPresentedWithAPurchaseConfirmationPage() {
    }

    @Then("user gets an order number and thank message with first name displayed")
    public void userGetsAnOrderNumberAndThankMessageWithFirstNameDisplayed() {
    }

    @And("user order confirmation page is populate with print icon, item image total price and continue shipping button")
    public void userOrderConfirmationPageIsPopulateWithPrintIconItemImageTotalPriceAndContinueShippingButton() {
    }

    @And("user clicks on continue and logout button")
    public void userClicksOnContinueAndLogoutButton() {
    }

    @Then("user is back to home page")
    public void userIsBackToHomePage() {
    }


}
