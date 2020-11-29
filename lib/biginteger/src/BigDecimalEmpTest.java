public class BigDecimalEmpTest {
    public static void main(String[] args) {

        String a = "60.002";
        String b = "2.01";

        BigDecimalEmp aEmp = new BigDecimalEmp(a);
        BigDecimalEmp bEmp = new BigDecimalEmp(b);
        try {
            BigDecimalEmp c = aEmp.add(bEmp);
            System.out.println(a + " + " + b + " = " + c);
            c = aEmp.sub(bEmp);
            System.out.println(a + " - " + b + " = " + c);
            c = aEmp.multiply(bEmp);
            System.out.println(a + " * " + b + " = " + c);
            c = aEmp.divide(bEmp);
            System.out.println(a + " / " + b + " = " + c);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}