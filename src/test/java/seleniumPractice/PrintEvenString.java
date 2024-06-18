package seleniumPractice;

public class PrintEvenString {
	public static void main(String[] args) {
		String name = "Mine Sky is blue and vast";
		String[] nameArray = name.split(" ");
		for(String eachWord : nameArray) {
			if(eachWord.length()%2 == 0) {
				System.out.println(eachWord);
			}
		}
	}
}
