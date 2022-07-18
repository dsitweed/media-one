package io;

import java.util.Scanner;

public class IO {
    static public String getString(Scanner scanner, String defaultValue, String message) {
        System.out.print(message);
        String buff;
        buff = scanner.nextLine().trim();

        if (!defaultValue.equals("") && buff.equals("")) {
            return defaultValue;
        }

        while (buff.equals("")) {
            System.out.println("Yêu cầu nhập vào xâu khác rỗng!");
            System.out.print(message);
            buff = scanner.nextLine().trim();
        }
        return buff;
    }

    static public int getNumber(Scanner scanner, int defaultValue, String message) {
        System.out.print(message);
        String buff;
        int val = 0;
        buff = scanner.nextLine().trim();

        try {
            val = Integer.parseInt(buff);
        } catch (Exception e) {
            val = 0;
        }

        if (defaultValue != 0 && val == 0) {
            return defaultValue;
        }

        while (val == 0) {
            System.out.println("Yêu cầu nhập vào số hợp lệ!");
            System.out.print(message);
            buff = scanner.nextLine().trim();
            try {
                val = Integer.parseInt(buff);
            } catch (Exception e) {
                val = 0;
            }
        }
        return val;
    }


    static public double getDoubleNumber(Scanner scanner, double defaultValue, String message) {
        System.out.print(message);
        String buff;
        double val = 0;
        buff = scanner.nextLine().trim();

        try {
            val = Double.parseDouble(buff);
        } catch (Exception e) {
            val = 0;
        }

        if (defaultValue != 0 && val == 0) {
            return defaultValue;
        }

        while (val == 0) {
            System.out.println("Yêu cầu nhập vào số hợp lệ!");
            System.out.print(message);
            buff = scanner.nextLine().trim();
            try {
                val = Integer.parseInt(buff);
            } catch (Exception e) {
                val = 0;
            }
        }
        return val;
    }



    static public int getNumberIndex(Scanner scanner, String message) {
        System.out.print(message);
        String buff;
        int val = 0;
        buff = scanner.nextLine().trim();

        try {
            val = Integer.parseInt(buff);
        } catch (Exception e) {
            val = -1;
        }
        if (val != -1) return  val;

        while (val == -1) {
            System.out.println("Yêu cầu nhập vào số hợp lệ!");
            System.out.print(message);
            buff = scanner.nextLine().trim();
            try {
                val = Integer.parseInt(buff);
            } catch (Exception e) {
                val = -1;
            }
        }
        return val;
    }
}
