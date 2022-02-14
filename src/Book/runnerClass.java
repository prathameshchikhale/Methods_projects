package Book;

import java.util.Scanner;

public class runnerClass {
    public static void main(String[] args) {
        System.out.println("Enter you;re booking mode = ");
        Scanner sc = new Scanner(System.in);
        String mode = sc.next();
        IndigoFlight indigo = new IndigoFlight();
        mmtFlights mmt = new mmtFlights();
        YatraCom yatra = new YatraCom();
        if(mode.equals("Indigo"))
        {
            indigo.Domestic();
        }
        else if(mode.equals("mmt"))
        {
            mmt.mmtDiscount(IndigoFlight.a);
            mmt.mmtDiscount(IndigoFlight.b);
        }
        else if(mode.equals(yatra))
        {
            yatra.yatraDiscount(IndigoFlight.a);
            yatra.yatraDiscount(IndigoFlight.b);
        }
        else
        {
            System.out.println("wrong input");
        }

    }
}
