public class ForExpress {
    public static void main(String[] args) {
        // for(express 1; express 2; express 3)
        // 先执行1，判断2，再进循环体，然后执行3，判断2，进循环体
        
        for(int a = 2; a < 2; a ++) {
            System.out.println(a);
            // cannot be excuted
        }
    }
}
