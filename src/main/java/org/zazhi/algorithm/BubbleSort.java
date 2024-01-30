package org.zazhi.algorithm;

/**
 * @Description 冒泡排序
 * @Date 2024/1/29
 * @Created by zazhi
 */
public class BubbleSort {

    public static void sort(int[] arr){
        bubbleSort(arr,arr.length-1);
    }

    private static void bubbleSort(int[] arr,int r){
        if (r == 0)return;//递归出口
        int x = 0; //flag
        for (int i = 0; i <=r-1; i++) {
            if (arr[i] > arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                x=i;//发生交换时，x标记i的位置
            }
        }
        //递归，x右边一定是有序的
        bubbleSort(arr,x);
    }

}
