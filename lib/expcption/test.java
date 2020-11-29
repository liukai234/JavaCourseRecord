import exception.*;

/**
 * test
 */
public class test {

    public static void main(String[] args) {
        Bank bank = new Bank();
        try {
            bank.income(-200, 100);
        } catch(BankException e) {
            System.out.println(e.warnUserConfig());
        }
    }
}