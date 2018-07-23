/**
 * 
 */
package com.wei.ds.tree;

import java.util.Stack;

/**
 * @author LL
 *
 */
public class BinaryTree {
	private Node root;
	
	public BinaryTree(){
		root = null;
	}
	
	public Node find(int key){
		Node current = root;
		while(current.data != key){
			if(key < current.data){
				current = current.leftChild;
			} else {
				current = current.rightChild;
			}
			if(current == null){
				return null;
			}
		}
		return current;
	}
	
	public void insert(int data){
		Node newNode = new Node(data);
		if(root == null){
			root = newNode;
		} else {
			Node current = root;
			Node parent;
			while(true){
				parent = current;
				if(data < current.data){
					current = current.leftChild;
					if(current == null){
						parent.leftChild = newNode;
						return;
					}
				} else {
					current = current.rightChild;
					if(current == null){
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}
	
	public boolean delete(int key){
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;
		
		while(current.data != key){
			parent = current;
			if(key < current.data){
				isLeftChild = true;
				current = current.leftChild;
			}else{
				isLeftChild = false;
				current = current.rightChild;
			}
			if(current == null){
				return false;
			}
		}
		
		if(current.leftChild == null && current.rightChild == null){
			if(current == root){
				root = null;
			}else if(isLeftChild){
				parent.leftChild = null;
			}else{
				parent.rightChild = null;
			}
		} else if(current.rightChild == null){
			if(current == root){
				root = current.leftChild;
			}else if(isLeftChild){
				parent.leftChild = current.leftChild;
			} else{
				parent.rightChild = current.leftChild;
			}
		}else if(current.leftChild == null){
			if(current == root){
				root = current.rightChild;
			}else if(isLeftChild){
				parent.leftChild = current.rightChild;
			}else{
				parent.rightChild = current.rightChild;
			}
		}else{
			Node successor = getSuccessor(current);
			if(current == root){
				root = successor;
			}else if(isLeftChild){
				parent.leftChild = successor;
			}else{
				parent.rightChild = successor;
			}
			successor.leftChild = current.leftChild;
		}
		return true;
	}
	
	private Node getSuccessor(Node delNode) {
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild;
		while(current != null){
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}
		if(successor != delNode.rightChild){
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		return successor;
	}

	public void displayTree(){
		Stack<Node> globalStack = new Stack<Node>();
		globalStack.push(root);
		int nBlanks = 8;
		boolean isRowEmpty = false;
		System.out.println("-------------");
		while(!isRowEmpty){
			Stack<Node> localStack = new Stack<Node>();
			isRowEmpty = true;
			for(int j = 0; j < nBlanks; j++){
				System.out.println(' ');
			}
			while(globalStack.isEmpty() == false){
				Node temp = (Node) globalStack.pop();
				if(temp != null){
					System.out.print(temp.data);
					localStack.push(temp.leftChild);
					localStack.push(temp.rightChild);
					
					if(temp.leftChild != null || temp.rightChild != null){
						isRowEmpty = false;
					}
				} else {
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for(int j=0; j < nBlanks * 2 - 2; j++){
					System.out.print(' ');
				}
			}
			System.out.println();
			nBlanks /= 2;
			while(!localStack.isEmpty()){
				globalStack.push(localStack.pop());
			}
		}
		System.out.println("-------------");
	}
	
	public void traverse(int type){
		switch(type){
		case 1:
			System.out.println("\nPreOrder traversal:");
			preOrder(root);
			break;
		case 2:
			System.out.println("\nInOrder traversal:");
			inOrder(root);
			break;
		case 3:
			System.out.println("\nPostOrder traversal:");
			postOrder(root);
			break;
		default:
			break;
		}
		System.out.println();
	}

	private void postOrder(Node localRoot) {
		if(localRoot != null){
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			System.out.print(localRoot.data + " ");
		}
	}

	private void inOrder(Node localRoot) {
		if(localRoot != null){
			inOrder(localRoot.leftChild);
			System.out.print(localRoot.data + " ");
			inOrder(localRoot.rightChild);
		}
	}

	private void preOrder(Node localRoot) {
		if(localRoot != null){
			System.out.print(localRoot.data + " ");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}
}
