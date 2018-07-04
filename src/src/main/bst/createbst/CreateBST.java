package src.main.bst.createbst;

import javax.swing.text.LabelView;

public class CreateBST {
	
	public static void main(String[] args) {
		
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		binarySearchTree.insertNode(20);
		binarySearchTree.insertNode(40);
		binarySearchTree.insertNode(24);
		binarySearchTree.insertNode(2);
		binarySearchTree.insertNode(22);
		binarySearchTree.insertNode(12);
		binarySearchTree.insertNode(23);
		binarySearchTree.insertNode(60);
		
		System.out.println("************Inorder traversal************");
		binarySearchTree.inOrderTraversal(binarySearchTree.root);
		System.out.println("Min value is BST is --> "+ binarySearchTree.minValue(binarySearchTree.root));
		
		binarySearchTree.findPredesAndSuccessor(binarySearchTree.root, 20);
		
		
		
		System.out.println("************Kth elements in the BST****************");
		binarySearchTree.findKthElement(binarySearchTree.root, 3);
		
//		System.out.println("************Reverse traversal************");
//		binarySearchTree.reverseInorderTraverse(binarySearchTree.root);
		
//		binarySearchTree.deleteNode(binarySearchTree.root, 23);
//		System.out.println("*********Inorder traversal after deletion********");
//		binarySearchTree.inorderTraverse();
		
		
		
		
	}

}
