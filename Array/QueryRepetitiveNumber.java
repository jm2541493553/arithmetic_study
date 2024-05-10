import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
//2 3 1 0 2 5 3
public class QueryRepetitiveNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = scanner.nextInt();
        }
        int x = QueryRepetitiveNumber2(array);
        System.out.println(x);

    }

    private static int QueryRepetitiveNumber1(int[] array) {
        Map<Integer,Integer > map = new LinkedHashMap<>();
        for(int i =0; i < array.length;i++){
            if(!map.containsKey(array[i])){
                map.put(array[i], 1);
            }
            else {
                map.put(array[i], map.get(array[i])+1);
            }
        }
        for(int k:map.keySet()){
            if(map.get(k) > 1){
                return k;
            }
        }
        return -1;
    }

    private static int QueryRepetitiveNumber2(int[] array) {
        int[] nums = new int[array.length];
        for(int i =0; i< array.length;i++){
            if(nums[array[i]]==1){
                return array[i];
            }else {
                nums[array[i]] = 1;
            }
        }

        return -1;
    }

}
