class Myclass {
    int height;
    Myclass(){
        System.out.println("无参数构造函数");
        height = 4;
    }
    Myclass(int i) {
        this.height = i;
        System.out.println("房子高度为　" + height);
    }
}
public class overloadingEmp {
    public static void main(String[] args) {
        Myclass t = new Myclass(3);
        System.out.println(t.height);
        new Myclass();
    }
}