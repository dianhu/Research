package basic.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) {
		  String str = "this is my test 52, i want find the number 89";  
		    Pattern patter = Pattern.compile("\\d+");  
		    Matcher matcher = patter.matcher(str);  
		    while(matcher.find()){  
		        System.out.println(matcher.group());  
		    }  
	}
}
