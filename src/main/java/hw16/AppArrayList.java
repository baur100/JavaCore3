package hw16;

import java.util.ArrayList;
import java.util.Arrays;

public class AppArrayList {
    public static void main(String[] args) {

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(2000);
        integers.add(3000);
        integers.add(4000);
        integers.add(5000);
        System.out.println(integers);

        integers.remove(3);
        System.out.println(integers);
        System.out.println(integers.get(2));
        integers.set(0,6000);
        System.out.println(integers);
        boolean isTrue = integers.contains(10000);
        System.out.println(isTrue);
        System.out.println(integers.get(2));

        for (Integer v:integers){
            System.out.println(v);
        }


    }
}
