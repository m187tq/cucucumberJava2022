package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class CheckoutCartPage extends BasePage {

    public CheckoutCartPage() throws IOException {
        super();
    }

    @FindBy(xpath="//input[@id='coupon_coupon']")
    private WebElement couponBox;

    @FindBy(css="#apply_coupon_btn")
    private WebElement applyCouponBtn;

    @FindBy(css="#estimate_country")
    private WebElement estimateCountryDropdown;

    @FindBy(css="#estimate_country_zones")
    private WebElement countryZonesDropdown;

    @FindBy(xpath="//input[@id='estimate_postcode']")
    WebElement estimatePostcodeBox;

    @FindBy(xpath="//tbody/tr[2]/td[1]/div[1]/form[1]/div[2]/div[1]/span[1]/button[1]")
    private WebElement estimateCalculatorBtn;

    @FindBy(xpath="//select[@id='shippings']")
    private WebElement FlatRateShipmentsDropdown;

    @FindBy(xpath="//*[@id=\"cart\"]/div/div[1]/table/tbody/tr[2]/td[7]/a/i")
    private WebElement removeItemBtn;

    @FindBy(id="cart_update")
    private WebElement updateBtn;

    @FindBy(xpath="//*[@id=\"cart\"]/div/div[3]/div/a[1]")
    private WebElement continieShippingBtn;

    @FindBy(css="i.btn.btn-orange.pull-right")
    private WebElement checkoutBtn;

    @FindBy(css=".maintext")
    private WebElement shoppingCartTxt;


    public boolean validateShoppingCartTxt() {
        return act.isDisplayed(getDriver(), shoppingCartTxt);
    }

    public void EnterCouponNumberOnCouponBox(String CouponNumber) throws Exception {
        act.type(couponBox, CouponNumber);
    }

    public void clickOnApplyCouponBtn() {
        waitForWebElementAndClick(applyCouponBtn);
    }

    public void selectEstimateCountryDropdown(String countryName) {
        act.selectByVisibleText(countryName, estimateCountryDropdown);
    }

    public void selectCountryZonesDropdown(String countryZonesName) {
        act.selectByVisibleText(countryZonesName, countryZonesDropdown) ;
    }

    public void enterOnEstimatePostcodeBox(String postCode) throws Exception {
        act.type(estimatePostcodeBox, postCode);
    }

    public void clickOnEstimateCalculatorBtn() {
        waitForWebElementAndClick(estimateCalculatorBtn);
    }

    public void selectFlatRateShipmentsDropdown(String flatRateShipment) {
        act.selectByVisibleText(flatRateShipment, FlatRateShipmentsDropdown);
    }

    public boolean validateRemoveIconBtn() {
        return act.isEnabled(getDriver(), removeItemBtn);
    }

    public void clickOnRemoveIconBtn() {
        waitForWebElementAndClick(removeItemBtn);
    }

    public void clickOnUpdateBtn() {
        waitForWebElementAndClick(updateBtn);
    }

    public IndexPage clickOnContinieShippingBtn() throws IOException {
        waitForWebElementAndClick(continieShippingBtn);
        return new IndexPage();
    }

    public AccountLoginPage clickOnCheckoutBtn() throws IOException {
        waitForWebElementAndClick(checkoutBtn);
        return new AccountLoginPage();
    }


}
