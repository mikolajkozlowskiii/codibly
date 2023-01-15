import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BucketSort {
    public <T extends Comparable<T>> List<T> sort(List<T> input){
        validateInput(input);
        List<T> result = new ArrayList<>(getCopyWithoutNulls(input));
        int size = result.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size-i-1; j++) {
                if (result.get(j + 1).compareTo(result.get(j)) < 0) {
                    result.add(j, result.remove(j + 1));
                }
            }
        }
        return result;
    }

    private <T extends Comparable<T>> void validateInput(List<T> input) {
        if(Objects.isNull(input)){
            throw new RuntimeException();
        }
    }

    private <T extends Comparable<T>> List<T> getCopyWithoutNulls(List<T> input) {
        return input
                .stream()
                .filter(Objects::nonNull)
                .toList();
    }

}
