import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class StringSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        ArrayList<String> newStrings = StringSort(str);

        for (String s:newStrings) {
            System.out.println(s);
        }

    }
    /*使用回溯，通过交换字符实现，主要重复元素需要跳过。步骤：

    将字符串分为两部分，首字符和剩下字符。
    将首字符和其他的字符进行交换，并以剩下的元素组成的字符串进行递归全排列。
    直到交换完最后一个元素的时候，结束。*/
    public static ArrayList<String> StringSort(String str){
        ArrayList<String> results = new ArrayList<>();
        if (str != null && str.length() > 0) {
            char[] chars = str.toCharArray();
            process(chars, results, 0);
        }
        results.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        return results;
    }
    private static void process(char[] chars, ArrayList<String> results, int index) {
        if (index == chars.length - 1) {
            if (!results.contains(new String(chars))) {
                results.add(new String(chars));
                return;
            }
        } else {
            for (int j = index; j < chars.length; j++) {
                swap(chars, index, j);
                process(chars, results, index + 1);
                swap(chars, index, j);
            }
        }
    }

    // 交换
    private static  void swap(char[] str, int i, int j) {
        if (i != j) {
            char t = str[i];
            str[i] = str[j];
            str[j] = t;
        }
    }
}
