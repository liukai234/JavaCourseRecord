import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Main {
    public static void main(String[] args) {
        NumberFormat numberFormat = NumberFormat.getIntegerInstance();

        String integer = numberFormat.format(2.5);
        int a = Integer.parseInt(integer);
        System.out.println(a);

        DecimalFormat decimalFormat = new DecimalFormat("#");
//        decimalFormat.setMaximumFractionDigits(3);
        String doubleNum= decimalFormat.format(2.51);
        System.out.println(doubleNum);
        double b = Double.parseDouble(doubleNum);
        System.out.println(b);
    }
}