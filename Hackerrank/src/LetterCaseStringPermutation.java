import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class LetterCaseStringPermutation {

    public static Queue<String> findLetterCaseStringPermutations(String str) {
        Queue<String> permutations = new LinkedList<>();
        // TODO: Write your code here
        permutations.add(str.charAt(0) + "");
        permutations.add(Character.toUpperCase(str.charAt(0)) + "");
        for (int i = 1; i < str.length(); i++) {

            int n = permutations.size();
            for (int j = 0; j < n; j++) {
                String oldPermutation = permutations.poll();
                if (Character.isLetter(str.charAt(i))) {
                    permutations.add(oldPermutation + Character.toUpperCase(str.charAt(i)) + "");
                    permutations.add(oldPermutation + str.charAt(i) + "");
                } else
                    permutations.add(oldPermutation + str.charAt(i) + "");
            }

        }
        return permutations;
    }

    public static void main(String[] args) {
        Queue<String> result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ad52");
        System.out.println(" String permutations are: " + result);

        result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ab7c");
        System.out.println(" String permutations are: " + result);
    }
}