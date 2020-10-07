public class BigDecimalEmpTest {
    public static void main(String[] args) {

        String a = "5";

        String b = "2.01";

        BigDecimalEmp aEmp = new BigDecimalEmp(a);
        BigDecimalEmp bEmp = new BigDecimalEmp(b);
        try {
            BigDecimalEmp c = aEmp.divide(bEmp);
            aEmp.getAllInfo();
            bEmp.getAllInfo();
            c.getAllInfo();
            System.out.println(c);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}