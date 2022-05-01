package pages;


import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class PaymentModeEditPage extends BasePage {
    public static Logger log = LoggerHelper.getLogger(PaymentModeEditPage.class);
    public PaymentModeEditPage() throws IOException {
        super();
    }

    @FindBy(css = ".paymentProviderHeader-name")
    private WebElement testGatewayTxt;

    @FindBy(css = "#ccNumber")
    private WebElement ccNumberBox;





}
