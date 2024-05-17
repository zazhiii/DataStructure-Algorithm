package org.zazhi.algorithm.recursion;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * @Description
 * @Date 2024/4/20
 * @Created by lixinhuan
 */
public class RecursionBinarySearchTest extends TestCase {
    @Test
    public void testBinarySearch() {
        int[] a = {7, 13, 21, 30, 38, 44, 52, 53};
        RecursionBinarySearch r = new RecursionBinarySearch();
        assertEquals(0, r.BinarySearch(a,7));
        assertEquals(1, r.BinarySearch(a,13));
        assertEquals(2, r.BinarySearch(a,21));
        assertEquals(3, r.BinarySearch(a,30));
        assertEquals(4, r.BinarySearch(a,38));
        assertEquals(5, r.BinarySearch(a,44));
        assertEquals(6, r.BinarySearch(a,52));
        assertEquals(7, r.BinarySearch(a,53));
        assertEquals(-1, r.BinarySearch(a,0));

    }
}