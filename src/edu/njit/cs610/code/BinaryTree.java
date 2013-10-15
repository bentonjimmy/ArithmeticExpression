package edu.njit.cs610.code;

public class BinaryTree<T> {

	BinaryTree()
	{
		root = null;
	}
	
	public void insert(T t)
	{
		if(root == null)
		{
			root = new Node<T>(t);
		}
		else
		{
			
		}
	}
	
	public T find(T t)
	{
		return null;
	}
	
	public void delete(T t)
	{
		
	}
	
	private Node<T> root;
	
	private class Node<T>
	{
		private Node(T t)
		{
			value = t;
		}
		
		private T value;
		private T leftChild;
		private T rightChild;
	}
}
