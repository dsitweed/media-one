package model;

import model.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Provider {
    private String address;
    private String name;

    private List<Product> listProductProvide;// List of product on offer

    public Provider() {
        this.address = "";
        this.name = "";
        this.listProductProvide = new ArrayList<>();
    }
    public Provider(String address, String name, List<Product> listProductProvide) {
        this.address = address;
        this.name = name;
        this.listProductProvide = listProductProvide;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public List<Product> getListProductProvide() {
        return listProductProvide;
    }

    public void setListProductProvide(List<Product> listProductProvide) {
        this.listProductProvide = listProductProvide;
    }


}
