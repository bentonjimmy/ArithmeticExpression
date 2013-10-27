package edu.njit.cs610.code;

public class Operator implements Op
{
	public Operator(String operator, int precedence, String associative)
	{
		this.operator = operator;
		this.precedence = precedence;
		this.associative = associative;
	}

	public String getOperator() {
		return operator;
	}

	public int getPrecedence() {
		return precedence;
	}
	
	public String getAssociative() {
		return associative;
	}

	private String operator;
	private int precedence;
	private String associative;
}
