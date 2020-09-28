package exception;

public class Bank {
    private int money;

    // 在函数中使用了throw则需要在函数声明出加上异常throws
    public void income (int in, int out) throws BankException {
        if(in < 0 || out > 0 || in + out < 0) {
            throw new BankException(in, out);
        }
        int netIncome = in - out;
        System.out.println(netIncome);
    }

    public int getMoney(){
        return money;
    }
}
