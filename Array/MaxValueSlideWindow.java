import java.util.ArrayList;
import java.util.Scanner;
/*
*
8
2 3 4 2 6 2 5 1
3
* */
public class MaxValueSlideWindow {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        int x = scanner.nextInt();
        ArrayList<Integer> maxNumbers = MaxValueInteractiveWindow(x, array);
        for (Integer i: maxNumbers){
            System.out.print(i);
        }
    }
    public static ArrayList<Integer> MaxValueInteractiveWindow(int x, int[] array){
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i< array.length; i++){
            if (i + x > array.length){
                break;
            }
            int max = 0;
            for (int j  = i; j < i+x; j++){
                if (array[j]>max){
                    max = array[j];
                }
            }
            arrayList.add(max);
        }
        return arrayList;
    }
}
