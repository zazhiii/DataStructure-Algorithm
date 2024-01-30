package org.zazhi.algorithm;

import org.junit.Test;

/**
 * @Description
 * @Date 2024/1/29
 * @Created by zazhi
 */
public class E04BubbleSortTest {

    @Test
    public void sort() {
        int[] arr = {1,3,2,4,9,7,3,6,0};
        BubbleSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}