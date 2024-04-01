package model;

import java.util.Calendar;

public class Place {

    //Attributes
    private String name;
    private double area;
    private Calendar inaugurationDate;
    private double resources;
    private PlaceType type;
    private Department department;
    
    //Relations
    private Species[] species;
    private Community caregivingCommunity;


    //Methods

    //Constructor
    public Place(String name, double area, Calendar inaugurationDate, double resources, 
    PlaceType type, Department department, Community caregivingCommunity) {
        this.name = name;
        this.area = area;
        this.inaugurationDate = inaugurationDate;
        this.resources = resources;
        this.type = type;
        this.department = department;
        this.species = new Species[50];
        this.caregivingCommunity = caregivingCommunity;
    }

    //Setters and Getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Calendar getInaugurationDate() {
        return inaugurationDate;
    }

    public void setInaugurationDate(Calendar inaugurationDate) {
        this.inaugurationDate = inaugurationDate;
    }

    public double getResources() {
        return resources;
    }

    public void setResources(double resources) {
        this.resources = resources;
    }

    public PlaceType getType() {
        return type;
    }

    public void setType(PlaceType type) {
        this.type = type;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Community getCaregivingCommunity() {
        return caregivingCommunity;
    }

    public void setCaregivingCommunity(Community caregivingCommunity) {
        this.caregivingCommunity = caregivingCommunity;
    }

    //No need for a set since the species are added by another method
    public Species[] getSpecies() {
        return species;
    }
}
