package testScriptsPractice;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.GenericUtlities.BaseClass;
@Listeners(vTiger.GenericUtlities.ListenersImplementationClass.class)

public class TestScript3Test extends BaseClass
{
	@Test
	public void Run1()
	{
		System.out.println("Running");
	}
	
	@Test
	public void Run2()
	{
		System.out.println("Walking");
	}
	
	@Test
	public void Run3()
	{
		System.out.println("Jagging");
	}

}
