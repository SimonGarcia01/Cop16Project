package model;

public class Product {
    //Enumerations
    public enum ProductType {
        FOOD,
        CRAFT
    }
    
    //Attributes
    private String name;
    private double naturePercent;
    private String handcraft;
    private ProductType type;
    //Relations

    //Methods

    //Constructor
    public Product(String name, double naturePercent, String handcraft, ProductType type) {
        this.name = name;
        this.naturePercent = naturePercent;
        this.handcraft = handcraft;
        this.type = type;
    }


    //Setters and Getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNaturePercent() {
        return naturePercent;
    }

    public void setNaturePercent(double naturePercent) {
        this.naturePercent = naturePercent;
    }

    public String getHandcraft() {
        return handcraft;
    }

    public void setHandcraft(String handcraft) {
        this.handcraft = handcraft;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }
    

}
