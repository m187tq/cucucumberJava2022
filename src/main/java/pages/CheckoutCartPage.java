package pages;

import helper.assertion.VerificationHelper;
import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class CheckoutCartPage extends BasePage {
    public static Logger log = LoggerHelper.getLogger(CheckoutCartPage.class);
    public CheckoutCartPage() throws IOException {
        super();
    }

    @FindBy(xpath="//input[@id='coupon_coupon']")
    public WebElement couponBox;

    @FindBy(css="#apply_coupon_btn")
    public WebElement applyCouponBtn;

    @FindBy(css="#estimate_country")
    public WebElement estimateCountryDropdown;

    @FindBy(css="#estimate_country_zones")
    public WebElement countryZonesDropdown;

    @FindBy(xpath="//input[@id='estimate_postcode']")
    public WebElement estimatePostcodeBox;

    @FindBy(xpath="//tbody/tr[2]/td[1]/div[1]/form[1]/div[2]/div[1]/span[1]/button[1]")
    public WebElement estimateCalculatorBtn;

    @FindBy(xpath="//select[@id='shippings']")
    public WebElement FlatRateShipmentsDropdown;

    @FindBy(xpath="//*[@id=\"cart\"]/div/div[1]/table/tbody/tr[2]/td[7]/a/i")
    public WebElement removeItemBtn;

    @FindBy(id="cart_update")
    public WebElement updateBtn;

    @FindBy(xpath="//*[@id=\"cart\"]/div/div[3]/div/a[1]")
    public WebElement continueShippingBtn;

    @FindBy(css="#cart_checkout1")
    public WebElement checkoutBtn;

    @FindBy(css=".maintext")
    public WebElement shoppingCartTxt;

    @FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[5]/div[1]/input[1]")
    public WebElement addQuantityBox;

    @FindBy(xpath = "//div[contains(text(),'\tYour shopping cart is empty!\t')]")
    public WebElement yourShoppingCartIsEmptyTxt;

    @FindBy(xpath = "//*[@id=\"cart\"]/div/div[1]/table/tbody/tr[2]/td[1]/a/img")
    public WebElement productImage;

    @FindBy(xpath = "//*[@id=\"cart\"]/div/div[1]/table/tbody/tr[2]/td[4]")
    public WebElement productPrice;

    @FindBy(xpath = "//*[@id=\"totals_table\"]/tbody/tr[1]/td[2]/span")
    public WebElement subPrice;

    @FindBy(xpath = "//*[@id=\"cart\"]/div/div[1]/table/tbody/tr[2]/td[6]")
    public WebElement productTotalPrice;

    @FindBy(xpath = "//*[@id=\"totals_table\"]/tbody/tr[3]/td[2]/span")
    public WebElement productGrandTotalPrice;


//==============================================================//

    public boolean validateUserOnShoppingCartPage() {
        return new VerificationHelper(getDriver()).isDisplayed(shoppingCartTxt);
    }

    public void enterCouponNumberOnCouponBox(String CouponNumber) throws Exception {
       sendKeysToWebElement(couponBox, CouponNumber);
    }

    public void clickOnApplyCouponBtn() {
        waitForWebElementAndClick(applyCouponBtn);
    }

    public void selectEstimateCountryDropdown(String countryName) {
        selectByVisibleText(countryName, estimateCountryDropdown);
    }
    public void selectCountryZonesDropdown(String countryZonesName) {
        selectByVisibleText(countryZonesName, countryZonesDropdown) ;
    }

    public void enterOnEstimatePostcodeBox(String postCode) throws Exception {
        sendKeysToWebElement(estimatePostcodeBox, postCode);
    }
    public void clickOnEstimateCalculatorBtn() {
        waitForWebElementAndClick(estimateCalculatorBtn);
    }
    public void selectFlatRateShipmentsDropdown(String flatRateShipment) {
        selectByVisibleText(flatRateShipment, FlatRateShipmentsDropdown);
    }
    public boolean validateRemoveIconBtnisEnabled() {
        return new VerificationHelper(getDriver()).isEnabled(removeItemBtn);
    }
    public void clickOnRemoveIconBtn() {
        waitForWebElementAndClick(removeItemBtn);
    }
    public void clickOnUpdateBtn() throws InterruptedException {
        waitForWebElementAndClick(updateBtn);
        Thread.sleep(3000);
    }

    public IndexPage clickOnContinueShippingBtn() throws IOException {
        waitForWebElementAndClick(continueShippingBtn);
        return new IndexPage();
    }
    public AccountLoginPage clickOnCheckoutBtn() throws IOException, InterruptedException {
        waitForWebElementAndClick(checkoutBtn);
        Thread.sleep(3000);
        return new AccountLoginPage();
    }
    public void adjustItemQuantity(String arg1) throws Exception {
        addQuantityBox.click();
        sendKeysToWebElement(addQuantityBox, arg1);
    }
    public boolean validateYourShoppingCartIsEmptyIsDisplayed() {
        return new VerificationHelper(getDriver()).isDisplayed(yourShoppingCartIsEmptyTxt);
    }

    public boolean validateProductImageIsDisplayed() {
        return new VerificationHelper(getDriver()).isDisplayed(productImage);
    }

    public String getProductPrice() {
        return new VerificationHelper(getDriver()).getText(productPrice);
    }

    public String getSubPrice() {
        return new VerificationHelper(getDriver()).getText(subPrice);
    }

    public String getProductTotalPrice() {
        return new VerificationHelper(getDriver()).getText(productTotalPrice);
    }

    public String getProductGrandTotalPrice() {
        return new VerificationHelper(getDriver()).getText(productGrandTotalPrice);
    }

}
