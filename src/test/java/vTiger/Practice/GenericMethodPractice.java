package vTiger.Practice;

public class GenericMethodPractice {
	
	public static void add(int a, int b) 
	{
		int c = a+b;
		System.out.println(c);
	}
	
	public static void sub(int a, int b) 
	{
		int c = a-b;
		System.out.println(c);
	}
	
	public static int multi(int a, int b) //metho dwith return type
	{
		int c = a*b;
		return c;
	}
	
	public static void main(String[] args) {
		
		add(10,20);
		add(44, 56);
		
		sub(100,25);
		sub(254,36);
		
		int x = multi(25,3);
		System.out.println(x);
		System.out.println(multi(45,2));
	}

}
