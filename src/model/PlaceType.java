package model;

public enum PlaceType {
    //Enumeration literals
    PROTECTED("Protected Area"),
    NATIONAL("National Park"),
    PRIVATE("Private Area");

    //Attributes
    private final String description;

    //Methods


    //Constructor
    private PlaceType(String description) {
        this.description = description;
    }
    
    //Getter
    public String getDescription() {
        return description;
    }


}
