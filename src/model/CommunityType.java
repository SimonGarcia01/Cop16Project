package model;

public enum CommunityType {
    //Enumeration literals
    AFRO("Afrocolombian"),
    INDIGENOUS("Indigenous"),
    RAIZAL("Raizal");

    //Attributes
    private final String description;

    //Methods

    //TO EXTRACT THE LIST OF DESCRIPTIONS
    /**
	* <p><b>getCommunityTypes</b></p>
	* <b>Description:</b> Extracts all the descriptions that are associated to the literals of the enumeration and returns a String[] holding them. 
    * The method loops extracting the description and concatenates everything.
	*	
	* <p><b>Preconditions:</b></p>
	* <ul>
	* 	<li> {@code literals} must have an associated description.</li>
	* </ul>
	*
	* <p><b>Postconditions:</b></p>
	* <ul>
	* 	<li>An String array is returned holding the descriptions of every Literal. </li>
	* </ul>
	*
	* @return A string[] holding all the descriptions representing the CommunityType literals.
	*/
    public static String[] getCommunityTypes() {
        CommunityType[] types = CommunityType.values();
        String[] descriptions = new String[types.length];
        for (int i = 0; i < types.length; i++) {
            descriptions[i] = types[i].getDescription();
        }
        return descriptions;
    }

    //CHANGE AN INT TO A COMMUNITYTYPE
    /**
	* <p><b>intToCommunityType</b></p>
	* <b>Description:</b> Takes in the selected option from the list of literals (printed as descriptions) and then runs a switch to return the value as a literal from the enumeration.
	*	
	* <p><b>Preconditions:</b></p>
	* <ul>
	* 	<li> {@code intType} must be an int between 1 and 3.</li>
	* </ul>
	*
	* <p><b>Postconditions:</b></p>
	* <ul>
	* 	<li>A CommunityType literal is returned associated to the list of literals.</li>
	* </ul>
	*
	* @param intType an int that the user entered to choose one of the CommunityTypes.
    *@return CommunityType literal associated to the list of CommunityTypes descriptions.  
	*/
    public static CommunityType intToCommunityType(int intType){
        CommunityType communityType = null;
        switch(intType){
            case 1:
                communityType = AFRO;
                break;
            case 2:
                communityType = INDIGENOUS;
                break;
            case 3:
                communityType = RAIZAL;
                break;
        }

        return communityType;
    }

    //CONSTRUCTOR
    /**
	* <p><b>CommunityType</b></p>
	* <b>Description:</b> Initializes the CommunityType literals with an associated String description.
	*	
	* <p><b>Preconditions:</b></p>
	* <ul>
	* 	<li> {@code description} There should be an associated attribute for the description and the literals must have their descriptions.</li>
	* </ul>
	*
	* <p><b>Postconditions:</b></p>
	* <ul>
	* 	<li>The literals inside CommuniType are initialized with associated descriptions.</li>
	* </ul>
	*
	* @param description String that comes from the CommunityType literal list.  
	*/
    private CommunityType(String description){
        this.description = description;
    }

    //GET THE DESCRIPTION FOR ONE LITERAL
    /**
	* <p><b>getDescription</b></p>
	* <b>Description:</b> Extracts the description associated to the CommunityTypes's literal in the enumeration.
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
	* @return A String with the description of a CommunityType literal.
	*/
    public String getDescription(){
        return description;
    }

}
