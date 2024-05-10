import java.util.Scanner;
import java.util.Stack;

//You are a cool boy.
public class ReversalWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String newStr = ReversalWords3(str);
        System.out.println(newStr);
    }
    public static String ReversalWords(String str){
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
}
