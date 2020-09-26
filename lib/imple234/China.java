package imple234;
public class China implements Computable3 {
    public int number;
    public int f(final int x) {
        int sum = 0;
        for(int i = 0; i <= x; i ++) {
            sum = sum + i;
        }
        return sum;
    }
}
