package testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class base {

	
	public static AppiumDriverLocalService server;
	public static AndroidDriver<AndroidElement> driver;

	public static AppiumDriverLocalService startServer() {

		/*
		 * serviceBuilder = new AppiumServiceBuilder();
		 * serviceBuilder.usingDriverExecutable(new
		 * File("C:\\Program Files\\nodejs\\node.exe")); serviceBuilder.withAppiumJS(new
		 * File("C:\\Users\\kumar\\AppData\\Local\\Programs\\Appium Server GUI\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"
		 * )); server = AppiumDriverLocalService.buildService(serviceBuilder);
		 * server.start();
		 */
		boolean serverFlag = checkIfServerIsRunning(4723);
		if (!serverFlag) {
			server = AppiumDriverLocalService.buildDefaultService();
			server.start();
		}
		return server;

	}

	public static boolean checkIfServerIsRunning(int port) {
		boolean isServerRuning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			// TODO: handle exception
//			If control comes here then it means that the port is in use
			isServerRuning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRuning;

	}

	public static AndroidDriver<AndroidElement> capabilities(String apkFile, String APP_PACK, String APP_ACT)
			throws IOException, InterruptedException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\data.properties");
		Properties prop = new Properties();
		prop.load(fis);

		DesiredCapabilities dc = new DesiredCapabilities();
//		String device = prop.getProperty("DEVICE_NAME");
		String device = System.getProperty("DEVICE_NAME");
		System.out.println("device : " +device);
		if(device.contains("emulator")) {			
			startEmulator();
		} 
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,14);
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

//		If the app is installed on device
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, prop.getProperty(APP_PACK));
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, prop.getProperty(APP_ACT));

//		If the app is not installed on device
		/*
		 * String appName = prop.getProperty("apkFile"); File app = new
		 * File(System.getProperty("user.dir")+"\\src\\test\\resources\\"+appName);
		 * dc.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		 */

		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		driver = new AndroidDriver<AndroidElement>(url, dc);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;

	}

	private static void startEmulator() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\test\\resources\\startEmulator.bat");
		Thread.sleep(10000);
	}
	
	public static void getScreenShot(String s) throws IOException {
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenShots\\"+s+".png"));
	}

}
