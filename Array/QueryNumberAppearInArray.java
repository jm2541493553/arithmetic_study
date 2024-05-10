import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
// 1 2 3 3 3 3 4 5
// 3
public class QueryNumberAppearInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        int x = scanner.nextInt();
        int num = QueryNumberAppearInArray2(x, array);
        System.out.println(num);
    }
    private static int QueryNumberAppearInArray(int x, int[] array) {
        int num = 0;
        for(int i =0; i < array.length;i++){
            if(array[i] ==  x){
                num ++ ;
            }
        }
        return num;
    }

    //数组为升序，采用分治法
    private static int QueryNumberAppearInArray2(int x, int[] array) {
        int left =0;
        int right = array.length-1;
        // 使用二分法，找出等于k的数的索引
        int index = findIndex(array, x, left, right);
        // 索引为-1，则说明该数不存在
        if (index == -1) {
            return 0;
        }
        // 存在则index处存在一个
        int num = 1;
        // 向左边拓展，计算相等的个数
        for (left = index - 1; left >= 0; left--) {
            if (array[left] == x) {
                num++;
            }else {
                break;
            }
        }
        // 向右边拓展，计算相等的个数
        for (right = index + 1; right < array.length; right++) {
            if (array[right] == x) {
                num++;
            }else {
                break;
            }
        }
        return num;
    }

    private static int findIndex(int[] array, int x, int left, int right){
        if(left==right){
            return array[left] == x ? left : -1;
        }else {
            int mid = left + (right-left)/2;
            if(array[mid] == x){
                return mid;
            }else if(array[mid] < x){
                return  findIndex(array, x, mid + 1, right);
            }else {
                return  findIndex(array, x, left, mid-1);
            }
        }
    }
}
