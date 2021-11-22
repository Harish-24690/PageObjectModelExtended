package test.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import test.listeners.CustomListeners;
import test.utilities.DriverManager;

public class ZohoHomePage extends BasePage{
	
	public WebDriver driver;
	
	
	public ZohoHomePage open(String url){
		
		System.out.println("Page Opened");
		DriverManager.getDriver().navigate().to(url);
		return (ZohoHomePage) openPage(ZohoHomePage.class);
	}
	

	@FindBy(how=How.XPATH,using="//*[@id='block-system-main']/div/div[1]/div/div/div[3]/div/div[4]/div/a[1]")
	public WebElement loginLink;
	
	
	
	public ZohoLoginPage gotoLogin(){
		
		//loginLink.click();
		click(loginLink);
		return (ZohoLoginPage) openPage(ZohoLoginPage.class);
	}



	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(loginLink);
	}
	
	
}


