import java.math.BigDecimal;

public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("1.01");
        BigDecimal b = new BigDecimal("2.02");
        a = a.divide(b);
        System.out.println(a);

    }
}
