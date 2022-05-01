package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class CheckoutSuccessPage extends BasePage {
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
        return getText(yourOrderHasBeenProcessedHeadingTxt);

    }
    public String getOrderNumber() {
        return getText(OrderNumberText);

    }
    public String getViewInvoice() {
        return getText(viewInvoiceText);
    }
    public String getThankYouForShoppingWithUsTxt() {
        return thankYouForShoppingWithUsTxt.getText();
    }
    public InvoiceOrderPage clickOnInvoicePageLink() throws IOException {
        waitForWebElementAndClick(invoicePageLink);
        return new InvoiceOrderPage();
    }
    public IndexPage clickOnContinueBtn() throws InterruptedException, IOException {
        waitFor(continueBtn);
        waitForWebElementAndClick(continueBtn);
        waitFor(indexPage.logoImage);
        return new IndexPage();

    }


}
