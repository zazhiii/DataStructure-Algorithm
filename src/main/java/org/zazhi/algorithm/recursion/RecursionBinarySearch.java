package org.zazhi.algorithm.recursion;

/**
 * @Description 递归实现二分查找（已测）
 * @Date 2024/4/20
 * @Created by lixinhuan
 */
public class RecursionBinarySearch {

    public int BinarySearch(int[] a, int target){
        return f(a, target, 0, a.length-1);
    }

    private int f(int[] a, int target, int l, int r){
        if (l>r) return -1;//递归出口
        int m = (l+r)>>>1;
        if(a[m]<target){
            return f(a, target, m + 1, r);
        }else if(target<a[m]){
            return f(a, target, l ,m - 1);
        }else{
            return m;
        }
    }
}
