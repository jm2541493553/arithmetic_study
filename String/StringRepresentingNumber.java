import java.util.Scanner;
/*
* 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
* 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
* 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。*/


/*
* 1.如果前面已经有小数点或者有E出现了，那么就是非法的，返回false。否则hasDot置为true
* 2.前面如果已经出现过数字或者符号或者小数点，都不是合法的，否则hasSign置为true，表示符号出现过
* 3.如果前面已经出现过E，或者前面没有数字，直接返回false，否则，hasE置为true，其他的置为false，也就是E后面可以继续出现符号数字和小数点了
* 4.如果c是e或者E：
* 5.如果c是“+”或者“-”：
* 6.如果c是小数点“.”
* 7.如果c为空格，直接跳出循环
* 8.否则，直接返回false
* */
public class StringRepresentingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        boolean isNumber = StringRepresentingNumber(str);

        System.out.println(isNumber);

    }

    public static boolean StringRepresentingNumber(String str){
        boolean hasSign = false;
        boolean hasNumber = false;
        boolean hasE = false;
        boolean hasDot = false;
        for (int i = 0; i < str.length();i++){
            char c = str.charAt(i);
            if (c>='0'&& c<='9' ){
                hasNumber = true;
                continue;
            }
            if (c == 'E' || c == 'e'){
                if (hasNumber){
                    hasE = true;
                    hasNumber =false;
                    hasSign = false;
                    hasDot = false;
                }else {
                    return false;
                }
            }else if(c == '+' || c == '-'){
                if (hasSign||hasNumber||hasDot){
                    return false;
                }else {
                    hasSign =true;
                }
            }else if (c == '.'){
                if (hasDot || hasE){
                    return false;
                }else {
                    hasDot = true;
                }
            }else {
                return false;
            }

        }
        if (hasNumber){
            return true;
        }else {
            return false;
        }
    }
}
