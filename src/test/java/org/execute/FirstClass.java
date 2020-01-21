package org.execute;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FirstClass {

	static WebDriver driver;

	@BeforeClass
	public static void beforeclass() {

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Register.html");

	}

	@Before
	public void beforemethod() {

		Date date = new Date();
		System.out.println(date);
	}

	@After
	public void aftermethod() {
		Date date1 = new Date();
		System.out.println(date1);
	}

	
	@Test
	public void test() throws Throwable {
		WebElement firstName = driver.findElement(By.xpath("//input[@placeholder ='First Name']"));
		firstName.sendKeys("Ruban");
		String fname = firstName.getAttribute("value");
		Assert.assertEquals("Message", "Ruban", fname);

		WebElement lastName = driver.findElement(By.xpath("//input[@placeholder ='Last Name']"));
		lastName.sendKeys("Amalaedwin");
		String lname = lastName.getAttribute("value");
		Assert.assertEquals("LastName", "Amalaedwin", lname);

		WebElement address = driver.findElement(By.xpath("//textarea[@ng-model ='Adress']"));
		address.sendKeys("Madurai");
		String add = address.getAttribute("value");
		Assert.assertEquals("Address", "Madurai", add);

		WebElement email = driver.findElement(By.xpath("//input[@ng-model ='EmailAdress']"));
		email.sendKeys("newlonrubat@gmail.com");
		String semail = email.getAttribute("value");
		Assert.assertEquals("verificationEmail", "newlonrubat@gmail.com", semail);

		WebElement phone = driver.findElement(By.xpath("//input[@ng-model ='Phone']"));
		phone.sendKeys("9790478928");
		String sphone = phone.getAttribute("value");
		Assert.assertEquals("verificationPhone", "9790478928", sphone);

		WebElement Gender = driver.findElement(By.xpath("(//input[@ng-model ='radiovalue'])[2]"));
		Gender.click();
		String gender = Gender.getAttribute("value");
		Assert.assertEquals("verificationgender", "FeMale", gender);

		WebElement Checkbox1 = driver.findElement(By.xpath("//input[@id ='checkbox1']"));
		Checkbox1.click();
		String games = Checkbox1.getAttribute("value");
		Assert.assertEquals("verificationcheckbox", "Cricket", games);

		WebElement Checkbox2 = driver.findElement(By.xpath("//input[@id ='checkbox3']"));
		Checkbox2.click();
		String games1 = Checkbox2.getAttribute("value");
		Assert.assertEquals("verificationcheckbox2", "Hockey", games1);

		WebElement Languages = driver.findElement(By.xpath("//div[@id ='msdd']"));
		Languages.click();
		WebElement english = driver.findElement(By.xpath("//a[text()='English']"));
		english.click();
		String eng = Languages.getAttribute("value");
		WebElement label = driver.findElement(By.xpath("//label[text()='Languages']"));
		label.click();
		Assert.assertEquals("Messsge", "English", eng);

		WebElement skills = driver.findElement(By.xpath("//select[@id ='Skills']"));
		Select sel = new Select(skills);
		sel.selectByVisibleText("C++");
		String attribute = skills.getAttribute("value");
		Assert.assertEquals("message", "C++", attribute);

		WebElement country = driver.findElement(By.xpath("//select[@id ='countries']"));
		Select count = new Select(country);
		count.selectByVisibleText("India");
		String attri = country.getAttribute("value");
		Assert.assertEquals("message", "India", attri);

		WebElement click = driver.findElement(By.xpath("//span[@role ='combobox']"));
		click.click();
		WebElement selCountry = driver.findElement(By.xpath("//input[@type ='search']"));
		selCountry.sendKeys("India");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Robot rob = new Robot();
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);
		String search = driver.findElement(By.xpath("//span[@class='select2-selection__rendered']")).getText();
		System.out.println(search);
		Assert.assertEquals("India", search);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement year = driver.findElement(By.xpath("//select[@id ='yearbox']"));
		Select dateyear = new Select(year);
		dateyear.selectByVisibleText("1993");
		String attyear = year.getAttribute("value");
		Assert.assertEquals("message", "1993", attyear);

		WebElement month = driver.findElement(By.xpath("//select[@placeholder ='Month']"));
		Select datemonth = new Select(month);
		datemonth.selectByVisibleText("September");
		String attmonth = month.getAttribute("value");
		Assert.assertEquals("message", "September", attmonth);

		WebElement day = driver.findElement(By.xpath("//select[@placeholder ='Day']"));
		Select dateday = new Select(day);
		dateday.selectByVisibleText("11");
		String attday = day.getAttribute("value");
		Assert.assertEquals("message", "11", attday);

		WebElement passWord = driver.findElement(By.xpath("//input[@id ='firstpassword']"));
		passWord.sendKeys("newlonrubat");
		String pass = passWord.getAttribute("value");
		Assert.assertEquals("message", "newlonrubat", pass);

		WebElement cpassWord = driver.findElement(By.xpath("//input[@id ='secondpassword']"));
		cpassWord.sendKeys("newlonrubat");
		String cpass = cpassWord.getAttribute("value");
		Assert.assertEquals("message", "newlonrubat", cpass);

	}

}
