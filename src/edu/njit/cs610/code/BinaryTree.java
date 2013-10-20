package edu.njit.cs610.code;

public class BinaryTree<K extends Comparable<K>, V> {

	public BinaryTree()
	{
		root = null;
		size = 0;
	}
	
	public int size()
	{
		return size;
	}
	
	public void insert(K k, V v)
	{
		if(root == null) //Nothing in the tree
		{
			root = new Node(k, v);
		}
		else //At least a root
		{
			insertNode(root, k, v);
		}
		size++; //Increase size by 1
	}
	
	protected void insertNode(Node n, K k, V v)
	{
		if(n.key.compareTo(k) > 0) //assume to be greater than
		{
			n.sizeLeftST++;
			if(n.leftChild == null)
			{
				n.leftChild = new Node(k, v);
			}
			else
			{
				insertNode(n.leftChild, k, v);
			}
		}
		else if(n.key.compareTo(k) < 0) //assume to be less than
		{
			n.sizeRightST++;
			if(n.rightChild == null)
			{
				n.rightChild = new Node(k, v);
			}
			else
			{
				insertNode(n.rightChild, k, v);
			}
		}
		else //equal key values
		{
			//Already in the tree
			//n = new Node(k, v);
		}
	}
	
	public V find(K k)
	{
		if(root == null) //No nodes to search
		{
			return null;
		}
		else //search the nodes
		{
			Node temp = findNode(root, k);
			return temp.value;
		}
	}
	
	protected Node findNode(Node n, K k)
	{
		if(n == null)//Not found
		{
			return null;
		}
		else
		{
			if(n.key.compareTo(k) > 0) //assume to be greater than
			{
				return findNode(n.leftChild, k);
			}
			else if(n.key.compareTo(k) < 0) //assume to be less than
			{
				return findNode(n.rightChild, k);
			}
			else //equal key values
			{
				return n;
			}
		}
	}
	
	public void remove(K k)
	{
		if(root != null)
		{
			Node delete = findNode(root, k);
			if(delete != null) //A node was found and can be removed from the tree
			{
				if(delete.leftChild == null && delete.rightChild == null) //no children
				{
					delete = null; //Replaces the delete node with a null value
				}
				else if(delete.leftChild == null) //only has a right child value
				{
					delete = delete.rightChild;
					//replaceNode(delete, delete.rightChild);
				}
				else if(delete.rightChild == null) //only has a left child value
				{
					delete = delete.leftChild;
					//replaceNode(delete, delete.leftChild);
				}
				else //has two children
				{
					Node rm;
					/*
					 * Find either the right most node in left subtree
					 * or left most node in right subtree
					 */
					if(delete.sizeLeftST > delete.sizeRightST)
					{
						rm = findRightMost(delete.leftChild);
					}
					else
					{
						rm = findLeftMost(delete.rightChild);
					}
					replaceNode(delete, rm);
				}
				size--;
			}
		}
	}
	
	protected Node findRightMost(Node n)
	{
		while(n.rightChild != null)
		{
			n = n.rightChild;
		}
		return n;
	}
	
	protected Node findLeftMost(Node n)
	{
		while(n.leftChild != null)
		{
			n = n.leftChild;
		}
		return n;
	}
	
	protected Node findParent(Node n, Node child)
	{
		if(child == root)
		{
			return root;
		}
		else
		{
			if(n.leftChild.key.compareTo(child.key) == 0 || n.rightChild.key.compareTo(child.key) == 0) 
			{
				return n;
			}
			else if(n.key.compareTo(child.key) > 0) //Go to the left
			{
				findParent(n.leftChild, child);
			}
			else  //Go to the right
			{
				findParent(n.rightChild, child);
			}
		}
		return null;
	}
	
	protected void replaceNode(Node target, Node replacement)
	{
		//Node parent = findParent(root, target);
		target.key = replacement.key;
		target.value = replacement.value;
		if(replacement.rightChild == null) //target is the right-most child
		{
			replacement = replacement.leftChild;
		}
		else //target is the left-most child
		{
			replacement = replacement.rightChild;
		}
		
	}
	
	public void printInOrder()
	{
		printInOrder(root);
	}
	
	protected void printInOrder(Node n)
	{
		if(n.leftChild != null)
		{
			printInOrder(n.leftChild);
		}
		System.out.print(n.value + " ");
		if(n.rightChild != null)
		{
			printInOrder(n.rightChild);
		}
	}
	
	private Node root;
	private int size;
	
	private class Node
	{
		private Node(K k, V v)
		{
			value = v;
			key = k;
			leftChild = null;
			rightChild = null;
			sizeLeftST = 0;
			sizeRightST = 0;
		}
		
		private K key;
		private V value;
		private Node leftChild;
		private Node rightChild;
		private int sizeLeftST;
		private int sizeRightST;
	}
}
