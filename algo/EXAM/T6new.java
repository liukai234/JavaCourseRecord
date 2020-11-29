import java.util.Scanner;

public class T6new {
    static int a[]; // 数组
    static int n; //元素个数
    static int ans = 0;

    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = input.nextInt();
        }
        input.close();

        for(int j = 1; j < n - 1; j++) {
            boolean right = false;
            boolean left = false;

            for(int i = j - 1; i >= 0; i --) {
                if(a[i] < a[j]) { right = true; }
            }

            for(int k = j + 1; k < n; k++) {
                if(a[j] < a[k]) { left = true; }
            }
            if(left && right) ans ++;
        
        }
        System.out.println(ans);
    }
}