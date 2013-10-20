package edu.njit.cs610.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.njit.cs610.code.BinaryTree;

public class BinaryTreeTests {

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
	public void testSize()
	{
		BinaryTree<String, String> bt = new BinaryTree<String, String>();
		assertTrue("Check initial size of Binary Tree - expect 0", bt.size() == 0);
		bt.insert("First", "Test");
		assertTrue("Check size after one insert - expect 1", bt.size() == 1);
		String value = bt.find("First");
		assertTrue("Check key/value pair - expect Test", value.equals("Test"));
		bt.remove("First");
		assertTrue("Check size after remove - expect 0", bt.size() == 0);
	}
	
	@Test
	public void test2()
	{
		BinaryTree<Integer, Integer> bt = new BinaryTree<Integer, Integer>();
		bt.insert(10,10);
		assertTrue("Expected size: 1", bt.size() == 1);
		bt.insert(5, 5);
		assertTrue("Expected size: 2", bt.size() == 2);
		bt.insert(2, 2);
		assertTrue("Expected size: 3", bt.size() == 3);
		bt.insert(6, 6);
		assertTrue("Expected size: 4", bt.size() == 4);
		bt.insert(15, 15);
		assertTrue("Expected size: 5", bt.size() == 5);
		bt.insert(20, 20);
		assertTrue("Expected size: 6", bt.size() == 6);
		bt.insert(25, 25);
		assertTrue("Expected size: 7", bt.size() == 7);
		bt.insert(23, 23);
		assertTrue("Expected size: 8", bt.size() == 8);
		bt.insert(22, 22);
		assertTrue("Expected size: 9", bt.size() == 9);
		bt.printInOrder();
		Integer v = bt.find(10);
		assertTrue("Find expected to retreive 10", v == 10);
		v = bt.find(23);//not work
		assertTrue("Find expected to retreive 23", v == 23);
		v = bt.find(2);
		assertTrue("Find expected to retreive 23", v == 2);
		v = bt.find(6);
		assertTrue("Find expected to retreive 23", v == 6);
		v = bt.find(22);
		assertTrue("Find expected to retreive 23", v == 22);
	}
}
