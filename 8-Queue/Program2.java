// Queue implementation using Array

import java.util.Scanner;

class Queue{

    int queueArr[];
    int front = -1;
    int rear = -1;
    int maxSize;

    Queue(int maxSize){
        queueArr = new int[maxSize];
        this.maxSize = maxSize;
    }

    void enqueue(int data){
        if(rear == maxSize-1){
            System.out.println("Queue is full");
            return;
        }
        if(front == -1){
            front = rear = 0;
        }else{
            rear++;
        }
        queueArr[rear] = data;
    }

    boolean empty(){
        if (front == -1) {
            return true;
        }else
            return false;
    }

    int deque(){

        int val = queueArr[front];
        front++;
        if(front > rear){
            front = rear = -1;
        }
        return val;
    }

    int front(){
        return queueArr[front];
    }

    int rear(){
        return queueArr[rear];
    }

    void printQueue(){

        for(int i=front; i<=rear; i++){
            System.out.print(queueArr[i] + " ");
        }
        System.out.println();
    }
}

class Client{
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Queue size");
        int size = sc.nextInt();

        char ch;

        Queue que = new Queue(size);

        do{
            System.out.println("Queue : array");

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
