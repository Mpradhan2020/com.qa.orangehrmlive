package com.qa.orangehrmlivePages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.orangehrmliveTestscript.TestBase;

public class Orangehrmlive_Pages extends TestBase {

	WebDriver Driver;
	

	@FindBy(xpath = "/html/body/div[1]/div/div[3]/div[2]/div[2]/form/div[2]/input")
	@CacheLookup
	WebElement UserNameInput;

	public void setUserName(String input) {
		UserNameInput.sendKeys(input);

	}

	@FindBy(xpath = "/html/body/div[1]/div/div[3]/div[2]/div[2]/form/div[3]/input")
	@CacheLookup
	WebElement UserPassInput;

	public void setPassName(String inputpass) {
		UserPassInput.sendKeys(inputpass);
	}

	@FindBy(xpath = "/html/body/div[1]/div/div[3]/div[2]/div[2]/form/div[5]/input")
	@CacheLookup
	WebElement ClickSubmit;

	// login button
	public void setSubmit() {
		ClickSubmit.click();

	}

	// Click on Admin menu
	// @FindBy(linkText="Admin")
	// @FindBy(id = "menu_admin_viewAdminModule")
	@FindBy(xpath = "//b[contains(text(),'Admin')]")
	@CacheLookup
	WebElement ClickAdmin;

	public void clickAdmin() {
		ClickAdmin.click();
	}

	@FindBy(xpath = "/html/body/div[1]/div[3]/div/div[1]/h1")
	@CacheLookup
	WebElement verDashboard;

	public WebElement verifyDashboard() {
		return verDashboard;
	}

	@FindBy(xpath = "/html/body/div[1]/div[2]/ul/li[1]/ul/li[2]/a")
	@CacheLookup
	WebElement clickJob;

	public void clickJob() {
		clickJob.click();

	}

	@FindBy(xpath = "/html/body/div[1]/div[2]/ul/li[1]/ul/li[2]/ul/li[1]/a")
	@CacheLookup
	WebElement clickJobTitle;

	public void clickTitle() {
		clickJobTitle.click();

	}

	@FindBy(xpath = "/html/body/div[1]/div[3]/div[1]/div/div[1]/h1")
	@CacheLookup
	WebElement JobTitle;

	
	// all textbox
	@FindBy(xpath = "//input[@type='text']")
	@CacheLookup
	List<WebElement> allTextbox;

	public List<WebElement> getAllTextBox() {

		return allTextbox;

	}

	// all hyperlinks

	@FindAll(@FindBy(tagName = "a"))
	@CacheLookup
	List<WebElement> AllLinks;

	public List<WebElement> getAllLinks() {

		return AllLinks;
	}

	// All Images.

	@FindBy(xpath = "//*/img")
	@CacheLookup
	List<WebElement> allImages;

	public List<WebElement> getAllImages() {

		return allImages;
	}

	// validate User Management

	@FindBy(id = "menu_admin_UserManagement")
	@CacheLookup
	WebElement usrManagement;

	public WebElement verifyUserManagement() {

		return usrManagement;

	}

	@FindBy(id = "menu_admin_Job")
	@CacheLookup
	WebElement adminJob;

	public WebElement verifyAdminJobMenu() {
		return adminJob;

	}

	@FindBy(id = "menu_admin_Organization")
	@CacheLookup
	WebElement adminOrg;

	public WebElement verifyAdminOrgnizationMenu() {

		return adminOrg;
		// String str = adminOrg.getText();
		// Assert.assertTrue(str.contains("Organization"));

	}

	@FindBy(id = "menu_admin_Qualifications")
	@CacheLookup
	WebElement adminQualification;

	public WebElement verifyAdminQualificationMenu() {

		return adminQualification;

	}

	@FindBy(id = "menu_pim_viewPimModule")
	@CacheLookup
	WebElement pimMenu;

	public void clickPIMMenu() {

		pimMenu.click();

	}

	@FindBy(id = "menu_leave_viewLeaveModule")
	@CacheLookup
	WebElement leaveMenu;

	public void clickLeaveMenu() {

		leaveMenu.click();

	}

	@FindBy(id = "menu_dashboard_index")
	@CacheLookup
	WebElement dashboardMenu;

	public void clickDashboardMenu() {

		dashboardMenu.click();

	}

	@FindBy(id = "menu_directory_viewDirectory")
	@CacheLookup
	WebElement directoryMenu;

	public void clickDirectoryMenu() {

		directoryMenu.click();

	}

	@FindBy(id = "menu_maintenance_purgeEmployee")
	@CacheLookup
	WebElement maintenanceMenu;

	public void clickMaintenanceMenu() {

		maintenanceMenu.click();

	}

	// Employ name in PIM menu
	@FindBy(id = "empsearch_employee_name_empName")
	@CacheLookup
	WebElement empName;

	public void setEmpName(String employName) {
		empName.sendKeys(employName);

	}

	// Search Employ name in PIM menu

	@FindBy(id = "searchBtn")
	@CacheLookup
	WebElement empSearch;

	public void clickEmpSearch() {
		empSearch.click();

	}

	// *[@id="employee-information"]/a

	@FindBy(xpath = "//*[@id=\"employee-information\"]/div[1]/h1")
	@CacheLookup
	WebElement pimHeading;

	public WebElement verifyPIMHeading() {

		return pimHeading;
	}

	// PIM Menu -- CSS
	@FindBy(css = "#menu_pim_viewPimModule")
	@CacheLookup
	WebElement cssPIMmenu;

	public void clickcssPIMMenu() {

		cssPIMmenu.click();

	}

	// Time Menu -- CSS
	@FindBy(css = "#menu_time_viewTimeModule")
	@CacheLookup
	WebElement cssTimemenu;

	public void clickcssTimeMenu() {

		cssTimemenu.click();

	}

	// Maintenance Menu -- CSS
	@FindBy(css = "#menu_maintenance_purgeEmployee")
	@CacheLookup
	WebElement cssMaintenanceMenu;

	public void clickcssMaintenanceMenu() {

		cssMaintenanceMenu.click();

	}

	// Dashboard Menu-- CSS
	@FindBy(css = "#menu_dashboard_index")
	@CacheLookup
	WebElement cssDashMenu;

	public void clickcssDashboardMenu() {

		cssDashMenu.click();

	}

	// Dashboard Menu -- Assign Leave-- CSS

	@FindBy(css = "#dashboard-quick-launch-panel-menu_holder > table > tbody > tr > td:nth-child(1) > div > a > img")
	@CacheLookup
	WebElement cssDashAssignLeave;

	public void clickcssDashAssignLeaveIcon() {

		cssDashAssignLeave.click();

	}

	// Dashboard Menu -- Timesheet-- CSS
	@FindBy(css = "#dashboard-quick-launch-panel-menu_holder > table > tbody > tr > td:nth-child(3) > div > a > img")
	@CacheLookup
	WebElement cssDashTimeSheet;

	public void clickcssDashTimeSheetIcon() {

		cssDashTimeSheet.click();

	}

	// Dashboard PI-chart
	// #div_graph_display_emp_distribution > canvas.flot-overlay

	@FindBy(css = "#div_graph_display_emp_distribution")
	@CacheLookup
	WebElement cssDashPi_Chart;

	public WebElement verifycssDash_Pi_Chart() {

		return cssDashPi_Chart;

	}

	// MarketPlace Link

	@FindBy(id = "MP_link")

	@CacheLookup
	WebElement xpathMarketplace;

	public void clickMarketplace() {
		xpathMarketplace.click();

	}

	// Verify Welcome User
	@FindBy(id = "welcome")
	@CacheLookup
	WebElement xpathWelcome;

	public WebElement verifyWelcomeUser() {
		return xpathWelcome;

	}

	// click on Leave List on Dashboard Menu

	@FindBy(xpath = "//*[@id=\"dashboard-quick-launch-panel-menu_holder\"]/table/tbody/tr/td[2]/div/a/span")
	@CacheLookup
	WebElement xpathLeaveList;

	public void verifyxpathLeaveList() {

		xpathLeaveList.click();

	}

	public Orangehrmlive_Pages(WebDriver Driver) {
		this.Driver = Driver;
		PageFactory.initElements(Driver, this);
	}

}
