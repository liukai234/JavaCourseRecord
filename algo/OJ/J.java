/*
 * @Author: your name
 * @Date: 2020-04-11 14:52:44
 * @LastEditTime: 2020-04-11 14:52:45
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: /java/OJ/J.java
 */

import java.util.Arrays;
import java.util.Scanner;
/**
 * @ClassName: PostfixExpression��׺����ʽ
 * @Description: ������ҵ�˼���Ƿ�������ۣ�
 * 1.���ֻ��+�ţ�û��-�ţ�����������ۼӼ��ɣ�
 * 2.���ֻ��-�ţ�û��+�ţ����ȴ�С��������Ȼ�������������ǣ�
 * ��1��.��Сֵ�Ǹ�����Ҳ���Ǻ��и�����������[-2, -1, 3, 4, 5]���ĸ����ţ��������Ϊ5 - (-1) - (-2 - 3 - 4) = 5 + 1 - (-9)
 *  = 5 + 1 + 9 = 15��Ҳ����˵ֻҪ���и���������ת������ȫ����Ӽ���
 * ��2��.��Сֵ��������ȫ����������������[1, 2, 3]���������ţ��������Ϊ3 - (1 - 2) = 3 + 2 - 1��Ҳ����˵�������Ϊ����
 *         ��Сֵ�����������Ӽ�ȥ��Сֵ 
 * 3.�����+�ţ���-�ţ������ۼ��ŵĸ����븺���ĸ�����������������ۣ�ʵ�ʷ�Ϊ���֣���
 *�� 1��.���Ÿ������ڵ��ڸ����������򽫸�����������ÿһ�������������Ĺ����У� ���ŵ�������Ҫ��һ��Ȼ������,��������Ӵ�С�ۼӣ�
 * ֱ��ʣ�µ����ָ����ͼ���������ͬ��Ȼ���ټ�ȥ��Щʣ�µ����֣���
 * ��2��.���Ÿ���С�ڸ������������ʱ�����Ǿ�Ӧ��ʹ��+�ţ���������������[2, -5 , -6, + , -]���������Ϊ2 - ((-5) + (-6)) = 
 * 2 + 11 = 13��,���ǿ����ٷ�������ۣ�
 * ��2.1��.ȫ�Ǹ�������[-1, -2, -3, -4, -5],����һ���Ӻ��������ţ��������Ϊ��-1 - ((-4) + (-5)) - (-3) - (-2) = -1 + 9 
 * + 3 + 2��,���������Ϊ��������ѡ�����е����ֵ�������������ֵľ���ֵ���У��������м���֤��������2.2��.���������и�����
 * [-1, 19, 17, -4, -5],���������Ӻ��������ţ����������Ϊ��19 + 17 - ((-4) + (-5)) - (-1) = 19 + 17 + 9 + 1��,������
 * ����Ϊ��������ѡ�����е����ֵ�������������ֵľ���ֵ���У��������м���֤�������������������ϡ�
 * @author: colou
 */
public class J {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		try {
			int add = input.nextInt();
			int reduce = input.nextInt();
			int totalLength = add + reduce + 1;
			int[] number = new int[totalLength];
			for (int i = 0; i < totalLength; i++) {
				number[i] = input.nextInt();
			}
			int sum = 0;
			if (reduce == 0) {
				for (int i = 0; i < totalLength; i++) {
					sum += number[i];
				}
			}
			if (add == 0) {
				Arrays.sort(number);
				if (number[0] < 0) {
					for (int i = 0; i <= reduce; i++) {
						if (number[i] > 0) 
							sum += number[i];
						else
							sum -= number[i];
					}
				} else {
					for (int i = 1; i <= reduce; i++) {
							sum += number[i];
					}
					sum -= number[0];
				}
			}
			if (add != 0 && reduce != 0) {
				int reduceNum = 0;
				for (int i = 0; i < totalLength; i++) {
					if (number[i] < 0) {
						reduceNum++;
					}
				}
				if (reduce >= reduceNum) {
					Arrays.sort(number);
					int temp = reduce;
					for (int i = 0; i < reduceNum; i++) {
						number[i] = -number[i];
						temp--;
					}
					Arrays.sort(number);
					for (int i = totalLength - 1; i >= temp; i--) {
						sum += number[i];
					}
					for (int i = temp - 1; i >= 0; i--) {
						sum -= number[i];
					}
				} else {
					Arrays.sort(number);
					sum += number[totalLength - 1];
					for (int i = 0; i < totalLength - 1; i++) {
						if (number[i] > 0)
							sum += number[i];
						else
							sum -= number[i];
					}
				}
			}
			System.out.println(sum);
		} catch (Exception e) {
			input.close();
		}
	}
}
