package testScriptsPractice;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.GenericUtlities.BaseClass;
@Listeners(vTiger.GenericUtlities.ListenersImplementationClass.class)

public class TestScript2Test extends BaseClass
{
	@Test(groups = "SmokeSuite")
	public void Demo1()
	{
		System.out.println("Demo1");
	}
	@Test(groups = "RegressionSuite")
	public void Demo2() 
	{
		System.out.println("Demo2");
	}
	@Test(groups = "SmokeSuite")
	public void Demo3()
	{
		System.out.println("Demo3");
	}
	@Test
	public void Demo4()
	{
		System.out.println("Demo4");
	}
	
}
