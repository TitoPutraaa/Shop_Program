import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);
    static String name;
    static String[] items;
    static int[] price;
    static int[] quantitiy;
    static int result;
    static double discon;
    
    public static void main(String[] args) {
        do {
            System.out.println("\n===MENU===");
            System.out.println("1 : INPUT DATA");
            System.out.println("2 : SHOW PRICE");
            System.out.println("3 : DETAIL INFORMATON");
            System.out.println("4 : EXIT PROGRAM");
            System.out.print("choose : ");
            int choose = sc.nextInt();

            switch (choose) {
                case 1:
                    input();
                        break;
                case 3:
                    detail();
                        break;
                case 2:
                    count();
                    show();
                        break;

                case 4:
                    System.out.println("===THANKS YOU===");
                    return;
            
                default:
                System.out.println("input the right choose");
                    break;
            }
        } while (true);

    }

    static void input() {
        System.out.print("\nTOTAL ITEMS : ");
        int total = sc.nextInt();
        items = new String[total];
        price = new int[total];
        quantitiy = new int[total];
        sc.nextLine();
        System.out.print("NAME : ");
        name = sc.nextLine();
        for (int i = 0; i < total; i++) {
            System.out.print("ITEMS " + (i+1) + " : ");
            items[i] = sc.nextLine();
            System.out.print("PRICES : ");
            price[i] = sc.nextInt();
            System.out.print("QUANTITIY : ");
            quantitiy[i] = sc.nextInt();
            sc.nextLine();
        }
    }

    static void count() {
        int[] priceItems = new int[items.length];
        for (int sum = 0; sum < priceItems.length; sum++) {
            for (int i = 0; i < items.length; i++) {
                priceItems[i] = price[i] * quantitiy[i];
            }
        }

        for (int i = 0; i < priceItems.length; i++) {
            result += priceItems[i];
        }
        System.out.println("\nTOTAL : " + (result - discon));
    }

    static void detail() {
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i] + "    " + price[i] + "    " + quantitiy[i] + " : " + (price[i] * quantitiy[i]));
        }

        if (result >= 200) {
            discon = result * 0.05;
            result -= discon;
            System.out.println("discount : " + discon);
        } else if (result >= 100 && result < 200) {
            double discon = result * 0.03;
            result -= discon;
            System.out.println("discount : " + discon);
        } else {
            System.out.println("total price discount not found");
        }

        System.out.println("TOTAL : " + (result-discon));
    }



    static void show() {
        System.out.println("\nNAME : " + name);
        System.out.println("___________________________________");

        for (int i = 0; i < items.length; i++) {
            System.out.println("ITEMS : " + items[i]);
            System.out.println("PRICE : " + price[i]);
            System.out.println("QUANTITIY : " + quantitiy[i]);
        }
    }
}