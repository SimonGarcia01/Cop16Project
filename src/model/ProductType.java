package model;

public enum ProductType {
    FOOD("Food"),
    Craft("Craft");

    //Attributes
    private final String description;

    //Methods
    
    //Constructor
    private ProductType(String description){
        this.description = description;
    }

    //Getter
    public String getDescription(){
        return description;
    }
}
