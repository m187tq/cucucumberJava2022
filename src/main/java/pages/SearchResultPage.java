package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class SearchResultPage extends BasePage{

    public SearchResultPage() throws IOException {
        super();
    }
    @FindBy(xpath = "//*[@id=\"product_details\"]/div/div[1]/div[1]/a/img")
    public WebElement productDetailsImage;

    @FindBy(xpath = "//span[contains(text(),'Viva Glam Lipstick')]")
    public WebElement productName;

    @FindBy(xpath = "//*[@id=\"product_details\"]/div/div[1]/div[1]/a")
    public WebElement product_details;

    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/label[1]")
    public WebElement totalPriceTxt;

    @FindBy(xpath = "//*[@id=\"product\"]/fieldset/div[5]/ul/li/a")
    public WebElement addToCartBtn;

    @FindBy(id = "product_quantity")
    public WebElement quantityBtn;

    @FindBy(xpath = "//*[@id=\"option305\"]")
    public WebElement colorDropdownBtn;

    @FindBy(css = "span.bgnone")
    public WebElement productNameTxt;

    @FindBy(css = "ul.productinfo")
    public WebElement productInfoBoxTxt;

    @FindBy(css = "ul.li.active")
    public WebElement productReviewBtn;

    @FindBy(xpath = "//*[@id=\"product\"]/fieldset/div[5]/ul/li/a")
    public WebElement addToCartShoppingCartBtn;

    @FindBy(xpath = "//*[@id=\"product\"]/fieldset/div[6]/a[2]")
    public WebElement AddToWishListBtn;

    public WebElement productDetailsImage() {
        return productDetailsImage;
    }

    public String getTotalPrice() {
        return totalPriceTxt.getText();
    }

    public void clickOnAddToCartBtn() throws InterruptedException {
        waitForWebElementAndClick(addToCartBtn);
    }

    public void enterQuantityOfItem(int noOfItem) throws Exception {
        sendKeysToWebElement(quantityBtn, String.valueOf(noOfItem));
    }

    public void selectColorDropdownBtnByName(String colorName) {
        act.selectByVisibleText(colorName, colorDropdownBtn) ;
    }


    public String getProductInfoBox() {
        return productInfoBoxTxt.getText();
    }

    public void clickOnProductReviewBtn() {
        waitForWebElementAndClick(productReviewBtn);
    }

    public WebElement productAvailablity() {
        return productDetailsImage;
    }
    public AddToCartPage clickOnProductItem() throws IOException {
        waitForWebElementAndClick(productDetailsImage);
        return new AddToCartPage();
    }
    public WebElement addtoCartBtn() throws Throwable {
        return addToCartShoppingCartBtn;
    }
    public void clickOnAddToWishListBtn() {
        waitForWebElementAndClick(AddToWishListBtn);
    }

    public WebElement productName() {
        return productName;
    }
    public String getProduct_details() {
        return product_details.getText();
    }



}




