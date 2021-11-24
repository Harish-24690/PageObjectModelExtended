package test.testcases;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import test.PageObjects.ZohoAppPage;
import test.PageObjects.ZohoHomePage;
import test.PageObjects.ZohoLoginPage;
import test.utilities.Constants;
import test.utilities.DataProviders;
import test.utilities.DataUtil;
import test.utilities.DriverManager;
import test.utilities.ExcelReader;

public class ZohoCRMPageTest extends BaseTest{
	
	@Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
	public void zohoCRMPageTest(Hashtable<String ,String>data) {
		
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "ZohoCRMPageTest", data.get("Runmode"), excel);
		openBrowser(data.get("browser"));
		ZohoHomePage home = new ZohoHomePage().open("https://www.zoho.com/index1.html");
		ZohoLoginPage page = home.gotoLogin();
		ZohoAppPage apppage= page.Validlogin(getDefaultUsername(), getDefaultPassword());
		apppage.crm();
		quit();
		

	}
	

}
