package pack1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Xml_Reports {
	WebDriver driver;
 @BeforeClass
 public void setup() {
	  driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.get("https://www.facebook.com/login/");
	 
 }

 @Test(dataProvider = "logintestdata")
 public void loginpage(String username, String password) throws InterruptedException {
	 Thread.sleep(5000);
	  driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(username);
	  driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(password);
	  driver.findElement(By.xpath("//button[@name='login' and @type ='submit']")).click();
  
 
 }
 @DataProvider(name= "logintestdata")
 public String[][] getdata() throws IOException {
	 File excelfile = new File("E:\\new sheet.xlsx");
	 System.out.println(excelfile.exists());
	 FileInputStream fis = new FileInputStream(excelfile);
	 XSSFWorkbook workbook = new XSSFWorkbook(fis);
	 XSSFSheet sheet = workbook.getSheet("sheet1");
	 int noofRow = sheet.getPhysicalNumberOfRows();
	 int noofcolums = sheet.getRow(0).getLastCellNum();
	 String[][]data =new String [noofRow-1][noofcolums];
	 for(int i=0;i<=noofRow-1;i++) {
		 if (sheet.getRow(i + 1) != null) {
		 for (int j=0; j<noofcolums;j++) {
			 DataFormatter df = new DataFormatter();
			data [i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j));
		 }
		 
		 } 
		 
	 }
	 workbook.close();
	 fis.close();
	 return data;
	 
 }
 
 
 @AfterClass
 public void tearDown() {
     if (driver != null) {
         driver.quit();
     }
 
//  @Test
//  public void navigatetomyinfo() {
//	  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a/span")).click();
//	  
//  }
//  
//  @Test
//  public void verifymyinfo() {
//	  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[6]/a/span")).isDisplayed();
//	  driver.quit();
//  }
  
 
 }
 
}
