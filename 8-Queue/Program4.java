// CircularQueue implementation using Array, CircularQueue is only present in Array

import java.util.Scanner;

class CircularQueue{

    int dequeArr[];
    int front;
    int rear;
    int maxSize;

    CircularQueue(int maxSize){
        dequeArr = new int[maxSize];
        this.maxSize = maxSize;
        this.front = -1;
        this.rear = -1;
    }

    void enqueue(int data){
        if((front == 0 && rear == maxSize-1) || ((rear+1)%maxSize == front)){
            System.out.println("Queue is full");
            return;
        }else if(front == -1){
            front = rear = 0;
        }else if(rear == maxSize-1 && front != 0){
            rear = 0;
        }else{
            rear++;
        }
        dequeArr[rear] = data;
    }

    boolean empty(){
        if (front == -1) {
            return true;
        }else
            return false;
    }

    int deque(){

        int ret = dequeArr[front];
        if(front == rear){
            rear = front - 1;
        }else if(front == maxSize-1){
            front = 0;
        }else{
            front++;
        }
        return ret;
    }

    int front(){
        return dequeArr[front];
    }

    int rear(){
        return dequeArr[rear];
    }

    void printQueue(){

        if(front <= rear){
            for(int i=front; i<=rear; i++){
                System.out.print(dequeArr[i] + " ");
            }
        }else{
            for(int i=front; i<maxSize; i++){
                System.out.print(dequeArr[i] + " ");
            }

            for(int i=0; i<=rear; i++){
                System.out.print(dequeArr[i] + " ");
            }
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

        CircularQueue cque = new CircularQueue(size);

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
                    cque.enqueue(data);
                    break;
                
                case 2:
                    if(cque.empty()){
                        System.out.println("Queue is empty");
                    }else{
                        int ret = cque.deque();
                        System.out.println(ret + " removed");
                    }
                    break;
                
                case 3:
                    if (cque.empty()) {
                        System.out.println("Queue is empty");
                    }else{
                        int ret = cque.front();
                        System.out.println("Front " + ret);
                    }
                    break;

                case 4:
                    if (cque.empty()) {
                        System.out.println("Queue is empty");
                    }else{
                        int ret = cque.rear();
                        System.out.println("Rear " + ret);
                    }
                    break;

                case 5:
                    if (cque.empty()) {
                        System.out.println("Queue is empty");
                    }else{
                        System.out.println("Queue is not empty");
                    }
                    break;

                case 6:
                    if (cque.empty()) {
                        System.out.println("Queue is empty");
                    }else{
                        cque.printQueue();
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
