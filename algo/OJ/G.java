
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class G {
	public static void main(String[] args) { 
		Scanner input = new Scanner(System.in);
		int N, M, T;
		Set<Integer> set = new HashSet<Integer>();
		N = input.nextInt(); // N����������
		M = input.nextInt(); // M��������Ϣ
		T = input.nextInt(); // Tʱ��
		int[][] orders = new int[M][2]; // ����
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < 2; j++) {
				orders[i][j] = input.nextInt();
			}
		}
		
		int[] priority = new int[N]; // ���ȼ�
		int[] sign = new int[N]; // ��־
		for(int i = 1; i <= T; i ++) {
			for(int j = 0; j < M; j++) {
				if(orders[j][0] == i) {
					priority[orders[j][1] - 1] += 2;
					if(priority[orders[j][1] - 1] > 5 && !set.contains(orders[j][1] - 1)) {
						set.add(orders[j][1] - 1);
					}
					sign[orders[j][1] - 1] = 1;
				}
			}
			
			for(int j = 0; j < N; j ++) {
				if(sign[j] == 0 && priority[j] > 0) {
					priority[j] --;
				}
				if(priority[j] <= 3) {
					set.remove(j);
				}
			}
			sign = new int[N]; // ��������
		}
		System.out.println("���: ");
		System.out.println(set.size());
		input.close();
		
	}
}
