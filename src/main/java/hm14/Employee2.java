package hm14;

public class Employee2 extends Company {
    private String firsName2;
    private String lastName2;

    public Employee2(CompanyName compname, String address, String phone_number, String firsName2, String lastName2) {
        super(compname, address, phone_number);
        this.firsName2 = firsName2;
        this.lastName2 = lastName2;
    }

    public String getFirsName2() {
        return firsName2;
    }

    public void setFirsName2(String firsName2) {
        this.firsName2 = firsName2;
    }

    public String getLastName2() {
        return lastName2;
    }

    public void setLastName2(String lastName2) {
        this.lastName2 = lastName2;
    }

    public void printMe() {
        System.out.println("Employee2{" +
                "firsName2='" + firsName2 + '\'' +
                ", lastName2='" + lastName2 + '\'' +
                ", name='" + compname + '\'' +
                ", address='" + address + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}');
    }
}
