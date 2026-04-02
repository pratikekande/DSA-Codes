class Rec5{

    static int reverse(int n, int rev){
        if(n==0)
            return rev;

        return reverse(n/10, rev*10 + (n%10));
    }

    public static void main(String[] args) {
        int n = 122;
        int ans = reverse(n, 0);

        if(n == ans)
            System.out.println("palindrome");
        else
            System.out.println("not");
    }
}

