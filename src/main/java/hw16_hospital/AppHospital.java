package hw16_hospital;

import l13.Doctor;

import java.util.ArrayList;
import java.util.HashMap;

public class AppHospital {
    public static void main(String[] args) {
        ArrayList<Doctors> doctors = new ArrayList<Doctors>();
        Doctors carry = new Doctors("Carry", "McWay", Position.PHYSICIAN);
        Doctors jim = new Doctors("Jim", "Goforth", Position.PEDIATRICIAN);
        Doctors monica = new Doctors("Monica", "Ratakovsky", Position.SURGEON);
        Doctors ben = new Doctors("Ben", "Wolf", Position.CARDIOLOGIST);
        Doctors david = new Doctors("David", "Burman", Position.DERMATOLOGIST);
        doctors.add(carry);
        doctors.add(jim);
        doctors.add(monica);
        doctors.add(ben);
        doctors.add(david);

        for (Doctors v : doctors) {
            v.printDoctors();
        }


        HashMap<Integer, String> rooms = new HashMap<>();
        rooms.put(23, "Physician Room");
        rooms.put(15, "Pediatrician Room");
        rooms.put(8, "Surgeon Room");
        rooms.put(32, "Cardiology");
        rooms.put(18, "Dermatology");
        System.out.println(rooms);


        ArrayList<InsuranceCompanies> acceptedInsurances = new ArrayList<>();
        acceptedInsurances.add(InsuranceCompanies.UNITED_HEALTHCARE);
        acceptedInsurances.add(InsuranceCompanies.KAISER);
        acceptedInsurances.add(InsuranceCompanies.BLUE_CROSS);

        Address hospitalAddress = new Address("250 N Robertson Blvd", "Beverly Hills", "CA", 90211);
        Hospital cedarsCinai = new Hospital("Cedars Cinai", hospitalAddress, acceptedInsurances);

        cedarsCinai.PrintInfo();

    }

}
