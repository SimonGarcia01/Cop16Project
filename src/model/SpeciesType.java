package model;

public enum SpeciesType {
    //Enumeration literals
    FAUNA("Fauna"),
    FLORA("Flora");

    //Attributes
    private final String description;

    //Methods
    
    //TO EXTRACT THE LIST OF DESCRIPTIONS
    /**
    * <p><b>getSpeciesTypes</b></p>
    * <b>Description:</b> Extracts the array from SpeciesType holding every description associated with a SpeciesType literal and returns it.
    * The method delegates to the descriptions provided by {@link SpeciesType#getSpeciesTypes()}.
    *
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code getSpeciesTypes} method in SpeciesType must be implemented.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>Returns a String array holding the descriptions of every literal.</li>
    * </ul>
    * 
    * @return A String array holding all the descriptions representing the SpeciesType literals.
    */ 
    public static String[] getSpeciesTypes() {
        SpeciesType[] speciesTypes = SpeciesType.values();
        String[] descriptions = new String[speciesTypes.length];
        for (int i = 0; i < speciesTypes.length; i++) {
            descriptions[i] = speciesTypes[i].getDescription();
        }
        return descriptions;
    }

    //CHANGE AN INT TO A PLACERTYPE
    /**
    * <p><b>intToSpeciesType</b></p>
    * <b>Description:</b> Takes the selected option from the list of literals (printed as descriptions) and then uses a switch to return the corresponding value as a literal from the SpeciesType enumeration.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code intType} must be an integer between 1 and 2.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>Returns a SpeciesType literal associated with the list of literals.</li>
    * </ul>
    * 
    * @param intType An integer representing the user's selection for one of the SpeciesType types.
    * @return A SpeciesType literal associated with the list of SpeciesType descriptions.
    */
    public static SpeciesType intToSpeciesType(int intType){
        SpeciesType speciesType = null;
        switch(intType){
            case 1:
                speciesType = FAUNA;
                break;
            case 2:
                speciesType = FLORA;
                break;
        }

        return speciesType;
    }



    //CONSTRUCTOR
    /**
    * <p><b>SpeciesType</b></p>
    * <b>Description:</b> Initializes the SpeciesType literals with an associated String description.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code description} There should be an associated attribute for the description and the literals must have their descriptions.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The literals inside SpeciesType are initialized with associated descriptions.</li>
    * </ul>
    * 
    * @param description The string associated with the SpeciesType literal.
    */
    private SpeciesType(String description){
        this.description = description;
    }

    //GET THE DESCRIPTION FOR ONE LITERAL
    /**
	* <p><b>getDescription</b></p>
	* <b>Description:</b> Extracts the description associated to the SpeciesType literal in the enumeration.
	*	
	* <p><b>Preconditions:</b></p>
	* <ul>
	* 	<li> {@code literals} must have an associated description. </li>
	* </ul>
	*
	* <p><b>Postconditions:</b></p>
	* <ul>
	* 	<li>A string that holds the description to a literal is returned.</li>
	* </ul>
	*
	* @return A String with the description of a SpeciesType literal.
	*/
    public String getDescription(){
        return description;
    }



}
