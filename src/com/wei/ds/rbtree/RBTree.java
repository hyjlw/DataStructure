/**
 * 
 */
package com.wei.ds.rbtree;

/**
 * @author LL
 *
 */
public class RBTree {
	private static final boolean RED = false;
	private static final boolean BLACK = true;
	
	private Node root = null;
	private Node nullNode = null;
	
	public RBTree(){
		this.nullNode = new Node();
		this.root = nullNode;
		this.nullNode.left = root;
		this.nullNode.right = root;
		this.nullNode.parent = root;
		this.nullNode.color = BLACK;
	}
	
	public Node find(int key){
		Node index = root;
		while(index != nullNode){
			if(key < index.data){
				index = index.left;
			}else if(key > index.data){
				index = index.right;
			}else{
				break;
			}
		}
		return index;
	}
	
	public void insert(int data){
		Node insertPoint = nullNode;
		Node index = root;
		while(!index.equals(nullNode)){
			insertPoint = index;
			if(data < index.data){
				index = index.left;
			}else if(data > index.data){
				index = index.right;
			}else{
				break;
			}
		}
		Node insertNode = new Node();
		insertNode.data = data;
		insertNode.color = RED;
		insertNode.left = nullNode;
		insertNode.right = nullNode;
		
		if(insertPoint.equals(nullNode)){
			root = insertNode;
			root.parent = nullNode;
			nullNode.left = root;
			nullNode.right = root;
			nullNode.parent = root;
		}else{
			if(data < insertPoint.data){
				insertPoint.left = insertNode;
			}else{
				insertPoint.right = insertNode;
			}
			insertNode.parent = insertPoint;
		}
		insertFixUp(insertNode);
	}

	private void insertFixUp(Node node) {
		while(node.parent.color == RED){
			if(node.parent.equals(node.parent.parent.left)){
				Node uncle = node.parent.parent.right;
				//插入情况1，z的叔叔y是红色的
				if(uncle.color == RED){
					node.parent.color = BLACK;
					uncle.color = BLACK;
					node.parent.parent.color = RED;
					node = node.parent.parent;
				}
				//插入情况2：z的叔叔y是黑色的
				else if(uncle.color == BLACK){
					if(node.equals(node.parent.right)){ //且z是右孩子 
						node = node.parent;
						rotateLeft(node);
					}
					//插入情况3：z的叔叔y是黑色的，但z是左孩子
					else{
						node.parent.color = BLACK;
						node.parent.parent.color = RED;
						node = node.parent.parent;
						rotateRight(node);
					}
				}
			}
			//这部分是针对为插入情况1中，z的父亲现在作为祖父的右孩子的情况
			else{
				Node uncle = node.parent.parent.left;
				//插入情况1，z的叔叔y是红色的
				if(uncle.color == RED){
					node.parent.color = BLACK;
					uncle.color = BLACK;
					node.parent.parent.color = RED;
					node = node.parent.parent;
				}
				//插入情况2：z的叔叔y是黑色的
				else if(uncle.color == BLACK){
					if(node.equals(node.parent.right)){ //且z是右孩子 
						node = node.parent;
						rotateRight(node);
					}
					//插入情况3：z的叔叔y是黑色的，但z是左孩子
					else{
						node.parent.color = BLACK;
						node.parent.parent.color = RED;
						node = node.parent.parent;
						rotateLeft(node);
					}
				}
			}
		}
		root.color = BLACK;
	}
	
	public void delete(int key){
		Node deletePoint = find(key);
		if(deletePoint.equals(nullNode)){
			return;
		}
		if(deletePoint.left != nullNode && deletePoint.right != nullNode){
			Node successor = inOrderSuccessor(deletePoint);
			deletePoint.data = successor.data;
			deletePoint = successor;
		}
		Node deletePointChild;
		if(deletePoint.right != nullNode){
			deletePointChild = deletePoint.right;
		}else if(deletePoint.left != nullNode){
			deletePointChild = deletePoint.left;
		}else{
			deletePointChild = nullNode;
		}
		deletePointChild.parent = deletePoint.parent;
		
		if(deletePoint.parent.equals(nullNode)){
			root = deletePointChild;
			nullNode.parent = root;
			nullNode.left = root;
			nullNode.right = root;
		}else if(deletePoint.equals(deletePoint.parent.right)){
			deletePoint.parent.right = deletePointChild;
		}else{
			deletePoint.parent.left = deletePointChild;
		}
		
		if(deletePoint.color == BLACK && !(deletePointChild.equals(nullNode) && deletePointChild.parent.equals(nullNode))){
			deleteFixUp(deletePointChild);
		}
	}

	private void deleteFixUp(Node node) {
		while(node != root && node.color == BLACK){
			if(node.equals(node.parent.left)){
				Node brother = node.parent.right;
				//情况1：x的兄弟w是红色的
				if(brother.color == RED){
					brother.color = BLACK;
					node.parent.color = RED;
					rotateLeft(node.parent);
				}
				//情况2：x的兄弟w是黑色的
				else{
					 //且w的俩个孩子都是黑色的
					if(brother.left.color == BLACK && brother.right.color == BLACK){
						brother.color = RED;
						node = node.parent;
					}
					//情况3：x的兄弟w是黑色的，w的右孩子是黑色（w的左孩子是红色）
					else if(brother.right.color == BLACK){
						brother.color = RED;
						brother.left.color = BLACK;
						rotateRight(brother);
					}
					//情况4：x的兄弟w是黑色的，且w的右孩子时红色的
					else if(brother.right.color == RED){
						brother.color = node.parent.color;
						node.parent.color = BLACK;
						brother.right.color = BLACK;
						rotateLeft(node.parent);
						node = root;
					}
				}
			}
			//下述情况针对上面的情况1中，node作为右孩子而阐述的
			else{
				Node brother = node.parent.left;
				//情况1：x的兄弟w是红色的
				if(brother.color == RED){
					brother.color = BLACK;
					node.parent.color = RED;
					rotateRight(node.parent);
				}
				//情况2：x的兄弟w是黑色的
				else{
					 //且w的俩个孩子都是黑色的
					if(brother.left.color == BLACK && brother.right.color == BLACK){
						brother.color = RED;
						node = node.parent;
					}
					//情况3：x的兄弟w是黑色的，w的右孩子是黑色（w的左孩子是红色）
					else if(brother.right.color == BLACK){
						brother.color = RED;
						brother.left.color = BLACK;
						rotateLeft(brother);
					}
					//情况4：x的兄弟w是黑色的，且w的右孩子时红色的
					else if(brother.right.color == RED){
						brother.color = node.parent.color;
						node.parent.color = BLACK;
						brother.right.color = BLACK;
						rotateLeft(node.parent);
						node = root;
					}
				}
			}
		}
		nullNode.parent = root;
		node.color = BLACK;
	}

	private Node inOrderSuccessor(Node node) {
		if(node.equals(nullNode)){
			return nullNode;
		}
		Node result = node.left;
		while(!result.equals(nullNode)){
			if(!result.right.equals(nullNode)){
				result = result.right;
			}else{
				break;
			}
		}
		if(result.equals(nullNode)){
			Node index = node.parent;
			result = node;
			while(!index.equals(nullNode) && result.equals(index.left)){
				result = index;
				index = index.parent;
			}
			result = index;
		}
		return result;
	}

	private void rotateRight(Node node) {
		if(node.equals(nullNode) || node.right.equals(nullNode)){
			return;
		}
		Node lowerLeft = node.left;
		node.left = lowerLeft.left;
		lowerLeft.parent = node.parent;
		if(!lowerLeft.right.equals(nullNode)){
			lowerLeft.right.parent = node;
		}
		if(!node.parent.equals(nullNode)){
			root = lowerLeft;
			nullNode.left = root;
			nullNode.right = root;
			//nullNode.parent = root;
		}else{
			if(node.equals(node.parent.right)){
				node.parent.right = lowerLeft;
			}else{
				node.parent.left = lowerLeft;
			}
		}
		node.parent = lowerLeft;
		lowerLeft.right = node;
	}

	private void rotateLeft(Node node) {
		if(node.equals(nullNode) || node.right.equals(nullNode)){
			return;
		}
		Node lowerRight = node.right;
		lowerRight.parent = node.parent;
		node.right = lowerRight.left;
		
		if(!lowerRight.left.equals(nullNode)){
			lowerRight.left.parent = node;
		}
		if(node.parent.equals(nullNode)){
			root = lowerRight;
			nullNode.left = root;
			nullNode.right = root;
		}else{
			if(node.equals(node.parent.left)){
				node.parent.left = lowerRight;
			}else{
				node.parent.left = lowerRight;
			}
		}
		node.parent = lowerRight;
		lowerRight.left = node;
	}
	
}
