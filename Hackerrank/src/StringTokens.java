import java.util.Scanner;

public class StringTokens {


        public static void main(String[] args) {

            String s = "";
            s = s.replace(',', ' ').replace('?', ' ').replace('!', ' ').replace("  ", " ").trim();
            System.out.println(s);
            String[] tokens = s.split("[!,?._'@\\s]+");
            if(tokens[0]==""){
                System.out.println('0');
            } else
            System.out.println(tokens.length);

            for(String t:tokens){
                    System.out.println(t);
            }

            // Write your code here.

        }


}
