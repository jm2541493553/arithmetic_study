import java.util.Scanner;

public class QueryTargetFromArray2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] arr = new int[m][n];

        for (int i=0; i< m; i++){
            for (int j=0; j< n; j++){
                arr[i][j] = scanner.nextInt();
            }
        }
        int target = scanner.nextInt();
//        boolean x = QueryNumber(arr, target);
//        System.out.println(x);
        boolean y = QueryNumber2(arr, target);
        System.out.println(y);
    }

    //暴力搜索
    public static boolean QueryNumber(int[][] array, int target) {
        // 比较次数
        int comNum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                comNum ++;
                if (array[i][j] == target) {
                    System.out.println(comNum);
                    return true;
                }
            }
        }
        return false;
    }
    //优化
    public static boolean QueryNumber2(int[][] array, int target) {
        // 比较次数
        int comNum = 0;
        for (int i = array.length - 1, j = 0; i >= 0 && i < array.length && j >= 0 && j < array[0].length; ) {
            comNum++;
            if (array[i][j] == target) {
                System.out.println(comNum);
                return true;
            }
            if(array[i][j]<target){
                j++;
                continue;
            }
            if(array[i][j]>target){
                i--;
                continue;
            }
        }
        return false;
    }
}

