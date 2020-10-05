import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

public class BigDecimalEmp {
    private int precision;
    private final int scale;
    private long intCompact;
    private transient String stringCache;

    // The unscaled value of this BigDecimal
    // private final BigInteger intVal;

    public BigDecimalEmp(String val) {
        this(val.toCharArray(), 0, val.length());
    }
    public BigDecimalEmp(char[] in) {
        this(in, 0, in.length);
    }
    BigDecimalEmp(long val, int scale, int prec) {
        this.intCompact = val;
        this.scale = scale;
        this.precision = prec;
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
                if (prec == 0) // if (prec != 1 || rs != 0) 从非0位开始计数
                    prec = 1;
                else if (rs != 0) { // compact // 整数中间位为0
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

        // 将小数位和整数位全部放入rs中，并用prec记录有效数字位长，用scl记录小数位长
        // 0.123的prec = 3, scl = 3

        this.scale = scl;
        this.precision = prec;
        this.intCompact = rs;
    }

    public void getAllInfo() {
        System.out.println("precision: " + precision + ", scale: " + scale + ", intCompact(rs): " + intCompact);
    }

    public BigDecimalEmp sub(BigDecimalEmp augend) {
        augend.intCompact = -augend.intCompact;
        return add(this.intCompact, this.scale, augend.intCompact, augend.scale);
    }

    public BigDecimalEmp add(BigDecimalEmp augend) {
        return add(this.intCompact, this.scale, augend.intCompact, augend.scale);
    }

    private static BigDecimalEmp add(final long xs, int scale1, final long ys, int scale2) {
        long sdiff = (long) scale1 - scale2; // 小数位之差
        if (sdiff == 0) {
            return add(xs, ys, scale1);
        } else if (sdiff < 0) {
            long raise = - sdiff;
            long scaledX = longMultiplyPowerTen(xs, raise);
            return add(scaledX, ys, scale2);
        } else {
            long raise = sdiff;
            long scaledY = longMultiplyPowerTen(ys, raise);
            return add(xs, scaledY, scale1);
        }
    }

    private static long longMultiplyPowerTen(long val, long n) {
        if (val == 0 || n <= 0)
            return val;
        return (long) (val * Math.pow(10, n));
    }

    private static BigDecimalEmp add(long xs, long ys, int scale) {
        long sum = add(xs, ys);
        return BigDecimalEmp.valueOf(sum, scale);
    }

    private static long add(long xs, long ys) {
        long sum = xs + ys;
        return sum;
    }

    public static BigDecimalEmp valueOf(long unscaledVal, int scale) {
//        if (scale == 0)
//            return valueOf(unscaledVal);
//        else if (unscaledVal == 0) {
//            return zeroValueOf(scale);
//        }
        return new BigDecimalEmp(unscaledVal, scale, 0);
    }

    @Override
    public String toString() {
        stringCache = layoutChars();
        return  stringCache;
    }

    private String layoutChars() {
        if (scale == 0)                      // zero scale is trivial
            return Long.toString(intCompact);

        char[] coeff = Long.toString(Math.abs(intCompact)).toCharArray(); // 将intCompact转换位char[], 其中coeff为小端法
        int offset = coeff.length;  // offset is the starting index for coeff array
        // Get the significand as an absolute value

        // Construct a buffer, with sufficient capacity for all cases.
        // If E-notation is needed, length will be: +1 if negative, +1
        // if '.' needed, +2 for "E+", + up to 10 for adjusted exponent.
        // Otherwise it could have +1 if negative, plus leading "0.00000"
        StringBuilder buf = new StringBuilder();

//        if (signum() < 0)
        if(intCompact < 0) // prefix '-' if negative
            buf.append('-');
            // TODO 负数时的offset需要后移的情况
//        int coeffLen = coeff.length - offset;
//        long adjusted = -(long)scale + (coeffLen -1);
        if (scale >= 0) { // plain number
            int pad = scale - offset;         // count of padding zeros
            if (pad >= 0) {                     // 0.xxx form
                buf.append('0');
                buf.append('.');
                for (; pad>0; pad--) {
                    buf.append('0');
                }
                buf.append(coeff, 0, offset);
            } else {                         // xx.xx form
                buf.append(coeff, 0, -pad);
                buf.append('.');
                buf.append(coeff, -pad, scale);
            }
        }
        return buf.toString();
    }


    public BigDecimalEmp multiply(BigDecimalEmp multiplicand) {
        int productScale =  scale + multiplicand.scale;
        return multiply(this.intCompact, multiplicand.intCompact, productScale);
    }

    private static BigDecimalEmp multiply(long x, long y, int scale) {
        long product = multiply(x, y);
        return valueOf(product, scale);
    }

    private static long multiply(long x, long y){
        long product = x * y;
        return product;
    }

    public long signum() {
        return intCompact;
    }

    public int scale() {
        return scale;
    }
    public int precision() { return precision; }
    static BigDecimalEmp zeroValueOf(int scale) {
            return new BigDecimalEmp(0, scale, 1);
    }

    public BigDecimalEmp divide(BigDecimalEmp divisor) {
        /*
         * Handle zero cases first.
         */
        if (divisor.signum() == 0) {   // x/0
            if (this.signum() == 0)    // 0/0
                throw new ArithmeticException("Division undefined");  // NaN
            throw new ArithmeticException("Division by zero");
        }

        // Calculate preferred scale // 被除数小数位数 - 除数小数位数
        int preferredScale = this.scale - divisor.scale;
        if(preferredScale < 0) preferredScale = -preferredScale + this.scale;

        if (this.signum() == 0) // 0/y
//            if(this.scale)
            return zeroValueOf(preferredScale); //保留小数位数
        else {
            /*
             * If the quotient this/divisor has a terminating decimal
             * expansion, the expansion can have no more than
             * (a.precision() + ceil(10*b.precision)/3) digits.
             * Therefore, create a MathContext object with this
             * precision and do a divide with the UNNECESSARY rounding
             * mode.
             */
            BigDecimalEmp dividend = this;
            BigDecimalEmp quotient; // 商
            int xscale = dividend.precision();
            int yscale = divisor.precision();

            quotient = this.divide(dividend.intCompact, xscale, divisor.intCompact, yscale, preferredScale);


            int quotientScale = quotient.scale();

            // divide(BigDecimal, mc) tries to adjust the quotient to
            // the desired one by removing trailing zeros; since the
            // exact divide method does not have an explicit digit
            // limit, we can add zeros too.
            if (preferredScale > quotientScale) // 将被除数精确位补足 // 四舍五入
                return quotient.setScale(preferredScale);

            return quotient;
        }
    }

    private static int compareMagnitudeNormalized(long xs, int xscale, long ys, int yscale) {
        // assert xs!=0 && ys!=0
        int sdiff = xscale - yscale;
        if (sdiff != 0) {
            if (sdiff < 0) {
                xs = longMultiplyPowerTen(xs, -sdiff);
            } else { // sdiff > 0
                ys = longMultiplyPowerTen(ys, sdiff);
            }
        }
        return longCompareMagnitude(xs, ys);
    }

    private static int longCompareMagnitude(long x, long y) {
        if (x < 0)
            x = -x;
        if (y < 0)
            y = -y;
        return (x < y) ? -1 : ((x == y) ? 0 : 1);
    }

    private static BigDecimalEmp divide(final long xs, int xscale, final long ys, int yscale, long preferredScale) {
        if (compareMagnitudeNormalized(xs, xscale, ys, yscale) > 0) {// satisfy constraint (b)
            yscale -= 1; // [that is, divisor *= 10]
        }

        BigDecimalEmp quotient;
        quotient = valueOf(divideAndRound(xs, ys), (int)preferredScale);
        return quotient;
    }

    public BigDecimalEmp setScale(int newScale) {
        int oldScale = this.scale;
        if (newScale == oldScale)        // easy case
            return this;
        if (this.signum() == 0)            // zero can have any scale
            return zeroValueOf(newScale);

        long rs = this.intCompact;
        if (newScale > oldScale) {
            int raise = newScale - oldScale;
            return valueOf(rs, newScale);

        } else {
            // newScale < oldScale -- drop some digits
            // Can't predict the precision due to the effect of rounding.
            int drop = oldScale - newScale;
            drop = (int)longMultiplyPowerTen(10, (long)drop);
            return valueOf(divideAndRound(rs, drop), newScale);

        }
    }

    private static long divideAndRound(long ldividend, long ldivisor) {
        long q = ldividend / ldivisor; // store quotient in long
        return q;
    }
}
