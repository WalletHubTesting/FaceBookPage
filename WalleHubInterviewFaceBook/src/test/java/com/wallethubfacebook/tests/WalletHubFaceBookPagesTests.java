package com.wallethubfacebook.tests;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.wallethubfacebook.base.TestBase;
import com.wallethubfacebook.pages.WalletHubFaceBookPage;

public class WalletHubFaceBookPagesTests extends TestBase {
	WalletHubFaceBookPage walletHubFaceBookPages;
	 SoftAssert softAssertion;
	
	
	
	
	public WalletHubFaceBookPagesTests() 
	{
		super(); 
		
	}
	
	@BeforeClass
	public void baseSetUp()
	{
		
		 initilization();
		 walletHubFaceBookPages =new WalletHubFaceBookPage();
		 softAssertion= new SoftAssert();
		 
	}
	
	
	
	@AfterClass
	public void tearDown()

	{
		driver.quit();
	}
	
	
	
	@Test(priority = 1, description = " Scenario 1 : Wallet Hub Test 2")
	public void faceBookStatus() throws InterruptedException
	{
		String statusMessage = "Hello World";
				walletHubFaceBookPages.faceBookLogin();
		walletHubFaceBookPages.faceBookStatusPost(statusMessage);
		//Assert.assertTrue(walletHubFaceBookPages.faceBookStatusPostIsPresent(), statusMessage);
		Assert.assertEquals(walletHubFaceBookPages.faceBookStatusPostIsPresent(), statusMessage);
	}
	
	
	
	
}
