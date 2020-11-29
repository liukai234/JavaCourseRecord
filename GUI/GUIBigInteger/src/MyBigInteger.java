import java.math.BigInteger;
import java.util.stream.IntStream;

public class MyBigInteger {
    String num;
    BigInteger bigInteger;
    public MyBigInteger(String num) {
        this.num = num;
    }

    public String calculate() {
        int end = Integer.parseInt(num);
        bigInteger = new BigInteger(String.valueOf(1));
        IntStream.rangeClosed(1, end).forEach(i -> bigInteger = bigInteger.multiply(new BigInteger(String.valueOf(i))));
        return bigInteger.toString();
    }
}
