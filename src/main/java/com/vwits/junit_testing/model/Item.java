package com.vwits.junit_testing.model;

import lombok.Data;

@Data
public class Item {

    public Item(int id, String name,int price,int quantity) {
        this.id=id;
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }

    private int id;

    private String name;

    private int price;

    private int quantity;

}
