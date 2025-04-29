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

import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.awt.event.InputEvent;
import java.util.Set;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.awt.*;

public class payment {

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
		// Robot robot = new Robot();
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
		Thread.sleep(8000);

		// robot.mouseMove(centerX, centerY);
		// Thread.sleep(3000);

		// robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		// robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

		// System.out.println("Clicked at (500, 300)");
		// Thread.sleep(2000);
		WebElement application1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html[1]/body[1]/div[1]/aside[1]/div[1]/nav[1]/ul[1]/li[3]/a[1]/span[1]")));
		Thread.sleep(3000);
		application1.click();
		Thread.sleep(4000);

		WebElement clickpro1 = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[4]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/a[1]/span[1]"));
		clickpro1.click();
		Thread.sleep(5000);

		WebElement verify = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/button[1]"));
		verify.click();
		Thread.sleep(8000);

		List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
		System.out.println("Found iframes: " + iframes.size());

		for (WebElement iframe : iframes) {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(iframe);

			// Check for Card Number
			List<WebElement> cardNumber = driver.findElements(By.cssSelector("input[name='number']"));
			if (!cardNumber.isEmpty()) {
				cardNumber.get(0).sendKeys("5454545454545454");
				System.out.println("✅ Card number entered");

			}
			List<WebElement> expDate = driver.findElements(By.cssSelector("input[name='expiry']"));
			if (!expDate.isEmpty()) {
				expDate.get(0).sendKeys("1234"); // MMYY
				System.out.println("✅ Expiry date entered");

			}

			// Check for CVC
			List<WebElement> cvc = driver.findElements(By.cssSelector("input[name='cvc']"));
			if (!cvc.isEmpty()) {
				cvc.get(0).sendKeys("123");
				System.out.println("✅ CVC entered");

			}
		}
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(2000);

		WebElement payment = driver.findElement(By.xpath(
				"//button[@type='submit']"));
		payment.click();
		Thread.sleep(5000);
	}
}