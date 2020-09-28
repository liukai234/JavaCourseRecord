package exception;

public class BankException extends Exception {
    static final long serialVersionUID = -3387516993124229948L;
    String message;
    public BankException(int m, int n) {
        message = "m < 0 || or n > 0 || m + n < 0";
    }
    public String warnUserConfig() {
        return message;
    }
}
