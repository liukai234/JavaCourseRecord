public class fib {
    public static void main(String[] args) {
        System.out.print("1\n1\n");
        int count = test(1, 1, 3);
        System.out.println(count);

    }

    static int test(int a, int b, int count) {
        if(a > Integer.MAX_VALUE - b) return count;
        count ++;
        int c = a + b;
        System.out.println(c);
        a = b; b = c;
        count = test(a, b, count);
        return count;
    }
}