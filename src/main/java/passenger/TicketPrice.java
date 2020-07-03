package passenger;

public class TicketPrice {
    public double getTicketPrice(int age, int price){
        double finalPrice = price;
        if(age<=2){
            finalPrice=0;
        }
        if(age>2 && age <=12){
            finalPrice = 0.5*price;
        }
        if(age>65){
            finalPrice = price*0.8;
        }
        return finalPrice;
    }
}
