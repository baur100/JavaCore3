package Algorithms;

public class getReminder {
    public static void main(String[] args) {

        int reminder = getReminder(5, 6);

        System.out.println("Reminder = " + reminder);
    }

    private static int getReminder(int a, int b){
        int x=a/b;
        return a-x*b;
    }
    //Swap 2 variables
//    int a=10;
//    int b=20;
//    a=a+b;//30
//    b=a-b;//30-20=10
//    a=a-b;//30-10=20

//    public static int getReminder(int a, int b) {
//        boolean cond = true;
//        while (cond) {
//            a = a - b;
//            if (a < b) {
//                cond = false;
//            }
//        }
//
//        return a;
//    }

}

