package complex;
import java.util.Scanner;

/**
 * Complex
 */
public class Complex {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // double re = input.nextDouble();
        // double im = input.nextDouble();
        input.close();

        InnerComplex complex1 = new InnerComplex(1.0, 2.0);
        InnerComplex complex2 = new InnerComplex(1.0, 2.0);

        InnerComplex complex3 = complex1.add(complex2);
        complex1.print(); System.out.print(" + "); complex2.print(); System.out.print(" = "); complex3.print(); System.out.println();
        
        complex3 = complex1.sub(complex2);
        complex1.print(); System.out.print(" - "); complex2.print(); System.out.print(" = "); complex3.print(); System.out.println();

        complex3 = complex1.mul(complex2);
        complex1.print(); System.out.print(" * "); complex2.print(); System.out.print(" = "); complex3.print(); System.out.println();

        complex3 = complex1.div(complex2);
        complex1.print(); System.out.print(" / "); complex2.print(); System.out.print(" = "); complex3.print(); System.out.println();

    }
}


/**
 * Complex
 */
class InnerComplex {
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
        double a = re, b = im, c = z.re, d = z.im;
        // (a+bi)(c+di)=(ac-bd)+(bc+ad)i
        re = a * c - b * d;
        im = b * c + a * d;
        return this;
    }

    public InnerComplex div(InnerComplex z) {
        double a = re, b = im, c = z.re, d = z.im;
        // (a+bi)(c+di)=(ac-bd)+(bc+ad)i
        re = (a * c + b * d) / (c * c + d * d);
        im = (b * c - a * d) / (c * c + d * d);
        return this;
    }

    public void print() {
        System.out.print("(" + re +" ," + im + ")");
    }

}
