package edu.njit.cs610.code;

public class BinaryTree<K extends Comparable<K>, V> {

	BinaryTree()
	{
		root = null;
		size = 0;
	}
	
	public void insert(K k, V v)
	{
		if(root == null) //Nothing in the tree
		{
			root = new Node<K, V>(k, v);
		}
		else //At least a root
		{
			insertNode(root, k, v);
		}
		size++; //Increase size by 1
	}
	
	protected void insertNode(Node<K, V> n, K k, V v)
	{
		if(n == null)
		{
			n = new Node<K, V>(k,v);
		}
		else
		{
			if(n.key.compareTo(k) < 0) //assume to be greater than
			{
				insertNode(n.leftChild, k, v);
			}
			else if(n.key.compareTo(k) > 0) //assume to be less than
			{
				insertNode(n.rightChild, k, v);
			}
			else //equal key values
			{
				n = new Node<K, V>(k, v);
			}
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
			Node<K,V> temp = findNode(root, k);
			return temp.value;
		}
	}
	
	protected Node<K,V> findNode(Node<K,V> n, K k)
	{
		if(n == null)//Not found
		{
			return null;
		}
		else
		{
			if(n.key.compareTo(k) < 0) //assume to be greater than
			{
				findNode(n.leftChild, k);
			}
			else if(n.key.compareTo(k) > 0) //assume to be less than
			{
				findNode(n.rightChild, k);
			}
			else //equal key values
			{
				return n;
			}
		}
		return null;
	}
	
	public void remove(K k)
	{
		if(root == null)
		{
			//nothing in tree to delete
		}
		else
		{
			Node<K,V> delete = findNode(root, k);
			if(delete != null) //A node was found and can be removed from the tree
			{
				Node<K,V> parent = findParent(root, k);
				if(delete.leftChild == null && delete.rightChild == null) //no children
				{
					if(parent.leftChild.key.compareTo(delete.key) == 0) //it's parents left child
					{
						parent.leftChild = null;
					}
					else//it's the parents right child
					{
						parent.rightChild = null;
					}
				}
				else if(delete.leftChild == null) //only has a right child value
				{
					if(parent.leftChild.key.compareTo(delete.key) == 0) //it's parents left child
					{
						parent.leftChild = delete.rightChild;
					}
					else//it's the parents right child
					{
						parent.rightChild = delete.rightChild;
					}
				}
				else if(delete.rightChild == null) //only has a left child value
				{
					if(parent.leftChild.key.compareTo(delete.key) == 0) //it's parents left child
					{
						parent.leftChild = delete.leftChild;
					}
					else//it's the parents right child
					{
						parent.rightChild = delete.leftChild;
					}
				}
				else //has two children
				{
					/*
					 * Find either the right most node in left subtree
					 * or left most node in right subtree
					 */
				}
			}
		}
	}
	
	protected Node<K,V> findParent(Node<K,V> n, K k)
	{
		if(n.leftChild.key.compareTo(k) == 0 || n.rightChild.key.compareTo(k) == 0) 
		{
			return n;
		}
		else if(n.key.compareTo(k) < 0) //assume to be greater than
		{
			findParent(n.leftChild, k);
		}
		else //assume to be less than
		{
			findParent(n.rightChild, k);
		}
		return null;
	}
	
	private Node<K, V> root;
	private int size;
	
	private class Node<K, V>
	{
		private Node(K k, V v)
		{
			value = v;
			key = k;
			leftChild = null;
			rightChild = null;
		}
		
		private K key;
		private V value;
		private Node<K,V> leftChild;
		private Node<K,V> rightChild;
	}
}
