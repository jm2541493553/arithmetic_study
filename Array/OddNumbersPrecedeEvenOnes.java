import java.util.Scanner;

public class OddNumbersPrecedeEvenOnes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = scanner.nextInt();
        }
        int[] x = OddNumbersPrecedeEvenOnes(array);

        for (int i = 0; i< x.length; i++){
            System.out.println(x[i]);
        }
    }
    public static int[] OddNumbersPrecedeEvenOnes(int[] array){
        int[] array2 = new int[array.length];
        int odds = 0;
        for (int i = 0; i<array.length;i ++){
            if (array[i] % 2 == 1){
                odds ++;
            }
        }
        int i = 0;
        int k = odds;
        for (int j = 0; j <array.length; j++){
            if (array[j] % 2 == 1){
                array2[i] = array[j];
                i++;
            }else {
                array2[k] = array[j];
                k++;
            }
        }
        return array2;
    }
}
