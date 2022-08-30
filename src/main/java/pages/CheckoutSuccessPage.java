package pages;

import helper.assertion.VerificationHelper;
import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class CheckoutSuccessPage extends BasePage {
    public static Logger log = LoggerHelper.getLogger(CheckoutSuccessPage.class);
    IndexPage indexPage = new IndexPage();
    public CheckoutSuccessPage() throws IOException {
        super();
    }
    @FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div/div/h1/span[1]")
    WebElement yourOrderHasBeenProcessedHeadingTxt;

    @FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div/div/div/section/p[2]")
    WebElement OrderNumberText;

    @FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div/div/div/section/p[3]")
    WebElement viewInvoiceText;

    @FindBy(xpath = "//p[contains(text(),'Thank you for shopping with us!')]")
    WebElement thankYouForShoppingWithUsTxt;

    @FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div/div/div/section/p[3]")
    WebElement invoicePageLink;

    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/section[1]/a[1]")
    WebElement continueBtn;

    public String getOrderHasBeenProcessedHeading() {
        return new VerificationHelper(getDriver()).getText(yourOrderHasBeenProcessedHeadingTxt);
    }
    public boolean validateOrderHasBeenProcessedHeading() {
        return new VerificationHelper(getDriver()).isDisplayed(yourOrderHasBeenProcessedHeadingTxt);
    }
    public String getOrderNumber() {
        return new VerificationHelper(getDriver()).getText(OrderNumberText);
    }
    public boolean validateOrderNumber() {
        return new VerificationHelper(getDriver()).isDisplayed(OrderNumberText);
    }
    public String getViewInvoice() {
        return new VerificationHelper(getDriver()).getText(viewInvoiceText);
    }
    public String getThankYouForShoppingWithUsTxt() {
        return new VerificationHelper(getDriver()).getText(thankYouForShoppingWithUsTxt);
    }
    public boolean validateThankYouForShoppingWithUsTxt() {
        return new VerificationHelper(getDriver()).isDisplayed(thankYouForShoppingWithUsTxt);
    }
    public InvoiceOrderPage clickOnInvoicePageLink() throws IOException {
        waitForWebElementAndClick(invoicePageLink);
        return new InvoiceOrderPage();
    }
    public IndexPage clickOnContinueBtn() throws InterruptedException, IOException {
        waitForWebElementAndClick(continueBtn);
        return new IndexPage();

    }


}
