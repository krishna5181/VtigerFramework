package vTiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertions {
	
	@Test
	public void hardAtests() {
		System.out.println("my prog1");
		System.out.println("my prog2");
		System.out.println("my prog3");
//		Assert.assertEquals(true, false);
		Assert.assertTrue(false);
		System.out.println("my prog4");
		System.out.println("my prog5");
		System.out.println("my prog6");
	}

}
