package com.HybridFramework.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class Base {

	public org.apache.logging.log4j.Logger logger;
	public static WebDriver driver;
	public FileInputStream fis;
	public Properties prop;

	@BeforeTest
	@Parameters("Browser")
	public void setup(String browserName) throws IOException {
		prop = new Properties();
		fis = new FileInputStream("./src//test//resources//data.properties");
		prop.load(fis);
		logger = LogManager.getLogger();

		switch (browserName.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "chromeheadless":
		    ChromeOptions options = new ChromeOptions();
		    options.addArguments("--headless=new");
		    options.addArguments("--window-size=1920,1080");
		    options.addArguments("--disable-gpu");
		    options.addArguments("--start-maximized");

		    driver = new ChromeDriver(options);  
		    break;

		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Wrong Browser Selection");
			return;
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.get("https://tutorialsninja.com/demo/");
		driver.get(prop.getProperty("baseUrl"));

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	public String getRandomString() {
		return RandomStringUtils.randomAlphabetic(6);
	}

	public String getRandomNum() {
		return RandomStringUtils.randomNumeric(10);
	}

	public String getAlphaNum() {
		String str = RandomStringUtils.randomAlphabetic(4);
		String val = RandomStringUtils.randomNumeric(3);
		return (str + val + "@");

	}

	public String getScreenshot(String methodName) throws IOException {
		String currentTimeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String targetFilepath = System.getProperty("user.dir") + "\\screenshots\\" + methodName + "_" + currentTimeStamp
				+ ".png";
		File targetFile = new File(targetFilepath);
		FileUtils.copyFile(srcFile, targetFile);
		return targetFilepath;
	}

}
