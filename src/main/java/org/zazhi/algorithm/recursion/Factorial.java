package org.zazhi.algorithm.recursion;

/**
 * @Description 计算阶乘
 * @Date 2024/1/21
 * @Created by zazhi
 */
public class Factorial {
    public static void main(String[] args) {

        System.out.println(f(5));
    }


    public static long f(int n){
        if (n==1)return 1;
        return n*f(n-1);
    }
}
