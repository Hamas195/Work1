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
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Basicweb {
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

		WebElement addPropertyButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[@href='properties/add' and contains(text(), 'Add Property')]")));

		// WebElement addPropertyButton =
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		// "//a[@class='data-[disabled=true]:pointer-events-none no-underline flex
		// h-[40px] items-center justify-center overflow-hidden rounded-sm px-4
		// font-Manrope font-medium transition-colors duration-200 focus:outline-none
		// focus:shadow-focus data-[disabled=true]:cursor-not-allowed border-none
		// bg-green-200 text-white hover:bg-green-300
		// data-[disabled=true]:bg-green-100']")));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addPropertyButton);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addPropertyButton);
		Thread.sleep(1000);

		WebElement apartmentButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Apartment']")));
		apartmentButton.click();
		Thread.sleep(1000);

		WebElement floorNumberField = driver.findElement(By.id("floor-number"));
		floorNumberField.sendKeys("11");
		Thread.sleep(1000);

		WebElement unitNumberField = driver.findElement(By.id("unit-number"));
		unitNumberField.sendKeys("21");
		Thread.sleep(1000);

		WebElement addressField = driver.findElement(By.id("property-address")); // Replace "address" with the actual ID
																					// or locator of the address field
		addressField.sendKeys("66");
		Thread.sleep(1000);

		WebElement dropdownOption = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='pac-item'])[1]")));
		dropdownOption.click();
		Thread.sleep(2000);

		WebElement Next1 = driver.findElement(By.xpath(" //button[@type='submit']"));
		Next1.click();
		Thread.sleep(6000);

		WebElement dropdown = driver.findElement(By.id("number-of-beds"));
		dropdown.click();
		Thread.sleep(2000);

		WebElement bedOption = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[span=(@class='ant-select-selection-item') and text()='3']")));
		actions.moveToElement(bedOption).click().perform();
		Thread.sleep(1000);

		WebElement dropdown2 = driver.findElement(By.id("number-of-baths"));
		dropdown2.click();
		Thread.sleep(1000);

		dropdown2.sendKeys(Keys.ARROW_DOWN); // Moves to the first option

		dropdown2.sendKeys(Keys.ENTER);
		Thread.sleep(1000);

		WebElement size1 = driver.findElement(By.id("size-in-sqft"));
		size1.sendKeys("666");
		Thread.sleep(2000);

		WebElement Next2 = driver.findElement(By.xpath(" //button[@type='submit']"));
		Next2.click();
		Thread.sleep(2000);

		WebElement amen = driver.findElement(By.xpath("//input[@value='swimming_pool']"));
		amen.click();
		Thread.sleep(1000);

		WebElement appliance = driver.findElement(By.xpath("//input[@value='stove_oven_gas']"));
		appliance.click();
		Thread.sleep(1000);
		WebElement util = driver.findElement(By.xpath("//input[@value='water']"));
		util.click();

		Thread.sleep(1000);

		WebElement park = driver.findElement(By.id("type-of-parking"));
		park.click();
		Thread.sleep(1000);

		park.sendKeys(Keys.ARROW_DOWN); // Moves to the first option
		park.sendKeys(Keys.ARROW_DOWN);

		park.sendKeys(Keys.ENTER);
		Thread.sleep(1000);

		WebElement parkfee = driver.findElement(By.xpath("//input[@value='false']"));
		parkfee.click();
		Thread.sleep(1000);

		WebElement pet = driver.findElement(By.xpath("//input[@value='will_consider']"));
		pet.click();
		Thread.sleep(1000);

		WebElement Next3 = driver.findElement(By.xpath(" //button[@type='submit']"));
		Next3.click();
		Thread.sleep(2000);

		WebElement image = driver
				.findElement(By.xpath("//label[@for='featured-image-upload']//p[normalize-space()='Upload']"));
		image.click();
		Thread.sleep(2000); // Wait for file dialog to appear

		Robot robot = new Robot();

		StringSelection filePath = new StringSelection("C:\\Users\\hamas.sohail\\Downloads\\house.jpeg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(6000); // Wait for the file to upload
		WebElement Next4 = driver.findElement(By.xpath(" //button[normalize-space()='Next']"));
		Next4.click();
		Thread.sleep(2000);

		WebElement discription = driver.findElement(By.id("description"));
		discription.sendKeys("Hello QA Team!");
		Thread.sleep(2000);

		WebElement Next5 = driver.findElement(By.xpath("//button[normalize-space()='Next']"));
		Next5.click();
		Thread.sleep(1000);

		try {
			WebElement role = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//input[@type='radio' and @value='property_manager']")));
			System.out.println("Radio button found!");

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", role);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", role);

		} catch (Exception e) {
			System.out.println("Radio button not found: " + e.getMessage());
		}

		Thread.sleep(2000);

		WebElement Addpro = driver.findElement(By.xpath("//button[@type='submit']"));
		Addpro.click();

		Thread.sleep(6000);
		WebElement targetElement = driver.findElement(By.xpath(
				"//*[contains(@class, 'pkg-flex pkg-h-[40px] pkg-items-center pkg-justify-center pkg-overflow-hidden pkg-rounded-sm pkg-px-4 pkg-font-Manrope pkg-text-base pkg-font-medium pkg-transition-all pkg-duration-200 focus:pkg-outline-none focus:pkg-shadow-focus disabled:pkg-cursor-not-allowed pkg-border pkg-border-green-200 pkg-bg-green-200 pkg-text-white hover:pkg-bg-green-300 hover:pkg-border-green-300 disabled:pkg-border-green-100 disabled:pkg-bg-green-100')]"));
		targetElement.click();
		Thread.sleep(4000);

		WebElement Next6 = driver.findElement(By.xpath(" /html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[1]/form[1]/div[3]/button[1]"));
		Next6.click();
		Thread.sleep(2000);

		WebElement monthly_rent = driver.findElement(By.id("monthly-rent"));
		monthly_rent.sendKeys("543");
		Thread.sleep(1000);

		WebElement security_deposit = driver.findElement(By.id("security-deposit"));
		security_deposit.sendKeys("200");
		Thread.sleep(1000);

		WebElement key_deposit = driver.findElement(By.id("key-deposit"));
		key_deposit.sendKeys("100");
		Thread.sleep(1000);

		WebElement cleaning_deposit = driver.findElement(By.id("cleaning-deposit"));
		cleaning_deposit.sendKeys("50");
		Thread.sleep(1000);

		WebElement pet_deposit = driver.findElement(By.id("pet-deposit"));
		pet_deposit.sendKeys("25");
		Thread.sleep(1000);

		WebElement Lease = driver.findElement(By.id("lease-length"));
		Lease.click();
		Thread.sleep(2000);

		Lease.sendKeys(Keys.ARROW_DOWN); // Moves to the first option
		Lease.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		WebElement Next7 = driver.findElement(By.xpath(" //button[@type='submit']"));
		Next7.click();
		Thread.sleep(2000);

		WebElement Next8 = driver.findElement(By.xpath(" //button[@type='submit']"));
		Next8.click();
		Thread.sleep(2000);

		WebElement Next9 = driver.findElement(By.xpath(" //button[normalize-space()='Next']"));
		Next9.click();
		Thread.sleep(2000);

		WebElement Next10 = driver.findElement(By.xpath("//button[normalize-space()='Next']"));
		Next10.click();
		Thread.sleep(2000);

		WebElement radio1 = driver.findElement(
				By.xpath("//input[@type='radio' and @value='false' and @name='minimum-credit-score-required']"));
		radio1.click();
		Thread.sleep(1000);

		WebElement radio2 = driver
				.findElement(By.xpath("//input[@type='radio' and @value='false' and @name='has-reserves-required']"));
		radio2.click();
		Thread.sleep(1000);

		WebElement radio3 = driver
				.findElement(By.xpath("//input[@type='radio' and @value='false' and @name='agent-friendly']"));
		radio3.click();
		Thread.sleep(1000);

		WebElement radio4 = driver
				.findElement(By.xpath("//input[@type='radio' and @value='false' and @name='evictions-accepted']"));
		radio4.click();
		Thread.sleep(1000);

		WebElement radio5 = driver
				.findElement(By.xpath("//input[@type='radio' and @value='false' and @name='accept-applyMor']"));
		radio5.click();
		Thread.sleep(1000);

		WebElement radio6 = driver
				.findElement(By.xpath("//input[@type='radio' and @value='false' and @name='bankruptcy-accepted']"));
		radio6.click();
		Thread.sleep(1000);

		WebElement radio7 = driver.findElement(By
				.xpath("//input[@type='radio' and @value='false' and @name='financial-assistance-programs-allowed']"));
		radio7.click();
		Thread.sleep(1000);

		WebElement radio8 = driver
				.findElement(By.xpath("//input[@type='radio' and @value='false' and @name='cosigners-allowed']"));
		radio8.click();
		Thread.sleep(1000);
		WebElement radio9 = driver.findElement(
				By.xpath("//input[@type='radio' and @value='false' and @name='has-minimum-income-requirement']"));
		radio9.click();
		Thread.sleep(1000);
		WebElement Next11 = driver.findElement(By.xpath("//button[@type='submit']"));
		Next11.click();
		Thread.sleep(2000);

		WebElement account = driver.findElement(By.id("showing-contact-same-as-account-holder"));
		account.click();
		Thread.sleep(2000);

		WebElement phone = driver.findElement(By.xpath(
				"//input[@type='checkbox' and @value='phone' and @name='showing-contact-preferred-contact-method']"));
		phone.click();
		Thread.sleep(1000);

		WebElement same_account = driver.findElement(By.id("reviewer-contact-same-as-showing-contact"));
		same_account.click();
		Thread.sleep(2000);

		WebElement agree = driver.findElement(By.id("agree-to-transunion-terms-and-conditions"));
		agree.click();
		WebElement Next12 = driver.findElement(By.xpath("//button[@type='submit']"));
		Next12.click();
		Thread.sleep(5000);

		WebElement logout = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Logout']")));
		Thread.sleep(3000);
		driver.close();
		Thread.sleep(3000);
	
	        


	}

}
