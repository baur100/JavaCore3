package hm14;

public class Company {
    protected CompanyName compname;
    protected String address;
    protected String phone_number;

    public Company(CompanyName compname, String address, String phone_number) {
        this.compname = compname;
        this.address = address;
        this.phone_number = phone_number;
    }

    public CompanyName getCompname() {
        return compname;
    }

    public void setCompname(CompanyName compname) {
        this.compname = compname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }


    public void printMe() {
        System.out.println("Company{" +
                "name='" + compname + '\'' +
                ", address='" + address + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}');
    }
}
