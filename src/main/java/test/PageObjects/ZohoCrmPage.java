package test.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ZohoCrmPage extends BasePage {
	
	@FindBy(how=How.XPATH,using="//*[@id='mini-panel-product_menu']/div/div[1]/div/a")
	public WebElement homeButton;

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(homeButton);
	}

	
	
}
