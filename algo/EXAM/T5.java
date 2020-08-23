// 30 -> 26

public class T5 {
    static int ans = 0;

    static boolean increase(int num, int stack) {
        if(stack < (num % 10)) return false;
        stack = num % 10;
        num /= 10;
        if(num == 0) return true;
        
        return increase(num, stack);
    }

    public static void main(String[] args) {
        for(int i = 1; i <= 30; i++) {
            if(increase(i, 10)) { ans ++;}
        }
        System.out.println(ans);

    }
}