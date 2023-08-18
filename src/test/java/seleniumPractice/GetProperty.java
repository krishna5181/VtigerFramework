package seleniumPractice;

import org.testng.annotations.Test;

public class GetProperty {
	@Test
	public void PrintProp() {
//		System.getProperties().list(System.out);
		
		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("user.name"));
		System.out.println(System.getProperty("os.version"));
		System.out.println(System.getProperty("java.runtime.name"));
		
	}

}
