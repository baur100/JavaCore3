package hw16;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.HashMap;
import java.util.Map;
import java.util.SplittableRandom;
import java.util.prefs.PreferenceChangeEvent;

public class AppHashMaps {
    public static void main(String[] args) {
        HashMap<String, String> accessories = new HashMap<>();
        accessories.put("Bag", "LV");
        accessories.put("Belt", "Gucci");
        accessories.put("Shoes", "Manolo");
        accessories.put("Hat", "Borsalino");

        for (String v: accessories.values()){
            System.out.println(v);
        }

        System.out.println(accessories);
        System.out.println(accessories.get("Belt"));
        accessories.get(2);
        accessories.remove("Hat");
        System.out.println(accessories);

        HashMap<String, Integer> years = new HashMap<>();
        years.put("school", 2008);
        years.put("university", 2014);
        years.put("University2", 2015);
        years.put("College",2016);
        System.out.println(years);

        for(Map.Entry<String,Integer> entry: years.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }


    }
}
