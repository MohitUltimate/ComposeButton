package ComposeButton.Gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	
	By email = By.cssSelector("[type='email']");
	By nextBtn = By.id("identifierNext");
	By password = By.xpath("//input[@aria-label='Enter your password']");
	By confirmBtn = By.xpath("//*[text()='Confirm']");
	By passNextBtn = By.id("passwordNext");
	
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getNextButton() {
		return driver.findElement(nextBtn);
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement getConfirmButton() {
		return driver.findElement(confirmBtn);
	}
	
	public WebElement getPassNextButton() {
		return driver.findElement(passNextBtn);
	}
	
}
