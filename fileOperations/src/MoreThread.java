public class MoreThread {
    public static void main(String[] args) {
        Thread A = new Thread(new AThread());
        A.start();
        new Thread(new AThread()).start();
    }
}

class AThread implements Runnable {
    public AThread() {}

    @Override
    public void run() {
        System.out.println("Something");
    }
}
