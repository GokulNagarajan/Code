package com.mindtree.entity;

public class Circle extends Shape{
	
	public Circle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Circle(int value) {
		super(value);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void print()
	{
		System.out.println("Circle value = "+value);
	}
}
