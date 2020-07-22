/*
 * @Author: your name
 * @Date: 2020-04-11 14:52:33
 * @LastEditTime: 2020-04-11 14:52:34
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: /java/OJ/H.java
 */

import java.util.*;
public class H {
	private static final int DEFINEK = 2000000;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
//		Queue<String> queue = new LinkedList<String>();
		int K;
		int sum = 0;
		String temp;
		temp = input.nextLine();
		K = Integer.parseInt(temp);
		String str = input.nextLine();// start with 0
		int AliceFirst = NameIndex(str, "Alice");
		int BobFirst = NameIndex(str, "Bob");
		if(AliceFirst == -1 && BobFirst == -1) {
			input.close();
			return;
		}
		if(AliceFirst < BobFirst) {
			
		}
		System.out.println(AliceFirst + "     " + BobFirst);
		if(Math.abs(AliceFirst - BobFirst) < K) {
			System.out.println(Math.abs(AliceFirst - BobFirst));
			sum ++;
		}
		System.out.println(sum);
		input.close();
	}
	
	public static int NameIndex(String str, String pat) {
		int NameFirst = -1;
		int wetherAdd = 0;
		String[] patten = {" " + pat + " ", " " + pat, pat + " ", "." + pat + ".", "." + pat, pat + "."};
		for(int i = 0; i < patten.length; i++) {
			if(str.indexOf(patten[i]) == -1) {
				continue;
			} else {
				if(wetherAdd == 0) {
					NameFirst = Math.min(str.indexOf(patten[i]), DEFINEK);
					wetherAdd ++;
				} else {
					NameFirst = Math.min(str.indexOf(patten[i]), NameFirst);
				}
			}
		}
		return NameFirst;
	}
}