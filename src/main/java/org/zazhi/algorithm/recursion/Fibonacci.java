package org.zazhi.algorithm.recursion;

/**
 * @Description 斐波那契数列
 * @Date 2024/1/29
 * @Created by zazhi
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(f01(4,0,1));
    }
    public static int f(int n){
        if (n==0)return 0;
        if (n==1)return 1;
        return f(n-1)+f(n-2);
    }
    public static int f01(int n, int first, int second){
        if (n==0)return 0;
        if (n==1)return second;
        return f01(n-1, second, first+second);
    }
}
