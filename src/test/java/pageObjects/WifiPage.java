package pageObjects;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WifiPage {
	
	public WifiPage(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="android:id/checkbox")
	private AndroidElement wifisettingchkbox;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='WiFi settings']")
	private AndroidElement wifisettingbtn;
	
	@AndroidFindBy(id="android:id/edit")
	private AndroidElement wifisettingEditbox;
	
	@AndroidFindBy(id="android:id/button1")
	private AndroidElement wifisettingOKbtn;

	public RemoteWebElement getwifisettingchkbox() {
		// TODO Auto-generated method stub
		return wifisettingchkbox;
	}

	public RemoteWebElement getwifisettingbtn() {
		// TODO Auto-generated method stub
		return wifisettingbtn;
	}

	public RemoteWebElement getwifisettingEditbox() {
		// TODO Auto-generated method stub
		return wifisettingEditbox;
	}

	public RemoteWebElement getwifisettingOKbtn() {
		// TODO Auto-generated method stub
		return wifisettingOKbtn;
	}

}
