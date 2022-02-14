package Book;

public class YatraCom extends IndigoFlight{
    public void yatraDiscount(double tickets)
    {
        double discount;
        discount = tickets-(10*tickets/100);
        System.out.println("Discount price on yatra com is = "+discount);
    }

}
