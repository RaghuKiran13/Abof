package com.lib;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.hssf.model.WorkbookRecordList;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class GenericLib {
	
	
	public static String sDirpath=System.getProperty("user.dir");
	public static String sconfigfile=sDirpath+"\\cong.properties";
	public static String stestdatafile=sDirpath+"\\Testdata.xlsx";
	
	public static String getprop(String skey){
		String svalue=null;
		try{
			FileInputStream fis=new FileInputStream(sconfigfile);
			Properties properties=new Properties();
			properties.load(fis);
			svalue=properties.getProperty(skey);
			
		}catch(Exception e){
			
		}
		return svalue;
	}
	
	
	public static String[] readdata(String sTestCasesid)
	{
		String sData[]=null;
		try{
			FileInputStream file=new FileInputStream(stestdatafile);
			Workbook wb=(Workbook)WorkbookFactory.create(file);
			Sheet sh=wb.getSheet("TestData");
			int srow=sh.getLastRowNum();
			for(int i=1;i<=srow;i++){
				if(sh.getRow(i).getCell(0).toString().equals(sTestCasesid)){
					int scell=sh.getRow(i).getLastCellNum();
					sData=new String[scell];
					for(int j=0;j<scell;j++){
						sData[j]=sh.getRow(i).getCell(j).getStringCellValue();
					}
				}
			}
			
		}catch(Exception e){
			
		}
		return sData;
	}
	

}
