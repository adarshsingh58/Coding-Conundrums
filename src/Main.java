
public class Main {
	public static void main(String[] args) {
        Test binarySearchTree=new Test();
        binarySearchTree.add(50);
        binarySearchTree.add(30);
        binarySearchTree.add(70);
        binarySearchTree.add(20);
        binarySearchTree.add(40);
        binarySearchTree.add(60);
        binarySearchTree.add(80);
        binarySearchTree.add(32);
        binarySearchTree.add(65);
        binarySearchTree.add(75);
        binarySearchTree.add(85);
        binarySearchTree.add(34);
        binarySearchTree.add(36);

//        binarySearchTree.delete(30);
//        binarySearchTree.inOrderTraversal();// Inorder traversal of BST gives you sorted order.
//        binarySearchTree.BFSTraversal();
    }

    private static void printNode(Test binarySearchTree) {
        System.out.println(binarySearchTree.root.data);
    }
}
