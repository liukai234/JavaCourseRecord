public class BigDecimalEmpTest {
    public static void main(String[] args) {

        String a = "100.0";
        String b = "-0.11";

        BigDecimalEmp aEmp = new BigDecimalEmp(a);
        BigDecimalEmp bEmp = new BigDecimalEmp(b);
        BigDecimalEmp c = aEmp.multiply(bEmp);
        aEmp.getAllInfo();
        bEmp.getAllInfo();
        c.getAllInfo();
        System.out.println(c);
    }
}