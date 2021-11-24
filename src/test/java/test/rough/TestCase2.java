package test.rough;

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
import test.testcases.BaseTest;

public class TestCase2 extends BaseTest{
	
	
	
	@Test(dataProvider="getData")
	public void doLogin(String username , String password ,String browser){
		openBrowser(browser);
		ZohoHomePage home= new ZohoHomePage().open("https://www.zoho.com/index1.html");
		ZohoLoginPage page =home.gotoLogin();
		page.Validlogin(username, password);
		
		/*getDriver().findElement(By.xpath("//*[@id='block-system-main']/div/div[1]/div/div/div[3]/div/div[4]/div/a[1]")).click();
		getDriver().findElement(By.xpath("//*[@id='login_id']")).sendKeys(username);
		getDriver().findElement(By.xpath("//*[@id='nextbtn']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getDriver().findElement(By.xpath("//*[@id='password']")).sendKeys(password);
		getDriver().findElement(By.xpath("//*[@id='nextbtn']/span")).click();*/
	    quit();
		
	}
	
	@DataProvider(parallel=true)
	public Object[][] getData(){
		
		Object[][] data= new Object[1][3];
		
		data[0][0]= "harishr24690@gmail.com";
		data[0][1]="harish9731332306";
		data[0][2]="chrome";
		
		
		
		return data;
	}

}


