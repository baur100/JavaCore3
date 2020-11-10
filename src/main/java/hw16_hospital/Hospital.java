package hw16_hospital;

import java.util.ArrayList;

public class Hospital {
    private String hospitalName;
    private Address address;
    private ArrayList<InsuranceCompanies> acceptedInsurances;

    public Hospital(String hospitalName, Address address, ArrayList<InsuranceCompanies> insuranceCompanies) {
        this.hospitalName = hospitalName;
        this.address = address;
        this.acceptedInsurances = insuranceCompanies;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ArrayList<InsuranceCompanies> getInsuranceCompanies() {
        return acceptedInsurances;
    }

    public void setInsuranceCompanies(ArrayList<InsuranceCompanies> insuranceCompanies) {
        this.acceptedInsurances = insuranceCompanies;
    }


    public void PrintInfo() {
        System.out.println("Hospital{" +
                "hospitalName='" + hospitalName + '\'' +
                ", address=" + address.getStreetAddress() + address.getTown() + address.getState() + address.getZip() +
                ", insuranceCompanies=" + acceptedInsurances +
                '}');
    }
}
