import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FistOnceChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int num = FistOnceChar1(str);
        System.out.println(num);
    }

    public static int FistOnceChar(String str){
        Map<Character,Integer> hashMap = new LinkedHashMap<>();
        for(int i = 0;i<str.length();i++){
            char c = str.charAt(i);
            if(hashMap.containsKey(c)){
                hashMap.put(c, 999999999);
            }else{
                hashMap.put(c,i);
            }
        }
        for (char k: hashMap.keySet()) {
            if (hashMap.get(k) != 999999999){
                return hashMap.get(k);
            }
        }
       return -1;
    }

//    大写英文字母。65~90 代表 A 到 Z 的大写字母。
//    小写英文字母。97~122 代表 a 到 z 的小写字母。
    public static int FistOnceChar1(String str){
        int[] strCount = new int[58];
        for (int i=0;i<strCount.length;i++){
            strCount[i] = -1;
        }
        for (int i = 0; i <str.length(); i++){
            char c = str.charAt(i);
            int index = c - 'A';
            if (strCount[index] >= 0){
                strCount[index] = 999999999;
            }else {
                strCount[index] = i;
            }
        }
        int index = 999999999;
        for (int i = 0; i < strCount.length; i++) {
            if (strCount[i] != -1 && strCount[i] != 999999999) {
                index = Math.min(index, strCount[i]);
            }
        }
        return index;
    }
}
