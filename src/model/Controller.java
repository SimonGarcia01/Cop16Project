package model;

import java.util.Calendar;

public class Controller {
    
    //Attributes

    //Relations
    Community[] communities;
    Place[] places;


    //Methods

    //MAIN METHODS
    //ADMINISTRATIVE MENU

    /**
	* <p><b>registerCommunty</b></p>
	* <b>Description:</b> Initializes and creates an instance of Community, saves it in the communities array and returns a success message. 
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
	* 	<li>An instance of Community is created with all the necessary parameters, stored in the communities array and a success message is returned.</li>
    * 	<li>If there is a community with the same name already stored, a duplicate message is returned instead.</li>
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

    /**
	* <p><b>registerPlace</b></p>
	* <b>Description:</b> Initializes and creates an instance of Place, saves it in the places array and returns a success message. 
    * First, it checks if there is atleast one community registered. If not, a no prexistent community message is returned.
    * Second, it changes the int option entered for community and then extracts the entire community.
    * Third, it is checked if there is a place with the same name already stored. If there is a duplicate it returns a duplicate message.
	* Finally, It checks if there is space to store a new placein the array. If there is no space a no space message will be returend.
    *
	* <p><b>Preconditions:</b></p>
	* <ul>
	* 	<li> {@code intCommunity} must be a int.</li>
	* 	<li> {@code placeName} must be a String.</li> 
	* 	<li> {@code area} must be a double.</li>   
	* 	<li> {@code inaugurationDate} must be a Calendar Type.</li>
	* 	<li> {@code photo} must be a String.</li>
	* 	<li> {@code resources} must be a double.</li>
	* 	<li> {@code intDepartment} must be an int between 1 and 4.</li>
	* 	<li> {@code intType} must be an int between 1 and 3.</li>
	* </ul>
	*
	* <p><b>Postconditions:</b></p>
	* <ul>
	* 	<li>An instance of place is created with all the necessary parameters, stored in the palces array and a success message is returned.</li>
    * 	<li>If there are no prexistent communities registered, a message will be returned.</li>
    * 	<li>If there is a palce with the same name already stored, a duplicate message is returned instead.</li>
	* 	<li>If there is no space to store a new place in the array, a no space message will be returned.</li>
	* </ul>
	*
	* @param intCommunity int the represents one of the options of the existing communities.
    * @param placeName The name of the place.
    * @param area The area that the place covers in km2.
    * @param inaugurationDate Date the the place is going to be inaugurated.
    * @param photo URL of a photo of the place. 
    * @param resources The amount of money that is invested in a places.
    * @param intDepartment int that represents one of the possible departments to be chosen from.
    * @param intType int that represents one of the possible place types to be chosen from.
    *
    * @return A message stating if the community was registered successfully or not (stating the reason if it wasn't successfull).
	*/    
    public String registerPlace(int intCommunity, String placeName, double area, Calendar inaugurationDate,
    String photo, double resources, int intDepartment, int intType){
        String message = "";

        boolean oneCommunity = oneMinCommunity();

        if(oneCommunity){

            Community caregivingCommunity = intToCommunity(intCommunity);

            boolean duplicate = searchPlace(placeName);

            if(duplicate){
                message = "A place with that name already exists.";
            } else {

                int space = availablePlace();

                if (space == -1){
                    message = "There is no more space to register a new place.";
                } else {
                    places[space] = new Place(placeName, area, inaugurationDate, photo, resources, 
                    intType, intDepartment, caregivingCommunity);
                    message = "The place has been registered successfully.";
                }

            }

        } else {
            message = "There is no community to select from. Register one, please.";
        }

        return message;
    }

    //TO ADD A NEW PRODUCT
    /**
	* <p><b>registerCommunty</b></p>
	* <b>Description:</b> Initializes and creates an instance of Community, saves it in the communities array and returns a success message. 
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
	* 	<li>An instance of Community is created with all the necessary parameters, stored in the communities array and a success message is returned.</li>
    * 	<li>If there is a community with the same name already stored, a duplicate message is returned instead.</li>
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
    public String addProduct(int intCommunity, String productName, double naturePercent, 
    String handcraft, int intProductType){
        String message = "";

        boolean oneCommunity = oneMinCommunity();

        if(oneCommunity){
            Community productCommunity = intToCommunity(intCommunity);

            Product newProduct = new Product(productName, naturePercent, handcraft, intProductType);

            message = productCommunity.addProduct(newProduct);
        } else {
            message = "There is no community to select from. Register one, please.";
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

/**
	* <p><b>searchPlace</b></p>
	* <b>Description:</b> Verifies if the entered place name already exists in the array of places. 
    * It will loop along all the existing places.
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
	* @param name the String entered for the place that wants to be registered. 
	* @return A boolean showing if there is a duplicate or not.
	*/

    public boolean searchPlace(String name){

        boolean duplicate = false;

        for (Place place : places) {
            if (place != null && place.getName().equals(name)) {
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

    /**
	* <p><b>availablePlace</b></p>
	* <b>Description:</b> Verifies if there is an empty space in the array of places in order to save another place afterwards. 
    * It will loop and check that every element is equals to Null and then return the index of the last Null element.
    * If there are no null elements, it will return a -1.
	*	
	* <p><b>Preconditions:</b></p>
	* <ul>
    *   <li> {@code Array} holding the places must already exist.</li>
	* </ul>
	*
	* <p><b>Postconditions:</b></p>
	* <ul>
	* 	<li> An int holding the last null element position in the places array will be returned. If there is no null element left -1 will be returned instead.</li>
	* </ul>
	*
	* @return An int holding the index of the last null element in the places array (if there is no more space a -1 will be returned).
	*/    
    public int availablePlace(){
        for (int i = 0; i < places.length; i++) {
            if (places[i] == null) {
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

    /**
	* <p><b>displayDepartments</b></p>
	* <b>Description:</b> Concatenates and returns a string that holds all the descriptions that represent every Department literal. 
    * It will loop, put a number and extract the String Departments that holds all the descriptions.
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
	* @return A String that holds all the numbered descriptions of the Deparment enumeration.
	*/     
    public String displayDepartments(){
        String message = "Available departments\n\t";

        String[] departments = Place.getDepartments();
    
        for (int i = 0; i < departments.length; i++) {
            message += (i + 1) + ". " + departments[i] + "\n\t";
        }
    
        // Return the constructed message
        return message;
    }

    /**
	* <p><b>displayPlaceTypes</b></p>
	* <b>Description:</b> Concatenates and returns a string that holds all the descriptions that represent every PlaceType literal. 
    * It will loop, put a number and extract the String PlaceTypes that holds all the descriptions.
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
	* @return A String that holds all the numbered descriptions of the PlaceType enumeration.
	*/     
    public String displayPlaceTypes(){
        String message = "Available community types:\n\t";

        String[] placeTypes = Place.getPlaceTypes();
    
        for (int i = 0; i < placeTypes.length; i++) {
            message += (i + 1) + ". " + placeTypes[i] + "\n\t";
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
    public String displayProductTypes(){
        String message = "Types of products:\n\t";

        String[] productTypes = Community.getProductTypes();
    
        for (int i = 0; i < productTypes.length; i++) {
            message += (i + 1) + ". " + productTypes[i] + "\n\t";
        }
    
        // Return the constructed message
        return message;
    }

    //SEARCH IF AT LEAST ONE COMMUNITY IS REGISTERED
    /**
	* <p><b>oneMinCommunity</b></p>
	* <b>Description:</b> Will check if at least one community was registered already (first position of communities).
	*	
	* <p><b>Preconditions:</b></p>
	* <ul>
    *   <li> {@code Array} of communities must already exist. </li>
	* </ul>
	*
	* <p><b>Postconditions:</b></p>
	* <ul>
	* 	<li>A boolean stating if the first position in the community array was occupied or not.</li>
	* </ul>
	*
	* @return A boolean stating if the first position of communities is filled.
	*/     
    public boolean oneMinCommunity() {
        boolean oneCommunity = false;

        if (this.communities[0] != null) {
            oneCommunity = true;
        } 
    
        return oneCommunity;
    }

    //CHANGE AN INT TO A COMMUNITY
    /**
	* <p><b>intToCommunity</b></p>
	* <b>Description:</b> Takes in the selected option from the list of communities and then extracts the community in the communities array.
	*	
	* <p><b>Preconditions:</b></p>
	* <ul>
	* 	<li> {@code intType} must be an int within the range of communities printed.</li>
	* </ul>
	*
	* <p><b>Postconditions:</b></p>
	* <ul>
	* 	<li> A community is returned that was associated to the entered option.</li>
	* </ul>
	*
	* @param intCommunity an int that the user entered to choose one of the communities.
    * @return The community that was selected from the community list. 
	*/   
    public Community intToCommunity(int intCommunity){
        Community communityType = communities[intCommunity-1];
    
        return communityType;
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
    
    /**
    * <p><b>getCommunities</b></p>
    * <b>Description:</b> Retrieves the array of communities saved in controller.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code Array} of communities must be in place beforehand.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>An array of communities is returned containing all available communities.</li>
    * </ul>
    * 
    * @return The array of communities (including nulls if there are any).
    */
    public Community[] getCommunities() {
        return communities;
    }

    public Place[] getPlaces() {
        return places;
    }

    

}
