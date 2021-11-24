package test.testcases;

import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import test.PageObjects.ZohoHomePage;
import test.PageObjects.ZohoLoginPage;
import test.utilities.Constants;
import test.utilities.DataProviders;
import test.utilities.DataUtil;
import test.utilities.ExcelReader;

public class LoginTest extends BaseTest {

	@Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
	public void loginTest(Hashtable<String ,String>data) {
		
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "LoginTest", data.get("Runmode"), excel);
		openBrowser(data.get("browser"));
		ZohoHomePage home = new ZohoHomePage().open("https://www.zoho.com/index1.html");
		ZohoLoginPage page = home.gotoLogin();
		page.Invalidlogin(data.get("username"), data.get("password"));
		quit();

	}

}

/*
 * getDriver().findElement(By.xpath(
 * "//*[@id='block-system-main']/div/div[1]/div/div/div[3]/div/div[4]/div/a[1]")
 * ).click();
 * getDriver().findElement(By.xpath("//*[@id='login_id']")).sendKeys(username);
 * getDriver().findElement(By.xpath("//*[@id='nextbtn']")).click(); try {
 * Thread.sleep(2000); } catch (InterruptedException e) { // TODO Auto-generated
 * catch block e.printStackTrace(); }
 * getDriver().findElement(By.xpath("//*[@id='password']")).sendKeys(password);
 * getDriver().findElement(By.xpath("//*[@id='nextbtn']/span")).click();
 */
