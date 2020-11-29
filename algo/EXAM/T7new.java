import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T7new{
	static String word; 
	static boolean[] res = new boolean[4];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		word = sc.next();
		sc.close();
		
		// 创建 Pattern 对象
		Pattern p = Pattern.compile("[^aeiou]+[aeiou]+[^aeiou]+[aeiou]+");//传入模式串
		// 现在创建 matcher 对象
	    Matcher m = p.matcher(word);//传入字符串
	    boolean success = m.matches();//返回匹配结果
	    if(success) {
	    	System.out.println("yes");
	    }else {
	    	System.out.println("no");
	    }
	}
}
