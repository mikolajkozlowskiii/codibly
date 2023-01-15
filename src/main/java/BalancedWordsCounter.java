import java.util.HashMap;
import java.util.Map;

public class BalancedWordsCounter {
    public Integer count(String input){
        validateInput(input);
        int count = 0;
        final int length = input.length();
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j <= length; j++) {
                String substring = input.substring(i,j);
                if(isBalanced(substring)){
                    count++;
                }
            }
        }
        return count;
    }

    private void validateInput(String input) {
        if(containsDigit(input)){
            throw new RuntimeException();
        }
    }

    private boolean containsDigit(String word){
        return word.matches(".*\\d+.*");
    }

    private boolean isBalanced(String word) {
        Map<String, Integer> letterCount = countLetters(word);
        return letterCount
                .values()
                .stream()
                .distinct()
                .count() == 1;
    }

    private Map<String,Integer> countLetters(String word){
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < word.length(); i++){
            map.merge(word.substring(i,i+1),1,(oldValue, value)->oldValue+1);
        }
        return map;
    }

}