import java.util.Scanner;

public class tip_calculator{
    public static void main(String[] args){
        double totalPrice = totalPrice();
        String serviceRating = getRating();
        double tax = totalPrice * .06;
        double tipPercent = getPercent(serviceRating);
        double tip = getTips(totalPrice, tipPercent);
        double total = getTotal(totalPrice, tip, tax);
        display(totalPrice, tip, tipPercent, total, tax);
    }
    public static double totalPrice(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("What was your total price? ");

        double price = myObj.nextDouble();
        while (price <= 0){
            System.out.println("Cannot be a negative number! Enter price: ");

            price = myObj.nextDouble();
        }
        //myObj.close();
        return price;
    }
    public static String getRating(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("How good was the service? Enter great, good, okay or bad: ");

        String rating = myObj.nextLine();
        while(!rating.equals("great") && !rating.equals("good") && !rating.equals("ok") && !rating.equals("bad")){
            System.out.println("Please enter great, good, okay or bad: ");

            rating = myObj.nextLine();
        }
        return rating;
    }
    public static double getPercent(String service){
        if (service.equals("great")){
            return .2;
        } else if(service.equals("good")){
            return .15;
        } else if (service.equals("ok")){
            return .05;
        } else{
            return 0;
        }
    }
    public static double getTips(double totalPrice, double tipPercent){
        return totalPrice * tipPercent;
    }

    public static double getTotal(double totalPrice, double tip, double tax){
        return totalPrice + tip + tax;
    }
    public static void display(double price, double tip, double tipPercent, double total, double tax){
        System.out.println("Price: " + price);
        System.out.printf("Tax: %,.2f%n", tax);
        System.out.printf("Tip: %,.2f" + " Tip percent was %,.2f%%%n", tip, tipPercent * 100);
        System.out.printf("Total: %,.2f%n", total);
    }
}