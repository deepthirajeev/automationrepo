package automation.glue;


import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import automation.drivers.DriverSingleton;
import automation.utils.Constants;
import automation.utils.TestCases;
import automation.utils.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	private static WebDriver driver;

	ExtentTest test;
    static ExtentReports report = new ExtentReports("report/TestReport.html");
    
   @FindBy(xpath="//input[@id='identifierId']")
   WebElement usernameField;
   
   @FindBy(xpath="//span[text()='Next']")
   WebElement nextButton;
   
   @FindBy(xpath="//input[@name='password']")
   WebElement passwordField;
   
   @FindBy(xpath="//div[@class='T-I T-I-KE L3']")
   WebElement composeButton;
   
		   
   @FindBy(xpath="(//div[contains(text(),'Compose')])[1]")
   WebElement verifycomposeText;   
   
   @FindBy(xpath="(//span[contains(text(),'New Message')])[2]")
   WebElement verifynewMessage;  
   
  
   @FindBy(xpath="(//textarea[@name='to'])[2]")
   WebElement toField; 
   
   @FindBy(xpath="(//input[@name='subjectbox'])[2]")
   WebElement subjectFiled; 
   
    @FindBy(xpath="(//div[@class='Am Al editable LW-avf tS-tW'])[2]")
    WebElement messageFiled; 
    
    @FindBy(xpath="(//div[contains(text(),'Send')])[3]")
    WebElement sendButton; 
    
    
   
   
	@Given("^user is already on Login page of gmail")
	public void user_already_on_login_page(){
		
		DriverSingleton.getInstance(Constants.CHROME);
        TestCases[] testCases = TestCases.values();
        test = report.startTest(testCases[Utils.testCount].getTestName());        
        Utils.testCount++;
        driver = DriverSingleton.getDriver();
        driver.get(Constants.URL);
        PageFactory.initElements(driver,this);
	}

	@When("When text of left side menu bar is \"(.*)\"$")
	public void verify_mail_text(String username, String password){

	}


	@Then("^user enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_username_and_password(String username, String password){
		System.out.println(username);
		usernameField.sendKeys(username);
		nextButton.click();
		System.out.println(password);
		passwordField.sendKeys(password);
		nextButton.click();	
	}


	@Then("verify the compose text is displayed {string}")
	public void text_of_left_side_menu_bar_is(String string) {
	 String text=verifycomposeText.getText();
	 if(text.contains("Compose")) {
		 System.out.println("Text is present");
	 }
	 else {
		 System.out.println("Text is not present");
	 }
	 
	    
	}
	@Then("user clicks on Compose button")
	public void user_clicks_on_compose_button() {
	    composeButton.click();
	    test.log(LogStatus.PASS, "Compose button clicked");
	}
	
	@When("text of left side menu bar is {string}")
	public void verify_text_sidepanel(String string) {
	
		String newtext=verifynewMessage.getText();
		 if(newtext.contains("New Message")) {
			 System.out.println("Text is present");
			 test.log(LogStatus.PASS, "Text is present");
		 }
		 else {
			 System.out.println("Text is not present");
			 test.log(LogStatus.FAIL, "Text is not present");
		 }
		
	}
	@Then("user select email in to To Field {string}")
	public void user_select_email_in_to_to_field(String toEmail) {
		System.out.println(toEmail);
		toField.sendKeys(toEmail);
		test.log(LogStatus.PASS, "Email To Address is entered");
	}
	
	@Then("user enter email subject {string}")
	public void user_enter_email_subject(String emailSubject) {
		System.out.println(emailSubject);
		subjectFiled.sendKeys(emailSubject);
		test.log(LogStatus.PASS, "Email subject is entered");
	}

	@Then("user enter Message Body {string}")
	public void user_enter_message_body(String toMessage) {
		System.out.println(toMessage);
		messageFiled.sendKeys(toMessage);
		test.log(LogStatus.PASS, "Email Message is entered");	
	}
	
	@Then ("user click Send button")
	public void user_click_Send_button() {
		sendButton.click();
		test.log(LogStatus.PASS, "Send button is clicked");	
	}

	@Then("^Close the browser$")
	public void close_the_browser(){
		driver.quit();
	}

	
	

}
