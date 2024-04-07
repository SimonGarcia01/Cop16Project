package model;

public class Species {
    
    //Attributes
    private String name;
    private String photo;
    private int localPop;
    private SpeciesType type;
    
    //Relations

    //Methods

    /**
    * <p><b>getProductTypes</b></p>
    * <b>Description:</b> Extracts the array from ProductType holding every description associated with a ProductType literal and returns it.
    * The method passes on the descriptios done by {@link ProductType#getProductTypes()}.
    *
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code getProductTypes} method in ProductType must be in place.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>A String array is returned holding the descriptions of every Literal.</li>
    * </ul>
    * 
    * @return A string[] holding all the descriptions representing the ProductType literals.
    */ 
    public static String[] getSpeciesTypes(){
        return SpeciesType.getSpeciesTypes();
    }

    //CONSTRUCTOR
    public Species(String name, String photo, int localPop, int intType) {
        this.name = name;
        this.photo = photo;
        this.localPop = localPop;
        this.type = SpeciesType.intToSpeciesType(intType);
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
