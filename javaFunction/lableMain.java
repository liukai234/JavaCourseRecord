public class lableMain {
    public static void main(String[] args) {
        String strSearch = "tttttttttttttttttttttttt subString";
        String subString = "subString";
        boolean found = false;
        int max = strSearch.length() - subString.length();
        testbl:
        for(int i = 0; i <= max; i++) {
            int length = subString.length();
            int j = i;
            int k = 0;
            while(length-- != 0) {
                if(strSearch.charAt(j++) != subString.charAt(k++)) {
                    continue testbl;
                }
            }
            found = true;
            break testbl;
        }
        if(found) {
            System.out.println("发现子字符串");

        } else {
            System.out.println("not found");
        }
    }
}