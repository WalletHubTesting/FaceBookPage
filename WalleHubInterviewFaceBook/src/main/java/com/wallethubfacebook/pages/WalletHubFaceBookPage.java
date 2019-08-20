package com.wallethubfacebook.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.wallethubfacebook.base.TestBase;

public class WalletHubFaceBookPage extends TestBase {

	public void faceBookLogin() throws InterruptedException {

		String faceBookUserName = prop.getProperty("faceBookUserName");
		String faceBookUserPassword = prop.getProperty("faceBookPassword");

		WebElement emailField = driver.findElement(By.id("email"));
		WebElement passwordField = driver.findElement(By.id("pass"));
		WebElement loginButton = driver.findElement(By.id("loginbutton"));

		emailField.clear();
		emailField.sendKeys(faceBookUserName);
		passwordField.clear();
		passwordField.sendKeys(faceBookUserPassword);
		loginButton.click();
		// Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(driver, 500);
		wait.until(ExpectedConditions.invisibilityOf((loginButton)));

	}

	public void faceBookStatusPost(String statusMessage) throws InterruptedException {
		driver.findElement(By.xpath("//textarea[starts-with(@title,'Write something here')]")).click();
		Thread.sleep(2000);
		Actions ac = new Actions(driver);
		ac.click(driver.findElement(By.xpath("//span[contains(text(),'Create Post')]"))).sendKeys(Keys.TAB)
				.sendKeys(Keys.TAB).sendKeys(statusMessage).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Post']"))).click();
		Thread.sleep(3000);
		// WebElement loginButton =
		// driver.findElement(By.xpath("//span[text()='Post']"));
		//wait.until(ExpectedConditions.visibilityOf(By.xpath("//*[text()='Hello']")));
	}

	public String faceBookStatusPostIsPresent() {
		System.out.println(driver.findElement(By.xpath("(//div[@data-testid='post_message'])[1]")).getText());
		return driver.findElement(By.xpath("(//div[@data-testid='post_message'])[1]")).getText();

	}

}
