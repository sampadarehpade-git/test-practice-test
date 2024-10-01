package PageobjectLearner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BasepkgLearner.Baseconstructor;

public class Registrationpage_Learner extends Baseconstructor {
	
	 WebDriver driver;
	 
	  public Registrationpage_Learner(WebDriver driver){
		 super(driver);
	 }
	  //anotation 
	 @FindBy(xpath = "//input[@id ='first-name']//parent::div") WebElement txtfirstN;
	 @FindBy(xpath = "//input[@id ='last-name']//parent::divv") WebElement txtLastN;
	 @FindBy(xpath = "//input[@id ='email']//parent::div") WebElement TxtEmail;
	 @FindBy(xpath = "//input[@id ='password']//parent::div") WebElement Pwd;
	 @FindBy(xpath = "//input[@id ='confirmPassword']//parent::div") WebElement CPwd;
	 @FindBy(xpath = "//button[@test-id='register-button']") WebElement BtnRegister;
	 
	 
	 //Action Method
	 public void setfirstname(String user) {
		 txtfirstN.sendKeys(user);
	 }
	 
	 public void Setlastname(String lastName) {
		 txtLastN.sendKeys(lastName);
	 }
	 public void SetEmail(String mailid) {
		 TxtEmail.sendKeys(mailid);
	 }
	 public void Password(String Pass) {
		 Pwd.sendKeys(Pass);
	 }
	 public void confpassword(String Cpass) {
		 CPwd.sendKeys(Cpass);
	 }
	 public void Register() {
		BtnRegister.click();;
	 }

}
