package model;

public enum Department {
    //Enumeration ligerals
    CHOCO("Choco"),
    VALLE("Valle del Cauca"),
    CAUCA("Cauca"),
    NARINO("Narino");

    //Attributes
    private final String description;

    //Methods

    //Constructor
    private Department(String description){
        this.description = description;
    }

    //Getter
    public String getDescription(){
        return description;
    }
}
