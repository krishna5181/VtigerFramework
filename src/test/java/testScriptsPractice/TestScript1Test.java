package testScriptsPractice;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.GenericUtlities.BaseClass;
@Listeners(vTiger.GenericUtlities.ListenersImplementationClass.class)

public class TestScript1Test  extends BaseClass
{
	@Test 
	public void Suite1()
	{
		System.out.println("Suite demo 1");
	}
	@Test
	public void Suite2()
	{
		System.out.println("Suite Demo 2");
	}
	@Test
	public void Suite3()
	{
		System.out.println("Suite Demo3");
	}
}
