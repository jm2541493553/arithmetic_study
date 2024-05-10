import java.util.Scanner;

//We Are Happy
public class ReplaceSpaceUse20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String newStr = ReplaceSpaceUse202(str);
        System.out.println(newStr);
    }

    public static String ReplaceSpaceUse201(String str){
        return str.replace(" ", "%20");
    }

    public static String ReplaceSpaceUse202(String str){
        char[] originChars= str.toCharArray();
        int num = 0;
        for (int i = 0; i < originChars.length; i++){
            if (originChars[i] == ' '){
                num ++;
            }
        }
        int newIndex = 0;
        char[] newChars = new char[originChars.length+2*num];
        for (int i = 0; i < originChars.length; i++){
            if (originChars[i] != ' '){
                newChars[newIndex++] = originChars[i];
            }else {
                newChars[newIndex++] = '%';
                newChars[newIndex++] = '2';
                newChars[newIndex++] = '0';
            }
        }
        return new String(newChars);
    }
}
