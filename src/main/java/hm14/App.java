package hm14;

public class App {
    public static void main(String[] args) {

        Company netflix = new Company(CompanyName.NETFLIX,"Alameda st, Los Angeles", "7473442356");
        Employee1 briana = new Employee1(CompanyName.NETFLIX,"Alameda st, Los Angeles", "7473442356", "Briana", "Gomez");
        briana.printMe();

        Employee2 gerald = new Employee2(CompanyName.AMAZON, "Victory st, Lost Angeles", "7473445678", "Gerald", "White");
        gerald.printMe();

        Company emp3 = new Employee1(CompanyName.NETFLIX,netflix.getAddress(),netflix.getPhone_number(),"Victoria", "Ruseva");
        emp3.printMe();

    }
}
