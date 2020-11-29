public class T4 {
    static int ans = 0;

    static boolean contain9(int num) {
        if(num % 10 == 9) return true;
        if(num / 10 == 0) return false;
        num /= 10;
        return contain9(num);
    }

    public static void main(String[] args) {
        for(int i = 1; i <= 2019; i++) {
            if(contain9(i)) { ans ++;}
        }
        System.out.println(ans);

    }
}