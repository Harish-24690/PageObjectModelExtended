package test.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.annotations.DataProvider;

import test.PageObjects.BasePage;









public class TestUtil extends BasePage{
	
	public static String screenshotPath;
	public static String screenshotName;

	public static void captureScreenshot() throws IOException   {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		FileUtils.copyFile(scrFile,
				new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName));
		FileUtils.copyFile(scrFile,
				new File(".\\reports\\" + screenshotName));
	}
	
	
	

	
@Override
protected ExpectedCondition getPageLoadCondition() {
	// TODO Auto-generated method stub
	return null;
}
}
