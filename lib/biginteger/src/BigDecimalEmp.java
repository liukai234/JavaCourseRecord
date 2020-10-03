//import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigInteger;


public class BigDecimalEmp {
    private transient int precision;
    private final transient long intCompact;
    private final int scale;
    static final long INFLATED = Long.MIN_VALUE;
    // The unscaled value of this BigDecimal
    private final BigInteger intVal;
    public BigDecimalEmp(String val) { this(val.toCharArray(), 0, val.length()); }

    BigDecimalEmp(BigInteger intVal, long val, int scale, int prec) {
        this.scale = scale;
        this.precision = prec;
        this.intCompact = val;
        this.intVal = intVal;
    }
    // offset 从0起
    // len = in.length
    public BigDecimalEmp(char[] in, int offset, int len) {
        // 是否越界异常检测
        int prec = 0;                 // record precision value // 整数数位
        int scl = 0;                  // 小数数位
        long rs = 0;                  // the compact value in long
        BigInteger rb = null;         // the inflated value in BigInteger
        // use array bounds checking to handle too-long, len == 0,
        // bad offset, etc.

        boolean isneg = false;          // 是否为负数
        if (in[offset] == '-') {
            isneg = true;               // leading minus means negative
            offset++;
            len--;
        } else if (in[offset] == '+') { // leading + allowed
            offset++;
            len--;
        }
        // should now be at numeric part of the significand
        boolean dot = false;             // true when there is a '.'
        long exp = 0;                    // exponent
        char c;                          // current character
        int idx = 0;
        // First compact case, we need not to preserve the character
        // and we can just compute the value in place.
        for (; len > 0; offset++, len--) {
            c = in[offset];
            if ((c == '0')) { // have zero // 当某一位为0时
                if (prec == 0) // 首位为0
                    prec = 1;
                else if (rs != 0) { // TODO: compact // 整数中间位为0
                    rs *= 10; // 整数值 *10
                    ++prec; // 位数+1
                } // else digit is a redundant leading zero
                if (dot)
                    ++scl; // 小数位累加
            } else if ((c >= '1' && c <= '9')) { // have digit
                int digit = c - '0';
                if (prec != 1 || rs != 0) //反 if(prec == 1 && rs == 0)
                    ++prec; //  如果前缀为0，则prec保持不变
                rs = rs * 10 + digit;
                if (dot)
                    ++scl;
            } else if (c == '.') {   // have dot
                // have dot
//                if (dot) // two dots
//                    throw new NumberFormatException("Character array"
//                            + " contains more than one decimal point.");
                dot = true;
            }
        }

//        if (prec == 0) // no digits found // 无整数位
//            throw new NumberFormatException("No digits found.");
        // Adjust scale if exp is not zero.

        rs = isneg ? -rs : rs;

        // 将小数位和整数位全部放入rs中，并用prec记录全部位长，用scl记录小数位长
        // 0.123的prec = 3, scl = 3

        this.scale = scl;
        this.precision = prec;
        this.intCompact = rs;
    }


    public BigDecimalEmp add(BigDecimalEmp augend) {
        return add(this.intCompact, this.scale, augend.intCompact, augend.scale);
    }

    private static BigDecimalEmp add(final long xs, int scale1, final long ys, int scale2) {
        long sdiff = (long) scale1 - scale2; // 小数位之差
        if (sdiff == 0) {
            return add(xs, ys, scale1);
        } /*else if (sdiff < 0) {
            int raise = checkScale(xs,-sdiff);
            long scaledX = longMultiplyPowerTen(xs, raise);
            if (scaledX != INFLATED) {
                return add(scaledX, ys, scale2);
            } else {
                BigInteger bigsum = bigMultiplyPowerTen(xs,raise).add(ys);
                return ((xs^ys)>=0) ? // same sign test
                        new BigDecimal(bigsum, INFLATED, scale2, 0)
                        : valueOf(bigsum, scale2, 0);
            }
        } else {
            int raise = checkScale(ys,sdiff);
            long scaledY = longMultiplyPowerTen(ys, raise);
            if (scaledY != INFLATED) {
                return add(xs, scaledY, scale1);
            } else {
                BigInteger bigsum = bigMultiplyPowerTen(ys,raise).add(xs);
                return ((xs^ys)>=0) ?
                        new BigDecimal(bigsum, INFLATED, scale1, 0)
                        : valueOf(bigsum, scale1, 0);
            }
        }*/
    }

/*    private static BigDecimalEmp add(long xs, long ys, int scale){
        long sum = add(xs, ys);
        if (sum!=INFLATED)
            return BigDecimal.valueOf(sum, scale);
        return new BigDecimal(BigInteger.valueOf(xs).add(ys), scale);
    }*/

    private static BigDecimalEmp add(long xs, long ys, int scale){
        long sum = add(xs, ys);
        // TODO
        return BigDecimal.valueOf(sum, scale);

    }

    public static BigDecimal valueOf(long val) {
        if (val >= 0 && val < ZERO_THROUGH_TEN.length)
            return ZERO_THROUGH_TEN[(int)val];
    }

    public static BigDecimalEmp valueOf(long unscaledVal, int scale) {
        if (scale == 0)
            return valueOf(unscaledVal);
        else if (unscaledVal == 0) {
            return zeroValueOf(scale);
        }
        return new BigDecimal(unscaledVal == INFLATED ?
                INFLATED_BIGINT : null,
                unscaledVal, scale, 0);
    }

    private static long add(long xs, long ys){
        long sum = xs + ys;
        return sum;
    }

    public BigInteger unscaledValue() {
        return this.inflated();
    }

    private BigInteger inflated() {
        if (intVal == null) {
            return BigInteger.valueOf(intCompact);
        }
        return intVal;
    }
}