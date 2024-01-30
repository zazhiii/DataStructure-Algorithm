package org.zazhi.algorithm;

/**
 * @Description 斐波那契数列
 * @Date 2024/1/29
 * @Created by zazhi
 */
public class Fibonacci {
    public static int f(int n){
        if (n==0)return 0;
        if (n==1)return 1;
        return f(n-1)+f(n-2);
    }
}
