package pageObjects;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage_GS {
	
	public HomePage_GS(AndroidDriver<AndroidElement> driver) {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="android:id/text1")
	public AndroidElement countryDD;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Angola']")
	public AndroidElement desiredText;

	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	public AndroidElement nameField;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
	public AndroidElement radioFemaleBtn;

	@AndroidFindBy(className="android.widget.Button")
	public AndroidElement letShopBtn;

}
