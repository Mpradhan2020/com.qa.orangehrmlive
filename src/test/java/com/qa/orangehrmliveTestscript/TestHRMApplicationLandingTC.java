package com.qa.orangehrmliveTestscript;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.qa.orangehrmliveUtilities.TestNGListner;

import com.qa.orangehrmlivePages.Orangehrmlive_Pages;

//Implement ITestListener for above scenario where full-page screenshot needs to be capture where ever test is pass or failed. Hint – Please use Shutterbug class
// Listeners can be implemented from testng.xml file by adding <listeners> tag
//@Listeners (com.qa.orangehrmliveUtilities.TestNGListner.class)
public class TestHRMApplicationLandingTC extends TestBase {

	Orangehrmlive_Pages OrangeOR;

	@BeforeMethod
	public void loadPages() {
		OrangeOR = new Orangehrmlive_Pages(Driver);

	}

	// Login and verify Dashboard at Landing Page
	@Test(priority = 1)
	public void verifyinDashboard() throws Throwable {

		OrangeOR.setUserName(prop.getProperty("username"));
		OrangeOR.setPassName(prop.getProperty("pass"));
		OrangeOR.setSubmit();


		// Verify "Dashboard" at Landing Page
		OrangeOR.verifyDashboard().getText();
		Assert.assertTrue(OrangeOR.verifyDashboard().getText().equals("Dashboard"));
		System.out.println("verifyinDashboard");
	}

	// Click on Admin Link in Home Page and validate following text
	/*
	 * User Management Job Organization Qualifications
	 */

	@Test(priority = 2)
	public void clickAdminLinkandVerifyMenues() throws InterruptedException {
		OrangeOR.clickAdmin();

		// Verify "User Management"
		String strManage = OrangeOR.verifyUserManagement().getText();
		Assert.assertTrue(strManage.equals("User Management"));

		// Verify "Job"

		String strAdminMenu = OrangeOR.verifyAdminJobMenu().getText();
		Assert.assertTrue(strAdminMenu.equals("Job"));

		// Verify "Organization"

		String strOrganization = OrangeOR.verifyAdminOrgnizationMenu().getText();
		Assert.assertTrue(strOrganization.equals("Organization"));

		// Verify "Qualifications"

		String strQual = OrangeOR.verifyAdminQualificationMenu().getText();
		Assert.assertTrue(strQual.equals("Qualifications"));
		System.out.println("clickAdminLinkandVerifyMenues");

	}

	// Verify page title for different menus- in order(Admin, PIM, Leave Dashboard,
	// Directory and Maintenance)
	@Test(priority = 3)
	public void clickAdminandVerifyTitle() throws InterruptedException {
		OrangeOR.clickAdmin();


		// Verify Title of Admin Page
		Assert.assertTrue(Driver.getTitle().equals("OrangeHRM"));

		// Verify Title of PIM Page
		OrangeOR.clickPIMMenu();
		Assert.assertTrue(Driver.getTitle().equals("OrangeHRM"));

		// Verify Title of Leave Page
		OrangeOR.clickLeaveMenu();
		Assert.assertTrue(Driver.getTitle().equals("OrangeHRM"));

		// Verify Title of Leave Page
		OrangeOR.clickDashboardMenu();
		Assert.assertTrue(Driver.getTitle().equals("OrangeHRM"));

		// Verify Title of Directory Page
		OrangeOR.clickDirectoryMenu();
		Assert.assertTrue(Driver.getTitle().equals("OrangeHRM"));

		// Verify Title of Maintenance Page

		OrangeOR.clickMaintenanceMenu();
		Assert.assertTrue(Driver.getTitle().equals("OrangeHRM"));
		System.out.println("clickAdminandVerifyTitle");

	}

	// Minimized window without @test annotation
	public void minimizeMindow() {

		Driver.manage().window().maximize();
		System.out.println("minimizeMindow");

	}

	// Read Dashboard heading using [driver.findelement(by.xpath()).gettext()].

	@Test(priority = 4, retryAnalyzer = com.qa.orangehrmliveUtilities.RetryAnalyzer.class)
	public void readDashboard() {

		OrangeOR.clickDashboardMenu();
		String srtDash = Driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/h1")).getText();
		// System.out.println("Landing page heading is : " + srtDash);
		Assert.assertTrue(srtDash.equals("Dashboard"));
		System.out.println("readDashboard");
	}

	// Click on PIM and search employname
	@Test(priority = 5)
	public void clickPIM_SearchEmp() throws Throwable {

		OrangeOR.clickPIMMenu();
	// Enter Employee Name-Linda Anderson in Search box (refer below image)
		OrangeOR.setEmpName("Linda Anderson");
		OrangeOR.clickEmpSearch();

		String strEmpInf = OrangeOR.verifyPIMHeading().getText();
		Assert.assertTrue(strEmpInf.equals("Employee Information"));

	}

	// Write CSS Selector of highlighted Rectangular object (in Red) in below Image
	@Test(priority = 6)
	public void cssMenus_Dashboard3Obj() throws Throwable {
		OrangeOR.clickcssPIMMenu();
		Assert.assertTrue(Driver.getCurrentUrl().contains("pim"));

		OrangeOR.clickcssTimeMenu();
		Assert.assertTrue(Driver.getCurrentUrl().contains("time"));
		OrangeOR.clickcssMaintenanceMenu();
		Assert.assertTrue(Driver.getCurrentUrl().contains("maintenance"));
		OrangeOR.clickcssDashboardMenu();
		Assert.assertTrue(Driver.getCurrentUrl().contains("dashboard"));
		OrangeOR.clickcssDashAssignLeaveIcon();
		Assert.assertTrue(Driver.getCurrentUrl().contains("assignLeave"));

		// Back to Dashboard Menu
		Driver.navigate().back();
		OrangeOR.clickcssDashTimeSheetIcon();
		Assert.assertTrue(Driver.getCurrentUrl().contains("viewEmployeeTimesheet"));

		// Back to Dashboard Menu
		Driver.navigate().back();

		// Verifying ID value
		String strID = OrangeOR.verifycssDash_Pi_Chart().getAttribute("id");
		System.out.println("Verity Pi-Chart: " + strID);
		Assert.assertTrue(strID.equals("div_graph_display_emp_distribution"));

	}

	// Write Xpath Selector of highlighted Rectangular object (in Red) in below –

	@Test(priority = 7)
	public void xpathMenus() throws Throwable {
		// Admin click
		OrangeOR.clickAdmin();
		Assert.assertTrue(Driver.getCurrentUrl().contains("admin"));

		// verify Marketplace
		OrangeOR.clickMarketplace();
		Assert.assertTrue(Driver.getCurrentUrl().contains("marketPlace"));

		// verify Welcome user
		String strWeclcome = OrangeOR.verifyWelcomeUser().getAttribute("id");
		Assert.assertTrue(strWeclcome.equals("welcome"));

		// click on Dashboard menu
		OrangeOR.clickDashboardMenu();
		Assert.assertTrue(Driver.getCurrentUrl().contains("dashboard"));

		// click Leave List
		OrangeOR.verifyxpathLeaveList();
		Assert.assertTrue(Driver.getCurrentUrl().contains("viewLeaveList"));

	}

}
