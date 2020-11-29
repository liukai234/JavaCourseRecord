import java.io.*;

// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.io.OutputStreamWriter;

class test2
{
    public static void main(String args[]) throws IOException
                  
    {
        long now = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter an integer");
        int a = Integer.parseInt(br.readLine());
        System.out.println("Enter a String");
        String b = br.readLine();
        System.out.println("You have entered: " + a + " and name as " + b);
        System.err.println(System.currentTimeMillis() - now);
    }
}