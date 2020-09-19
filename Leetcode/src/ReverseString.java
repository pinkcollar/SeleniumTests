public class ReverseString {
    public static void main(String[] args) {
        char[] s = {'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString(s);

    }
    public static void reverseString(char[] s){
        char buffer = 0;
        helper(buffer,0, s.length-1, s);
        System.out.println(s);
    }





    private static void helper(char buffer, int start, int end, char[] s){

        if(s.length == 0 || start >= end){
            return;
        }
        buffer = s[start];
        s[start] = s[end];
        s[end] = buffer;

        helper(buffer, start+1, end-1, s);



    }



}
