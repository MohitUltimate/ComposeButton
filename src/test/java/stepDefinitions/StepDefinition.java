package stepDefinitions;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ComposeButton.Gmail.EmailPage;
import ComposeButton.Gmail.LoginPage;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import resources.base;

@RunWith(Cucumber.class)
public class StepDefinition extends base {

	public WebDriver driver;
	public LoginPage lp;
	public EmailPage emailpage;

	public WebDriverWait wait;

	@Given("^I open \"([^\"]*)\"$")
	public void i_open(String url) throws Throwable {
		driver = initializeDriver();
		driver.get(url);
	}

	@Given("^I am on the login page$")
	public void i_am_on_the_login_page() throws Throwable {

	}

	@When("^I login using \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_login_using_and(String username, String password) throws Throwable {
		lp = new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(lp.getNextButton()));
		lp.getNextButton().click();
		wait.until(ExpectedConditions.elementToBeClickable(lp.getPassword())).click();
		lp.getPassword().sendKeys(password);
		wait.until(ExpectedConditions.elementToBeClickable(lp.getPassNextButton()));
		lp.getPassNextButton().click();
//	    wait.until(ExpectedConditions.elementToBeClickable(lp.getConfirmButton()));
//	    lp.getConfirmButton().click();
	}

	@When("^I am on main email landing page$")
	public void i_am_on_main_email_landing_page() throws Throwable {
//		Assert.assertTrue(driver.getTitle().contains("inbox"));
	}

	@Then("^I am able to verify that the compose button is displayed on the email landing page$")
	public void i_am_able_to_verify_that_the_compose_button_is_displayed_on_the_email_landing_page() throws Throwable {
		emailpage = new EmailPage(driver);
		emailpage.getComposeButton().isDisplayed();
	}

	@When("^I click on compose button$")
	public void i_click_on_compose_button() throws Throwable {
		emailpage = new EmailPage(driver);
		emailpage.getComposeButton().click();
	}

	@Then("^New message tab is opened$")
	public void new_message_tab_is_opened() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(emailpage.getMessageBox().isDisplayed());
	}

	@Then("^I am able to write email with subject \"([^\"]*)\" and body \"([^\"]*)\"$")
	public void i_am_able_to_write_email_with_subject_and_body(String subject, String body) throws Throwable {
		emailpage.getSubject().sendKeys(subject);
		emailpage.getMessageBody().sendKeys(body);
	}

	@Then("^I am able to click on Send button$")
	public void i_am_able_to_click_on_Send_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		emailpage.getSendButton().click();
	}

	@When("^I click on To button$")
	public void i_click_on_to_button() throws Throwable {
		emailpage.getToButton().click();
		driver.switchTo().frame(driver
				.findElement(By.xpath("(//span[text()='Select contacts']//following::iframe[@allow='camera'])[1]")));
	}

	@When("^I click on CC button$")
	public void i_click_on_cc_button() throws Throwable {
		emailpage.getCcButton().click();
		wait.until(ExpectedConditions.elementToBeClickable(emailpage.getCcMyContactsButton()));
		emailpage.getCcMyContactsButton().click();
		driver.switchTo().frame(driver
				.findElement(By.xpath("(//span[text()='Select contacts']//following::iframe[@allow='camera'])[2]")));
	}

	@When("^I click on BCC button$")
	public void i_click_on_bcc_button() throws Throwable {
		emailpage.getBccButton().click();
		wait.until(ExpectedConditions.elementToBeClickable(emailpage.getBccMyContactsButton()));
		emailpage.getBccMyContactsButton().click();
		driver.switchTo().frame(driver
				.findElement(By.xpath("(//span[text()='Select contacts']//following::iframe[@allow='camera'])[3]")));
	}

	@Then("^My Contacts tab is opened$")
	public void my_contacts_tab_is_opened() throws Throwable {
		Assert.assertTrue(
				wait.until(ExpectedConditions.visibilityOfElementLocated(emailpage.mycontacts)).isDisplayed());
		emailpage.getCloseButton().click();
		driver.switchTo().parentFrame();
	}
	

    @Then("^I verify that all the buttons like Formatting options, Attach files, Insert link, etc are visible$")
    public void i_verify_that_all_the_buttons_like_formatting_options_attach_files_insert_link_etc_are_visible() throws Throwable {
        Assert.assertTrue(emailpage.getFormattingOptions().isDisplayed());
        Assert.assertTrue(emailpage.getAttachFile().isDisplayed());
        Assert.assertTrue(emailpage.getInsertLink().isDisplayed());
        Assert.assertTrue(emailpage.getInsertEmoji().isDisplayed());
    }


	@After
	public void tearDown() {
		driver.quit();
	}

}
