package test.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import test.PageObjects.BasePage;
import test.listeners.CustomListeners;
import test.utilities.DriverFactory;
import test.utilities.DriverManager;


public class BaseTest {

	private WebDriver driver;
	private Properties config = new Properties();
	private FileInputStream fis;
	public boolean grid = false;
	
	@BeforeSuite
	public void setUpFramework(){
		
		DriverFactory.setGridPath("http://localhost:4444/wd/hub");
		DriverFactory.setConfigPropertyFile(
				System.getProperty("user.dir") + "//src//test//resources//properties//Config.properties");
		
		if (System.getProperty("os.name").contains("mac")) {

			DriverFactory.setChromeDriverExePath(
					System.getProperty("user.dir") + "//src//test//resources//executables.chromedriver");
			DriverFactory.setGeckoDriverExepath(
					System.getProperty("user.dir") + "//src//test//resources//executables//geckodriver");
		} else {
			DriverFactory.setChromeDriverExePath(
					System.getProperty("user.dir") + "//src//test//resources//executables.chromedriver.exe");
			DriverFactory.setGeckoDriverExepath(
					System.getProperty("user.dir") + "//src//test//resources//executables//geckodriver.exe");
		}
		try {
			fis = new FileInputStream(DriverFactory.getConfigPropertyFile());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			config.load(fis);
			// log.info("Configuration file loaded");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void openBrowser(String browser) {
		
		if(System.getenv("ExecutionType")!=null && System.getenv("ExecutionType").equals("Grid")){
			grid= true;
		}
		
		DriverFactory.setRemote(grid);
		if(DriverFactory.isRemote()){
			
			DesiredCapabilities cap = null;
			if (browser.equals("firefox")){
				
				cap = DesiredCapabilities.firefox();
				cap.setBrowserName("firefox");
				cap.setPlatform(Platform.ANY);
			}else if(browser.equals("chrome")){
				cap= DesiredCapabilities.chrome();
				cap.setBrowserName("chrome");
				cap.setPlatform(Platform.ANY);
				
			}else if(browser.equals("ie")){
				cap = DesiredCapabilities.internetExplorer();
				cap.setBrowserName("iexplore");
				cap.setPlatform(Platform.WIN10);
			}
			try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		} else {
			
			if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			logInfo("browser has been launched" +browser);
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			logInfo("browser has been launched" +browser);
		}
		
		}

		DriverManager.setWebDriver(driver);
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	public void quit() {

		DriverManager.getDriver().quit();
	}
	
	public  void logInfo(String message) {
		
		CustomListeners.testReport.get().info(message);
	}
	
}
