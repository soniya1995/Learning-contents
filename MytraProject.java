package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MytraProject {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);

		// 1.Open https://www.myntra.com/
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// 2. Mouse hover on MeN
		WebElement men = driver.findElement(By.xpath("//a[text()='Men']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(men).perform();
		// 3.Click Jacket
		driver.findElement(By.xpath("//a[text()='Jackets']")).click();
		Thread.sleep(3000);
		// 4.Find the total count of item
		String totalcount = driver.findElementByXPath("//span[@class='title-count']").getText();
		System.out.println("Then total count : " + totalcount);
		String replaceAll = totalcount.replaceAll("[^0-9]", "");
		System.out.println("After removing unwanted Characters :" + replaceAll);
		int parseInt = Integer.parseInt(replaceAll);
		System.out.println("After converting from string to integer :" + replaceAll);

		String count1 = driver.findElement(By.xpath("//span[@class='categories-num']")).getText();
		System.out.println("Jacket count : " + count1);
		String replaceAll1 = count1.replaceAll("[^0-9]", "");
		System.out.println("After removing unwanted Characters :" + replaceAll1);
		int parseInt1 = Integer.parseInt(replaceAll1);
		System.out.println("After converting from string to integer :" + parseInt1);

		String count2 = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText();
		System.out.println("Rain Jacket count : " + count2);
		String replaceAll2 = count2.replaceAll("[^0-9]", "");
		System.out.println("After removing unwanted Characters :" + replaceAll2);
		int parseInt2 = Integer.parseInt(replaceAll2);
		System.out.println("After converting from string to integer :" + parseInt2);
		// 5.Validate the sum of categories count matches
		int sum = parseInt1 + parseInt2;
		System.out.println("Total count of both Jacket : " + sum);

		if (parseInt == sum) {
			System.out.println("Count Matches");
		} else
			System.out.println("Count Mismatches");
		// Click Jacket

		driver.findElement(By.xpath("//span[@class='categories-num']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		driver.findElement(By.xpath("//input[@class='FilterDirectory-searchInput']")).sendKeys("Duke");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='common-checkboxIndicator']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();

	}

}
