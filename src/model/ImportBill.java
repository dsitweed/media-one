package model;


import model.person.Manager;

public class ImportBill  extends Bill{
    Manager manager;
    Provider provider;

    public ImportBill (Manager manager, Provider provider) {
        super();
        this.manager = manager;
        this.provider = provider;
    }
}
