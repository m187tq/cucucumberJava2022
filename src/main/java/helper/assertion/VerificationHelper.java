package helper.assertion;

import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class VerificationHelper {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(VerificationHelper.class);
	
	public VerificationHelper(WebDriver driver){
		this.driver = driver;
	}
	
	public boolean isDisplayed(WebElement element){
		try{
			element.isDisplayed();
			log.info("element is Displayed.."+element.getText());
			return true;
		}
		catch(Exception e){
			log.error("element is not Displayed..", e.getCause());
			return false;
		}
	}

	public boolean isEnabled(WebElement element){
		try{
			element.isEnabled();
			log.info("element is enabled.."+element.getText());
			return true;
		}
		catch(Exception e){
			log.error("element is not enabled..", e.getCause());
			return false;
		}
	}

	public boolean isSelected(WebElement element) {

		try{
			element.isSelected();
			System.out.println("The element is Selected:  " + "<" + element + ">");
			log.info("The element is Selected:  " + "<" + element + ">");
			return true;
		}
		catch(Exception e){
			System.out.println("The element is not Selected.... ");
			log.error("The element is not Selected: ", e.getCause());
			return false;
		}
	}
	
	public boolean isNotDisplayed(WebElement element){
		try{
			element.isDisplayed();
			log.info("element is present.."+element.getText());
			return false;
		}
		catch(Exception e){
			log.error("element is not present..");
			return true;
		}
	}
	
	public String readValueFromElement(WebElement element){
		if(null == element){
			log.info("WebElement is null..");
			return null;
		}
		boolean status = isDisplayed(element);
		if(status){
			log.info("element text is .."+element.getText());
			return element.getText();
		}
		else{
			return null;
		}
	}
	public String getText(WebElement element){
		if(null == element){
			log.info("WebElement is null..");
			return null;
		}
		boolean status = isDisplayed(element);
		if(status){
			log.info("element text is .."+element.getText());
			return element.getText();
		}
		else{
			return null;
		}
	}
	
	public String getTitle(){
		log.info("page title is: "+driver.getTitle());
		return driver.getTitle();
	}
	
	
}
