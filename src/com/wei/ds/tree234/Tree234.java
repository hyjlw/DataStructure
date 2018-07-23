/**
 * 
 */
package com.wei.ds.tree234;

/**
 * @author LL
 *
 */
public class Tree234 {
	private Node root = new Node();
	
	public int find(int key){
		Node curNode = root;
		int childNum;
		while(true){
			if((childNum = curNode.findItem(key)) != -1){
				return childNum;
			}else if(curNode.isLeaf()){
				return -1;
			}else{
				curNode = getNextChild(curNode, key);
			}
		}
	}
	
	public void insert(int value){
		Node curNode = root;
		DataItem tempItem = new DataItem(value);
		
		while(true){
			if(curNode.isFull()){
				split(curNode);
				curNode = curNode.getParent();
				curNode = getNextChild(curNode, value);
			}else if(curNode.isLeaf()){
				break;
			}else{
				curNode = getNextChild(curNode, value);
			}
		}
		curNode.insertItem(tempItem);
	}

	private void split(Node theNode) {
		DataItem itemB, itemC;
		Node parent, child2, child3;
		int itemIndex;
		
		itemC = theNode.removeItem();
		itemB = theNode.removeItem();
		child2 = theNode.disconnectChild(2);
		child3 = theNode.disconnectChild(3);
		Node newRight = new Node();
		
		if(theNode == root){
			root = new Node();
			parent = root;
			root.connectChild(0, theNode);
		}else{
			parent = theNode.getParent();
		}
		itemIndex = parent.insertItem(itemB);
		int n = parent.getNumItems();
		
		for(int j=n-1; j>itemIndex; j--){
			Node temp = parent.disconnectChild(j);
			parent.connectChild(j+1, temp);
		}
		parent.connectChild(itemIndex+1, newRight);
		newRight.insertItem(itemC);
		newRight.connectChild(0, child2);
		newRight.connectChild(1, child3);
	}

	public Node getNextChild(Node theNode, int key) {
		int j;
		int nItems = theNode.getNumItems();
		for(j=0;j<nItems;j++){
			if(key<theNode.getItem(j).data){
				return theNode.getChild(j);
			}
		}
		return theNode.getChild(j);
	}
	
	public void display(){
		recDisplay(root, 0, 0);
	}

	private void recDisplay(Node theNode, int level, int childNum) {
		System.out.print("Level=" + level + ", child=" + childNum + " ");
		theNode.display();
		int nItems = theNode.getNumItems();
		for(int j=0; j<nItems + 1; j++){
			Node nextNode = theNode.getChild(j);
			if(nextNode != null){
				recDisplay(nextNode, level + 1, j);
			}else{
				return;
			}
		}
	}
}
