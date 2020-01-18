enum Car {
    lamborghini("one", 900), tata("two", 2), audi("three", 50), fiat("four", 15), honda("five", 12);
    private int price;
    private String str;
    Car(String str, int p) {
        price = p;
        this.str = str;
    }
    void printPrice() {
        System.out.println("str: " + str + "  price" + price);
    }
}
public class EnumMain {
    public static void main(String[] args) {
        System.out.println("       ");
        for(Car c : Car.values()) {
            System.out.println(c );
            c.printPrice();
        }
    }
}