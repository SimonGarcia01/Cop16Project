package model;

public enum SpeciesType {
    //Enumeration literals
    FAUNA("Fauna"),
    FLORA("Flora");

    //Attributes
    private final String description;

    //Methods
    
    //Constructor
    private SpeciesType(String description){
        this.description = description;
    }

    //Getter
    public String getDescription(){
        return description;
    }



}
