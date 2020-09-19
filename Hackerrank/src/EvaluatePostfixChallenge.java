import java.util.Stack;

public class  EvaluatePostfixChallenge {
    public static int evaluatePostFix(String expression) {

        Stack<Integer> stack = new Stack<>();

        for(int i =0; i < expression.length(); i++){
            int x = 0;
            int y = 0;
            char character = expression.charAt(i);
            if( Character.isDigit(character)){
                stack.push(Character.getNumericValue(character));
            } else {
                if(character == '*'){
                    x = stack.pop();
                    y = stack.pop();
                    stack.push(y*x);

                }
                if(character == '-'){
                    x = stack.pop();
                    y = stack.pop();
                    stack.push(y-x);
                }
                if(character == '+'){
                    x = stack.pop();
                    y = stack.pop();
                    stack.push(y+x);
                }


            }



        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String str = "921*-8-4+";
        System.out.println(evaluatePostFix(str));
    }
}
