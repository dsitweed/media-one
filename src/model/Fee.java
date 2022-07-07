package model;

import java.util.Date;
import java.util.Scanner;

public class Fee {
    private String title; // chứa kiểu ?
    private String description;
    private double totalMoney;
    private Date date;

    public Fee(Scanner scanner) {
        System.out.print("Kiểu phí: ");
        title = scanner.nextLine().trim();
        System.out.print("Tổng tiền: ");
        totalMoney = Double.parseDouble(scanner.nextLine().trim());
        System.out.print("Nội dung miêu tả (thông tin phí, số lượng): ");
        description = scanner.nextLine().trim();
        date = new Date();
        System.out.print("Ngày tháng năm: " + date);
    }

    public Fee(String title, String description, double totalMoney, Date date) {
        this.title = title;
        this.description = description;
        this.totalMoney = totalMoney;
        this.date = date;
    }

    public void show () {
        System.out.println("Kiểu phí: " + title);
        System.out.println("Tổng tiền: " + totalMoney);
        System.out.println("Nội dung miêu tả (thông tin phí, số lượng): " + description);
        System.out.println("Ngày tháng năm: " + date);
    }
}
