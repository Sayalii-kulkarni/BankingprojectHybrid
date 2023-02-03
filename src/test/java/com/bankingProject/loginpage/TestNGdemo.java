package com.bankingProject.loginpage;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGdemo {
	
	@Test
	public void test() {
		
		SoftAssert assert1 = new SoftAssert();
		System.out.println("test start");
		System.out.println("hii");
		assert1.assertEquals("test", "test1");
		assert1.assertTrue(1>5);
		System.out.println("Bye");
		System.out.println("class");
		assert1.assertAll();
	}

}
