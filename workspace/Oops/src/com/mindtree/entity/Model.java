package com.mindtree.entity;

public class Model {
	private int privateInt=1;
	int defaultInt=2;
	protected int protectedInt=3;
	public int publicInt=4;
	public void fun()
	{
		System.out.println("Private int "+privateInt);
		System.out.println("Default int "+defaultInt);
		System.out.println("Protected int "+protectedInt);
		System.out.println("Public int "+publicInt);
	}
	
}
