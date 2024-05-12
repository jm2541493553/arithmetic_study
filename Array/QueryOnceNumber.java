import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/*
    10
    92 3 43 54 92 43 2 2 54 1
*/
public class QueryOnceNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = scanner.nextInt();
        }
        int[] x = QueryOnceNumber2(array);

        for (int i = 0; i< x.length; i++){
            System.out.println(x[i]);
        }
    }

    private static int[] QueryOnceNumber1(int[] array) {
        Map<Integer,Integer > map = new LinkedHashMap<>();
        for(int i =0; i < array.length;i++){
            if(!map.containsKey(array[i])){
                map.put(array[i], 1);
            }
            else {
                map.put(array[i], map.get(array[i])+1);
            }
        }
        int[] array2 = new int[2];
        int i = 0;
        for(int k:map.keySet()){
            if(map.get(k) == 1){
               array2[i] = k;
               i++;
            }
        }
        return array2;
    }

    private static int[] QueryOnceNumber2(int[] array) {
        int res = 0;
        for(int val : array){
            res = res^val;
        }
//        String binary = Integer.toBinaryString(res);
//        String binary2 = Integer.toBinaryString(-res);
        int temp = res & (-res);
        // 保存和最后一个不同的位异或的结果
        int res1 = 0;
        for (int val : array) {
            // 不等于0说明可能是其中一个数，至少排除了另外一个数
            if ((temp & val) != 0) {
                res1 ^= val;
            }
        }
        int[] array2 = new int[2];
        array2[0] = res1;
        array2[1] = res ^ res1;
        return array2;
    }
}
