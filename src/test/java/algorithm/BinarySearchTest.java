package algorithm;

import org.junit.Test;
import org.zazhi.algorithm.BinarySearch;

import static org.junit.Assert.*;

/**
 * @Description
 * @Date 2024/1/20
 * @Created by zazhi
 */
public class BinarySearchTest {
    BinarySearch binarySearch = new BinarySearch();
    int[] arr = {1,1,2,2,3,4,4,5,5,7,8,9,9,11};
    @Test
    public void binarySearch() {
        int res1 = binarySearch.BinarySearch(arr,2);
        int res2 = binarySearch.BinarySearch(arr,3);
        int res3 = binarySearch.BinarySearch(arr,6);
        assertEquals(res1,2);
        assertEquals(res2,4);
        assertEquals(res3,-1);
    }

    @Test
    public void binarySearch2() {
        int res1 = binarySearch.BinarySearch2(arr,11);
        int res2 = binarySearch.BinarySearch2(arr,3);
        int res3 = binarySearch.BinarySearch2(arr,6);
        assertEquals(res1,13);
        assertEquals(res2,4);
        assertEquals(res3,-1);
    }

    @Test
    public void binarySearch3() {
        int res1 = binarySearch.BinarySearch3(arr,1);
        int res2 = binarySearch.BinarySearch3(arr,2);
        int res3 = binarySearch.BinarySearch3(arr,6);
        int res4 = binarySearch.BinarySearch3(arr,9);
        assertEquals(res1,0);
        assertEquals(res2,2);
        assertEquals(res3,-1);
        assertEquals(res4,11);
    }

    @Test
    public void binarySearch4() {
        int res1 = binarySearch.BinarySearch4(arr,1);
        int res2 = binarySearch.BinarySearch4(arr,2);
        int res3 = binarySearch.BinarySearch4(arr,6);
        int res4 = binarySearch.BinarySearch4(arr,9);
        assertEquals(res1,1);
        assertEquals(res2,3);
        assertEquals(res3,-1);
        assertEquals(res4,12);
    }

    @Test
    public void binarySearchLeftmost() {
    }

    @Test
    public void binarySearchRightmost() {
    }
}