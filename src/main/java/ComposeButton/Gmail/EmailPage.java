package ComposeButton.Gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class EmailPage{

	public WebDriver driver;
	
	public EmailPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	By composeBtn = By.xpath("//*[text()='Compose']");
	By subjectBox = By.name("subjectbox");
	By body = By.xpath("//div[@aria-label='Message Body' and @role='textbox']");
	By messagebox = By.xpath("//div[@aria-label='New Message']");
	By subject = By.name("subjectbox");
	By messagebody = By.xpath("//div[@aria-label='Message Body']");
	By sendBtn = By.xpath("//div[contains(@data-tooltip,'Send')]");
	By to = By.xpath("//span[text()='To']");
	By cc = By.xpath("//span[contains(@aria-label,'Add Cc')]");
	By ccmycontacts = By.xpath("//span[@aria-label='Cc - Select contacts']");
	By bcc = By.xpath("//span[contains(@aria-label,'Add Bcc')]");
	By bccmycontacts = By.xpath("//span[@aria-label='Bcc - Select contacts']");
	public By mycontacts = By.xpath("//div[@aria-label='Select contacts']");
	By close = By.xpath("//div[@data-tooltip='Close']");
	By formattingOptions = By.xpath("//div[@data-tooltip='Formatting options']");
	By attachFiles = By.xpath("//div[@data-tooltip='Attach files']");
	By insertlink = By.xpath("//div[contains(@data-tooltip,'Insert link')]");
	By insertemoji = By.xpath("//div[contains(@data-tooltip,'Insert emoji')]");
	
	public WebElement getComposeButton() {
		return driver.findElement(composeBtn);
	}
	
	public WebElement getSubjectBox() {
		return driver.findElement(subjectBox);
	}
	
	public WebElement getBody() {
		return driver.findElement(body);
	}
	
	public WebElement getMessageBox() {
		return driver.findElement(messagebox);
	}
	
	public WebElement getSubject() {
		return driver.findElement(subject);
	}
	
	public WebElement getMessageBody() {
		return driver.findElement(messagebody);
	}
	
	public WebElement getSendButton() {
		return driver.findElement(sendBtn);
	}
	
	public WebElement getToButton() {
		return driver.findElement(to);
	}
	
	public WebElement getCcButton() {
		return driver.findElement(cc);
	}
	
	public WebElement getCcMyContactsButton() {
		return driver.findElement(ccmycontacts);
	}
	
	public WebElement getBccButton() {
		return driver.findElement(bcc);
	}
	
	public WebElement getBccMyContactsButton() {
		return driver.findElement(bccmycontacts);
	}
	
	public WebElement getMyContacts() {
		return driver.findElement(mycontacts);
	}
	
	public WebElement getCloseButton() {
		return driver.findElement(close);
	}
		
	public WebElement getFormattingOptions() {
		return driver.findElement(formattingOptions);
	}
	
	public WebElement getAttachFile() {
		return driver.findElement(attachFiles);
	}
	public WebElement getInsertLink() {
		return driver.findElement(insertlink);
	}
	public WebElement getInsertEmoji() {
		return driver.findElement(insertemoji);
	}
	
}
