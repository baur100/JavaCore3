package interviewQuestions;


public class Algorithm {
    public static void main(String[] args) {
        System.out.println("Algorithm");
///////////////         FizzBuzz

//        for (var i = 1; i < 100; i++) {
//            fizzBuzz(i);
//        }
/////////////         GetReminder

//        int reminder = getReminder(5,5);
//        int reminder1 = getReminder(5,6);
//        System.out.println("Reminder = " +reminder);

/////////////      Swap 2 variables
//        int a =10;
//        int b=20;
//        a = a+b;
//        b = a-b;
//        a = a-b;

//        Lucky String "tyuiuyt"
        String str = "tyuiuyt";
        if(isLucky(str)){
            System.out.println("Lucky "+str);
        } else {
            System.out.println("Not Lucky "+str);
        }

    }

    private static boolean isLucky(String str) {
        String reverse="";
        for (var i=str.length()-1; i>=0; i--){
            reverse+=str.charAt(i);
        }
        for (var i=0;i<str.length();i++){
            if(str.charAt(i)!=reverse.charAt(i)){
                return false;
            }
        }
        return true;
    }

    private static int getReminder(int c, int d){
        int x=c/d;
        return c-x*d;

    }

    private static int getReminder1(int a, int b) {
        boolean condition = true;
        if (a<b){
            return a;
        }
        while (condition){
            a=a-b;
            if (a<b){
                condition=false;
            }
        }
        return a;
    }

    private static void fizzBuzz(int i) {
        if (i % 3 == 0 && i % 5 == 0) {
            System.out.println(i + " FizzBuzz");
        } else if (i % 3 == 0) {
            System.out.println(i + " Fizz");
        }
        if (i % 5 == 0) {
            System.out.println(i + " Buzz");
        }
    }
}
