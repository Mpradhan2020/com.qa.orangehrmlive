package com.qa.orangehrmliveTestscript;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.orangehrmlivePages.Orangehrmlive_Pages;

public class TestHRMAppLoginTC extends TestBase {

	Orangehrmlive_Pages OrangeORLg;

	@BeforeMethod
	public void loadPages() {
		OrangeORLg = new Orangehrmlive_Pages(Driver);

	}

	// Application Title Verified
		@Test(priority = 1)
		public void verifyAppTitle()

		{
			Assert.assertTrue(Driver.getTitle().equals("OrangeHRM"));
			System.out.println("Applicaiton Title Verified");
			System.out.println("verifyAppTitle");
		}
		
		// All Text box’s
		@Test(priority = 2)
		public void listofTextBox() {

			List<WebElement> textboxes = OrangeORLg.getAllTextBox();
			System.out.println("No of Textboxs are : " + textboxes.size());
			System.out.println("listofTextBox");
		}

		// All Links
		@Test(priority = 3)
		public void listofLinks() {

			List<WebElement> allLinks = OrangeORLg.getAllLinks();
			System.out.println("No of Links : " + allLinks.size());
			System.out.println("listofLinks");
		}

		// All Images
		@Test(priority = 4)
		public void listofImages() {

			List<WebElement> allImg = OrangeORLg.getAllImages();

			System.out.println("No of Images : " + allImg.size());
			System.out.println("listofImages");
		}
}
