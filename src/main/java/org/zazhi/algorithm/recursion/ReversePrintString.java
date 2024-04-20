package org.zazhi.algorithm.recursion;

/**
 * @Description 用递归反向打印字符串
 * @Date 2024/4/20
 * @Created by lixinhuan
 */
public class ReversePrintString {
    public static void main(String[] args) {
        rePrint("nauhnixil", 0);
    }
    public static void rePrint(String s, int idx){
        if (idx==s.length()) return;
        rePrint(s,idx+1);
        System.out.print(s.charAt(idx));
    }
}
