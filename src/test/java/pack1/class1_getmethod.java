package pack1;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class class1_getmethod {
  public static void main (String args[]) throws InterruptedException {
	  WebDriver driver= new ChromeDriver();
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	 String url = driver.getCurrentUrl();
	 System.out.println(url);
	String title = driver.getTitle();
	System.out.println(title);
//	String url2 =driver.getPageSource();
//	System.out.println(url2);
	String window=driver.getWindowHandle();
	System.out.println(window);
	Thread.sleep(3000);
	driver.findElement(By.linkText("OrangeHRM, Inc")).click();
	Set<String>window1 = driver.getWindowHandles();
	for(String windowone:window1) {
		 System.out.println(windowone);
	}
	driver.quit();
}
}