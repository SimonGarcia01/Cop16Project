package model;

public class Controller {
    
    //Attributes

    //Relations
    Community[] communities;
    Place[] places;


    //Methods

    //MAIN METHODS

    /**
	* <p><b>registerCommunty</b></p>
	* <b>Description:</b> Initializes and creates an instance of Community, saves it in the communities array and returns a sucess message. 
    * First, it is checked if there is a community with the same name already stored. If there is a dupicate it returns a duplicate message.
	* Second, It checks if there is space to store a new Community in the array. If there is no space a no space message will be returend.
    *
	* <p><b>Preconditions:</b></p>
	* <ul>
	* 	<li> {@code name} must be a String.</li>
	* 	<li> {@code representantName} must be a String.</li> 
	* 	<li> {@code representantPhone} must be a String.</li>   
	* 	<li> {@code population} must be an int.</li>
	* 	<li> {@code intChallenge} must be an int between 1 and 4.</li>
	* 	<li> {@code population} must be an int between 1 and 3.</li>
	* </ul>
	*
	* <p><b>Postconditions:</b></p>
	* <ul>
	* 	<li>An instance of Community is created with all the necessary parameters, stored in the communities array and a sucess message is returned.</li>
    * 	<li>If there is a community with the same name already stored, a duplica message is returned instead.</li>
	* 	<li>If there is no space to store a new community in the array, a no space message will be returned.</li>
	* </ul>
	*
	* @param name The name of the Community.
    * @param representantName The name of the person that represents the community.
    * @param representantPhone The phone number of the community's representant.
    * @param population The number of people that live in the community.
    * @param intChallenge The chosen option from the list of Challenge descriptions.
    * @param intType The chosen option from the list of CommunityType descriptions.
    *
    * @return A message stating if the community was registered successfully or not (stating the reason if it wasn't successfull).
	*/    
    public String registerCommunity(String name, String representantName, String representantPhone, 
    int population,  int intChallenge, int intType){
        String message = "";

        boolean duplicate = searchCommunity(name);

        if(duplicate){
            message = "A community with that name already exists.";
        } else {

            int space = availableCommunity();

            if (space == -1){
                message = "There is no more space to register a new community.";
            } else {
                communities[space] = new Community(name, representantName, representantPhone, 
                population, intChallenge, intType);
                message = "The community has been registered successfully.";
            }

        }

        return message;
    }

    //SEARCH METHODS

    /**
	* <p><b>searchCommunity</b></p>
	* <b>Description:</b> Verifies if the entered community name already exists in the array of communities. It will loop along all the existing communities.
	*	
	* <p><b>Preconditions:</b></p>
	* <ul>
    *   <li> {@code Array} holding the Communities must already exist.</li>
	* 	<li> {@code name} has to be a String.</li>
	* </ul>
	*
	* <p><b>Postconditions:</b></p>
	* <ul>
	* 	<li>A boolean stating if a duplicate was found or not.</li>
	* </ul>
	*
	* @param name the String entered for the community that wants to be registered. 

	* @return A boolean showing if there is a duplicate or not.
	*/

    public boolean searchCommunity(String name){

        boolean duplicate = false;

        for (Community community : communities) {
            if (community != null && community.getName().equals(name)) {
                duplicate = true;
            }
        }

        return duplicate;
    }

    //AVAILABLE SPACE METHODS

    /**
	* <p><b>availableCommunity</b></p>
	* <b>Description:</b> Verifies if there is an empty space in the array of communities in order to save another community afterwards. 
    * It will loop an check that every element is equals to Null and then return the index of the last Null element.
    * If there are no null elements, it will return a -1.
	*	
	* <p><b>Preconditions:</b></p>
	* <ul>
    *   <li> {@code Array} holding the Communities must already exist.</li>
	* </ul>
	*
	* <p><b>Postconditions:</b></p>
	* <ul>
	* 	<li> An int holding the last null element position in the communities array will be returned. If there is no null element left -1 will be returned instead.</li>
	* </ul>
	*
	* @return An int holding the index of the last null element in the communities array (if there is no more space a -1 will be returned).
	*/    
    public int availableCommunity(){
        for (int i = 0; i < communities.length; i++) {
            if (communities[i] == null) {
                return i;
            }
        }
        //If there is no more space, a -1 will be returned
        return -1;
    }

    //DISPLAYING ENUMERATIONS

    /**
	* <p><b>displayChallengeTypes</b></p>
	* <b>Description:</b> Concatenates and returns a string that holds all the descriptions that represent every Challenge literal. 
    * It will loop, put a number and extract the String challenges that holds all the descriptions.
	*	
	* <p><b>Preconditions:</b></p>
	* <ul>
    *   <li> {@code literals} and {@code descriptions} must have been initialized and the getDescription method must be in place.</li>
	* </ul>
	*
	* <p><b>Postconditions:</b></p>
	* <ul>
	* 	<li>A String holding all the numbered descriptions in order will be returned.</li>
	* </ul>
	*
	* @return A String that holds all the numbered descriptions of the Challenge enumeration.
	*/ 
    public String displayChallengeTypes(){
        String message = "Available challenges: \n\t";

        String[] challenges = Community.getChallenges();
    
        for (int i = 0; i < challenges.length; i++) {
            message += (i + 1) + ". " + challenges[i] + "\n\t";
        }
    
        // Return the constructed message
        return message;
    }

    /**
	* <p><b>displayCommunityTypes</b></p>
	* <b>Description:</b> Concatenates and returns a string that holds all the descriptions that represent every CommunityType literal. 
    * It will loop, put a number and extract the String communityTypes that holds all the descriptions.
	*	
	* <p><b>Preconditions:</b></p>
	* <ul>
    *   <li> {@code literals} and {@code descriptions} must have been initialized and the getDescription method must be in place.</li>
	* </ul>
	*
	* <p><b>Postconditions:</b></p>
	* <ul>
	* 	<li>A String holding all the numbered descriptions in order will be returned.</li>
	* </ul>
	*
	* @return A String that holds all the numbered descriptions of the CommunityType enumeration.
	*/     
    public String displayCommunityTypes(){
        String message = "Available community types:\n\t";

        String[] communityTypes = Community.getCommunityTypes();
    
        for (int i = 0; i < communityTypes.length; i++) {
            message += (i + 1) + ". " + communityTypes[i] + "\n\t";
        }
    
        // Return the constructed message
        return message;
    }

    //CONSTRUCTOR
    /**
	* <p><b>Controller</b></p>
	* <b>Description:</b> Initializes the Controller with the empty arrays for communities and places.
	*	
	* <p><b>Preconditions:</b></p>
	* <ul>
	* 	<li> {@code None} No preconditions.</li>
	* </ul>
	*
	* <p><b>Postconditions:</b></p>
	* <ul>
	* 	<li>The controller is initialized with both of the necessary arrays.</li>
	* </ul>
	*/
    public Controller(){

        this.communities = new Community[3];
        this.places = new Place[3];

    }

    //SETTERS AND GETTERS
    public Community[] getCommunities() {
        return communities;
    }

    public Place[] getPlaces() {
        return places;
    }

    

}
