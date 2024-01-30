package org.zazhi.algorithm;


import java.io.StreamTokenizer;
import java.util.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        Read rd = new Read();
        //读输入
        int m = rd.nextInt();
        int n = rd.nextInt();
        int[] scoreLine = new int[m];
        int[] scores = new int[n];
        for (int i = 0; i <=m-1; i++) {
            scoreLine[i] = rd.nextInt();
        }
        for (int i = 0; i <=n-1; i++) {
            scores[i]=rd.nextInt();
        }
        //分数线转为数组
        Arrays.sort(scoreLine);
        //
        long res = 0;
        for (int i = 0; i < scores.length; i++) {
            //低于所有学校||高于所有学校
			if (scores[i]<=scoreLine[0]) {
				res+=scoreLine[0]-scores[i];
				continue;
			}
			if (scores[i]>=scoreLine[m-1]) {
				res+=scores[i]-scoreLine[m-1];
				continue;
			}
            //查找最接近的分数
            res+=bsearch(scoreLine,scores[i],m);
        }

        System.out.println(res);


    }

    public static int bsearch(int[] scoreLine, int target,int m){
        int l=0, r=m-1;
        while(l<=r) {
            int mid = (l+r)>>>1;
            if(target<scoreLine[mid])r=mid-1;
            else if(scoreLine[mid]<target)l=mid+1;
            else return 0;
        }
        return Math.min(scoreLine[l]-target, target-scoreLine[r]);
    }

}
class Read{
    StreamTokenizer  st  = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public int nextInt() throws IOException {
        st.nextToken();
        return (int)st.nval;
    }
}
