package org.zazhi.algorithm;

public class BinarySearch {

	
	
public  int BinarySearch(int[] arr, int target) {
		
	int l = 0, r = arr.length-1; //设置指针极其初值
		
	while(l<=r) {
		int m = (l+r)>>>1;	//用位运算代替除法防止超过整数范围
		if(arr[m]<target) {
			l = m+1;
		}else if(target<arr[m]){
			r = m-1;
		}else {
			return m;
		}
	}
	return -1;
	}



public  int BinarySearch2(int[] arr, int target) {
	int l = 0, r = arr.length;
	
	while(l<r) {
		int m = (l+r)>>>1;
		if(target<arr[m]) {
			r = m;
		}else if(arr[m]<target) {
			l = m+1;
		}else {
			return m;
		}
	}
	return -1;
	}


//leftmost
public  int BinarySearch3(int[] arr, int target) {
	
	int l = 0, r = arr.length-1; //设置指针极其初值
	int candidate = -1;
	
	while(l<=r) {
		int m = (l+r)>>>1;	//用位运算代替除法防止超过整数范围
		if(arr[m]<target) {
			l = m+1;
		}else if(target<arr[m]){
			r = m-1;
		}else {
			candidate =  m;
			r = m-1;
		}
	}
	
	return candidate;
	}

//rightmost
public  int BinarySearch4(int[] arr, int target) {
	
	int l = 0, r = arr.length-1; //设置指针极其初值
	int candidate = -1;
	
	while(l<=r) {
		int m = (l+r)>>>1;	//用位运算代替除法防止超过整数范围
		if(arr[m]<target) {
			l = m+1;
		}else if(target<arr[m]){
			r = m-1;
		}else {
			candidate =  m;
			l = m+1;
		}
	}
	
	return candidate;
	}
//leftMost
public  int BinarySearchLeftmost(int[] arr, int target) {
	int l = 0, r = arr.length-1;
	while(l<=r) {
		int m = l+r >>>1;
		if(target<=arr[m]) r = m-1;
		else l = m+1;
	}
	return l;
}

public  int BinarySearchRightmost(int[] arr, int target) {
	int l = 0, r = arr.length-1;
	while(l<=r) {
		int m = l+r>>>1;
		if(target<arr[m])r=m-1;
		else l=m+1;
	}
	return l+1;
}

}



