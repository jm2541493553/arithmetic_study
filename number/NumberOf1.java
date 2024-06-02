import java.util.Scanner;

public class NumberOf1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(NumberOf103(n));
    }

    private static int NumberOf101(int n) {
        int num = 0;
        while (n != 0) {
            int tmp = n % 2;
            if (tmp == 1||tmp==-1) {
                ++num;
            }
            n /= 2;
        }
        return num;
    }
    private static int NumberOf102(int n) {
        int num=0;
        while (n != 0) {
            if ((n & 1)==1){
                ++num;
            }
//            负数右移。前面补1，死循环
            n = n>>1;
        }
        return num;
    }
    private static int NumberOf103(int n) {
        int num=0;
        int flag =1;
        while (flag != 0) {
            if ((n & flag)!=0){
                ++num;
            }
            flag = flag << 1;
        }
        return num;
    }
}
