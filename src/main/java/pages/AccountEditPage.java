package pages;

import helper.javaScript.JavaScriptHelper;
import helper.logger.LoggerHelper;
import io.cucumber.datatable.DataTable;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class AccountEditPage extends BasePage {
    public static Logger log = LoggerHelper.getLogger(AccountEditPage.class);
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
        log.info("Successfully Sent the following keys: '" + FirstName + "' to element: " + "<"+ firstNameBox.toString() + ">");
        sendKeysToWebElement(firstNameBox, FirstName);
    }

    public void enterLastNameBox(String Lastname) throws Exception {
        log.info("Successfully Sent the following keys: '" + Lastname + "' to element: " + "<"+ lastNameBox.toString() + ">");
        sendKeysToWebElement(lastNameBox, Lastname);

    }

    public void enterFreshEmailBox() throws Exception {
        log.info("Successfully Sent the following keys: '" + email + "' to element: " + "<"+ emailBox.toString() + ">");
        sendKeysToWebElement(emailBox, email);

    }

    public void enterTelephoneBox(String Telephone) throws Exception {
        log.info("Successfully Sent the following keys: '" + Telephone + "' to element: " + "<"+ telephoneBox.toString() + ">");
        sendKeysToWebElement(telephoneBox, Telephone);

    }

    public void enterFaxBox(String Fax) throws Exception {
        log.info("Successfully Sent the following keys: '" + Fax + "' to element: " + "<"+ faxBox.toString() + ">");
        sendKeysToWebElement(faxBox, Fax);

    }

    public AccountPage clickOnContinueEditBtn() throws IOException {
        waitFor(continueEditBtn);
        new JavaScriptHelper(getDriver()).scrollToElement(continueEditBtn);
        waitForWebElementAndClick(continueEditBtn);
        log.info("Waited and clicked on the element...");
        log.info("Returning new AccountPage... ");
        return new AccountPage();

    }

    public void updatingProfileDetails(String firstname, String lastname, String telephone, String fax) throws Exception {
        log.info("editing Profile Details....");
        enterFirstNameBox(firstname);
        log.info("Sent data to the element: " + firstname);
        enterLastNameBox(lastname);
        log.info("Sent data to the element: " + lastname);
        enterFreshEmailBox();
        log.info("Sent Fresh Email to the element...");
        enterTelephoneBox(telephone);
        log.info("Sent data to the element: " + telephone);
        enterFaxBox(fax);
        log.info("Sent data to the element: " + fax);


    }

    public void userUpdateProfile(DataTable dataTable) throws Exception {
        sendKeysToWebElement(firstNameBox, dataTable.cell(1, 0));
        log.info("Sent data to the element: " + dataTable.cell(1, 0));
        sendKeysToWebElement(lastNameBox, dataTable.cell(1, 1));
        log.info("Sent data to the element: " + dataTable.cell(1, 1));
        enterFreshEmailBox();
        log.info("Sent generated Email to the element...");
        sendKeysToWebElement(telephoneBox, dataTable.cell(1, 2));
        log.info("Sent data to the element: " + dataTable.cell(1, 2));
        sendKeysToWebElement(faxBox, dataTable.cell(1, 3));
        log.info("Sent data to the element: " + dataTable.cell(1, 3));
    }

}
