package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.List;

public class NavigationMenuPage extends BasePage {


	public NavigationMenuPage() throws IOException {
		super();
	}

	@FindBy(xpath = "//*[@id=\"menu\"]/nav/ul[1]")
	private List<WebElement> subMenuList;

	@FindBy(xpath = "//header/div[@id='menu']/nav[1]/ul[1]/li[1]/a[1]")
	private WebElement gardenDropdownBtn;

	@FindBy(xpath = "//header/div[@id='menu']/nav[1]/ul[1]/li[2]/a[1]")
	private WebElement shopAllBtn;

	@FindBy(xpath = "//header/div[@id='menu']/nav[1]/ul[1]/li[3]/a[1]")
	private WebElement kitchenBtn;

	@FindBy(xpath = "//header/div[@id='menu']/nav[1]/ul[1]/li[4]/a[1]")
	private WebElement publications;

	@FindBy(xpath = "//header/div[@id='menu']/nav[1]/ul[1]/li[5]/a[1]")
	private WebElement utilityBtn;

	@FindBy(xpath = "//header/div[@id='menu']/nav[1]/ul[1]/li[6]/a[1]")
	private WebElement journalBtn;

	@FindBy(xpath = "//header/div[@id='menu']/nav[1]/ul[1]/li[7]/a[1]")
	private WebElement ourStoryBtn;

	@FindBy(xpath = "//header/div[@id='menu']/nav[1]/ul[1]/li[8]/a[1]")
	private WebElement contactUsBtn;

	@FindBy(xpath = "//header/div[@id='menu']/nav[1]/ul[1]/li[9]/a[1]")
	private WebElement shippingAndReturnBtn;


	public ProductIDPage clickOnMenu(WebElement element) throws IOException {
		log.info("clicking on : "+element.getText());
		act.click(getDriver(), element);
		return new ProductIDPage();
	}
	public ProductIDPage clickOnItem(String data) throws IOException {
		log.info("clicking on :"+data);
		WebElement item = getDriver().findElement(By.xpath("//*[contains(text(),'"+data+"')]"));
		act.click(getDriver(), item);
		return new ProductIDPage();
	}


	public List<WebElement> getSubMenuList() {
		return subMenuList;
	}

	public void clickOnGardenDropdownBtn() {
		act.click(getDriver(), gardenDropdownBtn);
	}

	public void clickOnShopAllBtn() {
		act.click(getDriver(), shopAllBtn);
	}

	public void clickOnKitchenBtn() {
		act.click(getDriver(), kitchenBtn);
	}

	public void clickOnPublications() {
		act.click(getDriver(), publications);
	}

	public void clickOnUtilityBtn() {
		act.click(getDriver(), utilityBtn);
	}

	public void clickOnJournalBtn() {
		act.click(getDriver(), journalBtn);
	}

	public void clickOnOurStoryBtn() {
		act.click(getDriver(), ourStoryBtn);
	}

	public void clickOnContactUsBtn() {
		act.click(getDriver(),contactUsBtn);
	}

	public void clickOnShippingAndReturnBtn() {
		act.click(getDriver(), shippingAndReturnBtn);
	}


}