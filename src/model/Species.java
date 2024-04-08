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


    //CHANGE AN INT TO A SPECIES TYPE
    /**
    * <p><b>intToSpeciesType</b></p>
    * <b>Description:</b> Converts the selected option from the list of literals (printed as descriptions) into a SpeciesType enumeration value.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code intType} must be an integer representing an option from the list of SpeciesType literals.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>A SpeciesType enumeration value associated with the selected option is returned.</li>
    * </ul>
    * 
    * @param intType An integer representing the selected option from the list of literals.
    * @return The SpeciesType enumeration value associated with the selected option.
    */
    public static SpeciesType intToSpeciesType(int intType){
        return SpeciesType.intToSpeciesType(intType);
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

    /**
    * <p><b>setName</b></p>
    * <b>Description:</b> Sets the name of the species to a new provided value.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code name} must be a non-null String.</li>
    * </ul>
    *
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The name of the species is updated to the provided value.</li>
    * </ul>
    *
    * @param name The new name for the species.
    */  
    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    /**
    * <p><b>setPhoto</b></p>
    * <b>Description:</b> Sets the photo of the species to a new provided value.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code photo} must be String representing the photo URL for the species.</li>
    * </ul>
    *
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The photo URL of the species is updated to the provided value.</li>
    * </ul>
    *
    * @param photo The new photo URL for the species.
    */  
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getLocalPop() {
        return localPop;
    }

    /**
    * <p><b>setLocalPop</b></p>
    * <b>Description:</b> Sets the local population of the species to a new provided value.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code localPop} must be an integer representing the local population of the species.</li>
    * </ul>
    *
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The local population of the species is updated to the provided value.</li>
    * </ul>
    *
    * @param localPop The new local population for the species.
    */  
    public void setLocalPop(int localPop) {
        this.localPop = localPop;
    }

    public SpeciesType getType() {
        return type;
    }

    /**
    * <p><b>setType</b></p>
    * <b>Description:</b> Sets the type of the species to a new provided value.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code type} must be a non-null value representing the species type.</li>
    * </ul>
    *
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The type of the species is updated to the provided value.</li>
    * </ul>
    *
    * @param type The new species type for the species.
    */  
    public void setType(SpeciesType type) {
        this.type = type;
    }
}
