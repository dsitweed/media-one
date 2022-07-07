package util;

import io.*;
import model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Menu {
    static final Scanner scanner = new Scanner(System.in);
    static final Warehouse warehouse = new Warehouse();
    static final Manager manager = new Manager("manager", 22, warehouse);

    static public void showMainMenu() {// cần chỉnh sửa ghi ra file
        int option = 0;
        while (option != 3) {
            System.out.println("\n----------\n");
            System.out.println("1. Staff");
            System.out.println("2. Manager");
            System.out.println("3. Exit");
            System.out.print("Select: ");
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid option!!!");
            }
            switch (option) {
                case 1 -> {
                    System.out.println("Staff selection");
                    staffMenu();
                }
                case 2 -> {
                    System.out.println("Manager selection");
                    managerMenu();
                }
                case 3 -> {// write data to file
                    try {
                        IOFile.writeToFile("data/book.txt", new ArrayList<>(warehouse.getBookStore().getList()));
                        IOFile.writeToFile("data/musicDisc.txt", new ArrayList<>(warehouse.getMusicDiscStore().getList()));
                        IOFile.writeToFile("data/movieDisc.txt", new ArrayList<>(warehouse.getMovieDiscStore().getList()));
//                        IOFile.writeStaffToFile("data/staffs.txt", warehouse.getListStaff());
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Fail to saved data");
                    }
                }
                default -> System.out.println("Invalid option!!!");
            }
        }
    } // end MainMenu

    static public void staffMenu() {
        int option = 0;
        while (option != 3) {
            System.out.println("\n----------\n");
            System.out.println("1. Create new bill");
            System.out.println("2. Report fees incurred");
            System.out.println("3. Return!");
            System.out.print("Select:");
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                option = 0;
            }
            switch (option) {
                case 1 -> {
                    creatBill();
                }
                case 2 -> {
                    System.out.println("Report fees incurred.");
                    reportIncurred();
                }
                case 3 -> {
                    return;
                }
                default -> {
                    System.out.println("Invalid option!!!");
                }
            }
        }// end while
    }

    private static void creatBill() {
        int option = 0;
        Class type = null;
//        Bill newBill = new Bill();
        while (option != 5) {
            System.out.println("\n\n----------\n\n");
            System.out.println("1. Show All products");
            System.out.println("2. Find product");
            System.out.println("3. Review Bill");
            System.out.println("4. Pay the bill");
            System.out.println("5. Delete the bill");
            System.out.print("Select:");
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                option = 0;
            }
            switch (option) {
                case 1 -> {
                    manager.showProduct();
                }
                case 2 -> {
                    type = selectProductType();
                    findProductByName(type);
                }
                case 3 -> {
                    System.out.println("Review bill");
                    // reviewBill();
                }
                case 4 -> {
                    System.out.println("Pay the bill");
                    // payBill();
                }
                case 5 -> {
                    System.out.println("Delete the bill");
                    // deleteBill();
                    return;
                }
                default -> {
                    System.out.println("Invalid option!!!");
                }
            }
        }// end while
    }// end func

    private static void reportIncurred() {
        NonFixedFee newFee;
        Date date = new Date();
        String title, description;
        double totalMoney;
        System.out.print("Kiểu phí: ");
        title = scanner.nextLine().trim();
        System.out.print("Tổng tiền: ");
        totalMoney = Double.parseDouble(scanner.nextLine().trim());
        System.out.print("Nội dung miêu tả (thông tin phí, số lượng): ");
        description = scanner.nextLine().trim();
        System.out.println("Ngày tháng năm: " + date);
        System.out.print("Confirm delete(Y/n): ");
        if (scanner.nextLine().toLowerCase().trim().equals("y")) {
            newFee = new NonFixedFee(title, description, totalMoney, date);
            newFee.show();
            warehouse.addNonFixedFee(newFee);
        }
    }// end func

    static public void managerMenu() {
        int option = 0;
        while (option != 4) {
            System.out.println("\n----------\n");
            System.out.println("1. Manage products");
            System.out.println("2. Manage staffs");
            System.out.println("3. Revenue statistics");
            System.out.println("4. Return!");
            System.out.print("Select:");
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                option = 0;
            }
            switch (option) {
                case 1 -> {
                     manageProducts();
                }
                case 2 -> {
                    manageStaffs();
                }
                case 3 -> {
                    revenueStatistics();
                }
                case 4 -> {
                    return;
                }
                default -> {
                    System.out.println("Invalid option!!!");
                }
            }
        }// end while
    }

    static public void manageProducts() {
        int option = 0;
        while (option != 5) {
            System.out.println("\n----------\n");
            System.out.println("1. Add product");
            System.out.println("2. Remove product");
            System.out.println("3. Set product");
            System.out.println("4. Show product");
            System.out.println("5. Return");
            System.out.print("Select: ");
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                option = 0;
            }
            switch (option) {
                case 1:
                    manager.addProduct();
                    break;
                case 2:
                    manager.removeProduct();
                    break;
                case 3:
                    manager.setProduct();
                    break;
                case 4:
                    manager.showProduct();
                    break;
                case 5:
                default:
                    System.out.println("Invalid option!!!");
            }
        }
    } // end func
    static public void manageStaffs() {
        int option = 0;
        while (option != 5) {
            System.out.println("\n----------\n");
            System.out.println("1. Add staff");
            System.out.println("2. Update information of staff");
            System.out.println("3. Show staffs");
            System.out.println("4. Pay wage");
            System.out.println("5. Return ");
            System.out.print("Select: ");
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                option = 0;
            }
            switch (option) {
                case 1:
                    System.out.print("Tên nhân viên: ");
                    String name = scanner.nextLine().trim();
                    System.out.print("Tuổi nhân viên: ");
                    int age = Integer.parseInt(scanner.nextLine());
                    System.out.print("Lương nhân viên: ");
                    double salary = Double.parseDouble(scanner.nextLine());
                    manager.addStaff(name, age, salary);
                    break;
                case 2:
                    manager.setStaff();
                    break;
                case 3:
                    manager.showStaffs(warehouse.getListStaff());
                    break;
                case 4:
                    manager.paySalary();
                    break;
                case 5:
                default:
                    System.out.println("Invalid option!!!");
            }
        }
    } // end func
    static public void revenueStatistics() {
        int option = 0;
        while (option != 3) {
            System.out.println("\n----------\n");
            System.out.println("1. By month");
            System.out.println("2. By year");
            System.out.println("3. Return");
            System.out.print("Select: ");
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                option = 0;
            }
            switch (option) {
                case 1:
                case 2:
                case 3:
                default:
                    System.out.println("Invalid option!!!");
            }
        }
    } // end func
    static public Class selectProductType() {
        int option = 0;
        while (option != 4) {
            System.out.println("\n\n----------\n\n");
            System.out.println("1. Book");
            System.out.println("2. Movie Disc");
            System.out.println("3. Music Disc");
            System.out.println("4. Return");
            System.out.print("Select: ");
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                option = 0;
            }
            switch (option) {
                case 1:
                    return Book.class;
                case 2:
                    return MovieDisc.class;
                case 3:
                    return MusicDisc.class;
                case 4:
                    return null;
                default:
                    System.out.println("Invalid option!!!");
            }
        }
        return null;
    }

    private static Store getStoreProduct(Class tClass) {
        Store store = tClass.equals(Book.class) ? warehouse.getBookStore() :
                tClass.equals(MusicDisc.class) ? warehouse.getMusicDiscStore() :
                tClass.equals(MovieDisc.class) ? warehouse.getMovieDiscStore() : null;
        return store;
    }
    private static void showProducts(Class tClass) {
        if (tClass == null) return;
        Store store = getStoreProduct(tClass);
        List<Product> list = store.getList();
        if (list == null || list.size() == 0) {
            System.out.println("Empty, please add more!!!");
        } else {
            printTable(tClass, list);
        }
        System.out.print("Please enter something to continue: ");
        scanner.nextLine();
    }
    private static void findProductByName(Class tClass) {
        if (tClass == null) return;
        Store store = getStoreProduct(tClass);
        List<Product> list = store.getList();
        System.out.print("Name: ");
        List<Product> result = store.find(scanner.nextLine().trim());
        printTable(tClass, result);
        System.out.print("Please enter something to continue: ");
        scanner.nextLine();
    }
    private static void findProductByIndex(Class tClass) {
        if (tClass == null) return;
        Store store = getStoreProduct(tClass);
        List<Product> list = store.getList();
        System.out.print("Index: ");
        List<Product> result = store.find(scanner.nextLine().trim());
        printTable(tClass, result);
        System.out.print("Please enter something to continue: ");
        scanner.nextLine();
    }

    public static void printTable(Class tClass, List<Product> result) {
        if (result == null || result.size() == 0) {
            System.out.println("Empty, please add more!!!");
            return;
        }
        if (tClass.equals(Book.class)) {
            System.out.printf("| %5s | %40s | %40s | %10s | %10s | %10s | %20s | %20s |\n", "index", "code", "name", "quantity", "import", "sell", "publisher", "author");
        } else if (tClass.equals(MusicDisc.class)) {
            System.out.printf("| %5s | %40s | %40s | %10s | %10s | %10s | %20s | %20s |\n", "index", "code", "name", "quantity", "import", "sell", "producer", "singer");
        } else {
            System.out.printf("| %5s | %40s | %40s | %10s | %10s | %10s | %20s | %20s |\n", "index", "code", "name", "quantity", "import", "sell", "producer", "director");
        }
        int index = 0;
        for (Object item : result) {
            System.out.printf("| %5d |%s\n", index++, item);
        }
    }
}
