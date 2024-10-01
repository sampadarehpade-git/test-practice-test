package BasepkgLearner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Baseconstructor {
	 public WebDriver driver;
	 
	 
	public Baseconstructor(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		 
	 }


}