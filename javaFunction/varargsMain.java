public class varargsMain {
    static int sumvarArgs(int ... intArrays) {
        int sum, i;
        sum = 0;
        for(i = 0; i < intArrays.length; i++) {
            sum += intArrays[i];
        }
        return(sum);
    }
    public static void main(String[] args) {
        int sum = 0;
        sum = sumvarArgs(10, 12, 33);
        System.out.println(sum);
    }
}