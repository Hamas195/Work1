package ui;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;

public class Demo {
	public static String browser = "chrome";
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, AWTException, IOException {

		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--force-device-scale-factor=0.8"); // 80% zoom
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		//Actions actions = new Actions(driver);

		driver.get("https://staging.spsgonline.net/login");
		driver.manage().window().maximize();
		String currurl = driver.getCurrentUrl();
		System.out.println(currurl);

		// Email
		WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		emailField.sendKeys("rnorth@spsgonline.org");

		// Password
		WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		passwordField.sendKeys("SuperAdminPassword123@!");

		// Sign In
		WebElement signInButton = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("/html/body/div/div/div/section/div[2]/form/button/span[1]")));
		signInButton.click();

		// OTP
		WebElement otp = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/section/div[2]/form/div/div/input")));
		otp.sendKeys("1234");

		WebElement click1 = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/section/div[2]/form/button")));
		click1.click();
//MemberS
		/*
		 * WebElement Member12 = wait.until(
		 * ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/members']")));
		 * Member12.click();
		 * 
		 * WebElement AddMember12 = wait.until(
		 * ExpectedConditions.elementToBeClickable(By.
		 * xpath("//span[normalize-space()='Add Member']"))); AddMember12.click();
		 * WebElement F_Name = wait.until(
		 * ExpectedConditions.elementToBeClickable(By.id("firstName")));
		 * F_Name.sendKeys("Automation");
		 * 
		 * WebElement L_Name = wait.until(
		 * ExpectedConditions.elementToBeClickable(By.id("lastName")));
		 * L_Name.sendKeys("Testing"); WebElement email_member = wait.until(
		 * ExpectedConditions.elementToBeClickable(By.id("email")));
		 * email_member.sendKeys("Testauto1@gmail.com"); WebElement submit1 =
		 * wait.until( ExpectedConditions.elementToBeClickable(By.xpath(
		 * "/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/section[1]/section[1]/button[1]/span[1]"
		 * ))); submit1.click();
		 */

		Thread.sleep(4000);

		((JavascriptExecutor) driver).executeScript("window.open()");

		// Get all open tabs again
		List<String> tabs = new ArrayList<>(driver.getWindowHandles());

		// Switch to the newest tab (last in the list)
		driver.switchTo().window(tabs.get(tabs.size() - 1));

		// Now navigate to your desired URL in this new tab
		driver.get("https://maxwell-duke-trading.staging.spsgonline.net/login");

		Thread.sleep(4000);
		System.out.println("Switched to tab with URL: " + driver.getCurrentUrl());
		// Example: interact with elements on this new tab
		WebElement email_org = wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
		email_org.sendKeys("members10@gmail.com");

		WebElement password_org = driver.findElement(By.id("password"));
		password_org.sendKeys("Password123$");

		WebElement org_signin = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
		org_signin.click();

		WebElement org_groups = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/organization-group']")));
		org_groups.click();
		WebElement group_create = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Create New']")));
		group_create.click();
		WebElement org_name = wait.until(ExpectedConditions.elementToBeClickable(By.id("groupName")));
		org_name.sendKeys("Test_automation");

		WebElement add_mem_group2 = wait.until(ExpectedConditions.elementToBeClickable(By.id(
				"memberIds")));
		add_mem_group2.sendKeys("t");
		
		WebElement add_name_group = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'tusb vsubs')]")));
		add_name_group.click();

		WebElement submit5 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Submit']")));
		submit5.click();
		

		// ORG
		/*
		 * WebElement Org = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "//a[@href='/organization']"))); Org.click();
		 * 
		 * WebElement Org_click = wait
		 * .until(ExpectedConditions.elementToBeClickable(By.
		 * xpath("//img[@alt='Maxwell Duke Trading Logo']"))); Org_click.click();
		 * 
		 * WebElement Secret =
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/main[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/button[1]/span[1]"
		 * ))); Secret.click();
		 * 
		 * String mainTab = driver.getWindowHandle();
		 * 
		 * wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		 * 
		 * // Switch to the new tab for (String handle : driver.getWindowHandles()) { if
		 * (!handle.equals(mainTab)) { driver.switchTo().window(handle); break; } }
		 * 
		 */

	}
}
// Report
/*
 * WebElement report =
 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
 * "//a[@href='/reports']"))); report.click(); WebElement report1 = wait.until(
 * ExpectedConditions.elementToBeClickable(By.
 * xpath("//button[normalize-space()='Select Report Type']"))); report1.click();
 * WebElement userreport = wait
 * .until(ExpectedConditions.elementToBeClickable(By.
 * xpath("//span[normalize-space()='User Report']"))); userreport.click();
 * 
 * WebElement username_click = wait
 * .until(ExpectedConditions.elementToBeClickable(By.xpath(
 * "//input[@id='userName']"))); username_click.click(); WebElement username =
 * wait.until(ExpectedConditions.elementToBeClickable(By.id("userName")));
 * username.sendKeys("Z"); WebElement name1 = wait
 * .until(ExpectedConditions.elementToBeClickable(By.
 * xpath("//div[contains(text(),'heel ziggler')]"))); name1.click();
 * 
 * WebElement generate = wait.until( ExpectedConditions.elementToBeClickable(By.
 * xpath("//span[normalize-space()='Generate Report']"))); generate.click();
 * 
 * } }
 */

//NEW COURSE

// Training menu
// WebElement Training = wait.until(ExpectedConditions
// .elementToBeClickable(By.xpath("/html/body/div/div/div/aside/div/div[2]/ul/li[3]/span/a")));
// Training.click();

/*
 * New Course WebElement New_course = wait.until(ExpectedConditions
 * .elementToBeClickable(By.xpath(
 * "/html/body/div/div/div/div/main/div/div/div[2]/a/button/span[2]")));
 * New_course.click();
 * 
 * // Course Name WebElement F_N =
 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("courseName"))
 * ); F_N.sendKeys("Hello");
 * 
 * // Version Name WebElement F_N1 =
 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("versionName")
 * )); F_N1.sendKeys("2");
 * 
 * // Description WebElement F_N2 =
 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("description")
 * )); F_N2.sendKeys("HelloHelloHelloHelloHelloHelloHello");
 * 
 * WebElement course_file =
 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
 * "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[2]/div[1]/form[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/span[1]/div[1]/p[1]"
 * ))); course_file.click();
 * 
 * Robot robot = new Robot();
 * 
 * StringSelection filePath = new
 * StringSelection("D:\\Courses\\SPSG_Hearing_Scorm2004_010324.zip");
 * Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);
 * robot.keyPress(KeyEvent.VK_CONTROL); robot.keyPress(KeyEvent.VK_V);
 * robot.keyRelease(KeyEvent.VK_V); robot.keyRelease(KeyEvent.VK_CONTROL);
 * Thread.sleep(2000);
 * 
 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
 * WebElement submit_course =
 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
 * "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[2]/div[1]/form[1]/div[5]/div[1]/button[1]"
 * ))); submit_course.click();
 * 
 * WebElement ok_course =
 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
 * "/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]/span[1]"
 * ))); ok_course.click();
 */

//ASSIGN Course
/*
 * WebElement assign_course = wait.until(
 * ExpectedConditions.visibilityOfElementLocated(By.
 * xpath("//span[normalize-space()='Assign Courses']"))); assign_course.click();
 * 
 * WebElement ind_assign = wait.until(
 * ExpectedConditions.visibilityOfElementLocated(By.xpath(
 * "//span[normalize-space()='Individual']")));
 * 
 * ind_assign.click();
 * 
 * WebElement dropdown_course =
 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
 * "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/main[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]"
 * ))); dropdown_course.click(); Thread.sleep(1000); WebElement Course1 =
 * wait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath(
 * "/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]"
 * ))); Course1.click();
 * 
 * WebElement main = wait.until(ExpectedConditions
 * .visibilityOfElementLocated(By.
 * xpath("	/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/main[1]")));
 * main.click();
 * 
 * WebElement user =
 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
 * "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/main[1]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]"
 * ))); user.click(); WebElement user_send =
 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("usersDrpdwn")
 * )); user_send.sendKeys("Z");
 * 
 * WebElement user1 = wait.until(
 * ExpectedConditions.visibilityOfElementLocated(By.
 * xpath("//div[contains(text(),'heel ziggler')]"))); user1.click();
 * Thread.sleep(1000); main.click(); WebElement assign = wait
 * .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
 * "//span[normalize-space()='Assign']"))); assign.click();
 * 
 * WebElement ok =
 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
 * "/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]/span[1]"
 * ))); ok.click();
 * 
 * } }
 */

/*
 * package ui;
 * 
 * 
 * import java.awt.AWTException; import java.awt.Dimension; import
 * java.awt.Robot; import java.awt.Toolkit; import java.awt.event.InputEvent;
 * import java.io.File; import java.io.IOException; import java.time.Duration;
 * import java.util.List; import org.openqa.selenium.chrome.ChromeOptions;
 * import org.openqa.selenium.By; import org.openqa.selenium.JavascriptExecutor;
 * import org.openqa.selenium.Keys; import org.openqa.selenium.OutputType;
 * import org.openqa.selenium.TakesScreenshot; import
 * org.openqa.selenium.WebDriver; import org.openqa.selenium.WebElement; import
 * org.openqa.selenium.chrome.ChromeDriver; import
 * org.openqa.selenium.firefox.FirefoxDriver; import
 * org.openqa.selenium.interactions.Actions; import
 * org.openqa.selenium.support.ui.ExpectedConditions; import
 * org.openqa.selenium.support.ui.WebDriverWait; import
 * org.apache.commons.io.FileUtils;
 * 
 * public class Demo { public static String browser = "chrome"; public static
 * WebDriver driver;
 * 
 * public static void main(String[] args) throws InterruptedException,
 * AWTException, IOException {
 * 
 * if (browser.equalsIgnoreCase("chrome")) { ChromeOptions options = new
 * ChromeOptions(); // 0.8 = 80% zoom
 * options.addArguments("--force-device-scale-factor=0.8"); driver = new
 * ChromeDriver(options); } else if (browser.equalsIgnoreCase("firefox")) {
 * driver = new FirefoxDriver(); // Firefox zoom would need JavaScript or CTRL +
 * - }
 * 
 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
 * Actions actions = new Actions(driver);
 * 
 * driver.get("https://staging.spsgonline.net/login");
 * driver.manage().window().maximize(); String currurl = driver.getCurrentUrl();
 * System.out.println(currurl);
 * 
 * Thread.sleep(2000);
 * 
 * WebElement emailField = driver.findElement(By.id("email"));
 * emailField.sendKeys("rnorth@spsgonline.org");
 * 
 * WebElement passwordField = driver.findElement(By.id("password"));
 * passwordField.sendKeys("SuperAdminPassword123@!");
 * 
 * WebElement signInButton = driver.findElement( By.xpath(
 * "/html[1]/body[1]/div[1]/div[1]/div[1]/section[1]/div[2]/form[1]/button[1]/span[1]"
 * )); signInButton.click(); Thread.sleep(4000); WebElement otp =
 * driver.findElement( By.xpath(
 * "/html[1]/body[1]/div[1]/div[1]/div[1]/section[1]/div[2]/form[1]/div[1]/div[1]/input[1]"
 * )); otp.sendKeys("1234"); WebElement click1 = driver .findElement(By.xpath(
 * "/html[1]/body[1]/div[1]/div[1]/div[1]/section[1]/div[2]/form[1]/button[1]"))
 * ; click1.click(); Thread.sleep(8000); WebElement Training = driver
 * .findElement(By.xpath(
 * "/html[1]/body[1]/div[1]/div[1]/div[1]/aside[1]/div[1]/div[2]/ul[1]/li[3]/span[1]/a[1]"
 * )); Training.click(); Thread.sleep(4000); WebElement New_course = driver
 * .findElement(By.xpath(
 * "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[2]/a[1]/button[1]/span[2]"
 * )); New_course.click(); Thread.sleep(2000); WebElement F_N =
 * driver.findElement(By.id("courseName")); F_N.sendKeys("Hello");
 * Thread.sleep(2000);
 * 
 * WebElement F_N1 = driver.findElement(By.id("versionName"));
 * F_N1.sendKeys("2"); Thread.sleep(2000);
 * 
 * WebElement F_N2 = driver.findElement(By.id("description"));
 * F_N2.sendKeys("HelloHelloHelloHelloHelloHelloHello"); Thread.sleep(2000);
 * 
 */

/*
 * List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
 * System.out.println("Iframes found: " + iframes.size());
 * driver.switchTo().frame(0); Thread.sleep(1000);
 * 
 * WebElement closeButton =
 * driver.findElement(By.xpath("//img[@class='close_cross_big']"));
 * closeButton.click(); driver.switchTo().defaultContent();
 * 
 * WebElement city = wait.until( ExpectedConditions.elementToBeClickable(By.
 * xpath("//div[@aria-label='City filter']//*[name()='svg']"))); city.click();
 * 
 * WebElement city_sel = wait
 * .until(ExpectedConditions.elementToBeClickable(By.xpath(
 * "//button[@aria-label='Lahore']"))); city_sel.click();
 * 
 * WebElement location =
 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
 * "//input[@type='text']"))); location.click(); location.sendKeys("Allama");
 * Thread.sleep(2000); location.sendKeys(Keys.ENTER);
 * System.out.println("Location entered."); WebElement option1 =
 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
 * "//div[@aria-label='Category filter']//*[name()='svg']//*[name()='path' and contains(@class,'cls-1')]"
 * ))); option1.click();
 * 
 * WebElement House = wait
 * .until(ExpectedConditions.elementToBeClickable(By.xpath(
 * "//li[normalize-space()='House']"))); House.click();
 * 
 * WebElement price = wait.until(ExpectedConditions.elementToBeClickable( By.
 * xpath("//div[@name='Price (PKR)']//span[@aria-label='Min value'][normalize-space()='0']"
 * ))); price.click();
 * 
 * WebElement price1 = driver.findElement(By.id("activeNumericInput"));
 * price1.sendKeys("5000000"); WebElement price2 =
 * driver.findElement(By.id("inactiveNumericInput"));
 * price2.sendKeys("9990000");
 * 
 * WebElement price3 = wait.until(ExpectedConditions .elementToBeClickable(By.
 * xpath("//div[@name='Price (PKR)']//div[@role='button']//*[name()='svg']")));
 * price3.click(); WebElement find = wait
 * .until(ExpectedConditions.elementToBeClickable(By.
 * xpath("//a[@aria-label='Find button']"))); find.click(); Thread.sleep(2000);
 * 
 * JavascriptExecutor js = (JavascriptExecutor) driver;
 * 
 * js.executeScript("window.scrollBy(0,800)"); Thread.sleep(2000); WebElement
 * property = wait.until(ExpectedConditions.elementToBeClickable( By.
 * xpath("//a[@title='House Available For sale In Allama Iqbal Town']//div[@class='_3547d663']"
 * ))); ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
 * property); Thread.sleep(500); js.executeScript("window.scrollBy(0,200)");
 * Thread.sleep(1000);
 * 
 * WebElement property_d = wait.until(ExpectedConditions
 * .elementToBeClickable(By.
 * xpath("//div[@class='_4c37362f c4618ba6']//*[name()='svg']")));
 * property_d.click(); Thread.sleep(1000);
 * 
 * File screenshot = ((TakesScreenshot)
 * driver).getScreenshotAs(OutputType.FILE); new File("screenshots").mkdirs();
 * FileUtils.copyFile(screenshot, new File("screenshots/screenshot1.png"));
 */
