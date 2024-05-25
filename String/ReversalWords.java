import java.util.Scanner;
import java.util.Stack;

//You are a cool boy.
public class ReversalWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String newStr = ReversalWords4(str);
        System.out.println(newStr);
    }
    public static String ReversalWords1(String str){
        String[] words = str.split(" ");
        String ret = "";
//        StringBuilder stringBuilder = new StringBuilder();
        for (int i = words.length-1; i >=0; i--){
            ret = ret + words[i];
            if (i!=0){
                ret  = ret + " ";
            }
        }
        return ret;
    }

    public static String ReversalWords2(String str){
        String[] words = str.split(" ");
        String ret = "";
        Stack<String> s = new Stack();
        for (int i =0; i <words.length-1; i++){
            s.push(words[i]);
            s.push(" ");
        }
        s.push(words[words.length-1]);
        while (!s.empty()){
            ret = ret + s.pop();
        }
        return ret;
    }

    public static String ReversalWords3(String str){
        String[] words = str.split(" ");
        String ret = "";
        int j = 0;
        for (int i =0; i<str.length(); i++){
            if (str.charAt(i)!= ' '){
                ret = ret + str.charAt(i);
            }else {
                words[j] = ret;
                j ++;
                ret = "";
            }
        }
        ret = "";
        for (int i = words.length-1; i >=0; i--){
            ret = ret + words[i];
            if (i!=0){
                ret  = ret + " ";
            }
        }
        return ret;
    }
    public static String ReversalWords4(String str){
        if (str != null && str.length() != 0 && !str.equals("   ")) {
            int start = str.length() - 1, end = start;
            StringBuffer stringBuffer = new StringBuffer();
            for (; start > 0; ) {
                // 如果为空格
                if (str.charAt(start) == ' ') {
                    // 且开始索引和结束索引不一致的情况
                    if (start != end) {
                        // 遍历start+1~end的字符，加到
                        for (int i = start + 1; i <= end; i++) {
                            stringBuffer.append(str.charAt(i));
                        }
                        // 每一个单词的后面加上一个空格
                        stringBuffer.append(" ");
                    }
                    start--;
                    end = start;
                } else {
                    start--;
                }
            }
            // 处理最后一个单词
            for (int i = 0; i <= end; i++) {
                stringBuffer.append(str.charAt(i));
            }
            return stringBuffer.toString();
        }
        return str;
    }
}
