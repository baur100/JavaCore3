package hw18_farm;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class App {
    public static void main(String[] args) {

        HashMap<Cattle,Integer> cattle = new HashMap<>();
        cattle.put(Cattle.COWS,50);
        cattle.put(Cattle.SHEEP,40);
        cattle.put(Cattle.PIGS,20);
        cattle.put(Cattle.CHICKENS,50);
        cattle.put(Cattle.TURKEYS,25);


        ArrayList<AgreeCultural> agreeCultural = new ArrayList<>();
        AgreeCultural rice = new AgreeCultural("Rice",10);
        AgreeCultural wheat = new AgreeCultural("Wheat", 16);
        AgreeCultural barley = new AgreeCultural("Barley", 21);
        agreeCultural.add(rice);
        agreeCultural.add(wheat);
        agreeCultural.add(barley);
//        for (AgreeCultural v : agreeCultural) {
//            v.printInfo();
//        }

        Address farmAddress = new Address("3421 Malibu Drive","Malibu", "CA",90263);
        Farm sunlight = new Farm("SunLight", farmAddress,cattle,agreeCultural);
        sunlight.printInfo();

    }
}
