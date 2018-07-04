package src.main.bst.createbst;


public class BinarySearchTree {

	Node root;
	
	/*
	 * Insert elements and construct BST
	 */
	void insertNode(int key){
		root = insertElement(root, key);
	}
	
	public Node insertElement(Node node, int key){
		
		if(node == null){
			return new Node(key);
		}
		if(key<node.key){
			node.left = insertElement(node.left, key);
		}
		if(key>node.key){
			node.right = insertElement(node.right, key);
		}
		
		return node;
	}
	
	/*
	 * Delete given node from BST
	 */
	void deleteNode(Node root, int key){
		deleteNodeRec(root, key);
	}
	
	Node deleteNodeRec(Node root, int key){
		
		if(root == null){
			return root;
		}
		if(key<root.key){
			root.left = deleteNodeRec(root.left, key);
		}
		else if(key>root.key){
			root.right = deleteNodeRec(root.right, key);
		}
		else{
			if(root.left == null)
				return root.right;
			if(root.right == null)
				return root.left;
			root.key = findMin(root.right);
			root.right = deleteNodeRec(root.right, root.key);
		}
		return root;
	}
	
	
	
	/*
	 * Find min value node in BST
	 */
	int findMin(Node root){
		int minValue = root.key;
		while(root.left != null){
			minValue = root.left.key;
			root = root.left;
		}
		return minValue;
	}

	/*
	 * BST in order traverse or print all BST nodes in ASC order
	 */
	void inorderTraverse(){
		inOrderTraversal(root);
	}
	
	void inOrderTraversal(Node root){
		
		if(root == null){
			return;
		}else{
			inOrderTraversal(root.left);
			System.out.println(root.key+ " ");
			inOrderTraversal(root.right);
		}
	}
	
	/*
	 * Print all nodes of BST in DESC order
	 */
	void reverseInorderTraverse(Node root){
		
		if(root == null){
			return;
		}else{
			reverseInorderTraverse(root.right);
			System.out.println(root.key + " ");
			reverseInorderTraverse(root.left);;
		}
	}
	
	
	int minValue(Node root){
		
		if(root == null){
			return 0;
		}
		int minValue = root.key; 
		while(root.left!= null){
			minValue = root.left.key;
			root = root.left;
		}
		return minValue;
	}
	
	
	
	/*
	 * Find predecessor of given node in a BST
	 * Desc :- Predecessor : max node in left tree of given node 
	 * Find successor for given node in a BST
	 * Desc :- Successor : min right node of given node
	 */
	void findPredesAndSuccessor(Node root, int key){
		
		if(root == null){
			return;
		}
		if(key == root.key){
//			right most node of root's left node
			if(root.left!=null){
				System.out.println("Predessor value is --> "+findPredessor(root.left));
			}else{
				System.out.println("Predessor value is --> "+root.left.key);
			}
			
//			left most node of root's right node
			if(root.right!=null){
				System.out.println("Successor value is --> "+findSuccessor(root.right));
			}else{
				System.out.println("Successor value is --> "+root.right.key);
			}
			
		}
		if(key<root.key){
			findPredesAndSuccessor(root.left, key);
		}
		if(key>root.key){
			findPredesAndSuccessor(root.right, key);
		}
	}
	
	int findPredessor(Node root){
		
		int rightMost = root.key;
		while(root.right!=null){
			rightMost = root.right.key;
			root = root.right;
		}
		return rightMost;
	}
	int findSuccessor(Node root){
		
		int leftMost = root.key;
		while(root.left!=null){
			leftMost = root.left.key;
			root = root.left;
		}
		return leftMost;
	}
	
	
	
	/*
	 * K'th smallest element in BST. It's not working now. need to look into this again
	 */
	
	void findKthElement(Node root, int k){
		Level index = new Level(0);
		kthSmallestElementRec(root, k, index);
	}
	
	void kthSmallestElementRec(Node root, int k, Level index){
		
		if(root == null){
			return;
		}else{
			kthSmallestElementRec(root.left, k, index);
			index.kthElement = index.kthElement+1;
			if(index.kthElement==k){
				System.out.println("Kth elements in the BST is --> "+root.key);
			}
			kthSmallestElementRec(root.right, k, index);
		}
		
	}
}
