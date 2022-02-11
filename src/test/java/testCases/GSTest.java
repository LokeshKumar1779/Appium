package testCases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import pageObjects.HomePage_GS;
import utilities.UtilityMethods;

public class GSTest extends base {

	
	@BeforeTest
	public void killAllNode() throws IOException, InterruptedException {
		
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
	}

	//(dataProvider="inputData" , dataProviderClass=TestData.class)
	
	@Test
	public static void addProductToCart() throws IOException, InterruptedException {
		server = startServer();
		AndroidDriver<AndroidElement> driver = capabilities("GeneralStoreApp","APP_PACKAGE_GS","APP_ACTIVITY_GS");
		HomePage_GS hp = new HomePage_GS(driver);

		hp.countryDD.click();
		UtilityMethods um = new UtilityMethods(driver);
		um.scrollToText("Angola");
		hp.desiredText.click();
		hp.nameField.sendKeys("Lokesh");
//		driver.hideKeyboard();
//		driver.pressKey(new KeyEvent(AndroidKey.BACK));
//		Thread.sleep(2000);
		hp.radioFemaleBtn.click();
		hp.letShopBtn.click();
		driver.quit();
		server.stop();
	}
	

	




}
