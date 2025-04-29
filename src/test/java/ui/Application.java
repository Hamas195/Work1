package ui;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import java.awt.AWTException;
import java.util.List;
import java.util.ArrayList;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.Set;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.awt.*;
public class Application {
	public static String browser = "chrome";
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, AWTException {

		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("Firefox")) {
			driver = new FirefoxDriver();
		}

		driver.get("https://dev.rentmor.com/signin");
		driver.manage().window().maximize();
		String currurl = driver.getCurrentUrl();
		System.out.println(currurl);
		Thread.sleep(1000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Actions actions = new Actions(driver);

		WebElement emailField = driver.findElement(By.id("email"));
		emailField.sendKeys("seseh32525@exclussi.com");
		Thread.sleep(1000);

		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("Rent123!");
		Thread.sleep(1000);
		WebElement signInButton = driver.findElement(By.xpath("/html/body/main/div[1]/div/form/button"));
		signInButton.click();
		Thread.sleep(6000);
		WebElement application = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/aside[1]/div[1]/nav[1]/ul[1]/li[4]/a[1]/span[1]")));
		Thread.sleep(3000);
		application.click();
		Thread.sleep(6000);
		
		
		WebElement clickpro = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[4]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/a[1]/span[1]"));
		clickpro.click();
		Thread.sleep(3000);

		WebElement screen = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[1]/button[1]"));
		screen.click();
		Thread.sleep(3000);
		
	}
		
		
}
		
		

