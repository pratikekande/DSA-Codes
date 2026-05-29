import java.util.Scanner;

class Node{

    Node left = null;
    int data;
    Node right = null;

    Node(int data){
        this.data = data;
    }
}

class BinaryTree{

    Scanner sc = new Scanner(System.in);
    Node constructBT(){

        System.out.println("Enter data for node");
        int data = sc.nextInt();

        Node newNode = new Node(data);

        System.out.println("Do you want to add node at left? of " + newNode.data);
        char leftNode = sc.next().charAt(0);

        if(leftNode == 'y' || leftNode == 'Y'){
            newNode.left = constructBT();
        }

        System.out.println("Do you want to add node at right? of " + newNode.data);
        char rightNode = sc.next().charAt(0);

        if(rightNode == 'y' || rightNode == 'Y'){
            newNode.right = constructBT();
        }

        return newNode;
    }

    void preOrder(Node root){
        if(root == null)
            return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    void inOrder(Node root){
        if(root == null)
            return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    void postOrder(Node root){
        if(root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
        
    }

    int countNode(Node root){

        if(root == null)
            return 0;

        int leftStCount = countNode(root.left);
        int rightSTCount = countNode(root.right);

        return leftStCount + rightSTCount + 1; 
    }
}

class Client{
    public static void main(String[] args) {
        
        Node root = null;
        BinaryTree bt = new BinaryTree();
        root = bt.constructBT();

        System.out.println("PreOrder Traversal");
        bt.preOrder(root);
        System.out.println();

        System.out.println("InOrder Traversal");
        bt.inOrder(root);
        System.out.println();

        System.out.println("PostOrder Traversal");
        bt.postOrder(root);
        System.out.println();

        int  count = bt.countNode(root);
        System.out.println("Node count " + count);
    }
}