import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BucketSortTest {
    private BucketSort bucketSort;

    @BeforeEach
    void setUp() {
        bucketSort = new BucketSort();
    }

    @Test
    public void sort_positiveValues_sorted(){
        List<Integer> unsortedList = List.of(1,4,5,6,8,3,8);

        List<Integer> actualList = bucketSort.sort(unsortedList);
        List<Integer> expectedList = List.of(1,3,4,5,6,8,8);

        assertEquals(expectedList, actualList);
    }

    @Test
    public void sort_positiveAndNegativeValues_sorted(){
        List<Double> unsortedList = List.of(-9.3,0.2,4.0,0.1,5.0,9.0);

        List<Double> actualList = bucketSort.sort(unsortedList);
        List<Double> expectedList = List.of(-9.3,0.1,0.2,4.0,5.0,9.0);

        assertEquals(expectedList, actualList);
    }

    @Test
    public void sort_emptyInput_emptyList(){
        List<Double> unsortedList = Collections.emptyList();

        List<Double> actualList = bucketSort.sort(unsortedList);
        List<Double> expectedList = Collections.emptyList();

        assertEquals(expectedList, actualList);
    }

    @Test
    public void sort_listWithOneNullValue_nullSkippedListSorted(){
        List<Double> unsortedList = Arrays.asList(null,5.0001);

        List<Double> actualList = bucketSort.sort(unsortedList);
        List<Double> expectedList = List.of(5.0001);

        assertEquals(expectedList, actualList);
    }

    @Test
    public void sort_nullInput_thrownRuntimeException(){
        List<Double> unsortedList = null;

        assertThrows(RuntimeException.class,
                () -> bucketSort.sort(unsortedList));
    }
}