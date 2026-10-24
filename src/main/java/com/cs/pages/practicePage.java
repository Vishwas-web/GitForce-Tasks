package com.cs.pages;

import org.openqa.selenium.By;

import com.cs.DriverManager.DriverManager;
import com.cs.enums.WaitType;

import SeleniumUtils.Utils;

public class practicePage {

	private static final By BTN_SIGN = By.xpath("//ul/li/a[@data-test='nav-sign-in']");
	private static final By TXT_EMIAL = By.id("email");
	private static final By TXT_PWD = By.id("password");
	private static final By BTN_LOGIN = By.xpath("//input[@type='submit']");
	private static final By BTN_ADMINNAME = By.id("admin-menu");
	private static final By BTN_BRAND = By.xpath("//ul/li/a[@data-test='nav-admin-brands']");
	private static final By BtN_ADDBRAND = By.xpath("//div/a[@data-test='brand-add']");
	private static final By TXT_NAME = By.id("name");
	private static final By TXT_SLUG = By.id("slug");
	private static final By BTN_SAVE = By.xpath("//div/button[@type='submit']");

	public void login() {
		Utils.clickElement(BTN_SIGN, WaitType.CLICKABLE, "Sign In button");
		Utils.type(TXT_EMIAL, "admin@practicesoftwaretesting.com", WaitType.PRESENCE, "Email input");
		Utils.clickElement(TXT_PWD, WaitType.CLICKABLE, "Click PWD");
		Utils.type(TXT_PWD, "welcome01", WaitType.PRESENCE, "PWD");
		Utils.clickElement(BTN_LOGIN, WaitType.CLICKABLE, "Login");
	}

	public void createBrand() {
		Utils.clickElement(BTN_ADMINNAME, WaitType.CLICKABLE, "ADmin name");
		Utils.clickElement(BTN_BRAND, WaitType.CLICKABLE, "Brand");
		Utils.clickElement(BtN_ADDBRAND, WaitType.CLICKABLE, "ADD button");
		Utils.type(TXT_NAME, "Hammer", WaitType.PRESENCE, "name");
		Utils.type(TXT_SLUG, "12", WaitType.PRESENCE, "Slug");
		Utils.clickElement(BTN_SAVE, WaitType.CLICKABLE, "Save");
	}

	public String getAlertMessage() {
		return DriverManager.getDriver().findElement(By.xpath("//div[@role='alert']")).getText();
	}
}
