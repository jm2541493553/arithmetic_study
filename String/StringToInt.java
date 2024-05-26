import java.util.ArrayList;
import java.util.Scanner;
//+2147483647
//1a33
public class StringToInt {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int newInt = StringToInt(str);

        System.out.println(newInt);

    }
    public static int StringToInt(String str){
        boolean  positive = true;
        int result = 0;
        for (int i = 0; i<str.length();i++){
            if(i ==0 && str.charAt(i) == '+'){
                continue;
            }else if (i ==0 && str.charAt(i) == '-'){
                positive = false;
                continue;
            }else {
                if (str.charAt(i) - '0' >= 0 && '9' - str.charAt(i) >= 0) {
                    result = result * 10 + (str.charAt(i) - '0');
                } else {
                    return 0;
                }
            }
        }
        if (positive){
            return result;
        }else {
            return -result;
        }
    }
}
