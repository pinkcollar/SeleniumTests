import java.util.Scanner;

public class Margama {

        static boolean isAnagram(String a, String b) {
            // Complete the function
            for(int i =0; i<a.length(); i++){
                if(b.toLowerCase().contains(String.valueOf(a.charAt(i)).toLowerCase())){
                    System.out.println(b);
                    b = b.replaceFirst(String.valueOf(a.charAt(i)), "1");

                } else{
                    return false;
                }

            }

            return true;
        }

        public static void main(String[] args) {

            Scanner scan = new Scanner(System.in);
            String a = scan.next();
            String b = scan.next();
            scan.close();
            boolean ret = isAnagram(a, b);
            System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
        }
    }

