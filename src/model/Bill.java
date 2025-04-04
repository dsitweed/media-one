package model;

import model.person.Staff;
import model.product.Product;

import java.io.Serializable;
import java.util.*;


public class Bill implements Serializable {
    private final List<CartItem> listCart;
    private String code;
    private int qtyOrdered;
    private Date dateBuy;
    private Customer customer;
    private Staff staff;
    private double discount;   // default = 0

    private double totalMoney;

    public Bill(Staff staff, Customer customer) {
        // random code
        code = UUID.randomUUID().toString();
        dateBuy = new Date();
        listCart = new ArrayList<>();
        discount = 0; // default

        this.staff = staff;
        this.customer = customer;
    }

    public Bill() {
        code = UUID.randomUUID().toString();
        dateBuy = new Date();
        listCart = new ArrayList<>();
        discount = 0; // default
    }

    public String getCode() {
        return code;
    }

    public void setCode(String s) {
        code = s;
    }

    public int getQtyOrdered() {
        return qtyOrdered;
    }

    public void setQtyOrdered(int qty) {qtyOrdered = Math.max(qty, 0);}

    public Date getDateBuy() {
        return dateBuy;
    }
    public int getMonth() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateBuy);
        return cal.get(Calendar.MONTH) + 1;
    }
    public int getYear() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateBuy);
        return cal.get(Calendar.YEAR);
    }

    public void setDateBuy(Date date) {
        dateBuy = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer otherCus) {
        customer = otherCus;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff otherStaff) {
        staff = otherStaff;
    }

    public List<CartItem> getListCart() {
        return listCart;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscout(double newDiscount) {
        if (newDiscount < 0) discount = 0;
        else discount = newDiscount;
    }

    // add
    public boolean addCartItem(CartItem item) {
        qtyOrdered += item.getQuantity();
        return listCart.add(item);
    }

    //remove
    public boolean removeCartItem(CartItem item) {
        if (listCart.removeIf(n -> n == item)) {
            qtyOrdered -= item.getQuantity();
            return true;
        }
        return false;
    }

    // tinh tong
    public double totalCost() {
        double total = 0;
        for (CartItem cartItem : listCart) {
            total += cartItem.getAllPrice();
        }
        totalMoney = total - total * discount;
        return totalMoney;
    }

    public  double totalImportMoney() {
        double total = 0;
        Product p;
        for (CartItem cartItem : listCart) {
            p = cartItem.getProduct();
            total += p.getImportPrice();
        }
        return total;
    }
    // Can kiem tra Class nay

    public void showInfor() {
        Iterator<CartItem> i = listCart.iterator();
        //System.out.println("Bill Inforamtion:" );
        System.out.println("Mã hóa đơn: " + code);
        while (i.hasNext()) {
            CartItem cart = (CartItem) i.next();
            cart.showInfo();
        }
        System.out.println("Ngày mua: " + dateBuy);
        System.out.println("Tổng tiền: " + totalCost());
    }

    @Override
    public String toString() {
        return "Bill{" +
                "code='" + code + '\'' +
                ", qtyOrdered=" + qtyOrdered +
                ", dateBuy=" + dateBuy +
                ", customer=" + customer +
                ", staff=" + staff.getName() + "\n" +
                ", discount=" + discount +
                ", totalMoney=" + totalCost() +
                '}';
    }
}
