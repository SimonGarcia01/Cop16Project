package model;

public enum PlaceType {
    //Enumeration literals
    PROTECTED("Protected Area"),
    NATIONAL("National Park"),
    PRIVATE("Private Area");

    //Attributes
    private final String description;

    //Methods

    //TO EXTRACT THE LIST OF DESCRIPTIONS
    /**
    * <p><b>getPlaceTypes</b></p>
    * <b>Description:</b> Extracts all the descriptions that are associated to the literals of the PlaceType enumeration and returns a String[] holding them. 
    * The method loops through each PlaceType, extracting its description, and concatenates everything.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code literals} must have an associated description.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>An String array is returned holding the descriptions of every Literal.</li>
    * </ul>
    * 
    * @return A string[] holding all the descriptions representing the PlaceType literals.
    */
    public static String[] getPlaceTypes() {
        PlaceType[] placeTypes = PlaceType.values();
        String[] descriptions = new String[placeTypes.length];
        for (int i = 0; i < placeTypes.length; i++) {
            descriptions[i] = placeTypes[i].getDescription();
        }
        return descriptions;
    }

    //CHANGE AN INT TO A PLACERTYPE
    /**
    * <p><b>intToPlaceType</b></p>
    * <b>Description:</b> Takes in the selected option from the list of literals (printed as descriptions) and then runs a switch to return the value as a literal from the enumeration.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code intType} must be an int between 1 and 3.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>A PlaceType literal is returned associated to the list of literals.</li>
    * </ul>
    * 
    * @param intType An int that the user entered to choose one of the PlaceType types.
    * @return PlaceType literal associated to the list of PlaceType descriptions.
    */
    public static PlaceType intToPlaceType(int intType){
        PlaceType placeType = null;
        switch(intType){
            case 1:
                placeType = PROTECTED;
                break;
            case 2:
                placeType = NATIONAL;
                break;
            case 3:
                placeType = PRIVATE;
                break;
        }

        return placeType;
    }

    //CONSTRUCTOR
    /**
    * <p><b>PlaceType</b></p>
    * <b>Description:</b> Initializes the PlaceType literals with an associated String description.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code description} There should be an associated attribute for the description and the literals must have their descriptions.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The literals inside PlaceType are initialized with associated descriptions.</li>
    * </ul>
    * 
    * @param description String that comes from the PlaceType literal list.  
    */
    private PlaceType(String description) {
        this.description = description;
    }
    
    //GET THE DESCRIPTION FOR ONE LITERAL
    /**
	* <p><b>getDescription</b></p>
	* <b>Description:</b> Extracts the description associated to the Department's literal in the enumeration.
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
	* @return A String with the description of a Department literal.
	*/
    public String getDescription() {
        return description;
    }


}
