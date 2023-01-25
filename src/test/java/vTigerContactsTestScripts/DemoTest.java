package vTigerContactsTestScripts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.GenericUtlities.BaseClass;

@Listeners(vTiger.GenericUtlities.ListenersImplementationClass.class)
public class DemoTest extends BaseClass{
	@Test
	public void demoTest() throws InterruptedException 
	{
		System.out.println("Demo");
		Thread.sleep(2000);
	}
	@Test
	public void sampleTest() throws InterruptedException 
	{
		System.out.println("sample");
		Thread.sleep(2000);
		Assert.fail();
	}
}
