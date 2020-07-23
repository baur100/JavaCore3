package Algorithms;

public class LuckyString {
    public static void main (String[]arg){
//        Lucky string "tyuiuyt"

        String str = "tyu5uyt";
        if(isLucky(str)){
            System.out.println("Licky "+str);
        }else {
            System.out.println("Not lucky "+str);
        }
    }

    private static  boolean isLucky(String str){
     String reverse="";
     for (var i=str.length()-1;i>0;i--){
         reverse+=str.charAt(i);
     }
     for (var i=0;i<str.length()/2;i++){
         if(str.charAt(i)!=reverse.charAt(i)){
             return false;
         }
     }
     return true;
    }
}
