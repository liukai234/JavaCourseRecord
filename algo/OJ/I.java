
import java.util.Scanner;
/**
 * 
 * @ClassName: CharacterCorrelationAnalysis��������Է���
 * @Description: "."��"|"����ת���ַ�������ü�"\\"��
 * @author: color
 */
public class I {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		try {
			int K = input.nextInt();
			input.nextLine();
			String text = input.nextLine();
			//�ַ����ָ���տո��.�ָ��ַ������ǣ�.�ո񣩷ָ��Ϊ���ַ�����
			String[] words = text.split("\\s+|\\."); // \\s+ ƥ�����հ��ַ�, | ��ʾ��, \\. ��ʾƥ��1����
			/*
			for(String str : words) {
				System.out.println(str);
			} */
			
			int[] wordsLength = new int[words.length];
			//���ָ���ַ����ĳ���ֵ�洢����������ѭ���е���String.length();
			for (int i = 0; i < words.length; i++) {
				wordsLength[i] = words[i].length(); // �洢��ÿһ�����ʵĳ���
			}
			int num = 0;
			// for example: Alice is Bob Alice Is Bob.
			// ������1��Alice���Զ�Ӧ���Bob. ���Դ������Alice is Bob is BobΪ2��.
			//Alice ����> Bob�ľ���
			for (int i = 0; i < words.length; i++) {
				if (words[i].equals("Alice")) {
					for (int j = i + 1; j < words.length; j++) {
						int sum = 1; // ԭ����Alice���ֺ�����һ���ո�
						if (words[j].equals("Bob")) {
							for (int k = i + 1; k < j; k++) {
								//ÿ�����ʵĳ��ȼӿո�ռ�ݵĳ���
								sum += wordsLength[k] + 1;
							}
							if (sum <= K) {
								num++;
							}
						}
					}
				}
			}
			//Bob ����> Alice�ľ���
			for (int i = 0; i < words.length; i++) {
				if (words[i].equals("Bob")) {
					for (int j = i + 1; j < words.length; j++) {
						int sum = 1;
						if (words[j].equals("Alice")) {
							for (int k = i + 1; k < j; k++) {
								sum += wordsLength[k] + 1;
							}
							if (sum <= K) {
								num++;
							}
						}
					}
				}
			}
			System.out.println(num);
		} catch (Exception e) {
			input.close();
		}
	}
}
