import java.util.*;

class Abbr {

    public static List<String> generateGeneralizedAbbreviation(String word) {
        List<String> result = new ArrayList<String>();
        // TODO: Write your code here
        generateGeneralizedAbbreviationRecurtion(word, result);
        return result;
    }

    private static void generateGeneralizedAbbreviationRecurtion(String word, List<String> result){
        Queue<String> queue = new LinkedList<>();
        queue.add(word.charAt(0) + "");
        queue.add("1");

        while(!queue.isEmpty()){
            String currentCombination = queue.poll();
            if(Character.isLetter(currentCombination.charAt(currentCombination.length()-1))){


                    result.add(currentCombination + word.charAt(currentCombination.length()));
                    result.add(currentCombination + "1");

                queue.add(currentCombination + word.charAt(currentCombination.length()));
                queue.add(currentCombination + "1");
            } else {


                    result.add(currentCombination + word.charAt(currentCombination.length()));
                queue.add(currentCombination + word.charAt(currentCombination.length()));
                    if(currentCombination.length()>1) {
                        currentCombination = currentCombination.substring(0, currentCombination.length() - 1)
                               + (Character.getNumericValue(currentCombination.charAt(currentCombination.length() - 1)) + 1);
                        result.add(currentCombination);

                        queue.add(currentCombination + word.charAt(currentCombination.length()));
                        currentCombination = currentCombination.substring(0, currentCombination.length() - 2)
                                + (Integer.valueOf(currentCombination.charAt(currentCombination.length() - 1)) + 1);
                        queue.add(currentCombination);
                    } else {currentCombination = currentCombination.replace(currentCombination.charAt(0),
                            (char)(Integer.valueOf(currentCombination.charAt(0)) + 1 ));
                        queue.add(currentCombination);
                        result.add(currentCombination);

                    }

            }
        }
    }

    public static void main(String[] args) {
        List<String> result = Abbr.generateGeneralizedAbbreviation("BAT");
        System.out.println("Generalized abbreviation are: " + result);

        result = Abbr.generateGeneralizedAbbreviation("code");
        System.out.println("Generalized abbreviation are: " + result);
    }
}
