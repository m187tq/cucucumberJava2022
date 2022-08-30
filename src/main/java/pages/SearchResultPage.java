package pages;

import helper.assertion.VerificationHelper;
import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class SearchResultPage extends BasePage{
    public static Logger log = LoggerHelper.getLogger(SearchResultPage.class);
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

    @FindBy(xpath = ".productcart")
    public List<WebElement> addToCartBtn;

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

    @FindBy(css=".topcart .dropdown-toggle")
    public WebElement itemsCartSubMenuDropDown;

    @FindBy(xpath = "//*[@id=\"product\"]/fieldset/div[6]/a[2]")
    public WebElement AddToWishListBtn;


    @FindBy(css = ".prdocutname")
    List<WebElement> itemNameList;

    @FindBy(css = "a.cart")
    WebElement addToCartButton;


    public WebElement productDetailsImage() {
        return productDetailsImage;
    }

    public String getTotalPrice() {
        return new VerificationHelper(getDriver()).getText(totalPriceTxt);
    }

    public void addProductByClickingOnAddToCartBtn() throws InterruptedException {
        List<WebElement> itemNames = getDriver().findElements(By.cssSelector(".prdocutname"));
        List<WebElement> addToCartProduct = getDriver().findElements(By.cssSelector("a.productcart"));

        String itemsNeeded = "VIVA GLAM LIPSTICK";

        for(int i = 0; i<itemNames.size(); i++)
        {
            String name = itemNames.get(i).getText();

            if(name.contains(itemsNeeded))
            {
                addToCartProduct.get(i).click();
                break;
            }

        }
    }

    public void addProductsToCart() throws InterruptedException {
        List<WebElement> itemNames = getDriver().findElements(By.cssSelector(".prdocutname"));
        List<WebElement> addToCartBtn = getDriver().findElements(By.cssSelector("a.productcart"));

        String itemsNeeded [] = {"BODY CREAM BY BULGARI", "CREME PRECIEUSE NUIT 50ML","JASMIN NOIR BODY LOTION 6.8 FL OZ"};

        for(int i = 0; i<itemNames.size(); i++)
        {
            String name = itemNames.get(i).getText();
            List itemsNeededList = Arrays.asList(itemsNeeded);

            if(itemsNeededList.contains(name))
            {
                addToCartBtn.get(i).click();
            }

        }
    }

    public void addProductToCart() throws InterruptedException {
        List<WebElement> listProducts = getDriver().findElements(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/div[3]/div"));
        String itemName = "Name";
        for(WebElement listProduct: listProducts){
            System.out.println(listProduct.getText());
            System.out.println("============================");
        }

    }

    public void clickOnItemCartSubMenu() throws InterruptedException {
        waitForWebElementAndClick(itemsCartSubMenuDropDown);
    }
    public void enterQuantityOfItem(int noOfItem) throws Exception {
        sendKeysToWebElement(quantityBtn, String.valueOf(noOfItem));
    }

    public void selectColorDropdownBtnByName(String colorName) {
        selectByVisibleText(colorName, colorDropdownBtn) ;
    }


    public String getProductInfoBox() {
        return new VerificationHelper(getDriver()).getText(productInfoBoxTxt);
    }

    public void clickOnProductReviewBtn() {
        waitForWebElementAndClick(productReviewBtn);
    }

    public boolean productAvailablity() {
        return new VerificationHelper(getDriver()).isDisplayed(productDetailsImage);
    }
    public AddToCartPage clickOnProductItem() throws IOException {
        waitForWebElementAndClick(productDetailsImage);
        return new AddToCartPage();
    }
    public WebElement addToCartBtn() throws Throwable {
        return addToCartShoppingCartBtn;
    }
    public void clickOnAddToWishListBtn() {
        waitForWebElementAndClick(AddToWishListBtn);
    }

    public boolean validateProductNameIsDisplayed() {
        return new VerificationHelper(getDriver()).isDisplayed(productName);
    }
    public boolean validateProductDetailsImageIsDisplayed() {
        return new VerificationHelper(getDriver()).isDisplayed(productDetailsImage);
    }

    public String getProduct_details() {
        return new VerificationHelper(getDriver()).getText(product_details);
    }

    public void clickOnAddToCartButton() {
        waitAndClickElement(addToCartButton);
    }



}




