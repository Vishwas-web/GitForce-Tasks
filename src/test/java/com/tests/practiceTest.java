package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cs.pages.practicePage;

public class practiceTest extends BaseTest {
	@Test
	public void verifyCreationBrand() {
		practicePage page = new practicePage();
		page.login();
		page.createBrand();
		Assert.assertEquals("Brand saved!", page.getAlertMessage());
	}
}
