package utils;

import java.util.Scanner;
public class  Utils {

    public static void Utils() {
    }

    public static Double extractDouble(String s)
    {
        s = s.replaceAll("[^0-9]", " ");
        s = s.replaceAll(" +", " ");
        Scanner scanner = new Scanner(s);
        double  dollars = scanner.nextDouble();
        double  cents = scanner.nextDouble();
        Double price = cents/100 + dollars;
        return price;
    }

}
