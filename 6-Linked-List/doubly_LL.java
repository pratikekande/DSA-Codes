import java.util.Scanner;

class Node{

    Node prev = null;
    int data;
    Node next = null;

    Node(int data){
        this.data = data;
    }
}

class DoublyLinkedList{

    Node head = null;

    // ADD FIRST
    void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        } else{
            newNode.next = head;
            head = newNode;
            newNode.next.prev = newNode;   // Can also use head.next.prev = head;

            // can also write as 
            // head.prev = newNode;
            // newNode.next = head;
            // head = newNode;
        }
    }

    // ADD LAST
    void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        } else{
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    // COUNT NODE
    int countNode(){
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // INSERT AT POSITION
    void addAtPos(int pos, int data){
        int n = countNode();

        if(pos <= 0 || pos > n+1){
            System.out.println("Wrong Input for position");
            return;
        }

        if(pos == 1){
            addFirst(data);
        } else if(pos == n+1){
            addLast(data);
        }else{
            Node newNode = new Node(data);
            Node temp = head;
            while (pos-2 != 0) {  // can also write pos-1 != 1 
                temp = temp.next;
                pos--;
            }
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next = newNode;
            newNode.next.prev = newNode;
        }
    }

    // DELETE FIRST
    void deleteFirst(){
        if(head == null){
            System.out.println("Node is not present for deletion");
        } 
        if(countNode() == 1){
            head = null;
        }else{
            head = head.next;
            head.prev = null;
        }
    }

    // DELETE LAST
    void deleteLast(){
        if(head == null){
            System.out.println("Node is not present for deletion");
            return;
        }

        if(countNode() == 1){
            head = null;
        }else{
            Node temp = head;

            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next.prev = null;
            temp.next = null;
        }
    }

    // DELETE AT POSITION
    void deleteAtPos(int pos){
        int n = countNode();

        if(pos <= 0 || pos > n){
            System.out.println("Wrong Input for position");
            return;
        }

        if(pos == 1){
            deleteFirst();
        } else if(pos == n){
            deleteLast();
        }else{
            Node temp = head;
            while (pos-2 != 0) {
                temp = temp.next;
                pos--;
            }
            temp.next = temp.next.next;

            // Extra operations, if not done it's ok
            // temp.next.prev.prev = null;   
            // temp.next.prev.next = null;

            temp.next.prev = temp;
        }
    }

    // PRINT LINKED LIST
    void printLinkedList(){
        if(head == null){
            System.out.println("DoublyLinkedList is empty");
            return;
        } else{
            Node temp = head;
            while (temp.next != null) {
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
            System.out.println(temp.data);
        }
    }
}

class Client{

    public static void main(String[] args) {
        
        DoublyLinkedList ll = new DoublyLinkedList(); 

        char ch;

        do{
            System.out.println("Doubly LinkedList");
            System.out.println("1. Add First");
            System.out.println("2. Add Last");
            System.out.println("3. Add at Position");
            System.out.println("4. Delete First");
            System.out.println("5. Delete Last");
            System.out.println("6. Delete at Postion");
            System.out.println("7. Count Node");
            System.out.println("8. Print LinkedList");

            System.out.println("Enter your choice :");

            Scanner sc = new Scanner(System.in);

            int choice = sc.nextInt();

            switch (choice) {
                case 1:{
                        System.out.println("Enter data");
                        int data = sc.nextInt();
                        ll.addFirst(data);
                    }   
                    break;
                case 2:{
                        System.out.println("Enter data");
                        int data = sc.nextInt();
                        ll.addLast(data);
                    }     
                    break;
                case 3:{
                        System.out.println("Enter data");
                        int data = sc.nextInt();
                        System.out.println("Enter Position");
                        int pos = sc.nextInt();
                        ll.addAtPos(pos, data);
                    }     
                    break;
                case 4:
                    ll.deleteFirst();
                    break;
                case 5:
                    ll.deleteLast();
                    break;
                case 6:{
                        System.out.println("Enter Position");
                        int pos = sc.nextInt();
                        ll.deleteAtPos(pos);
                    }     
                    break;
                case 7:
                    ll.countNode();
                    break;
                case 8:
                    ll.printLinkedList();
                    break;
                default:
                    System.out.println("Wrong Input");
            }

            System.out.println("Do you want to continue?");
            ch = sc.next().charAt(0);
        }while(ch == 'y' || ch == 'Y');

        // ll.printLinkedList();

        // ll.addFirst(30);
        // ll.addFirst(20);
        // ll.addFirst(10);
        // ll.printLinkedList();

        // ll.addLast(40);
        // ll.printLinkedList();

        // ll.addAtPos(2, 25);
        // ll.printLinkedList();

        // ll.deleteFirst();
        // ll.printLinkedList();

        // ll.deleteLast();

        // ll.deleteAtPos(2);
        // ll.printLinkedList();
    }
}
