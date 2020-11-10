package hm14;

public class Employee1 extends Company {
    private String firstName1;
    private String lastName1;

    public Employee1(CompanyName compname, String address, String phone_number, String firstName1, String lastName1) {
        super(compname, address, phone_number);
        this.firstName1 = firstName1;
        this.lastName1 = lastName1;
    }

    public String getFirstName1() {
        return firstName1;
    }

    public void setFirstName1(String firstName1) {
        this.firstName1 = firstName1;
    }

    public String getLastName1() {
        return lastName1;
    }

    public void setLastName1(String lastName1) {
        this.lastName1 = lastName1;
    }



    public void printMe() {
        System.out.println("Employee1{" +
                "firstName1='" + firstName1 + '\'' +
                ", lastName1='" + lastName1 + '\'' +
                ", compname=" + compname +
                ", address='" + address + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}');
    }
}


