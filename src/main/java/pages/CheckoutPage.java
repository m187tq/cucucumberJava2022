package pages;

import actiondriver.Action;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.datarepo;

import java.io.IOException;

public class CheckoutPage extends BasePage {

    Action actor = new Action();

public CheckoutPage() throws IOException {
    super();
}

    @FindBy(xpath="//h2[contains(text(),'Customer')]")
    public WebElement customerHeadingTxt;

    @FindBy(css=".product-column.product-figure")
    public WebElement itemImage;

    @FindBy(xpath="//button[contains(text(),'Sign Out')]")
    public WebElement signOutBtn;

    @FindBy(xpath="//*[@id=\"checkout-app\"]/div/div/div/div/ol/li[3]/div/a/div[3]/button")
    public WebElement billingAddrEditBtn;

    @FindBy(xpath="//body/div[@id='checkout-app']/div[1]/div[1]/div[1]/div[1]/ol[1]/li[2]/div[1]/a[1]/div[3]/button[1]")
    public WebElement ShippingAddressEditBtn;

    @FindBy(css=".checkout-step.optimizedCheckout-checkoutStep.checkout-step--customer")
    public WebElement fullCustomerHeadingTxt;

    @FindBy(id="addressToggle")
    public WebElement shippingAddressTxt;

    @FindBy(xpath="//label[contains(text(),'My billing address is the same as my shipping addr')]")
    public WebElement MyBillingAddressSameShippingAddressTxt;

    @FindBy(xpath="//h2[contains(text(),'Customer')]")
    public WebElement shippingMethodTxt;

    @FindBy(css="#checkout-shipping-continue")
    public WebElement customerContinueBtn;

    @FindBy(xpath="//h3[contains(text(),'Order Summary')]")
    public WebElement orderSummaryTxt;

    @FindBy(css="#cart-edit-link")
    public WebElement editCartLinkTxt;

    @FindBy(xpath="//*[@id=\"checkout-app\"]/div/div/div/aside/article/section[3]/div/div")
    public WebElement totalPrice;

    public boolean isCustomerHeadingTxtDisplayed() {
        return act.isDisplayed(getDriver(), customerHeadingTxt);
    }

    public boolean isItemImageDisplayed() {
        return  act.isDisplayed(getDriver(),itemImage);
    }

    public void clickOnSignOutBtn() {
        act.click(getDriver(), signOutBtn);

    }

    public boolean isSignOutBtnEnabled() {
        return act.isEnabled(getDriver(), signOutBtn);

    }

    public void clickOnBillingAddrEditBtn() {
        actor.fluentWait(getDriver(), billingAddrEditBtn, datarepo.getFifteenSeconds());
        act.click(getDriver(), billingAddrEditBtn);

    }

    public void isBillingAddrEditBtnEnabled() {
        act.isEnabled(getDriver(),billingAddrEditBtn);
    }

    public void isBillingAddrEditBtnDisplayed() {
        act.isDisplayed(getDriver(),billingAddrEditBtn);
    }

    public boolean isShippingAddrEditBtnDisplayed() {
        return  act.isDisplayed(getDriver(),ShippingAddressEditBtn);
    }

    public boolean isFullCustomerHeadingTxtDisplayed() {
        return  act.isDisplayed(getDriver(),fullCustomerHeadingTxt);

    }
    public boolean isShippingAddressTxtDisplayed() {
        return  act.isDisplayed(getDriver(),shippingAddressTxt);
    }
    public boolean isMyBillingAddressSameShippingAddressTxtDisplayed() {
        return  act.isDisplayed(getDriver(),MyBillingAddressSameShippingAddressTxt);
    }
    public boolean isShippingMethodTxtDisplayed() {
        return  act.isDisplayed(getDriver(),shippingMethodTxt);
    }

    public void clickOnCustomerContinueBtn() {
        act.click(getDriver(),customerContinueBtn);
    }
    public boolean isOrderSummaryTxtDisplayed() {
        return  act.isDisplayed(getDriver(),orderSummaryTxt);

    }
    public void clickOnEditCartLinkTxt() {
        act.click(getDriver(), editCartLinkTxt);
    }

    public boolean isEditCartLinkTxtDisplayed() {
       return  act.isDisplayed(getDriver(),editCartLinkTxt);
    }

    public boolean isTotalPriceDisplay() {
       return act.isDisplayed(getDriver(),totalPrice);
    }


}
