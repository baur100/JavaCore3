package seleniumTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import passenger.TicketPrice;

public class DataProvider {

    @org.testng.annotations.DataProvider(name = "Ages")
    public Object[][] createData() {
        return new Object[][]{
                {1, 1000, 0.0},
                {5, 1000, 500.0},
                {15, 1000, 1000.0},
                {68, 1000, 800.0}
        };
    }

    @Test(dataProvider = "Ages")
    public void ticketPriceCalculator(int age, int fare, double result) {
        TicketPrice calculator = new TicketPrice();
        double ticketPrice = calculator.getTicketPrice(age, fare);
        Assert.assertEquals(ticketPrice, result);
    }
}
