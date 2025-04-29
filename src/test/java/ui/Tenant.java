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

public class Tenant {
	
	
	
	public static String browser = "chrome";
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException, AWTException {
		
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("Firefox")) {
			driver = new FirefoxDriver();
		}
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int centerX = screenSize.width / 2;
		int centerY = screenSize.height / 2;
		Robot robot = new Robot();
		driver.get("https://dev.rentmor.com/signin");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		WebElement emailField2 = driver.findElement(By.id("email"));
		emailField2.sendKeys("uitesting090@gmail.com");
		Thread.sleep(1000);
		WebElement passwordField2 = driver.findElement(By.id("password"));
		passwordField2.sendKeys("Rent123!");
		Thread.sleep(1000);
		WebElement signInButton2 = driver.findElement(By.xpath("/html/body/main/div[1]/div/form/button"));
		signInButton2.click();
		Thread.sleep(14000);

		robot.mouseMove(centerX, centerY);
		Thread.sleep(3000);

		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

		System.out.println("Clicked at (500, 300)");
		Thread.sleep(2000);
		WebElement search = driver.findElement(By.id("home-address"));
		search.click();
		search.sendKeys("Guth");
		Thread.sleep(1000);
		WebElement dropdownOption = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='pac-item'])[2]")));
		dropdownOption.click();
		Thread.sleep(4000);
		WebElement clickpro = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/a[1]/div[1]/div[1]/div[1]"));
		clickpro.click();
		Thread.sleep(2000);

		List<String> tabs = new ArrayList<>(driver.getWindowHandles());

		// Switch to the second tab (index 1)
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(2000);
		WebElement reqpro = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@type='button'][normalize-space()='Request to Apply']")));
		Thread.sleep(3000);
		reqpro.click();
		Thread.sleep(2000);
		WebElement reqpro1 = driver.findElement(
				By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/button[1]"));
		reqpro1.click();
		Thread.sleep(2000);
		WebElement calanderdrop = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]"));
		calanderdrop.click();
		Thread.sleep(1000);
		WebElement date = driver.findElement(By.xpath("//div[contains(text(),'29')]"));
		date.click();
		WebElement lease = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]/span[1]/input[1]"));
		lease.click();
		lease.sendKeys(Keys.ARROW_DOWN); // Moves to the first option

		lease.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		WebElement Next13 = driver.findElement(By.xpath(" //button[@type='submit']"));
		Next13.click();
		Thread.sleep(2000);
	}
}

/*
 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
 * Actions actions = new Actions(driver);
 * 
 * WebElement emailField = driver.findElement(By.id("email"));
 * emailField.sendKeys("hamassohail222@gmail.com"); Thread.sleep(1000);
 * 
 * WebElement passwordField = driver.findElement(By.id("password"));
 * passwordField.sendKeys("Rent123!"); Thread.sleep(1000); WebElement
 * signInButton =
 * driver.findElement(By.xpath("/html/body/main/div[1]/div/form/button"));
 * signInButton.click(); Thread.sleep(4000); WebElement address =
 * wait.until(ExpectedConditions.elementToBeClickable(By.id("home-address")));
 * address.clear(); address.sendKeys("Newyork"); Thread.sleep(2000);
 * 
 * WebElement home_dropdown = wait
 * .until(ExpectedConditions.elementToBeClickable(By.xpath(
 * "(//div[@class='pac-item'])[1]"))); home_dropdown.click();
 * Thread.sleep(2000);
 * 
 * // JavascriptExecutor js = (JavascriptExecutor) driver; //
 * js.executeScript("window.scrollBy(0,500)");
 * 
 * // WebElement Property1 = driver.findElement(By.className("text-sm-manrope
 * -mt-1 // truncate text-gray-300")); // Property1.click();
 * 
 * actions.moveByOffset(500, 300).click().perform(); Thread.sleep(2000);
 * 
 * WebElement Property1 = driver.findElement(By.
 * className("text-sm-manrope -mt-1 truncate text-gray-300"));
 * Property1.click(); Thread.sleep(2000);
 */
