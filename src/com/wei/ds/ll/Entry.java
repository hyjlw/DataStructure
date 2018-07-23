package com.wei.ds.ll;

public class Entry{
	int data;
	Entry next;
	
	Entry(){
		
	}
	Entry(int value){
		data = value;
	}
	
	void display(){
		System.out.print("{" + data + "}");
	}
}