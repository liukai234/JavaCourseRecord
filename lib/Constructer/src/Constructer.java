import java.util.Map;

class Constructer {
    private int a = Integer.MAX_VALUE;
    private int b = Integer.MAX_VALUE;
    private static int c = Integer.MAX_VALUE;

    public Constructer() { System.out.println("正在调用Constructer()"); }

    public Constructer(int a) {
        this();
        System.out.println("正在调用Constructer(int a)");
        System.out.println("通过Constructer(int a)调用Constructer()");
    }

    public Constructer(int a, int b) {
        this(1); // Call to 'this()' must be first statement in constructor body
        System.out.println("正在调用Constructer(int a, int b)");
        System.out.println("通过Constructer(int a, int  b)调用Constrcuter(int a)");
    }

    // 静态方法先初始化，成员a, b后被初始化，所以在a, b初始化之前不能使用a, b
    public static void print() {
//        System.out.println("a: " + "b: ");    // Error 不能输出非静态成员a, b
        System.out.println("c: " + c);
    }
}

