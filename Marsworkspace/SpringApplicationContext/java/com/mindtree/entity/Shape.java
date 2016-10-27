package com.mindtree.entity;

public class Shape {
	int value;
	
	public Shape() {
		value=0;
	}
	public Shape(int value) {
		this.value=value;
	}

	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value=value;
	}
	public void print()
	{
		System.out.println("Shape value = "+value);
	}
}
