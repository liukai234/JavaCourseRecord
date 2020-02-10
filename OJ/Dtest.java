public class Dtest {
    public static void main(String[] args) {
        /* String str = "01234";
        System.out.println(str.indexOf("3")); */
        int n = 2019;
        int sum = 0;
        for(int i = 1; i < n; i++) {
            if((i + "").indexOf("2") != -1 || (i + "").indexOf("4") != -1) {
                continue;
            }
            for(int j = 1; j < n; j ++) {
                if((j + "").indexOf("2") != -1 || (j + "").indexOf("4") != -1) {
                    continue;
                }
                int k = n - i - j;
                if(i == j || j == k || i == k) continue;
                if(k > 0 && (k + "").indexOf("2") == -1 && (k + "").indexOf("4") == -1){
                     sum ++;
                }

            }
        }
        System.out.println(sum / 6);
    }
}