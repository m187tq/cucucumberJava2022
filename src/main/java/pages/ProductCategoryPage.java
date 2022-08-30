package pages;

import helper.DropDown.DropDownHelper;
import helper.javaScript.JavaScriptHelper;
import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class ProductCategoryPage extends BasePage{

    public static Logger log = LoggerHelper.getLogger(ProductCategoryPage.class);

    public ProductCategoryPage() throws IOException {
        super();
    }

    @FindBy(css= ".maintext")
    WebElement productHeader;

    @FindBy(css= ".prdocutname")
    List<WebElement> itemNames;

    @FindBy(css= "a.productcart")
    List<WebElement> addToCartProduct;

    @FindBy(xpath="//*[@id='layered_block_left']/p")
    public WebElement catalogTextObj;

    @FindBy(xpath="//*[@id='layer_cart']/div[1]/div[1]/h2")
    public WebElement productAddedSuccessfully;

    @FindBy(xpath="//*[@id='center_column']/ul/li[4]/div/div[2]/div[2]/a[1]/span")
    public WebElement addToCart;

    @FindBy(xpath="//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")
    public WebElement proceedToCheckOut;

    @FindBy(xpath=".prdocutname")
    List<WebElement> totalProducts;

    @FindBy(xpath="")
    public WebElement sortBy;

    @FindBy(xpath=".oneprice")
    List<WebElement> allPriceElements;

    public void AddAnItemToCart(){

        String itemsNeeded = "BODY CREAM BY BULGARI";
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

    public void AddMultipleItemsToCart(){

        List<WebElement> itemNames = getDriver().findElements(By.cssSelector(".prdocutname"));
        List<WebElement> addToCartProduct = getDriver().findElements(By.cssSelector("a.productcart"));

        String itemsNeeded [] = {"BODY CREAM BY BULGARI", "CREME PRECIEUSE NUIT 50ML","JASMIN NOIR BODY LOTION 6.8 FL OZ"};

        for(int i = 0; i<itemNames.size(); i++)
        {
            String name = itemNames.get(i).getText();
            List itemsNeededList = Arrays.asList(itemsNeeded);

            if(itemsNeededList.contains(name))
            {
                addToCartProduct.get(i).click();
            }

        }
    }

    public void clickOnAddToCart(){
        log.info("clicking on add to cart");
        addToCart.click();
    }

    public void clickOnProceedToCheckOut(){
        log.info("clicking on :"+proceedToCheckOut.getText());
        proceedToCheckOut.click();
    }

    public void selectColor(String data){
        new JavaScriptHelper(getDriver()).scrollIntoView(getDriver().findElement(By.xpath("//a[contains(text(),'"+data+"')]/parent::*/preceding-sibling::input[1]")));
        getDriver().findElement(By.xpath("//a[contains(text(),'"+data+"')]/parent::*/preceding-sibling::input[1]")).click();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void selectSmallSize() {
        log.info("selecting small size..");
        getDriver().findElement(By.xpath("//*[@id='layered_id_attribute_group_1']")).click();
    }

    public void selectMediumSize() {
        log.info("selecting Medium size..");
        try {
            boolean selected = getDriver().findElement(By.xpath("//*[@id='layered_id_attribute_group_2']']")).isSelected();
            if (!selected) {
                getDriver().findElement(By.xpath("//*[@id='layered_id_attribute_group_2']']")).click();
                log.info("checkbox is checked..");
            }
        } catch (Exception e) {
            log.info("checkbox was already checked..");
        }
    }

    public void selectLSize() {
        log.info("selecting Large size..");
        try {
            boolean selected = getDriver().findElement(By.xpath("//*[@id='layered_id_attribute_group_3']")).isSelected();
            if (!selected) {
                getDriver().findElement(By.xpath("//*[@id='layered_id_attribute_group_3']")).click();
                log.info("checkbox is checked..");
            }
        } catch (Exception e) {
            log.info("checkbox was already checked..");
        }
    }

    public void selectFirstProduct() {
        Actions obj = new Actions(getDriver());
        log.info("performing mouse over on first product of page..");
        obj.moveToElement(totalProducts.get(0)).build().perform();
        log.info("clicking on add to basket..");
        addToCart.click();
    }

    public int getTotalProducts(){
        return totalProducts.size();
    }

    public List<WebElement> getAllProductsPrice(){
        return allPriceElements;
    }

    public void selectSortByFilter(String dataToSelect){
        DropDownHelper dropdown = new DropDownHelper(getDriver());
        dropdown.SelectUsingVisibleText(sortBy, dataToSelect);
    }

    public boolean verifyArrayHasAscendingData(ArrayList<Integer> array){
        for (int i = 0; i < array.size() - 1; i++) {
            // this condition will check all next price should be smaller than previous one.
            // next price can be grater and equal
            if (array.get(i) <= array.get(i + 1)) {
                log.info("obj.get(i).." + array.get(i));
                log.info("obj.get(i+1).." + array.get(i + 1));
            } else {
                log.info("price filter is not working");
                return false;
            }
        }
        return true;
    }

    public ArrayList<Integer> getPriceMassagedData(Iterator<WebElement> itr){
        ArrayList<Integer> array = new ArrayList<Integer>();
        while (itr.hasNext()) {
            String p = itr.next().getText();
            if (p.contains("$")) {
                String actualData = p.substring(1);
                log.info(actualData);
                double p1 = Double.parseDouble(actualData);
                int productPrice = (int) (p1);
                array.add(productPrice);
            }
        }
        return array;
    }

}

