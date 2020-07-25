package Algorithms;

import java.util.ArrayList;
import java.util.List;

public class PrintRepitedNumbers {
    public static void main (String [] arg ){
        int[] array = {5,5,6,7,8,9,6,0,5,9,2,3,1};
        printRepited(array);
    }

    private static void printRepited(int[] array) {
        List repeat = new ArrayList<Integer>();
        for (int i=0;i<array.length;i++){
            for (int j=i+1;j<array.length;j++){
                if(array[i]==array[j]){
                    if(!repeat.contains(array[i])){
                        repeat.add(array[i]);
                    }
                }
            }
        }
        repeat.forEach(x-> System.out.println(x));
    }
}
