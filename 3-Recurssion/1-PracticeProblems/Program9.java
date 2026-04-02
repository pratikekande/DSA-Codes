class Rec9 {

  static int sum = 0;
  static int SumOfDigit(int num) {
    if(num == 0)
        return 0;

    // int rem = num % 10;
    // sum = sum + rem;
    // //num = num / 10;
    // SumOfDigit(num/10);

    return num%10 + SumOfDigit(num/10);
  }

  public static void main(String[] args){
    System.out.println(SumOfDigit(123));
  }
}
