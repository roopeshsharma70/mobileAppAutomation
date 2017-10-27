package com.app.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author roopesh.sharma
 *
 */
public class AppAttributes {

	protected static String APPIUM_NODE_PATH;
	public static String APPIUM_JS_PATH;
	public static String PLATFORM_VERSION;
	public static String DEVICE_NAME;
	public static String PLATFORM_NAME;
	public static String UDID;
	public static String APP_PACKAGE;
	public static String APP_ACTIVITY;
	public static String SEARCH_KEYWORD;
	public static String APP;

	/**
	 * Method will set config form config properties file
	 */
	public void setConfig(String file) {
		Properties prop = new Properties();
		try {
			String separator = System.getProperty("file.separator");
			String user_dir = System.getProperty("user.dir");

			String properties_dir = user_dir + separator + "src" + separator + "com" + separator +"app"+ separator
					+ "config" + separator;
			
			String fileName = properties_dir + separator + file + ".properties";
			InputStream is = new FileInputStream(fileName);
			
			prop.load(is);
			
			APPIUM_NODE_PATH = prop.getProperty("Appium_Node_Path");
			APPIUM_JS_PATH = prop.getProperty("Appium_JS_Path");
			PLATFORM_VERSION = prop.getProperty("platformVersion");
			DEVICE_NAME = prop.getProperty("deviceName");
			PLATFORM_NAME = prop.getProperty("platformName");
			UDID = prop.getProperty("udid");
			APP_PACKAGE = prop.getProperty("appPackage");
			APP_ACTIVITY = prop.getProperty("appActivity");
			SEARCH_KEYWORD=prop.getProperty("keyword");
			APP = user_dir + separator + "app" + separator + "Snapdeal-universal-debug.apk";
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
