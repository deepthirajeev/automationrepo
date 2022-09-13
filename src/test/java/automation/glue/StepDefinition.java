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

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

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


	@Given("^user is already on Login page of gmail")
	public void user_already_on_login_page(){
		DriverSingleton.getInstance(Constants.CHROME);
        TestCases[] testCases = TestCases.values();
        test = report.startTest(testCases[Utils.testCount].getTestName());        
        Utils.testCount++;
        driver = DriverSingleton.getDriver();
        driver.get(Constants.URL);
	}

	@When("When text of left side menu bar is \"(.*)\"$")
	public void verify_mail_text(String username, String password){

	}


	@Then("^user enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_username_and_password(String username, String password){
		System.out.println(username);
		System.out.println(password);		
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
	}

	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button() {

	}

	@Then("^user click Send button$")
	public void user_clicks_send_button() {
   }

	@When("text of left side menu bar is {string}")
	public void text_of_left_side_menu_bar_is(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("user clicks on Compose button")
	public void user_clicks_on_compose_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("user enter Message Body {string}")
	public void user_enter_message_body(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("user select email in to To Field {string}")
	public void user_select_email_in_to_to_field(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Then("user enter email subject {string}")
	public void user_enter_email_subject(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}


	@Then("^Close the browser$")
	public void close_the_browser(){
		driver.quit();
	}

	
	

}
