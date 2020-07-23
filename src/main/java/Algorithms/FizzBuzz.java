package Algorithms;


public class FizzBuzz {
    public static void main(String[] arg) {
        for (var i = 1; i < 100; i++) {
            fizzBuzz(i);
        }
    }
        public static void fizzBuzz ( int i){

            if (i%3==0 && i%5==0) {
                System.out.println(i + " FizzBuzz");
            }
            if (i%3==0){
                System.out.println(i + " Fizz");
            }
            if (i%5==0){
                System.out.println(i+ " Buzz");
            }


        }
    }


