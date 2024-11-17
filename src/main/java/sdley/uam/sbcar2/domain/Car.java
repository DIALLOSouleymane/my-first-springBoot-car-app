package sdley.uam.sbcar2.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String brand, model, color, registerNumber;
    @Column(name="annee")
    private int year;
    private double price;


    public Car(){}


    public Car(String brand, String model, String color, String registerNumber, int year, double price, Owner Owner) {
        super();
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.registerNumber = registerNumber;
        this.year = year;
        this.price = price;
        this.Owner = Owner;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Owner")
    private Owner Owner;

    public Long getId() {
        return id;
    }


    public String getBrand() {
        return brand;
    }


    public String getModel() {
        return model;
    }


    public String getColor() {
        return color;
    }


    public String getRegisterNumber() {
        return registerNumber;
    }


    public int getYear() {
        return year;
    }


    public double getPrice() {
        return price;
    }

    public Owner getOwner(){
        return Owner;
    }

    
    public void setId(Long id) {
        this.id = id;
    }


    public void setBrand(String brand) {
        this.brand = brand;
    }


    public void setModel(String model) {
        this.model = model;
    }


    public void setColor(String color) {
        this.color = color;
    }


    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }


    public void setYear(int year) {
        this.year = year;
    }


    public void setPrice(double price) {
        this.price = price;
    }  

    public void setOwner(Owner Owner) {
        this.Owner = Owner;
    }
}

