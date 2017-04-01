package com.lib;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;



import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.AndroidServerFlag;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class BaseLib {
	
	
	public static  AndroidDriver driver;
	public String apkpath = null;
	public String Appium_node="C:\\Program Files (x86)\\Appiumlatest\\node.exe";
	public String Appium_js="C:\\Program Files (x86)\\Appiumlatest\\node_modules\\appium\\bin\\appium.js";
	public AppiumDriverLocalService appiumService;
	public DesiredCapabilities capabilities;
	@Parameters({ "udid", "port" })
	@BeforeTest
	public void startserver(String udid,String port){
		
		appiumService = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.usingPort(Integer.parseInt(port)).usingDriverExecutable(new File(Appium_node))
				.withArgument(GeneralServerFlag.ROBOT_ADDRESS, udid).withAppiumJS(new File(Appium_js))
				.withArgument(AndroidServerFlag.BOOTSTRAP_PORT_NUMBER, (Integer.parseInt(port) + 10 + "")));
		// .withLogFile(new File("D:/" + udid + ".log")));
		appiumService.start();

	
	}
	@Parameters({ "port", "deviceName", "platformVersion", "udid","apkPath" })

	@BeforeClass
	public void setup(String port, String deviceName, String platformVersion, String udid,String apkpPath){
		apkpath = GenericLib.sDirpath + "\\" + apkpPath + ".apk";

		File app = new File(apkpath);
		try{
			capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,
					GenericLib.getprop("AUTOMATIONNAME"));
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,
					GenericLib.getprop("AUTOMATIONNAME"));
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			capabilities.setCapability(MobileCapabilityType.UDID, udid);
			capabilities.setCapability("app", app.getAbsolutePath());
			//capabilities.setCapability("appPackage", GenericLib.getCongigValue(sConfigFile, "VoonikPackage"));
			//capabilities.setCapability("appActivity", GenericLib.getCongigValue(sConfigFile, "VoonikActivity"));
			//capabilities.setCapability("fullReset", false);
			driver = new AndroidDriver(new URL("http://127.0.0.1:" + port + "/wd/hub"), capabilities);
		}catch(Exception e){
		
		}
		
	}
	
	@AfterClass
	public void stopserver(){
		appiumService.stop();
	}
	
	
	

}
