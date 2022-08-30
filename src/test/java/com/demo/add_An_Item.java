package com.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.BasePage;

import java.io.IOException;
import java.util.List;

public class add_An_Item extends BasePage {

    public add_An_Item() throws IOException {
        super();
    }

    @Test
    public void AddItemsToCart(){

        getDriver().get("https://automationteststore.com/index.php?rt=product/category&path=43_46");

        List<WebElement> itemNames = getDriver().findElements(By.cssSelector(".prdocutname"));
        List<WebElement> addToCartProduct = getDriver().findElements(By.cssSelector("a.productcart"));

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

}
