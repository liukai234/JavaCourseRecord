
public class Main {
    public static void main(String[] args) {
        Window win = new Window();
        PoliceListener listener = new PoliceListener();
        win.process(listener);

    }
}
