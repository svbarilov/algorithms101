package algorithms;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class BubbleSortTest {

    private ZMyBubbleSort bubbleSort;

    @Before
    public void SetUp() {
        bubbleSort = new ZMyBubbleSort();
    }

    @Test
    public void Sort() {
        int[] array = {5, 1, 4, 2, 8, 9 , 11, 12};

        int[] sorted = bubbleSort.sort(array);

        Assert.assertEquals(1, sorted[0]);
        Assert.assertEquals(2, sorted[1]);
        Assert.assertEquals(4, sorted[2]);
        Assert.assertEquals(5, sorted[3]);
        Assert.assertEquals(8, sorted[4]);
    }

}
