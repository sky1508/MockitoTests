package com.sky.mockitotest.mockitotest.model;

public class Item {
    private final int id;
    private final String name;
    private final int price;
    private final int qty;

    public Item(int id, String name, int price, int qty) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    @Override
    public String toString() {
        return String.format("Item[%d, %s, %d, %d",id, name, price, qty);
    }
}
