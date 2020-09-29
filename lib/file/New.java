public class New {
    public static void main(String[] args) {
        InnerNew new1 = new InnerNew();
        try{
            new1.f();
        } catch(MyException1 e) {
            e.errorMessage();
        } catch(MyException2 e) {
            e.errorMessage();
        }
    }
}

class InnerNew {
    public void f() throws MyException2, MyException1 {
        if(false) g();
        throw new MyException1();
    }
    
    public void g() throws MyException2 {
        throw new MyException2();
    }
}

class MyException1 extends Exception {
    public MyException1() {

    }
    public void errorMessage() {
        System.out.println("MyException1");
    }
}

class MyException2 extends Exception {
    public MyException2() {

    }
    public void errorMessage() {
        System.out.println("MyException2");
    }
}
