public class C {
    public static void main (String[] args) {
        int a = 1;
        int b = 1;
        int c = 1;
        int d = 0;
        for(int i = 4; i <= 20190324; i++){
            /* a %= 10000;
            b %= 10000;
            c %= 10000; */
            d = (a + b + c) % 10000;
            // update a b c
            // System.out.println(a + " " + b + " " + c);
            a = b;
            b = c;
            c = d;
            // if(i == 6) break;
            
        }
        System.out.println(d);
    }
}