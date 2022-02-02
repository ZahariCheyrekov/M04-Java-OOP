package M04_JavaOOP.L10_UnitTesting.Exercises.T04BubbleSortTest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {
    private int[] array;

    @Before
    public void setUp() {
        this.array = new int[]{6, 2, 1, 5, 3, 4};
    }

    @Test
    public void testChecksIfBubbleSortIsWorkingCorrectly() {
        Bubble.sort(this.array);
        int[] expectedArray = {1, 2, 3, 4, 5, 6};
        assertArrayEquals(expectedArray, this.array);
    }
}