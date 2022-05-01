package pages;

import helper.javaScript.JavaScriptHelper;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.globalVars;

import java.io.IOException;

public class AccountEditPage extends BasePage {
    String email = System.currentTimeMillis() + "@gmail.com";

    public AccountEditPage() throws IOException {
        super();
    }

    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/h1[1]/span[1]")
    public WebElement myaccountInformationHeadingtext;

    @FindBy(name = "firstname")
    public WebElement firstNameBox;
    @FindBy(xpath = "//*[@id=\"AccountFrm_lastname\"]")
    public WebElement lastNameBox;

    @FindBy(id = "AccountFrm_email")
    public WebElement emailBox;
    @FindBy(css = "#AccountFrm_telephone")
    public WebElement telephoneBox;
    @FindBy(css = "#AccountFrm_fax")
    public WebElement faxBox;
    @FindBy(xpath = "//*[@id=\"AccountFrm\"]/div[2]/div/button")
    public static WebElement continueEditBtn;


    public boolean validateUserOnAccountEditPageIsDisplayed() throws InterruptedException {
        waitFor(myaccountInformationHeadingtext);
        return myaccountInformationHeadingtext.isDisplayed();
    }

    public void enterFirstNameBox(String FirstName) throws Exception {
        sendKeysToWebElement(firstNameBox, FirstName);
    }

    public void enterLastNameBox(String Lastname) throws Exception {
        sendKeysToWebElement(lastNameBox, Lastname);

    }

    public void enterFreshEmailBox() throws Exception {
        sendKeysToWebElement(emailBox, email);

    }

    public void enterTelephoneBox(String Telephone) throws Exception {
        sendKeysToWebElement(telephoneBox, Telephone);

    }

    public void enterFaxBox(String Fax) throws Exception {
        sendKeysToWebElement(faxBox, Fax);

    }

    public AccountPage clickOnContinueEditBtn() throws IOException, InterruptedException {
        act.explicitWait(getDriver(), continueEditBtn, globalVars.getExplicitWait());
        new JavaScriptHelper(getDriver()).scrollToElement(continueEditBtn);
        act.JSClick(getDriver(), continueEditBtn);
        return new AccountPage();

    }

    public void updatingProfileDetails(String firstname, String lastname, String telephone, String fax) throws Exception {
        log.info("editing Profile Details....");
        enterFirstNameBox(firstname);
        enterLastNameBox(lastname);
        enterFreshEmailBox();
        enterTelephoneBox(telephone);
        enterFaxBox(fax);
        log.info("editing Profile Details....");

    }

    public void userUpdateProfile(DataTable dataTable) throws Exception {
        sendKeysToWebElement(firstNameBox, dataTable.cell(1, 0));
        sendKeysToWebElement(lastNameBox, dataTable.cell(1, 1));
        enterFreshEmailBox();
        sendKeysToWebElement(telephoneBox, dataTable.cell(1, 2));
        sendKeysToWebElement(faxBox, dataTable.cell(1, 3));
    }

}
