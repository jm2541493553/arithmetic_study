import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
//1 2 3 2 2 2 5 4 2
public class QueryOverHalfOfLength {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = scanner.nextInt();
        }
        int x = QueryOverHalfOfLength2(array);
        System.out.println(x);

    }

    private static int QueryOverHalfOfLength1(int[] array) {
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
            if(map.get(k) > (array.length/2)){
                return k;
            }
        }
        return 0;
    }
    // 肯定存在超过一半的数无法减为0
    private static int QueryOverHalfOfLength2(int[] array) {
        int num = array[0];
        int count = 1;
        for(int i = 1; i < array.length; i++){
            if(array[i] == num){
                count ++;
            }else{
                count --;
            }
            if(count == 0){
                num = array[i];
                count = 1;
            }
        }
        count=0;
        for(int i=0;i<array.length;i++){
            if(array[i]==num){
                count++;
            }
        }
        if(count>array.length/2){
            return num;
        }
        return 0;
    }
}
