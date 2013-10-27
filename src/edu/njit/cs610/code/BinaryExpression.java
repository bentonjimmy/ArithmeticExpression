package edu.njit.cs610.code;

import java.util.Stack;

public class BinaryExpression 
{
	public BinaryExpression()
	{
		bt = new BinaryTree<Integer, Integer>();
	}
	
	public void addExpression(Op[] expression)
	{
		this.expression = expression;
	}
	
	public int solve()
	{
		int nodeCounter = 0;//Keeps track of the Integer key for the Node
		for(int i=0; i<expression.length; i++)
		{
			if(expression[i] instanceof Operand)
			{
				BinaryTree<Integer, Op> number = new BinaryTree<Integer, Op>();
				number.insert(i, expression[nodeCounter]);
				nodeCounter = nodeCounter + 2; //Numbers get even numbers
				stack.push(number);
			}
			else
			{
				//Operands get odd numbers
			}
		}
		return 0;
	}
	
	private Stack<BinaryTree<Integer, Op>> stack;
	private BinaryTree<Integer, Integer> bt;
	private Op[] expression;
}
