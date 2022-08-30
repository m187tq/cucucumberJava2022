package pages;

import helper.logger.LoggerHelper;
import helper.wait.WaitHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.List;

public class NavigationMenuPage extends BasePage {
	public static Logger log = LoggerHelper.getLogger(NavigationMenuPage.class);
	public NavigationMenuPage() throws IOException {
		super();
	}
	@FindBy(xpath = "//*[@id=\"categorymenu\"]/nav/ul/li")
	private List<WebElement> menuList;

	@FindBy(css = "a.menu_home")
	private WebElement homeMenu;

	@FindBy(linkText = "APPAREL & ACCESSORIES")
	private WebElement apparelAccessories;

	@FindBy(linkText = "MAKEUP")
	private WebElement makeup;

	@FindBy(linkText = "SKINCARE")
	private WebElement skincare;

	@FindBy(linkText = "FRAGRANCE")
	private WebElement fragrance;

	@FindBy(linkText = "MEN")
	private WebElement men;

	@FindBy(linkText = "HAIR CARE")
	private WebElement hairCare;

	@FindBy(linkText = "BOOKS")
	private WebElement books;


	public ProductIDPage clickOnMenu(WebElement element) throws IOException {
		log.info("clicking on : "+element.getText());
		waitForWebElementAndClick(element);
		return new ProductIDPage();
	}
	public ProductIDPage clickOnItem(String data) throws IOException {
		log.info("clicking on :"+data);
		WebElement item = getDriver().findElement(By.xpath("//*[contains(text(),'"+data+"')]"));
		waitForWebElementAndClick(item);
		return new ProductIDPage();
	}
	public void mouseOver(String data){
		log.info("doing mouse over on :"+data);
		Actions action = new Actions(getDriver());
		action.moveToElement(getDriver().findElement(By.xpath("//*[contains(text(),'"+data+"')]"))).build().perform();
	}
	public void mouseOverOnProduct(int number){
		String fPart = "//*[@id='center_column']/ul/li[";
		String sPart = "]/div/div[2]/h5/a";
		Actions action = new Actions(getDriver());
		log.info("doing mouse over on: "+number+"..product");
		action.moveToElement(getDriver().findElement(By.xpath(fPart+number+sPart))).build().perform();
	}

	public List<WebElement> getMenuList() {
		return menuList;
	}

	public WebElement getHomeMenu() {
		return homeMenu;
	}

	public WebElement getApparelAccessories() {
		return apparelAccessories;
	}

	public WebElement getMakeup() {
		return makeup;
	}

	public WebElement getSkincare() {
		return skincare;
	}

	public WebElement getFragrance() {
		return fragrance;
	}

	public WebElement getMen() {
		return men;
	}

	public WebElement getHairCare() {
		return hairCare;
	}

	public WebElement getBooks() {
		return books;
	}


}