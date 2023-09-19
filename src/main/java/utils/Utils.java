package utils;

import java.util.Scanner;

public class Utils {

    public Utils() {
    }

    public static Double extractDouble(String s)
    {
        Double price = Double.valueOf(0);
        s = s.replaceAll("[^0-9]", " ");
        s = s.replaceAll(" +", " ");
        if (s.equals(""));
        Scanner scanner = new Scanner(s);
        Double  dollars = Double.valueOf(scanner.nextInt());
        Double  cents = Double.valueOf(scanner.nextInt());
        price = cents/100 + dollars;
        return price;
    }

}
