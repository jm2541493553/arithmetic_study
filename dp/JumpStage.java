import java.util.Scanner;

public class JumpStage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        System.out.println(JumpStage01(n));
    }
    public static int JumpStage01(int n){
        if (n == 0){
            return 0;
        } else if (n == 1) {
            return 1;
        }else if (n == 2){
            return 2;
        }else {
            return JumpStage01(n-1)+JumpStage01(n-2);
        }
    }
    public static int JumpStage02(int n){
        if (n==0){
            return 0;
        }
//        int[] dp = new int[n+1];
        int[] dp = new int[2];
        int result = 0;
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <=n;i++){
//            dp[i] = dp[i-1]+dp[i-2];
            result = dp[0]+dp[1];
            dp[0] = dp[1];
            dp[1] = result;
        }
        return result;
    }
}
