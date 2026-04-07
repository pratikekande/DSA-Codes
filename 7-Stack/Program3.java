// Stack implementation using LinkedList

import java.util.Scanner;

class Node{
    int data;
    Node next = null;

    Node(int data){
        this.data = data;
    }
}

class Stack{

    Node top = null;

    void push(int data){

        Node newNode = new Node(data);
        if(top == null){
            top = newNode;
        }else{
            newNode.next = top;
            top = newNode;
        }
    }

    boolean empty(){
        if(top == null){
            return true;
        }else
            return false;
    }

    int pop() {
        int val = top.data;
        top = top.next;
        return val;
    }

    int peek() {
        return top.data;
    }

    int size(){
        Node temp = top;
        int count = 0;
        while (temp != null) {          
            temp = temp.next;
            count++;
        }
        return count;

        // can also write like this
        // while (temp.next != null) {
        //     temp = temp.next;
        //     count++;
        // }
        // return count + 1;
    }

    void printStack(){

        if(empty()){
            System.out.println("Stack is empty");
            return;
        }
        Node temp = top;
        System.out.print("[");
        while (temp.next != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println(temp.data + " ]");
    }
}

class Client {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        Stack st = new Stack();

        char ch;
        do{
            System.out.println("Stack : LinkedList");

            System.out.println("1.push");
            System.out.println("2.pop");
            System.out.println("3.peek");
            System.out.println("4.empty");
            System.out.println("5.size");
            System.out.println("6.printStack");

            System.out.println("Enter your choice");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter data");
                    int data = sc.nextInt();
                    st.push(data);
                    break;
                
                case 2:
                    if(st.empty()){
                        System.out.println("Stack Undeflow");
                    }else{
                        int val = st.pop();
                        System.out.println(val + " popped");
                    }
                    break;
                
                case 3:
                    if(st.empty()){
                        System.out.println("Stack Undeflow");
                    }else{
                        int val = st.peek();
                        System.out.println("top element " + val);
                    }
                    break;

                case 4:
                    if(st.empty()){
                        System.out.println("Stack is empty");
                    }else{
                        System.out.println("Stack is not empty");
                    }
                    break;

                case 5:
                    int sz = st.size();
                    System.out.println("size :" + sz);
                    break;
                
                case 6:
                    st.printStack();
                    break;
                default:
                    System.out.println("Wrong Choice");
                    break;
            }

            System.out.println("Do you want to continue");
            ch = sc.next().charAt(0);
        }while(ch == 'y' || ch == 'Y');
    }
}
