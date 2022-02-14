package Book;

public class mmtFlights extends IndigoFlight {
    public void mmtDiscount(double tickets)
    {
        double discount;
        discount =
        discount = tickets-(10*tickets/100);
        System.out.println("Discounted price on MakeMyTrip = "+discount);
    }

}
