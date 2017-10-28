package com.test.frameworks.AutomationFrameworkProject.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestAdminLoginPage {
	
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shashank Sharma\\workspace\\talentCentralAutomationProject\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testAdminLogin() {
		driver.get("https://talentcentral.cebglobal.com/admin/login");
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("j_username"))).sendKeys("automation.admin@shl.com");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("j_password"))).sendKeys("Shlonline@123");
		driver.findElement(By.id("proceed")).click();
	}
	
	@AfterTest
	public void shutDown() {
		driver.close();
		driver.quit();
	}
}
