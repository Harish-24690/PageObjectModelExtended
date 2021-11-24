package test.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ZohoAppPage extends BasePage {
	
	@FindBy(how =How.XPATH,using="//*[@id='zl-myapps']/div[1]/div[4]/div/a/span")
	public WebElement cliqLink;

	@FindBy(how =How.XPATH,using="//*[@id='block-system-main']/div/div[3]/section[2]/div/div/ul/li[1]/a/span[2]/label")
	public WebElement crmLink;
	
	@FindBy(how=How.XPATH,using="//*[@id='zl-myapps']/div[1]/div[7]/div/a/span")
	public WebElement deskLink;
	
	
	public void cliq(){
		
		click(cliqLink);
	}
	public ZohoCrmPage crm(){
		
		click(crmLink);
		return (ZohoCrmPage) openPage(ZohoCrmPage.class);
	}
	public void Desk(){
		
		click(deskLink);
	}
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(crmLink);
	}
	
}
