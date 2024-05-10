import java.util.ArrayList;
import java.util.Scanner;

public class ClockwisePrintArray2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        ArrayList<Integer> result = ClockwisePrintArray2(arr);

        for (Integer r:result) {
            System.out.println(r);
        }
    }
    //   处理边界问题
    //   首先定义一个up（上边界为0）,down(下边界为matrix.length - 1)，left（左边界为0），right（右边界为matrix[0].length - 1）
    public static ArrayList ClockwisePrintArray2(int[][] array) {
        int left = 0;
        int right = array[0].length - 1;
        int up = 0;
        int down = array.length - 1;
        int i;
        ArrayList<Integer> results = new ArrayList();
        while (true){
            for(i = left; i <= right; i++){
                results.add(array[up][i]);
            }
            up ++;
            if(up > down){
                break;
            }
            for (i = up; i <= down; i++){
                results.add(array[i][right]);
            }
            right --;
            if (right < left){
                break;
            }
            for (i = right; i >= left; i--){
                results.add(array[down][i]);
            }
            down --;
            if (down < up){
                break;
            }
            for (i = down; i >= up; i--){
                results.add(array[i][left]);
            }
            left ++;
            if (left > right){
                break;
            }
        }
        return results;
    }
}
