package testCases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import pageObjects.HomePageDM;
import pageObjects.HomePage_GS;
import pageObjects.PreferencePage;
import pageObjects.WifiPage;

public class APIDemoTest extends base {
	

	@Test
	public static void DemoAppTC_01() throws IOException, InterruptedException {
		server = startServer();
		AndroidDriver<AndroidElement> driver = capabilities("APIDemoTestApp","APP_PACKAGE_DM","APP_ACTIVITY_DM");
		HomePageDM hp = new HomePageDM(driver);
		hp.getPreferenceBtn().click();
		PreferencePage pp = new PreferencePage(driver);
		pp.getpreferencedepBtn().click();
		WifiPage wp = new WifiPage(driver);
		wp.getwifisettingchkbox().click();
		wp.getwifisettingbtn().click();
		wp.getwifisettingEditbox().sendKeys("Hello");
		wp.getwifisettingOKbtn().click();
		driver.quit();
		server.stop();
		

	}

	

}
