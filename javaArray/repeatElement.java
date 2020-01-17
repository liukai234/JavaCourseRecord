public class repeatElement {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 4, 5, 6, 3, 3, 3, 3 };
        findDupicateInArray(array);
        findNotDupicateInArray(array);
    }
    public static void findDupicateInArray(int[] array) {
        int count = 0;
        for(int j = 0; j < array.length; j++) {
            for(int k = j + 1; k < array.length; k++) {
                if(array[k] == array[j]){
                    count ++;
                }
            }
            if(count == 1) {
                System.out.println("重复元素：" + array[j]);
            }
            count = 0;
        }
    }
    public static void findNotDupicateInArray(int[] array){
        int count = 0;
        for(int j = 0; j < array.length; j++) {
            for(int k = 0; k < array.length; k++) {
                if(array[k] == array[j]){
                    count ++;
                }
            }
            // 等于１的时候只有自身
            if(count == 1) {
                System.out.println("不重复元素：" + array[j]);
            }
            count = 0;
        }       
    }
}
