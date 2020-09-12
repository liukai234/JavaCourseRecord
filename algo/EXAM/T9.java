public class T9 {
    static final MOD = 10000;
    static int n;
    static int ans;
    void dfs() {

    }
    


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        ans = 0;
        for(int x = 1; x <= n; x++) {
            ans = (ans + dfs(n, x)) % MOD;
        }
    }
}