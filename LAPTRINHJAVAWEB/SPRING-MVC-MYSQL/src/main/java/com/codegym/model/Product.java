package com.codegym.model;

public class Product {
    private int pid;
    private String pcode;
    private String pname;
    private double price;
    private int quantity;
    private String pimage;
    private String color;
    private String description;


    public Product() {
    }

    public Product(int pid, String pcode, String pname, double price, int quantity,String pimage, String color, String description ) {
        this.pid = pid;
        this.pcode = pcode;
        this.pname = pname;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.description = description;
        this.pimage = pimage;
    }
    public Product(String pcode, String pname, double price, int quantity,String pimage, String color, String description ) {
        this.pcode = pcode;
        this.pname = pname;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.description = description;
        this.pimage = pimage;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }


}
