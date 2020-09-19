import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters3 {
    public static void main(String[] args) {
        String str = "dvdf";
        System.out.println(lengthOfLongestSubstring(str));
    }

    public static int lengthOfLongestSubstring(String s) {

        HashSet<Character> uniqeChars = new HashSet<>();
        int n = s.length();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n)
            if (!uniqeChars.contains(s.charAt(j))) {
                System.out.println(s.charAt(j));
                uniqeChars.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                System.out.println("i" + s.charAt(i));
                uniqeChars.remove(s.charAt(i++));
            }
//      }
        return ans;
    }

}
