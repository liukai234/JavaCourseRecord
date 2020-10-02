import java.util.Scanner;

/**
 * src.Complex
 */
public class Complex {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // double re = input.nextDouble();
        // double im = input.nextDouble();
        input.close();

        InnerComplex complex1 = new InnerComplex(1.0, 2.0);
        InnerComplex complex2 = new InnerComplex(0, 0);

        InnerComplex complex3 = complex1.add(complex2);
        complex1.print(); System.out.print(" + "); complex2.print(); System.out.print(" = "); complex3.print(); System.out.println();
        
        complex3 = complex1.sub(complex2);
        complex1.print(); System.out.print(" - "); complex2.print(); System.out.print(" = "); complex3.print(); System.out.println();

        complex3 = complex1.mul(complex2);
        complex1.print(); System.out.print(" * "); complex2.print(); System.out.print(" = "); complex3.print(); System.out.println();

        try{
            complex3 = complex1.div(complex2);
            complex1.print(); System.out.print(" / "); complex2.print(); System.out.print(" = "); complex3.print(); System.out.println();
        } catch(DivException e) {
            System.out.println(e.getMessage());
        }
    }
}


/**
 * src.Complex
 */
class InnerComplex  {
    private double re = 0;
    private double im = 0;

    public InnerComplex(double re, double im) {
        this.re = re;
        this.im = im;
    }
    public InnerComplex(double re) {
        this.re = re;
    }
    public InnerComplex() {}
    
    public InnerComplex add(InnerComplex z) {
        InnerComplex zNew = new InnerComplex();
        zNew.re = this.re + z.re;
        zNew.im = this.im + z.im;
        return zNew;
    }

    public InnerComplex sub(InnerComplex z) {
        InnerComplex zNew = new InnerComplex();
        zNew.re = this.re - z.re;
        zNew.im = this.im - z.im;
        return zNew;
    }

    public InnerComplex selfAdd(InnerComplex z) {
        re += z.re;
        im += z.im;
        return this;
    }

    public InnerComplex selfSub(InnerComplex z) {
        re -= z.re;
        im -= z.im;
        return this;
    }
    public InnerComplex mul(InnerComplex z) {
        InnerComplex zNew = new InnerComplex();
        double a = re, b = im, c = z.re, d = z.im;
        // (a+bi)(c+di)=(ac-bd)+(bc+ad)i
        zNew.re = a * c - b * d;
        zNew.im = b * c + a * d;
        return zNew;
    }

    public InnerComplex div(InnerComplex z) throws DivException {
        InnerComplex zNew = new InnerComplex();
        double a = re, b = im, c = z.re, d = z.im;
        // (a+bi)(c+di)=(ac-bd)+(bc+ad)i
        if((c * c + d * d) == 0) throw new DivException("DivException: Divisor cannot be 0");
        zNew.re = (a * c + b * d) / (c * c + d * d);
        zNew.im = (b * c - a * d) / (c * c + d * d);
        return this;
    }

    public void print() {
        System.out.print("(" + re +" ," + im + ")");
    }

}

class DivException extends Exception {
    public DivException(String message) {
        super(message);
    }
}
