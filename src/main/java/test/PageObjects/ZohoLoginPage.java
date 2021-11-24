package test.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ZohoLoginPage extends BasePage {

	

	@FindBy(how = How.XPATH, using = "//*[@id='login_id']")
	public WebElement emailblock;

	@FindBy(how = How.XPATH, using = "//*[@id='nextbtn']")
	public WebElement nextBtn;

	@FindBy(how = How.XPATH, using = "//*[@id='password']")
	public WebElement passwordblock;

	@FindBy(how = How.XPATH, using = "//*[@id='nextbtn']/span")
	public WebElement loginBtn;;

	public ZohoLoginPage Invalidlogin(String username, String password) {

		
		type(emailblock,username);              //emailblock.sendKeys(username);
		click(nextBtn);                         //nextBtn.click();
		
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    type(passwordblock,password);	         //passwordblock.sendKeys(password);
		click(loginBtn);                        //loginBtn.click();
		return this;
	}
	
	public ZohoAppPage Validlogin(String username, String password) {

		
		type(emailblock,username);              //emailblock.sendKeys(username);
		click(nextBtn);                         //nextBtn.click();
		
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    type(passwordblock,password);	         //passwordblock.sendKeys(password);
		click(loginBtn);                        //loginBtn.click();
		return (ZohoAppPage) openPage(ZohoAppPage.class);
	}


	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(emailblock);
	}

}
