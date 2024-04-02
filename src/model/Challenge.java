package model;

public enum Challenge {
    HOSPITALS("Absence of hospitals"),
    SCHOOLS("Lack of schools"),
    WATER("Inadequate access to clean water"),
    FOOD("Insufficient access to food");

    //Attributes
    private final String description;

    //Methods

    //TO EXTRACT THE LIST OF DESCRIPTIONS
    /**
	* <p><b>getChallenges</b></p>
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
	* @return A string[] holding all the descriptions representing the Challenge literals.
	*/
    public static String[] getChallenges() {
        Challenge[] challenges = Challenge.values();
        String[] descriptions = new String[challenges.length];
        for (int i = 0; i < challenges.length; i++) {
            descriptions[i] = challenges[i].getDescription();
        }
        return descriptions;
    }

    //CHANGE AN INT TO A COMMUNITYTYPE
    /**
	* <p><b>intToChallenge</b></p>
	* <b>Description:</b> Takes in the selected option from the list of literals (printed as descriptions) and then runs a switch to return the value as a literal from the enumeration.
	*	
	* <p><b>Preconditions:</b></p>
	* <ul>
	* 	<li> {@code intType} must be an int between 1 and 4.</li>
	* </ul>
	*
	* <p><b>Postconditions:</b></p>
	* <ul>
	* 	<li>A Challenge literal is returned associated to the list of literals.</li>
	* </ul>
	*
	* @param intChallenge an int that the user entered to choose one of the Challenges.
    * @return Challenge literal associated to the list of Challenges descriptions.  
	*/
    public static Challenge intToChallenge(int intChallenge){
        Challenge challenge = null;
        switch(intChallenge){
            case 1:
                challenge = Challenge.HOSPITALS;
                break;
            case 2:
                challenge = Challenge.SCHOOLS;
                break;
            case 3:
                challenge = Challenge.WATER;
                break;
            case 4:
                challenge = Challenge.FOOD;
                break;
        }

        return challenge;
    }

    //CONSTRUCTOR
    /**
	* <p><b>Challenge</b></p>
	* <b>Description:</b> Initializes the Challenge literals with an associated String description.
	*	
	* <p><b>Preconditions:</b></p>
	* <ul>
	* 	<li> {@code description} There should be an associated attribute for the description and the literals must have their descriptions.</li>
	* </ul>
	*
	* <p><b>Postconditions:</b></p>
	* <ul>
	* 	<li>The literals inside Challenge are initialized with associated descriptions.</li>
	* </ul>
	*
	* @param description String that comes from the Challenge literal list.  
	*/
    private Challenge(String description){
        this.description = description;
    }

    //GET THE DESCRIPTION FOR ONE LITERAL
    /**
	* <p><b>getDescription</b></p>
	* <b>Description:</b> Extracts the description associated to the Challenge's literal in the enumeration.
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
	* @return A String with the description of a Challenge literal.
	*/
    public String getDescription(){
        return description;
    }


}
