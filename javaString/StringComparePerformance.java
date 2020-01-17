public class StringComparePerformance {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < 5000000; i++){
            String str = "12306";
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}