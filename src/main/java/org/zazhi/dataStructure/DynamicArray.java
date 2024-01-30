package org.zazhi.dataStructure;

import java.util.Iterator;

public class DynamicArray implements Iterable<Integer> {
	private int size=0;
	private int capacity = 10;
	private int[] array = new int[capacity];
	
	//添加元素
	public void addLast(int e) {
		enlarge();
		array[size] = e;
		size++;
	}
	//插入元素
	public void insert(int e, int index) throws Exception {
		enlarge();
		if (index<0||index>size) {
			throw new Exception("索引不合法");
		}
		for(int i = size;i>=index+1;i--) {
			array[i]= array[i-1]; 
		}
		array[index] = e;
		size++;
	}
	//通过索引获取元素
	public int get(int index) throws Exception {
		if (index<0||index>=size) {
			throw new Exception("索引不合法");
		}
		return array[index];
	}
	//遍历
	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			int i=0;
			@Override
			public Integer next() {
				return array[i++];
			}
			
			@Override
			public boolean hasNext() {
				return i<size;
			}
		};
	}
	//删除
	public int remove(int index) throws Exception {
		if (index<0||index>=size) {
			throw new Exception("索引不合法");
		}
		for (int i = index; i <=array.length-2; i++) {
			array[i]=array[i+1]; 
		}
		size--;
		return array[index];
	}
	
	//扩容
	public void enlarge() {
		if(size==capacity) {
			capacity+=capacity>>>1;
		}
		int[] newArr = new int[capacity];
		for (int i = 0; i < size; i++) {
			newArr[i]=array[i]; 
		}
		array = newArr;
	}
}
