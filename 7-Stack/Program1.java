import java.util.*;

class StackDemo {
    public static void main(String[] args) {
        Stack st = new Stack();

        st.push(10);
        st.push(20);
        st.push(30);

        System.out.println(st); // [10, 20, 30]

        System.out.println(st.pop());  // 30

        System.out.println(st);

        System.out.println(st.peek());

        System.out.println(st.empty());
    }
}

// Output
