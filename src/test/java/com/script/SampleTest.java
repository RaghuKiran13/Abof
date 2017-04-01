package com.script;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;
import com.lib.BaseLib;
import com.lib.GenericLib;
import com.po.GooglePo;

public class SampleTest extends BaseLib {
	GooglePo googlepo;
	public static String sTestCasesid=null;
	public static String sData[]=null;
	
	@Test(priority=1,enabled=true,description="the passed testcases")
	public void Googlepage() throws Exception{
		googlepo=new GooglePo(driver);
		sTestCasesid="Google";
		sData=GenericLib.readdata(sTestCasesid);
		try{
			Thread.sleep(3000);
			googlepo.getElegoogleSearchTxtBox().click();
			Thread.sleep(3000);
			
		Thread.sleep(4000);
		}catch(Exception e){
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
		
		
		
		
	}

}
