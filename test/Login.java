package test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Login {
	@Test
	public void setUpGrid() throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = null;
		RemoteWebDriver driver = null;
		String node1 = "http://172.25.12.21:5566/wd/hub";
		String node2 = "http://172.25.12.21:5567/wd/hub";
		String node3 = "http://172.25.12.21:5568/wd/hub";		
		
		initDriver("chrome",node1,cap,driver);
		initDriver("firefox",node2,cap,driver);
		initDriver("IE",node3,cap,driver);
	}
	
	public void initDriver(String browserName, String node, DesiredCapabilities cap, RemoteWebDriver driver) throws MalformedURLException, InterruptedException {
		if(browserName.equalsIgnoreCase("chrome")) {
			cap = DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			driver = new RemoteWebDriver(new URL(node), cap);
			getNewsTitle(driver);
		}
		if(browserName.equalsIgnoreCase("firefox")) {
			cap = DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			driver = new RemoteWebDriver(new URL(node), cap);
			getNewsTitle(driver);
		}
		if(browserName.equalsIgnoreCase("IE")) {
			cap = DesiredCapabilities.internetExplorer();
			cap.setBrowserName("internet explorer");
			driver = new RemoteWebDriver(new URL(node), cap);
			getNewsTitle(driver);
		}		
		
	}
	
	public void getNewsTitle(RemoteWebDriver driver) throws InterruptedException {
		driver.get("https://in.yahoo.com/?p=us");
		driver.findElement(By.xpath("//div[@id=\"mega-bottombar\"]/ul/li[3]/a")).click();
		Thread.sleep(2000);
		driver.getTitle();
		System.out.println(driver.getTitle());
	}
}
