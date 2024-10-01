package testPkgLearner;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageobjectLearner.Registrationpage_Learner;

public class TC_0001_Registrationlearner {
	 public  WebDriver driver;
	 
	
	@BeforeClass
	public void Setup() {
		 driver = new ChromeDriver();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get("https://demo.learner.dev.adroit-lms.com/portal/registration");
		 driver.manage().window().maximize();
		
		
	}
	@AfterClass
		public void teardown() {
		
		if (driver!= null) {
			driver.quit();
		}
			
		}
		
	@Test
	public void varification_registerpage_learner() {
		
		Registrationpage_Learner Rl = new Registrationpage_Learner(driver);
		
		Rl.setfirstname(randaomString().toUpperCase());
		Rl.Setlastname(randaomString().toUpperCase());
		Rl.SetEmail(randaomString()+"@maildrop.cc");
		
		String password = randomalphanumeric();
		
		Rl.Password(password);
		Rl.confpassword(password);
		Rl.Register();
		
		
	}
	 public String randaomString() {
		 String genraterStrg = RandomStringUtils.randomAlphabetic(7);
		 return genraterStrg;
	 }
	  public String randomnum() {
		  String genratednum = RandomStringUtils.randomNumeric(10);
			
			return genratednum;
			
			}
			public String randomalphanumeric() {
				String genratedstr = RandomStringUtils.randomAlphabetic(4);
				String genratednum = RandomStringUtils.randomNumeric(3);
				return(genratedstr+"@" + genratednum);
			}
	  }
	
	
	


