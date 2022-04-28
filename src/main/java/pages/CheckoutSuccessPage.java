package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class CheckoutSuccessPage extends BasePage {

    public CheckoutSuccessPage() throws IOException {
        super();
    }

    public String orderSuccessPageUrl = "https://automationteststore.com/index.php?rt=checkout/success";

    @FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div/div/h1/span[1]")
    private WebElement yourOrderHasBeenProcessedHeadingTxt;

    @FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div/div/div/section/p[2]")
    private WebElement OrderNumberText;

    @FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div/div/div/section/p[3]")
    private WebElement viewInvoiceText;

    @FindBy(xpath = "//p[contains(text(),'Thank you for shopping with us!')]")
    private WebElement thankYouForShoppingWithUsText;

    @FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div/div/div/section/p[3]")
    private WebElement invoicePageLink;

    @FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div/div/div/section/a")
    private WebElement continueCheckoutSuccessBtn;

    public String validateOrderSuccessPageUrl() {
        return orderSuccessPageUrl;
    }

    public boolean validateYourOrderHasBeenProcessedHeadingTxt() {
        return act.isDisplayed(getDriver(), yourOrderHasBeenProcessedHeadingTxt);
    }

    public boolean validateOrderNumberText() {
        return act.isDisplayed(getDriver(), OrderNumberText);
    }

    public boolean validateViewInvoiceText() {
        return act.isDisplayed(getDriver(), viewInvoiceText);
    }

    public boolean validateThankYouForShoppingWithUsText() {
        return act.isDisplayed(getDriver(), thankYouForShoppingWithUsText);
    }

    public InvoiceOrderPage clickOnInvoicePageLink() throws IOException {
        waitForWebElementAndClick(invoicePageLink);
        return new InvoiceOrderPage();
    }

    public IndexPage clickOnContinueCheckoutSuccessBtn() throws IOException {
        waitForWebElementAndClick(continueCheckoutSuccessBtn);
        return new IndexPage();
    }

}
