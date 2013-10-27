package edu.njit.cs610.code;

public class Operand implements Op {

	public Operand(Integer i)
	{
		this.i = i;
	}
	
	public Integer getValue()
	{
		return i;
	}
	
	private Integer i;
}
