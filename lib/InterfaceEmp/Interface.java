// 接口
interface Computable {
    // int MAX = 64;
    public static final int MAX = 64;
    // int f(int x);
    public abstract int f(int x);
}

public class Interface {
    public static void main(String[] args) {
        China china = new China();
        Japan japan = new Japan();
        
        china.number = Computable.MAX + 20;
        japan.number = Computable.MAX + 20;
        
        System.out.println(china.f(100));    
        System.out.println(japan.f(100));    
    }
}

class China implements Computable {
    public int number;
    public int f(final int x) {
        int sum = 0;
        for(int i = 0; i <= x; i ++) {
            sum = sum + i;
        }
        return sum;
    }
}

class Japan implements Computable {
    public int number;
    public int f(final int x) {
        return MAX + x;
    }
}
