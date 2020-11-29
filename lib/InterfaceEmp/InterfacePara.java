// 接口参数
interface SpeakHello{
    void speakHello();
}

class Chinese implements SpeakHello {
    public void speakHello() {
        System.out.println("233");
    }
}

class English implements SpeakHello {
    public void speakHello() {
        System.out.println("332");
    }
}

class Speak {
    // 接口参数: 用接口定义参数
    public void speakHello2(SpeakHello speak) {
        speak.speakHello();
    }
}

public class InterfacePara {
    public static void main(String[] args) {
        Speak speak = new Speak();
        speak.speakHello2(new Chinese());
        speak.speakHello2(new English());
    }
}
