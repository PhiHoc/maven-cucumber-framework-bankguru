package stepDefinitions;

import cucumberOptions.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    private WebDriver driver;
    public LoginSteps(){
        driver = Hooks.openAndQuitBrowser();
    }
    @Given("I open application")
    public void iOpenApplication() {
        
        
    }
    @When("I get Login page Url")
    public void iGetLoginPageUrl() {
        
        
    }
    @When("I click to here link")
    public void iClickToHereLink() {
        
        
    }
    @When("I input to email textbox with data {string}")
    public void iInputToEmailTextboxWithData(String string) {
        
        
    }
    @When("I click to Submit button at Register page")
    public void iClickToSubmitButtonAtRegisterPage() {
        
        
    }
    @Then("I get UserID infor")
    public void iGetUserIDInfor() {
        
        
    }
    @Then("I get Password infor")
    public void iGetPasswordInfor() {
        
        
    }
    @When("I open Login page again")
    public void iOpenLoginPageAgain() {
        
        
    }
    @When("I input to Username textbox")
    public void iInputToUsernameTextbox() {
        
        
    }
    @When("I input to Password textbox")
    public void iInputToPasswordTextbox() {
        
        
    }
    @When("I click to Login button at Login page")
    public void iClickToLoginButtonAtLoginPage() {
        
        
    }
    @Then("Verify Home page displayed with message {string}")
    public void verifyHomePageDisplayedWithMessage(String string) {
        
        
    }
}
