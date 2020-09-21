public class test {
    public static void main(String[] args){
        // int a = 128;
        // int b = -127;
        // byte aT = (byte) a;
        // byte bT = (byte) b;
        // System.out.println("a:" + a + " -> aT:" + aT);
        // System.out.println("b:" + b + " -> bT:" + bT);
        intToByte(1879048190);
    
    }


    public static byte intToByte(int x){
		System.out.println("int 是:"+x);
		System.out.println("int的二进制数据为:"+Integer.toBinaryString(x));
		byte b =(byte) (x & 0xff);
		System.out.println("截取后8位的二进制数据为:"+Integer.toBinaryString(x & 0xff));
		System.out.println("byte 是:"+b);
		return b;
	}

}


