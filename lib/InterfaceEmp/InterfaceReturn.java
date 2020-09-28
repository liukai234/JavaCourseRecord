// 接口回调
interface ShowMessage {
    void print(String s);
}

class TV implements ShowMessage {
    public void print(String s) {
        System.out.println(s);
    }    
}

class PC implements ShowMessage {
    public void print(String s) {
        System.out.println(s);
    }    
}

public class InterfaceReturn {
    public static void main(String[] args) {
        // 多态、接口回调
        ShowMessage showmessage = new TV();
        showmessage.print("tv");
        showmessage = new PC();
        showmessage.print("pc");
    }
}
