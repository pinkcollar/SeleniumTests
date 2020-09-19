import java.util.Stack;

class CheckBalancedChallenge {
    public static boolean isBalanced(String exp) {
        // Write -- Your -- Code
        if(exp.isEmpty()){
            return false;
        }

        if(exp.length()%2!=0){
            return false;
        }

        Stack<Character> parenthenes1 = new Stack<>();


        for(int i = exp.length()/2; i < exp.length(); i++){
            parenthenes1.push(exp.charAt(i));
        }
       System.out.println( parenthenes1);
        char pop1;
        while(!parenthenes1.isEmpty()){



            for(int i = 0; i < exp.length()/2; i++){
                pop1 = parenthenes1.pop();
                if(exp.charAt(i) == '[' && pop1!=']'){
                    return false;
                }

                if(exp.charAt(i)== '{' && pop1!='}'){
                    return false;
                }

                if(exp.charAt(i) == '(' && pop1!=')'){
                    return false;
                }
                if(exp.charAt(i) == ']' && pop1!='['){
                    return false;
                }

                if(exp.charAt(i)== '}' && pop1!='{'){
                    return false;
                }

                if(exp.charAt(i) == ')' && pop1!='('){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String args[]){
        String str = "{}{}{}";

        System.out.println(isBalanced(str));
    }

}