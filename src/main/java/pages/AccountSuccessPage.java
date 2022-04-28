package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class AccountSuccessPage extends BasePage {
    public AccountSuccessPage() throws IOException {
        super();
    }


    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/h2[1]/span[1]")
    public WebElement myAccountText;
    @FindBy(css = ".btn.btn-default.mr10")
    public WebElement continueAccountSuccessBtn;

    @FindBy(xpath = "//*[@id=\"customer_menu_top\"]/li/a/div")
    public WebElement accountHasBeenCreatedHeadingTxt;


    public boolean validateMyAccountTxtIsDisplayed() {
        waitFor(myAccountText);
        return act.isDisplayed(getDriver(), myAccountText);
    }
    public boolean validateAccountHasBeenCreatedHeadingTxtIsDisplayed(String arg1) {
        waitFor(accountHasBeenCreatedHeadingTxt);
        return isDisplayed(accountHasBeenCreatedHeadingTxt);
    }

    public AccountPage clickOnContinueAccountSuccessBtn() throws IOException {
        waitFor(continueAccountSuccessBtn);
        act.click(getDriver(), continueAccountSuccessBtn);
        return new AccountPage();

    }


}
