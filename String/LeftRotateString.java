import java.util.Scanner;
//XYZdefabc
public class LeftRotateString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int index = sc.nextInt();
        String newStr = LeftRotateString2(str, index);
        System.out.println(newStr);
    }
    public static String LeftRotateString(String str, int index){
        String ret = "";
        String ret2 = "";
        for (int i = 0; i < str.length();i++){
            if(i < index){
                ret = ret + str.charAt(i);
            }else {
                ret2 = ret2 + str.charAt(i);
            }
        }
        return ret2 + ret;
    }

    public static String LeftRotateString2(String str, int index){
        return str.substring(index) + str.substring(0, index);
    }
}
