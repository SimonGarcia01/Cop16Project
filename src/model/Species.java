package model;

public class Species {
    
    //Attributes
    private String name;
    private String photo;
    private int localPop;
    private SpeciesType type;
    
    //Relations

    //Methods

    //Constructor
    public Species(String name, String photo, int localPop, SpeciesType type) {
        this.name = name;
        this.photo = photo;
        this.localPop = localPop;
        this.type = type;
    }

    //Setters and Getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getLocalPop() {
        return localPop;
    }

    public void setLocalPop(int localPop) {
        this.localPop = localPop;
    }

    public SpeciesType getType() {
        return type;
    }

    public void setType(SpeciesType type) {
        this.type = type;
    }
}
