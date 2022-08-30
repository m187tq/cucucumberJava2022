package com.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.BasePage;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class add_Multiple_Items extends BasePage {

    public add_Multiple_Items() throws IOException {
        super();
    }

    @Test
    public void AddItemsToCart(){

        getDriver().get("https://automationteststore.com/index.php?rt=product/category&path=43_46");

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

}
