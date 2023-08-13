package Stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	  private WebDriver driver;

	  @Given("the user navigates to JavaTpoint.com")
	  public void goToJavaTpoint() {
	    driver = (WebDriver) new ChromeDriver();
	    driver.get("https://www.javatpoint.com");
	  }

	  @When("the user clicks on Feedback")
	  public void clickFeedbackButton() {
	    WebElement feedbackButton = driver.findElement(By.cssSelector("#feedback-button"));
	    feedbackButton.click();
	  }

	  @Then("the Feedback page opens")
	  public void verifyFeedbackPage() {
	    WebElement feedbackForm = driver.findElement(By.cssSelector("#feedback-form"));
	    assertTrue(feedbackForm.isDisplayed());
	  }

	  @And("the user submits feedback message")
	  public void submitFeedbackMessage() {
	    WebElement feedbackMessage = driver.findElement(By.cssSelector("#feedback-message"));
	    feedbackMessage.sendKeys("This is a test feedback message");
	    WebElement submitButton = driver.findElement(By.cssSelector("#submit-button"));
	    submitButton.click();
	  }

	  @Then("feedback should be received on the admin page")
	  public void verifyFeedbackReceived() {
	    WebElement feedbackNotification = driver.findElement(By.cssSelector("#feedback-notification"));
	    assertTrue(feedbackNotification.isDisplayed());
	    assertEquals("Feedback received!", feedbackNotification.getText());
	  }

	  @And("admin can reply to the user")
	  public void replyToFeedback() {
	    WebElement replyButton = driver.findElement(By.cssSelector("#reply-button"));
	    replyButton.click();
	    WebElement replyMessage = driver.findElement(By.cssSelector("#reply-message"));
	    replyMessage.sendKeys("Thank you for your feedback!");
	    WebElement sendReplyButton = driver.findElement(By.cssSelector("#send-reply-button"));
	    sendReplyButton.click();
	  }
	}