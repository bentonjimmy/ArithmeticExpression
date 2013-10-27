package edu.njit.cs610.code;

import java.util.ArrayList;
import java.util.Stack;

public class InfixExpr 
{
	public InfixExpr()
	{
	}
	
	public Op[] parseInfix(Op[] equation)
	{
		Stack<Operator> equStack = new Stack<Operator>();
		ArrayList<Op> output = new ArrayList<Op>();
		for(int i=0; i<equation.length; i++)
		{
			Op o = equation[i];
			//Check if o is an Integer
			if(o instanceof Operand)
			{
				output.add(o);
			}
			
			else //it must be an operator
			{
				Operator operator = (Operator)o;
				if(equStack.size() == 0) //push the operator onto the stack
				{
					equStack.push(operator);
				}
				else //there is at least one operator on the stack
				{
					if(operator.getOperator().equals("("))//Check if operator is a (
					{
						equStack.push(operator);
					}
					else if(operator.getOperator().equals(")"))//Check if operator is a )
					{
						Operator popOp = equStack.pop();
						while(!popOp.getOperator().equals("("))//While it is not a (
						{
							output.add(popOp);
							popOp = equStack.pop();
						}
					}
					else
					{
						while(popConditions(equStack, output, operator))
						{
							Operator op1 = equStack.pop();
							output.add(op1);
						}
						equStack.push(operator);
					}
				}
			}
		}
		//Clear the stack by popping everything into the output ArrayList
		while(equStack.size() > 0)
		{
			Operator op2 = equStack.pop();
			output.add(op2);
		}
		//return array version of the output
		return output.toArray(new Op[0]);
	}
	
	protected boolean popConditions(Stack<Operator> equStack, ArrayList<Op> output, Operator o1)
	{
		if(equStack.size() > 0) 
			{
				Operator o2 = equStack.peek();
				if((o1.getAssociative().equals("left") && o2.getPrecedence() == o1.getPrecedence())
						||(o1.getPrecedence() < o2.getPrecedence()))
				{
					return true;
				}
				else
				{
					return false;
				}
				
			}
		return false;
	}
	
	private String[] infix;
	private boolean hasExpression;
}
