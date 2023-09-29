package utils;

import java.util.Scanner;

//TODO let's make this class static. in this way we don't need to create an object when we need to use the methods inside it, we just simply call them
public class Utils {

    public Utils() {
    }

    public static Double extractDouble(String s)
    {
        //TODO I think we should use double, a primitive in this scenario. and it doesn't need initialization
        Double price = Double.valueOf(0);
        s = s.replaceAll("[^0-9]", " ");
        s = s.replaceAll(" +", " ");
        //TODO the if is redundant
        if (s.equals(""));
        Scanner scanner = new Scanner(s);
        //TODO same as above, make it a primitive
        Double  dollars = Double.valueOf(scanner.nextInt());
        Double  cents = Double.valueOf(scanner.nextInt());
        price = cents/100 + dollars;
        return price;
    }

}
