/**
 * 
 */
package com.wei.ds.tree234;

/**
 * @author LL
 *
 */
public class Node {
	private static final int ORDER = 4;
	private int nItems;
	private Node parent;
	private Node childArray[] = new Node[ORDER];
	private DataItem []itemArray = new DataItem[ORDER - 1];
	
	public void connectChild(int childNum, Node child){
		childArray[childNum] = child;
		if(child!=null){
			child.parent = this;
		}
	}
	
	public Node disconnectChild(int childNum){
		Node tempNode = childArray[childNum];
		childArray[childNum] = null;
		return tempNode;
	}
	
	public Node getChild(int childNum){
		return childArray[childNum];
	}
	
	public Node getParent(){
		return parent;
	}
	
	public boolean isLeaf(){
		return childArray[0] == null ? true : false;
	}
	
	public int getNumItems(){
		return nItems;
	}
	
	public DataItem getItem(int index){
		return itemArray[index];
	}
	
	public boolean isFull(){
		return nItems == ORDER - 1 ? true : false;
	}
	
	public int findItem(int key){
		for(int j=0; j<ORDER - 1; j++){
			if(itemArray[j] == null){
				break;
			} else if(itemArray[j].data == key){
				return j;
			}
		}
		return -1;
	}
	
	public int insertItem(DataItem newItem){
		nItems++;
		int newKey = newItem.data;
		for(int j=ORDER - 2; j>=0; j--){
			if(itemArray[j] == null){
				continue;
			}else{
				int itsKey = itemArray[j].data;
				if(newKey < itsKey){
					itemArray[j+1] = itemArray[j];
				}else{
					itemArray[j+1] = newItem;
					return j+1;
				}
			}
		}
		itemArray[0] = newItem;
		return 0;
	}
	
	public DataItem removeItem(){
		DataItem temp = itemArray[nItems - 1];
		itemArray[nItems - 1] = null;
		nItems--;
		return temp;
	}
	
	public void display(){
		for(int j=0; j<nItems; j++){
			itemArray[j].display();
		}
		System.out.println();
	}
}
