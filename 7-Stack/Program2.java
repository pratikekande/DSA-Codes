// Stack implementation using Array

import java.util.Scanner;

class Stack{

    int maxSize;
    int top = -1;
    int stackArr[];

    Stack(int maxSize){
        this.maxSize = maxSize;
        stackArr = new int[maxSize];
    }

    void push(int data){
        if(top == maxSize -1){
            System.out.println("Stack overflow");
            return; // garaj nastey asa 
        }else{
            top++;
            stackArr[top] = data;
        }
    }

    boolean empty(){
        if(top == -1){
            return true;
        }else{
            return false;
        }
    }

    int pop() {
        
        // this is written for normal case
        // if(empty()){
        //     System.out.println("Stack Underflow");
        //     return -1;
        // }else{
        //     int val = stackArr[top];
        //     top--;
        //     return val;
        // }

        // this is for the data is -1
        int val = stackArr[top];
        top--;
        return val;
    }

    int peek() {
        if(empty()){
            System.out.println("Stack Underflow");
            return -1;
        }else{
            return stackArr[top];
        }
    }

    int size(){
        return top;
    }

    void printStack(){

        System.out.print("[");
        for(int i=top; i>=0; i--){
            System.out.print(stackArr[i] + ",");
        }
        System.out.print("]");
    }
}

class Client {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter stack size");
        int size = sc.nextInt();

        Stack st = new Stack(size);

        char ch;
        do{
            System.out.println("Stack : array");

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
                        System.out.println(val + "popped");
                    }
                    break;
                
                case 3:
                    int val = st.peek();
                    if(val != -1){
                        System.out.println(val);
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
                    System.out.println("size :" + (sz + 1));
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
