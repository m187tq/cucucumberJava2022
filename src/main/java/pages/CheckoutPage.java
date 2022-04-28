package pages;

import actiondriver.Action;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.data;

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
        return isDisplayed(customerHeadingTxt);
    }

    public boolean isItemImageDisplayed() {
        return isDisplayed(itemImage);
    }

    public void clickOnSignOutBtn() {
        act.click(getDriver(), signOutBtn);

    }

    public boolean isSignOutBtnEnabled() {
        return isEnabled(signOutBtn);

    }

    public void clickOnBillingAddrEditBtn() {
        actor.fluentWait(getDriver(), billingAddrEditBtn, data.getFifteenSeconds());
        act.click(getDriver(), billingAddrEditBtn);

    }

    public void isBillingAddrEditBtnEnabled() {
        isEnabled(billingAddrEditBtn);
    }

    public void isBillingAddrEditBtnDisplayed() {
        isDisplayed(billingAddrEditBtn);
    }

    public boolean isShippingAddrEditBtnDisplayed() {
        return isDisplayed(ShippingAddressEditBtn);
    }

    public boolean isFullCustomerHeadingTxtDisplayed() {
        return isDisplayed(fullCustomerHeadingTxt);

    }
    public boolean isShippingAddressTxtDisplayed() {
        return isDisplayed(shippingAddressTxt);
    }
    public boolean isMyBillingAddressSameShippingAddressTxtDisplayed() {
        return isDisplayed(MyBillingAddressSameShippingAddressTxt);
    }
    public boolean isShippingMethodTxtDisplayed() {
        return isDisplayed(shippingMethodTxt);
    }

    public void clickOnCustomerContinueBtn() {
        act.click(getDriver(),customerContinueBtn);
    }
    public boolean isOrderSummaryTxtDisplayed() {
        return isDisplayed(orderSummaryTxt);

    }
    public void clickOnEditCartLinkTxt() {
        act.click(getDriver(), editCartLinkTxt);
    }

    public boolean isEditCartLinkTxtDisplayed() {
       return isDisplayed(editCartLinkTxt);
    }

    public boolean isTotalPriceDisplay() {
       return act.isDisplayed(getDriver(),totalPrice);
    }


}
