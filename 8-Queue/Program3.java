// Queue implementation using LinkedList

import java.util.Scanner;

class Node{

    int data;
    Node next;

    Node(int data){
        this.data = data;
    }
}

class Queue{

    Node front = null;
    Node rear = null;

    void enqueue(int data){
        Node newNode = new Node(data);

        if(front == null){
            front = newNode;
            rear = newNode;
        }else{
            rear.next = newNode;
            rear = newNode;
        }
    }

    boolean empty(){
        if (front == null) {
            return true;
        }else
            return false;
    }

    int deque(){

        int ret = front.data;
        if(front == rear){
            front = rear = null;
        }else{
            front = front.next;
        }
        return ret;
    }

    int front(){
        return front.data;
    }

    int rear(){
        return rear.data;
    }

    void printQueue(){

        rear = front;
        while (rear.next != null) {
            System.out.println(rear.data + " ");
            rear = rear.next;
        }
        System.out.println(rear.data);
    }
}

class Client{
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        char ch;
        Queue que = new Queue();

        do{
            System.out.println("Queue : LL");

            System.out.println("1.enqueue");
            System.out.println("2.deque");
            System.out.println("3.front");
            System.out.println("4.rear");
            System.out.println("5.empty");
            System.out.println("6.printQueue");

            System.out.println("Enter your choice");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter data");
                    int data = sc.nextInt();
                    que.enqueue(data);
                    break;
                
                case 2:
                    if(que.empty()){
                        System.out.println("Queue is empty");
                    }else{
                        int ret = que.deque();
                        System.out.println(ret + " removed");
                    }
                    break;
                
                case 3:
                    if (que.empty()) {
                        System.out.println("Queue is empty");
                    }else{
                        int ret = que.front();
                        System.out.println("Front " + ret);
                    }
                    break;

                case 4:
                    if (que.empty()) {
                        System.out.println("Queue is empty");
                    }else{
                        int ret = que.rear();
                        System.out.println("Rear " + ret);
                    }
                    break;

                case 5:
                    if (que.empty()) {
                        System.out.println("Queue is empty");
                    }else{
                        System.out.println("Queue is not empty");
                    }
                    break;

                case 6:
                    if (que.empty()) {
                        System.out.println("Queue is empty");
                    }else{
                        que.printQueue();
                    }
                    break;
                
                default:
                    System.out.println("Worng choice");
                    break;
            }

            System.out.println("Do you want to continue ?");
            ch = sc.next().charAt(0);

        }while(ch == 'y' || ch == 'Y');
    }
}
