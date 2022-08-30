package pages;

import helper.action.Action;
import helper.assertion.VerificationHelper;
import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utilities.datarepo;

import java.io.IOException;

public class AddToCartPage extends BasePage {
    public static Logger log = LoggerHelper.getLogger(AddToCartPage.class);
    Action act = new Action();
    public AddToCartPage() throws IOException {
        super();
    }

    @FindBy(xpath = "//*[@id=\"quickSearch\"]/div/section/ul/li[2]")
    public WebElement addToCartByIndex;

    @FindBy(id="quantity_wanted")
    private WebElement quantity;

    @FindBy(name="group_1")
    private WebElement size;

    @FindBy(xpath="//span[text()='Add to cart']")
    private WebElement addToCartBtn;

    @FindBy(xpath="//*[@id=\"layer_cart\"]//h2/i")
    private WebElement addToCartMessage;

    @FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
    private WebElement proceedToCheckOutBtn;

    public void enterQuantity(String quantity1) throws Throwable {
        sendKeysToWebElement(quantity, quantity1);
    }
    public void selectSize(String size1) throws Throwable {
        selectByVisibleText(size1, size);
    }
    public void clickOnAddToCart() throws Throwable {
        waitForWebElementAndClick(addToCartBtn);
    }
    public boolean validateAddToCart() throws Throwable {
        fluentWait(getDriver(), addToCartMessage, datarepo.getTenSeconds());
        return new VerificationHelper(getDriver()).isDisplayed(addToCartMessage);
    }
    public OrderConfirmationPage clickOnCheckOut() throws Throwable {
        fluentWait(getDriver(), proceedToCheckOutBtn, datarepo.getTenSeconds());
        waitForWebElementAndClick(proceedToCheckOutBtn);
        return new OrderConfirmationPage();
    }
    public void ClickOnAddToCartByIndex() {
        act.moveToElement(getDriver(),addToCartByIndex);
        waitForWebElementAndClick(addToCartByIndex);
    }
    public void setAddToCartByIndex(WebElement addToCartByIndex) {
        this.addToCartByIndex = addToCartByIndex;
    }

}
