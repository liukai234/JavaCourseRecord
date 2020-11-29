public class StringRegionMatch {
    public static void main(String[] args) {
        String str = "Helloooooooooooo";
        String anotherStr = "HellooooooooooO";
        boolean match1 = str.regionMatches(true, 0, anotherStr, 0, 100);
        System.out.println(match1); 
    }
}