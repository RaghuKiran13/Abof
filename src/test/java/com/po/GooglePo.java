package com.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class GooglePo {
	
	AndroidDriver driver;
	
	public GooglePo(AndroidDriver ldriver){
		
		this.driver=ldriver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="com.example.simplecamera:id/button1")
	private WebElement googleSearchTxtBox;
	
	public WebElement getElegoogleSearchTxtBox(){
		return googleSearchTxtBox;
	}
	
	@FindBy(id="tsbb")
	private WebElement googleSearchBtn;
	public WebElement getgoogleSearchBtn()
	{
		return googleSearchBtn;
		
	}
	

}
