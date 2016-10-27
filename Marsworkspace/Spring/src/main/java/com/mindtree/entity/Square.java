package com.mindtree.entity;

public class Square extends Shape{
	
	public Square() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Square(int value) {
		super(value);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void print()
	{
		System.out.println("Square value = "+value);
	}
}
