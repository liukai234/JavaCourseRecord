public class StringCompareEmp{
    public static void main(String[] args) {
        String str = "Hello World";
        String anotherString = "Hello world";

        // compare时以主字符串减副字符串
        // 两个字符数组依次从前开始比较，如果对象位置出现字符不同则返回两个字符的编码之差，后面的字符不再比较；
        // 如果两个字符数组的长度不一样，并且较短的数组和较长数组所有对应位置的字符都相同，则返回两个数组的长度之差。
        System.out.println(str.compareTo(anotherString));
        System.out.println(str.compareToIgnoreCase(anotherString));
    }
}