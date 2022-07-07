package model;

import io.IOFile;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    private final Store bookStore;
    private final Store musicDiscStore;
    private final Store movieDiscStore;
    private List<Bill> listBill; // list of paid bills
    private List<Staff> listStaff; // list of staffs

    private List<MaintenanceFee> listMaintenanceFee; // list of MaintenanceFee
    private List<NonFixedFee> listNonFixedFee; // list of NonFixedFee
    private double profit; //
    private int soldNumber;

    public Warehouse() {
        bookStore = new Store(Book.class);
        musicDiscStore = new Store(MusicDisc.class);
        movieDiscStore = new Store(MovieDisc.class);
        listBill = new ArrayList<>();
        listStaff = IOFile.readStaffFormFile("data/staffs.txt");
        listMaintenanceFee = new ArrayList<>();
        listNonFixedFee = new ArrayList<>();
    }

    // add


    // thao tac voi Bill
    public void addListBill(Bill bill) {
        if (bill == null) return;
        listBill.add(bill);
    }

    public List<Bill> getListBill() {
        return listBill;
    }

    public List<Staff> getListStaff() {
        return listStaff;
    }

    public void setListStaff(List<Staff> listStaff) {
        this.listStaff = listStaff;
    }

    public void addStaff(Staff newStaff) {
        if (newStaff == null) return;
        listStaff.add(newStaff);
    }

    public void removeStaff(Staff staff) {
        if (staff != null) {
            listStaff.remove(staff);
        }
    }

    public void showAllBill() {
        for (Bill bill : listBill) {
            showBill(bill);
        }
    }

    public Store getBookStore() {
        return bookStore;
    }

    public Store getMusicDiscStore() {
        return musicDiscStore;
    }

    public Store getMovieDiscStore() {
        return movieDiscStore;
    }

    public List<MaintenanceFee> getListMaintenanceFee() {
        return listMaintenanceFee;
    }

    public Store getStoreByType(Class tClass) {
        Store store = tClass.equals(Book.class) ? this.bookStore :
                tClass.equals(MusicDisc.class) ? this.musicDiscStore :
                tClass.equals(MovieDisc.class) ? this.movieDiscStore : null;
        return store;
    }

    // Phuong thuc nay hoi ngu
    public void showBill(Bill bill) {
        if (listBill.contains(bill)) bill.showInfor();
    }
    // just have addFunction MaintenanceFee
    public void addMaintenanceFee(MaintenanceFee newFee) {
        listMaintenanceFee.add(newFee);
    }
    public void addNonFixedFee(NonFixedFee newFee) {
        listNonFixedFee.add(newFee);
    }
}//end class
