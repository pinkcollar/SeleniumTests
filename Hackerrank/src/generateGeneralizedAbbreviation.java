import java.util.*;

class GeneralizedAbbreviation {

    public static List<String> generateGeneralizedAbbreviation(String word) {
        List<String> result = new ArrayList<String>();
        // TODO: Write your code here
        generateGeneralizedAbbreviationRecurtion("", 0, 0, word, result);
        return result;
    }

    private static void generateGeneralizedAbbreviationRecurtion(String currentCombination, int index, int count, String word, List<String> result){

        if(currentCombination.length() == word.length()){

            result.add(currentCombination);
            return;
        }
        currentCombination+= word.charAt(index) + "";


        generateGeneralizedAbbreviationRecurtion(currentCombination, currentCombination.length(), count, word, result);


        if(currentCombination.length() == 0 || Character.isLetter(currentCombination.charAt(index))){


            generateGeneralizedAbbreviationRecurtion(currentCombination, currentCombination.length(), count + 1, word, result);
        } else {

            currentCombination += currentCombination.substring(0, index - 1) + count;
            generateGeneralizedAbbreviationRecurtion(currentCombination, currentCombination.length(), count + 1, word, result);
        }

            return;

    }

    public static void main(String[] args) {
        List<String> result = GeneralizedAbbreviation.generateGeneralizedAbbreviation("BAT");
        System.out.println("Generalized abbreviation are: " + result);

        result = GeneralizedAbbreviation.generateGeneralizedAbbreviation("code");
        System.out.println("Generalized abbreviation are: " + result);
    }
}
