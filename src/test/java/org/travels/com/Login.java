package org.travels.com;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Login extends Excel {

	static WebDriver driver;

	@BeforeClass

	public static void beforeclass() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.airnorth.com.au/");
		driver.manage().deleteAllCookies();
		WebElement Close = driver.findElement(By.xpath("//a[@id='TB_closeWindowButton']"));
		Close.click();
	}

	@AfterClass
	public static void afterclass() {
		driver.quit();
	}

	@Before
	public void beforemethod() {
		Date date = new Date();
		System.out.println(date);
	}

	@After
	public void aftermethod() {
		Date date = new Date();
		System.out.println(date);
	}

	@Test
	public void methodss() throws Throwable {

		WebElement radioButton = driver.findElement(By.xpath("//input[@id='rbOneWay']"));
		radioButton.click();
		Assert.assertEquals("Choose Onetrip", "One way", radioButton.getAttribute("alt"));

		WebElement Depart = driver.findElement(By.xpath("//select[@id='ddlOrigin']"));
		dropDown(Depart, "DRW");
		Assert.assertEquals("CheckDepart", "DRW", Depart.getAttribute("value"));

		WebElement returnDrop = driver.findElement(By.xpath("//select[@id='ddlDestination']"));
		dropDown(returnDrop, "ELC");
		Assert.assertEquals("CheckReturn", "ELC", returnDrop.getAttribute("value"));

		WebElement depatDate = driver.findElement(By.xpath("//a[@id='DepCalendar']"));
		depatDate.click();
		WebElement date = driver.findElement(By.xpath("//td[@id='cal1_0_cell32']"));
		date.click();
		// Assert.assertEquals("CheckDate","31",date.getAttribute("value"));

		WebElement passenger = driver.findElement(By.xpath("// select[@id='ddlAdultCount']"));
		dropDown(passenger, "2");
		Assert.assertEquals("CheckReturn", "2", passenger.getAttribute("value"));

		WebElement searchFlights = driver.findElement(By.xpath("//input[@id='btnFlightSearch']"));
		searchFlights.click();

		// RadioButton
		WebElement FlightsOut = driver.findElement(By.xpath("(//input[contains(@id,'DRW_ELC_300120_S')])[1]"));
		FlightsOut.click();
		Assert.assertEquals("Flight Select", "TL212_DRW_ELC_300120_S", FlightsOut.getAttribute("value"));

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement Insurance = driver.findElement(By.xpath("//input[@value ='rdoInsuranceNo']"));
		Insurance.click();
		Assert.assertEquals("Insurance", "rdoInsuranceNo", Insurance.getAttribute("value"));

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement Continue = driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_btnContinue']"));
		Continue.click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Book
		WebElement Title1 = driver
				.findElement(By.xpath("//select[@id='ctl00_ContentPlaceHolder1_Passenger0_ddlTitle']"));
		dropDown(Title1, "Mr");
		Assert.assertEquals("TitleFirstPerson", "Mr", Title1.getAttribute("value"));

		driver.findElement(By.xpath("//input[contains(@id,'Passenger0_txtFirstName')]")).sendKeys(demo(1, 0));
		driver.findElement(By.xpath("//input[contains(@id,'Passenger0_txtLastName')]")).sendKeys(demo(1, 1));

		WebElement Title2 = driver.findElement(By.xpath("//select[contains(@id,'Passenger1_ddlTitle')]"));
		dropDown(Title2, "Mrs");
		Assert.assertEquals("TitleFirstPerson", "Mrs", Title2.getAttribute("value"));

		driver.findElement(By.xpath("//input[contains(@id,'Passenger1_txtFirstName')]")).sendKeys(demo(2, 0));
		driver.findElement(By.xpath("//input[contains(@id,'Passenger1_txtLastName')]")).sendKeys(demo(2, 1));

		WebElement Title3 = driver.findElement(By.xpath("//select[contains(@id,'ddlContactTitle')]"));
		dropDown(Title3, "Mr");
		Assert.assertEquals("TitleFirstPerson", "Mr", Title3.getAttribute("value"));

		driver.findElement(By.xpath("//input[contains(@id,'txtContactFirstName')]")).sendKeys(demo(4, 0));
		driver.findElement(By.xpath("//input[contains(@id,'txtContactFamilyName')]")).sendKeys(demo(4, 1));

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[contains(@id,'ctl00_ContentPlaceHolder1_txtMobileNumber')]"))
				.sendKeys(demo(5, 0));
		driver.findElement(By.xpath("//input[contains(@id,'txtHomeNumber')]")).sendKeys(demo(6, 0));
		driver.findElement(By.xpath("//input[contains(@id,'txtAddress1')]")).sendKeys(demo(7, 0));
		driver.findElement(By.xpath("//input[contains(@id,'txtCity')]")).sendKeys(demo(9, 0));
		driver.findElement(By.xpath("//input[contains(@id,'txtPostCode')]")).sendKeys(demo(10, 0));
		driver.findElement(By.xpath("//input[contains(@id,'txtEmail')]")).sendKeys(demo(11, 0));
		driver.findElement(By.xpath("//input[contains(@id,'txtConfirmEmail')]")).sendKeys(demo(12, 0));

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[contains(@id,'txtCCNumber')]")).sendKeys(demo(13, 0));

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement Title5 = driver
				.findElement(By.xpath("//select[@id='ctl00_ContentPlaceHolder1_CreditCardBlock1_ddlCCMonth']"));
		dropDown(Title5, "07");
		Assert.assertEquals("Month", "07", Title5.getAttribute("value"));

		WebElement Title6 = driver
				.findElement(By.xpath("//select[@id='ctl00_ContentPlaceHolder1_CreditCardBlock1_ddlCCYear']"));
		dropDown(Title6, "23");
		Assert.assertEquals("Month", "23", Title6.getAttribute("value"));

		driver.findElement(By.xpath("//input[contains(@id,'txtCVV')]")).sendKeys(demo(14, 0));
		driver.findElement(By.xpath("//input[contains(@id,'txtCCName')]")).sendKeys(demo(15, 0));

	}

}
