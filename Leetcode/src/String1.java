import java.util.HashMap;

public class String1 {
    public static void main(String[] args) {
        String str1 = "asd";
        String str2 = "sfg";
        System.out.println(check(str1, str2));

    }


    public static boolean check(String str1, String str2) {
        HashMap map = new HashMap<Integer, Character>();
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                str2.replace(str2.charAt(i), str1.charAt(i));

                if (!map.containsValue(str2.charAt(i))) {
                    map.put(i, str1.charAt(i));
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    // aaa zaz -> in 1st string all symbols are the sameand im sicond one are not and vice versa;
    //ab ba -> have to check if replaced symbol is presented in first string somewere else and check if same symbol in the same position in the second string;


}


