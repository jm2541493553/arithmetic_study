import java.util.Scanner;

public class Add {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(Add01(x,y));
    }

    private static int Add01(int x, int y) {
        while (y!=0){
            int z = (x & y) << 1;
            x = x^y;
            y = z;
        }
        return x;
    }
}
