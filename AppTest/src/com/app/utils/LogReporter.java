/**
 * 
 */
package com.app.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

/**
 * @author roopesh.sharma
 *
 */
public class LogReporter {
	
	/**
	 * Method will used to step reporting
	 * @param msg Show message on step
	 * 		  flag To decide screenshot is taken or not
	 */
	public static void stepReporting(WebDriver driver,String msg, boolean flag) throws Exception {
		String path = "#";
		String str = "NA";
		if(flag) {
			path = takeScreenshot(driver);
			str = "Screenshot";
		}
		String logMsg = "<div style=\"display:table-row;border: 1px solid navy;margin:20px;padding: 10px;\">" + 
				"<div style=\"display:table-cell;margin-right:300px;border: 1px solid navy;\">" + 
				msg+ " </div>" + 
				"<div style=\"display:table-cell;margin-left:30px;border: 1px solid navy;\"><a href=\""+path+"\">"+str+"</a>" + 
				"</div>" + "</div></br>";
		Reporter.log(logMsg);		 
		}
	
	/**
	 * Method will take screenshot
	 * @return file path i.e. used in step reporting to attach screenshot
	 */
	public static String takeScreenshot(WebDriver driver) {
		String timeStamp;
		File screenShotName;
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
		screenShotName = new File(System.getProperty("user.dir")+"/screenshot/"+timeStamp+".png");
		try {
			FileUtils.copyFile(scrFile, screenShotName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String filePath = screenShotName.toString();
		return filePath;
	}

}
