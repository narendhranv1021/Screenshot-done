package org.facesshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sshot {
	static WebDriver d;

	private static void screenshot(String data) throws IOException {
		TakesScreenshot t = (TakesScreenshot) d;
		File f = t.getScreenshotAs(OutputType.FILE);
		System.out.println(f);
		File h = new File("E:\\Workspaces\\S.shot\\Screenshots\\" + data);
		FileUtils.copyFile(f, h);
	}

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "E:\\Workspaces\\Selenium\\Driver\\chromedriver.exe");
		d = new ChromeDriver();
		d.get("https://www.facebook.com/");
		screenshot("fb.png");
		WebElement k = d.findElement(By.id("email"));
		k.sendKeys("narendhran");
		screenshot("username.png");
		WebElement j = d.findElement(By.id("pass"));
		j.sendKeys("1234567890");
		screenshot("password.png");
		WebElement v = d.findElement(By.xpath("//input[@value='Log In']"));
		v.click();
		screenshot("login.png");

	}
}
