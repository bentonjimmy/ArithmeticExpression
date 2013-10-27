package edu.njit.cs610.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.njit.cs610.code.InfixExpr;
import edu.njit.cs610.code.Op;
import edu.njit.cs610.code.Operand;
import edu.njit.cs610.code.Operator;

public class InfixExprTests {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testParseInfix()
	{
		InfixExpr ie = new InfixExpr();
		Op op[] = new Op[3];
		
		op[0] = new Operand(3);
		op[1] = new Operator("+", 1, "left");
		op[2] = new Operand(2);
		
		Op parsed[] = ie.parseInfix(op);
		assertTrue("Equ 1 - Expecting an Operand - 3", parsed[0] instanceof Operand);
		assertTrue("Equ 1 - Expecting a 3", ((Operand)parsed[0]).getValue() == 3);
		assertTrue("Equ 1 - Expecting an Operand - 2", parsed[1] instanceof Operand);
		assertTrue("Equ 1 - Expecting a 2", ((Operand)parsed[1]).getValue() == 2);
		assertTrue("Equ 1 - Expecting an Operator", parsed[2] instanceof Operator);
		assertTrue("Equ 1 - Test it is a plus sign", ((Operator)parsed[2]).getOperator().equals("+"));
		
		op = new Op[5];
		op[0] = new Operand(3);
		op[1] = new Operator("+", 1, "left");
		op[2] = new Operand(2);
		op[3] = new Operator("-", 1, "left");
		op[4] = new Operand(5);
		
		parsed = ie.parseInfix(op);
		assertTrue("Equ 2 - Expecting an Operand - 3", parsed[0] instanceof Operand);
		assertTrue("Equ 2 - Expecting a 3", ((Operand)parsed[0]).getValue() == 3);
		assertTrue("Equ 2 - Expecting an Operand - 2", parsed[1] instanceof Operand);
		assertTrue("Equ 2 - Expecting a 2", ((Operand)parsed[1]).getValue() == 2);
		assertTrue("Equ 2 - Expecting an Operator", parsed[2] instanceof Operator);
		assertTrue("Equ 2 - Test it is a plus sign", ((Operator)parsed[2]).getOperator().equals("+"));
		assertTrue("Equ 2 - Expecting an Operand - 5", parsed[3] instanceof Operand);
		assertTrue("Equ 2 - Expecting a 5", ((Operand)parsed[3]).getValue() == 5);
		assertTrue("Equ 2 - Expecting an Operator", parsed[4] instanceof Operator);
		assertTrue("Equ 2 - Test it is a minus sign", ((Operator)parsed[4]).getOperator().equals("-"));
		
	}
	
	@Test
	public void testMultAdd()
	{
		InfixExpr ie = new InfixExpr();
		Operator plus = new Operator("+", 1, "left");
		Operator multiply = new Operator("x", 2, "left");
		Op op[] = new Op[5];
		Op[] parsed;
		
		op[0] = new Operand(5);
		op[1] = multiply;
		op[2] = new Operand(3);
		op[3] = plus;
		op[4] = new Operand(2);
		parsed = ie.parseInfix(op);
		
		assertTrue("Equ 1 - Expecting an Operand - 5", parsed[0] instanceof Operand);
		assertTrue("Equ 1 - Expecting a 5", ((Operand)parsed[0]).getValue() == 5);
		assertTrue("Equ 1 - Expecting an Operand - 3", parsed[1] instanceof Operand);
		assertTrue("Equ 1 - Expecting a 3", ((Operand)parsed[1]).getValue() == 3);
		assertTrue("Equ 1 - Expecting an Operator", parsed[2] instanceof Operator);
		assertTrue("Equ 1 - Expecting a multiplication sign", ((Operator)parsed[2]).getOperator().equals("x"));
		assertTrue("Equ 1 - Expecting an Operand - 2", parsed[3] instanceof Operand);
		assertTrue("Equ 1 - Expecting a 2", ((Operand)parsed[3]).getValue() == 2);
		assertTrue("Equ 1 - Expecting an Operator", parsed[4] instanceof Operator);
		assertTrue("Equ 1 - Expecting a plus sign", ((Operator)parsed[4]).getOperator().equals("+"));

		op[0] = new Operand(5);
		op[1] = plus;
		op[2] = new Operand(3);
		op[3] = multiply;
		op[4] = new Operand(2);
		parsed = ie.parseInfix(op);
		
		assertTrue("Equ 1 - Expecting an Operand - 5", parsed[0] instanceof Operand);
		assertTrue("Equ 1 - Expecting a 5", ((Operand)parsed[0]).getValue() == 5);
		assertTrue("Equ 1 - Expecting an Operand - 3", parsed[1] instanceof Operand);
		assertTrue("Equ 1 - Expecting a 3", ((Operand)parsed[1]).getValue() == 3);
		assertTrue("Equ 1 - Expecting an Operand - 2", parsed[2] instanceof Operand);
		assertTrue("Equ 1 - Expecting a 2", ((Operand)parsed[2]).getValue() == 2);
		assertTrue("Equ 1 - Expecting an Operator", parsed[3] instanceof Operator);
		assertTrue("Equ 1 - Expecting a multiplication sign", ((Operator)parsed[3]).getOperator().equals("x"));
		assertTrue("Equ 1 - Expecting an Operator", parsed[4] instanceof Operator);
		assertTrue("Equ 1 - Expecting a plus sign", ((Operator)parsed[4]).getOperator().equals("+"));
	
	}
	
	@Test
	public void testParens()
	{
		InfixExpr ie = new InfixExpr();
		Operator plus = new Operator("+", 1, "left");
		Operator multiply = new Operator("x", 2, "left");
		Operator leftParen = new Operator("(", -1, "left");
		Operator rightParen = new Operator(")", 3, "left");
		Op op[] = new Op[9];
		Op[] parsed;
		
		//5x(3+5)x2
		op[0] = new Operand(5);
		op[1] = multiply;
		op[2] = leftParen;
		op[3] = new Operand(3);
		op[4] = plus;
		op[5] = new Operand(5);
		op[6] = rightParen;
		op[7] = multiply;
		op[8] = new Operand(2);
		
		parsed = ie.parseInfix(op);
		assertTrue("Equ 1 - Expecting an Operand - 5", parsed[0] instanceof Operand);
		assertTrue("Equ 1 - Expecting a 5", ((Operand)parsed[0]).getValue() == 5);
		assertTrue("Equ 1 - Expecting an Operand - 3", parsed[1] instanceof Operand);
		assertTrue("Equ 1 - Expecting a 3", ((Operand)parsed[1]).getValue() == 3);
		assertTrue("Equ 1 - Expecting an Operand - 5", parsed[2] instanceof Operand);
		assertTrue("Equ 1 - Expecting a 5", ((Operand)parsed[2]).getValue() == 5);
		assertTrue("Equ 1 - Expecting an Operator", parsed[3] instanceof Operator);
		assertTrue("Equ 1 - Expecting a plus sign", ((Operator)parsed[3]).getOperator().equals("+"));
		assertTrue("Equ 1 - Expecting an Operator", parsed[4] instanceof Operator);
		assertTrue("Equ 1 - Expecting a multiplication sign", ((Operator)parsed[4]).getOperator().equals("x"));
		assertTrue("Equ 1 - Expecting an Operand - 2", parsed[5] instanceof Operand);
		assertTrue("Equ 1 - Expecting a 2", ((Operand)parsed[5]).getValue() == 2);
		assertTrue("Equ 1 - Expecting an Operator", parsed[6] instanceof Operator);
		assertTrue("Equ 1 - Expecting a multiplication sign", ((Operator)parsed[6]).getOperator().equals("x"));
		
	}

}
