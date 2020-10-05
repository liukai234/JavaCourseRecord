public class BigDecimalEmpTest {
    public static void main(String[] args) {

        String a = "157.00";
        String b = "1.002";

        BigDecimalEmp aEmp = new BigDecimalEmp(a);
        BigDecimalEmp bEmp = new BigDecimalEmp(b);
        BigDecimalEmp c = aEmp.divide(bEmp);
        aEmp.getAllInfo();
        bEmp.getAllInfo();
        c.getAllInfo();
        System.out.println(c);
    }
}