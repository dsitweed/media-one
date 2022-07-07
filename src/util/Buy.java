package util;

import io.IOFile;

import java.util.Scanner;

public class Buy {
    static final Scanner scanner = new Scanner(System.in);

    // buy == productCode
    static public void showBuyMenu (String productCode) {
        int option = 0;
        while (true) {
            System.out.println("\n\n----------\n\n");
            System.out.println("1. Show All");
            System.out.println("2. Add");
            System.out.println("3. Find by name");
            System.out.println("4. Find by index");
            System.out.println("5. Find and delete by name");
            System.out.println("6. Find and delete by index");
            System.out.println("7. Return");
            System.out.print("Select: ");
        }
    }
}
