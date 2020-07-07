package interviewQuestions;


public class Algorithm {
    public static void main(String[] args) {
        System.out.println("Algorithm");
        // FizzBuzz //
//        for (var i = 1; i < 100; i++) {
//            fizzBuzz(i);
//        }
        // GetReminder
        int reminder = getReminder(5,6);
        System.out.println("Reminder = " +reminder);
    }

    private static int getReminder(int a, int b) {
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
