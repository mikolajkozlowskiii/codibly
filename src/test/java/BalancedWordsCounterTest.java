import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BalancedWordsCounterTest {
    private BalancedWordsCounter balancedWordsCounter;

    @BeforeEach
    void setUp() {
        balancedWordsCounter = new BalancedWordsCounter();
    }

    @Test
    public void count_balancedWordsInput_balancedWordsCounted(){
        final String word = "aabbabcccba";

        final int actualCount = balancedWordsCounter.count(word);
        final int expectedCount = 28;

        assertEquals(expectedCount,actualCount);
    }

    @Test
    public void count_emptyInput_zeroBalancedWords(){
        final String word = "";

        final int actualCount = balancedWordsCounter.count(word);
        final int expectedCount = 0;

        assertEquals(expectedCount,actualCount);
    }

    @Test
    public void count_digitInput_thrownRuntimeException(){
        final String word = "abababa1";

        assertThrows(RuntimeException.class,
                () -> balancedWordsCounter.count(word));
    }

    @Test
    public void count_nullInput_thrownRuntimeException(){
        final String word = null;

        assertThrows(RuntimeException.class,
                () -> balancedWordsCounter.count(word));
    }
}