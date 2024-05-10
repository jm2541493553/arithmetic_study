import java.util.Scanner;

public class QueryReversePairFromArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        int num = QueryReversePairFromArray(array);
        System.out.println(num);
    }

    public static int QueryReversePairFromArray(int[] array) {
        int count = 0;
        for (int i = 0; i< array.length; i++){
            for(int j= i+1; j< array.length; j++ ){
                if( array[j] < array[i] ){
                    count ++;
                }
            }
        }
        return count;
    }

    //分治法
    public static int QueryReversePairFromArray2(int[] array) {
        int count = 0;
        for (int i = 0; i< array.length; i++){
            for(int j= i+1; j< array.length; j++ ){
                if( array[j] < array[i] ){
                    count ++;
                }
            }
        }
        return count;
    }
}
