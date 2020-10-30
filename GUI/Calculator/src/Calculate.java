public class Calculate {
    int a, b, c = 0;
    String symbol;
    public Calculate(int a, int b, String symbol) {
        this.a = a;
        this.b = b;
        this.symbol = symbol;
    }

    int calculate() {
        switch(symbol){
            case "+" :
                c = a + b;
                break;
            case "-" :
                c = a - b;
                break;
            case "*" :
                c = a * b;
                break;
            case "/" :
                c = a / b;
                break;
            default :
                break;
        }
        return c;
    }

}
