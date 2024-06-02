import java.util.Scanner;

public class NumberOf1Between1AndN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(NumberOf1Between1AndN03(n));
    }

    private static int NumberOf1Between1AndN01(int n) {
        if (n < 1) {
            return 0;
        }

        int count = 0;
        String numStr = null;
        char[] numCharArray = null;

        for (int i = 1; i <= n; i++) {
            numStr = String.valueOf(i);
            numCharArray = numStr.toCharArray();
            for (char c : numCharArray) {
                if (c == '1') {
                    count++;
                }
            }
        }

        return count;
    }
    private static int NumberOf1Between1AndN03(int n) {
        if (n < 1) {
            return 0;
        }

        int count = 0;
        int x = 0;

        for (int i = 1; i <= n; i++) {
            x = i;
            while (x != 0) {
                if (x % 10 == 1) {
                    count++;
                }
                x /= 10;
            }
        }

        return count;
    }
    private static int NumberOf1Between1AndN02(int n) {
        int sum = 0;
        int level = 1;
        int high = n / 10;
        int low = 0;
        int cur = n % 10;
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                sum = sum + high * level;
            } else if (cur == 1) {
                sum = sum + high * level + low + 1;
            } else {
                sum = sum + (high + 1) * level;
            }
            low = cur * level + low;
            level = level * 10;
            cur = high % 10;
            high = high / 10;
        }
        return sum;
    }
}
