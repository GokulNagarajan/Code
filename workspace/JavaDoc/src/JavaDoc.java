/*
 * 
 * @author="gokul"
 * 
 */
/*
 * Program used to create a java document 
 * 
 */
public class JavaDoc {
//main method delcaration
	public static void main(String[] args) {
		String str="Welcome";//string variable to print a message
		//calling static method
		greet(str);
	}
//method to greet user
	private static void greet(String str) {
		//print the messsage which is passed as parameter
		System.out.println(str);
	}

}
