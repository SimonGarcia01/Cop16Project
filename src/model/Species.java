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
    * <p><b>getSpeciesTypes</b></p>
    * <b>Description:</b> Retrieves an array containing descriptions of all species types available.
    * The String[] is pased on by {@link Species#getSpeciesTypes()}.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code getSpeciesTypes} method in the {@link Species} class must be in place.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>An array of species type names is returned containing all available species types.</li>
    * </ul>
    * 
    * @return A String[] holding all the descriptions representing the species type literals.
    */  
    public static String[] getSpeciesTypes(){
        return SpeciesType.getSpeciesTypes();
    }

    //CONSTRUCTOR
    /**
    * <p><b>Species</b></p>
    * <b>Description:</b> Initializes and creates an instance of Species.
    * The name, photo, and localPop parameters are used exactly as they are entered.
    * For intType, it is first converted to a SpeciesType literal.
    *
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code name} must be a String.</li>
    *   <li>{@code photo} must be a String.</li>
    *   <li>{@code localPop} must be an int.</li>
    *   <li>{@code intType} must be an int between 1 and 2. </li>
    *   <li>{@link SpeciesType#intToSpeciesType(int)} method must be in place.</li>
    * </ul>
    *
    * <p><b>Postconditions:</b></p>
    * <ul>
    *     <li>An instance of Species is created with all the necessary parameters.</li>
    * </ul>
    *
    * @param name The name of the Species.
    * @param photo The photo URL or file path of the Species.
    * @param localPop The population of the Species in the local area.
    * @param intType The chosen option from the list of SpeciesType descriptions.
    */
    public Species(String name, String photo, int localPop, int intType) {
        this.name = name;
        this.photo = photo;
        this.localPop = localPop;
        this.type = SpeciesType.intToSpeciesType(intType);
    }

    //SETTERS AND GETTERS
    /**
    * <p><b>getName</b></p>
    * <b>Description:</b> Retrieves the name of the species as a String.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>The object instance must not be null. Otherwise, a NullPointerException will occur.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>Returns a String containing the name of the species instance.</li>
    * </ul>
    * 
    * @return A String representing the name of the species instance.
    */
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
