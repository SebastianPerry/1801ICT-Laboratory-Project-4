package com.company;

import java.io.Serializable;


public class Contact implements Serializable{
    // variables
    private int  Number;
    private String firstName;
    private String lastName;
    private int YOB;
    private String address;
    private String priContactNum;
    private String secContactNum;

    // methods
    public Contact() {}

    // initializer
    public void initializer(int num, String fName, String lName, int year, String addr, String priNum, String secNum) {
        this.Number = num;
        this.firstName = fName;
        this.lastName = lName;
        this.YOB = year;
        this.address = addr;
        this.priContactNum = priNum;
        this.secContactNum = secNum;
    }

    // setters
    public void setNumber(int num) {
        this.Number = num;
    }
    public void setFirstName(String fName) {
        this.firstName = fName;
    }
    public void setLastName(String lName) {
        this.lastName = lName;
    }
    public void setYOB(int year) {
        this.YOB = year;
    }
    public void setAddress(String addr) {
        this.address = addr;
    }
    public void setPriContactNum(String priNum) {
        this.priContactNum = priNum;
    }
    public void setSecContactNum(String secNum) {
        this.secContactNum = secNum;
    }

    // getters
    public int getNumber() {
        return(this.Number);
    }
    public String getFirstName() {
        return(this.firstName);
    }
    public String getLastName() {
        return(this.lastName);
    }
    public int getYOB() {
        return(this.YOB);
    }
    public String getAddress() {
        return (this.address);
    }
    public String getPriContactNum() {
        return (this.priContactNum);
    }
    public String getSecContactNum() {
        return (this.secContactNum);
    }
}