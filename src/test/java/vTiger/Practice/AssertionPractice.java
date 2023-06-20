package vTiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice 
{
	@Test
	public void assertTest1() 
	{
		System.out.println("stepA");
		System.out.println("stepB");
		Assert.assertEquals(false, false);
		Assert.assertTrue(true);
		System.out.println("stepC");
		System.out.println("stepD");
	}
	@Test
	public void assertTest2() 
	{
		SoftAssert sa = new SoftAssert();
		System.out.println("step1");
		Assert.assertTrue(true);
		
		System.out.println("step2");
		sa.assertEquals(true, true);
		
		System.out.println("step3");
		
		sa.assertTrue(false);
		
		System.out.println("step4");
		System.out.println("step5");
		sa.assertTrue(false);
		
		System.out.println("step6");
//		sa.assertAll();
		
		
		
		
		
		
		
		
		
	}

}
