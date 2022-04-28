package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.data;

import java.io.IOException;
import java.util.List;

public class CheckoutConfirmationPage extends BasePage {

    public CheckoutConfirmationPage() throws IOException {
        super();
    }

    private String checkoutConfirmationPageURL = "https://automationteststore.com/index.php?rt=checkout/confirm";

    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/h1[1]/span[1]")
    private WebElement checkoutConfirmationTxt;

    @FindBy(xpath = "//span[contains(text(),'Order Summary')]")
    private WebElement orderSummaryTxt;

    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]")
    private WebElement qtyProductWithStockLocations;

    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]")
    private List<WebElement> ShippingPaymentItemsInYourCartText;

    @FindBy(xpath = "/html/body/div/header/div[2]/div/div[2]/ul/li")
    private WebElement currencyDropdownBtn;

    @FindBy(css = "#checkout_btn")
    private WebElement confirmOrderBtn;

    @FindBy(xpath = "/html/body/div/header/div[2]/div/div[3]/ul/li/a")
    private WebElement itemsCartIcon;

    @FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div[1]/div/h1/span[1]")
    private WebElement checkoutConfirmionHeadingTxt;

    @FindBy(css = "//*[@id=\"maincontainer\"]/div/div[1]/div/div[2]/p")
    private WebElement clickingConfirmOrderReturnPolicyText;

    @FindBy(xpath = "//b[contains(text(),'Return Policy')]")
    private WebElement returnPolicyTxtLink;

    @FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div[1]/div/div[2]/table[1]/tbody/tr/td[4]/a")
    private WebElement editShipmentIcon;

    @FindBy(xpath = "//h4[contains(text(),'Shipping')]")
    private WebElement shippingTxt;

    @FindBy(css = "//h4[contains(text(),'Payment')]")
    private WebElement paymentTxt;

    @FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div[1]/div/div[2]/table[2]/tbody/tr/td[4]/a[1]")
    private WebElement editPaymentIcon;

    @FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div[1]/div/div[2]/table[2]/tbody/tr/td[4]/a[2]")
    private WebElement editCouponIcon;

    @FindBy(linkText = "Items in your cart")
    private WebElement itemsInYourCartTxt;

    @FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div[1]/div/div[2]/h4[3]/a")
    private WebElement editCartIcon;

    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/table[3]/tbody[1]/tr[1]/td[2]")
    private WebElement itemsInYourCart;

    @FindBy(css = "#back")
    private WebElement backArrowBtn;

    @FindBy(css = "span.bold.totalamout")
    private List<WebElement> totalPriceAndAmountTxt;


    @FindBy(xpath = "//b[contains(text(),'$')]")
    private WebElement unitPriceTxt;

    @FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div[1]/div/div[2]/div/div[1]/table/tbody/tr[4]/td[1]/span")
    private WebElement totalPriceTxt;

    @FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div[1]/div/div[2]/div/div[1]/table/tbody/tr[4]/td[2]/span")
    private WebElement amountTxt;

    public String getCheckoutConfirmationPageURL() {
        return checkoutConfirmationPageURL;
    }

    public boolean validateCheckoutConfirmationTxt() {
        return act.isDisplayed(getDriver(), checkoutConfirmationTxt);
    }

    public boolean validateUserOncheckoutConfirmatioPage() {
        return act.isDisplayed(getDriver(), orderSummaryTxt);
    }

    public WebElement getQtyProductWithStockLocations() {
        return qtyProductWithStockLocations;
    }

    public List<WebElement> getShippingPaymentItemsInYourCartText() {
        return ShippingPaymentItemsInYourCartText;
    }

    public void selectCurrencyDropdownBtn(String currenyName) {
        act.explicitWait(getDriver(), currencyDropdownBtn, data.getTenSeconds());
        act.selectByVisibleText(currenyName, currencyDropdownBtn);
    }

   /* public CheckoutSuccessPage clickOnConfirmOrderBtn() throws IOException {
        waitForWebElementAndClick(confirmOrderBtn);
        return new CheckoutSuccessPage();
    }*/

    public CheckoutCartPage clickOnItemsCartIcon() throws IOException {
        waitForWebElementAndClick(itemsCartIcon);
        return new CheckoutCartPage();

    }

    public boolean validateCheckoutConfirmionHeadingTxt() {
        return act.isDisplayed(getDriver(), checkoutConfirmionHeadingTxt);

    }

    public boolean validateClickingConfirmOrderReturnPolicyText() {
        return act.isDisplayed(getDriver(), clickingConfirmOrderReturnPolicyText);
    }

    public void clickOnReturnPolicyTxtLink() {
        waitForWebElementAndClick(returnPolicyTxtLink);
    }

    public CheckoutShippingModeEditPage clickEditShipmentIcon() throws IOException {
        waitForWebElementAndClick(editShipmentIcon);
        return new CheckoutShippingModeEditPage();
    }

    public boolean validateShippingTxt() {
        return act.isDisplayed(getDriver(), shippingTxt);
    }

    public boolean validatePaymentTxt() {
        return act.isDisplayed(getDriver(), paymentTxt);
    }

    public PaymentModeEditPage clickOnEditPaymentIcon() throws IOException {
        waitForWebElementAndClick(editPaymentIcon);
        return new PaymentModeEditPage();
    }

    public PaymentModeEditPage clickOnEditCouponIcon() throws IOException {
        waitForWebElementAndClick(editCouponIcon);
        return new PaymentModeEditPage();
    }

    public boolean validateItemsInYourCartTxt() {
        return act.isDisplayed(getDriver(), itemsInYourCartTxt);
    }

    public CheckoutCartPage clickOnEditCartIcon() throws IOException {
        waitForWebElementAndClick(editCartIcon);
        return new CheckoutCartPage();
    }

    public boolean validateItemsInYourCart() {
        return act.isDisplayed(getDriver(), itemsInYourCart);
    }

    public PaymentModeEditPage clickOnBackArrowBtn() throws IOException {
        waitForWebElementAndClick(backArrowBtn);
        return new PaymentModeEditPage();
    }

    public boolean validateTotalPriceTxt() {
        return act.isDisplayed(getDriver(), totalPriceTxt);
    }

    public boolean validateAmountTxt() {
        return act.isDisplayed(getDriver(), amountTxt);
    }

    public double getUnitPrice() {
        String unitPrice1=unitPriceTxt.getText();
        String unit=unitPrice1.replaceAll("[^a-zA-Z0-9]","");
        double finalUnitPrice=Double.parseDouble(unit);
        return finalUnitPrice/100;
    }

    public double getTotalPrice() {
        String totalPrice1=totalPriceTxt.getText();
        String tot=totalPrice1.replaceAll("[^a-zA-Z0-9]","");
        double finalTotalPrice=Double.parseDouble(tot);
        return finalTotalPrice/100;
    }

    public CheckoutSuccessPage clickOnConfirmOrderBtn() throws Throwable {
        act.fluentWait(getDriver(), confirmOrderBtn, 10);
        act.click(getDriver(), confirmOrderBtn);
        return new CheckoutSuccessPage();
    }

}
